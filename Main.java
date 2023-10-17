import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Livro:");
        livro.exibir_info();
        livro.reservar();
        livro.exibir_info();
        livro.devolver();
        livro.exibir_info();
        livro.imprimir();

        System.out.println("Revista:");
        revista.exibir_info();
        revista.reservar();
        revista.exibir_info();
        revista.devolver();
        revista.exibir_info();
        revista.imprimir();


        Biblioteca biblioteca = new Biblioteca();

       Livro l1 = new Livro("O Príncipe "," Nicolau Maquiavél ", " Isbn1 " );

       biblioteca.addLivro(l1);
       boolean reserva1 = l1.reservar();
       System.out.println("Reserva efetuada!" + reserva1);

       Livro l2 = new Livro(" O Poder do Hábito "," Charles Duhigg ", " Isbn2 " );
       
       biblioteca.addLivro(l2);
       l2.devolver();
       System.out.println("Livro devolvido");

       Livro l3 = new Livro(" O Poder da Ação "," Paulo Vieira "," Isbn3 " );


       biblioteca.addLivro(l3);
       boolean emprestado = biblioteca.emprestar_livro("Isbn3");
       System.out.println("Emprestimo do l3 efetuado " + emprestado);

       Revista r1 = new Revista("Caras", "Abril", "2");
       Revista r2 = new REvista("Contigo", "Abril", "6");

       biblioteca.devolver_livro("Isbn3");

       
        String tituloBuscado = "O Príncipe";
        List<Livro> livrosEncontrados = biblioteca.buscar_por_titulo(tituloBuscado);
        System.out.println("Livro encontrado!");
        for(Livro livro : livrosEncontrados){
            System.out.println(livro.exibir_info());
        }

        System.out.println("Lista dos livros emprestados: " );
        List<Livro> livrosEmprestados = biblioteca.listar_Livros();
        for(Livro livro : livrosEmprestados){
            System.out.println(livro.exibir_info());
        }

     
    }
}