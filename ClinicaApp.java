package apresentacaoJpa.App;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import apresentacaoJpa.Administracao;
import apresentacaoJpa.Usuario;

public class ClinicaApp {

	private static String nome;
	private static String email;
	private static String endereco;
	private static String telefone;
	private static Object admin1;
	public static void main(String[] args) {
		
		Administracao adm = new Administracao(null, "Patricia Alves", "Administrador");
		
		Administracao administracao = null;
		System.out.println(adm);
		
		Usuario us1 = new Usuario(null, "Suzana Mendes", "Rua Meire 87, Rio Claro/SP","susu@hotmail.com","118974586", administracao);
		Usuario us2 = new Usuario(null, "Marilia Freitas", "Rua alemã 87, Rio Claro/SP","marilia@hotmail.com", "1185654789", administracao);
		Usuario us3 = new Usuario(null, "Tamiris Cunha", "Rua Machado 150, Osasco/SP","tami@hotmail.com", "118598767", administracao);
		Usuario us4 = new Usuario(null, "Marcela", "Rua Lima, São Paulo/SP","marci@hotmail.com", "112025352", administracao);
		Usuario usuario;
		
		System.out.println(us1);
		System.out.println(us2);
		System.out.println(us3);
		System.out.println(us4);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicajpa");		
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		
		//usuario = em.find(Usuario.class, 2);//se o banco de dados estiver vazio, não chamar esse código. Dará erro de id is null.
		//System.out.println(usuario);
		//usuario.setNome("");
		
		
		em.persist(us1);
		em.persist(us2);
		em.persist(us3);
		em.persist(us4);	
		em.getTransaction().commit();
		System.out.println("Usuário cadastrado");
		usuario = em.find(Usuario.class, 2);
		System.out.println(usuario);
		
		
        em.getTransaction().begin();
		
		administracao = em.find(Administracao.class, 1);
		System.out.println(administracao);
		em.merge(administracao);
		
		em.persist(adm);
		em.getTransaction().commit();
		administracao = em.find(Administracao.class, 1);
		administracao.setNome("");
		System.out.println(administracao);
		em.close();
		
		
	
	Scanner sc = new Scanner(System.in);
	EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("clinicajpa");
    EntityManager em1 = emf.createEntityManager();
    int opcaoMenu;
    do {
        System.out.print("|-----------------------------|\n");
        System.out.print("|-----SISTEMA DE CADASTRO-----|\n");
        System.out.print("|------CLINICA MULHER DEV-----|\n");
        System.out.print("|-----------------------------|\n");
        System.out.print("| 1 - Cadastro Administrativo |\n");
        System.out.print("| 2 - Cadastro Usuario        |\n");
        System.out.print("| 3 - Consultar Nome/Setor    |\n");
        System.out.print("| 4 - Alterar Dados           |\n");
        System.out.print("| 5 - Remover Dados           |\n");
        System.out.print("| 0 - Sair                    |\n");
        System.out.print("|-----------------------------|\n");
        System.out.print("Digite uma opção do menu: ");
        opcaoMenu = sc.nextInt();
        sc.nextLine();

        switch (opcaoMenu) {
            case 1:
                adminCadastro();
                break;
            case 2:
                inserirDados();
                break;
            case 3:
                consultar();
                break;
            case 4:
                alterarDados();
                break;
            case 5:
                removerCadastro();
                break;

        }
    } while (opcaoMenu != 0);
	}


public static void adminCadastro() {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicajpa");
    EntityManager em = emf.createEntityManager();
    
    Scanner scan = new Scanner(System.in);
    System.out.print("Informe a Identificação do Setor:Ex:Administração:  \n");
    String nome = scan.nextLine();
    System.out.print("Informe o Tipo do Perfil: \n");
    String tipo = scan.nextLine();
    Administracao admin = new Administracao();
    admin.setNome(nome);
    admin.setTipoUsuario(tipo);
    em.getTransaction().begin();
    em.persist(admin);
    em.getTransaction().commit();
    em.close();
    List<Administracao> adminPerfil = new ArrayList<>();
    adminPerfil.add(admin);

}
public static void inserirDados() {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicajpa");
    EntityManager em = emf.createEntityManager();
    Scanner scan = new Scanner(System.in);
    System.out.println("*** Cadastro de usuário ***");
    System.out.print("Informe o nome completo: ");
    String nome = scan.nextLine();
    System.out.print("Informe o e-mail: ");
    String email = scan.nextLine();
    System.out.print("Informe o seu endereço: ");
    String endereco = scan.nextLine();
    System.out.print("Informe o numero de telefone: ");
    String telefone = scan.nextLine();
    System.out.println("**************************");

    Administracao admin;
    System.out.println("1-Médico, 2-Administrador, 3-Assistente, 4-Paciente");
    System.out.print("Informe o setor que esse usuário pertencerá: ");
    int setor = scan.nextInt();
    scan.nextLine();
    if(setor > 4){
        System.out.println("Setor invalido");
    } else{
       
		admin = em.find(Administracao.class, setor);
        Usuario user = new Usuario();
        user.setNome(nome);
        user.setEmail(email);
        user.setEndereco(endereco);
        user.setTelefone(telefone);
        user.setAdministracao(admin);
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        System.out.println("Usuário cadastrado!");
        scan.nextLine();
        em.close();
		emf.close();

    }


}
public static  void consultar(){
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicajpa");
    EntityManager em = emf.createEntityManager();
    Scanner scan = new Scanner(System.in);
    System.out.print("Informe o id da consulta: ");
    int id = scan.nextInt();
    scan.nextLine();
    Query query = em.createNativeQuery("SELECT usuarios.nome as Nome_do_Usuario, administracao.nome as Classificacao FROM Usuarios\n" +
            "INNER JOIN Administracao ON Administracao.id = Usuarios.administracao_id\n" +
            "WHERE Administracao.id = "+id);
    List<Object[]> resultList = query.getResultList();
    List<ArmazenadorDadosDTO> dtos = new ArrayList<>();

    for (Object[] result : resultList) {
        String usuarioNome = (String) result[0];
        String administracaoNome = (String) result[1];


        ArmazenadorDadosDTO dto = new ArmazenadorDadosDTO();
        dto.setAdministracaoNome(administracaoNome);
        dto.setUsuarioNome(usuarioNome);


        dtos.add(dto);
    }

    if (resultList.isEmpty()) {
        System.out.println("Consulta Invalida ou Banco de Dados vazio!");
    } else {
        for (ArmazenadorDadosDTO dto : dtos) {
            String userName = dto.getUsuarioNome();
            String classificacao = dto.getAdministracaoNome();

            System.out.println("Nome do Usuário: " + userName);
            System.out.println("Classificação: " + classificacao);
            System.out.println("--------------------");
        }
    }

}

public static void alterarDados() {
    Scanner scan = new Scanner(System.in);
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicajpa");
    EntityManager em = emf.createEntityManager();
    int opcaoMenu;
    do {
        System.out.println("Qual das tabelas terá os dados modificados: ");
        System.out.print("|*****************************|\n");
        System.out.print("| 1 - Table Usuarios          |\n");
        System.out.print("| 2 - Table Administracao     |\n");
        System.out.print("| 0 - Sair                    |\n");
        System.out.print("|*****************************|\n");
        System.out.print("Digite uma opção do menu: ");
        opcaoMenu = scan.nextInt();
        scan.nextLine();

        switch (opcaoMenu){
            case 1:
                Usuario user;
                System.out.print("Informe o id do perfil a ser modificado: ");
                int id = scan.nextInt();
                scan.nextLine();
                user = em.find(Usuario.class,id);
                if(user == null) System.out.println("Usuário não existe");
                int opcaoMenu1;
                do {
                System.out.println("Qual dado será modificado: ");
                System.out.print("|*****************************|\n");
                System.out.print("| 1 - Nome         |\n");
                System.out.print("| 2 - E-mail     |\n");
                System.out.print("| 3 - Endereço              |\n");
                System.out.print("| 4 - Telefone              |\n");
                System.out.print("| 5 - Todos              |\n");
                System.out.print("| 0 - Sair             |\n");
                System.out.print("|*****************************|\n");
                System.out.print("Digite uma opção do menu: ");
                opcaoMenu1 = scan.nextInt();
                scan.nextLine();
                               
                switch (opcaoMenu1) {
                case 1:
                    System.out.print("Informe o nome completo: ");
                    user.setNome(scan.nextLine());
                    break;

                case 2:
                    System.out.print("Informe o e-mail: ");
                    user.setEmail(scan.nextLine());
                    break;

                case 3:
                    System.out.print("Informe o seu endereço: ");
                    user.setEndereco(scan.nextLine());
                    break;

                case 4:
                    System.out.print("Informe o numero de telefone: ");
                    user.setTelefone(scan.nextLine());
                    break;
                case 5:
                	System.out.println("Informe o nome completo: ");
                    user.setNome(scan.nextLine());
                    System.out.print("Informe o e-mail: ");
                    user.setEmail(scan.nextLine());
                    System.out.print("Informe o seu endereço: ");
                    user.setEndereco(scan.nextLine());
                    System.out.print("Informe o numero de telefone: ");
                    user.setTelefone(scan.nextLine());
                    System.out.print("|*****************************");
                Administracao admin;
                System.out.println("1-Médico, 2-Administrador, 3-Assistente, 4-Paciente");
                System.out.print("Informe o setor que esse usuário pertencerá: ");
                Integer setor = scan.nextInt();
                scan.nextLine();
                admin = em.find(Administracao.class, setor);
                user.setNome(nome);
                user.setEmail(email);
                user.setEndereco(endereco);
                user.setTelefone(telefone);
                user.setAdministracao(admin);
                break;
                default:
                System.out.println("Opção inválida");
                }
                
               }while (opcaoMenu1 != 0);
                em.getTransaction().begin();
                em.persist(user);
                em.getTransaction().commit();
                
                break;
            case 2:
                Administracao admin1;
                System.out.print("Informe o id do perfil a ser modificado: ");
                int id1 = scan.nextInt();
                scan.nextLine();
                admin1 = em.find(Administracao.class,id1);
                System.out.print("Informe a Identificação do Setor:Ex:Administração:  \n");
                String nome1 = scan.nextLine();
                System.out.print("Informe o Tipo do Perfil: \n");
                String tipo = scan.nextLine();
                admin1.setNome(nome1);
                admin1.setTipoUsuario(tipo);
                break;
        }while (opcaoMenu != 0);
        em.getTransaction().begin();
        em.persist(admin1);
        em.getTransaction().commit();
        em.close();
    }while(opcaoMenu != 0);
    
    

}
public static void removerCadastro(){
    Scanner scan = new Scanner(System.in);
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicajpa");
    EntityManager em = emf.createEntityManager();

    int opcaoMenu;
    do {
        System.out.println("Qual das tabelas terá os dados removidos: ");
        System.out.print("|*****************************|\n");
        System.out.print("| 1 - Table Usuarios          |\n");
        System.out.print("| 2 - Table Administracao     |\n");
        System.out.print("| 0 - Sair                    |\n");
        System.out.print("|*****************************|\n");
        System.out.print("Digite uma opção do menu: ");
        opcaoMenu = scan.nextInt();
        scan.nextLine();
        switch (opcaoMenu){
            case 1:
                Usuario user;
                System.out.print("Informe o id do perfil a ser removido: ");
                Integer id = scan.nextInt();
                scan.nextLine();
                user = em.find(Usuario.class,id);
                System.out.print(user+"\n");
                System.out.println("Este é o perfil que deseja remover? S - Sim ou N - Não");
                char resp = scan.nextLine().charAt(0);
                while (resp != 'S' && resp != 's'){
                    System.out.println("ok!");
                    System.out.print("Informe o id do perfil a ser removido: ");
                    int id2 = scan.nextInt();
                    scan.nextLine();
                    user = em.find(Usuario.class,id2);
                    System.out.println("Ok! então este perfil será removido");
                    em.getTransaction().begin();
                    em.remove(user);
                    em.getTransaction().commit();
                    System.out.println("Dados deletados com sucesso!");
                    break;
                }
                    em.getTransaction().begin();
                    em.remove(user);
                    em.getTransaction().commit();
                    System.out.println("Dados deletados com sucesso!");
                break;
            case 2:
                Administracao admin;
                System.out.print("Informe o id do perfil a ser removido: ");
                Integer id1 = scan.nextInt();
                scan.nextLine();
                admin = em.find(Administracao.class, id1);
                System.out.println(admin+"\n");
                System.out.println("Este é o perfil que deseja remover? S - Sim ou N - Não");
                char resp1 = scan.nextLine().charAt(0);
                while (resp1 != 'S' && resp1 != 's') {
                    System.out.println("ok!");
                    System.out.print("Informe o id do perfil a ser removido: ");
                    int cod = scan.nextInt();
                    scan.nextLine();
                    admin = em.find(Administracao.class, cod);
                    System.out.println("Ok! então este perfil será removido");
                    em.getTransaction().begin();
                    em.remove(admin);
                    em.getTransaction().commit();
                    System.out.println("Dados deletados com sucesso!");
                    break;
                }
                em.getTransaction().begin();
                em.remove(admin);
                em.getTransaction().commit();
                System.out.println("Dados deletados com sucesso!");
                break;
        }



    }while (opcaoMenu != 0);



}





}
