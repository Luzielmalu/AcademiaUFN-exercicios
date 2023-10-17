public class Revista extends Livro implements Imprimivel{
 private String titulo;
 private String empresa;
 private int edicao;
 private boolean emprestado;
 private int nroCopias;

public String Revista(String titulo, String autor, String isbn){
    super(titulo, autor, isbn);
    this.titulo = titulo;
    this.empresa = empresa;
    this.edicao = edicao;
    this.emprestado = false;
    this.nroCopias = 1;

}
public String getTitulo(){
    return = titulo;
}
public void setTitulo(String titulo){
    this.titulo = titulo;
} 
@override
public boolean  reservar(){
    if(emprestado == !emprestado){
        emprestado = true;
        return true;
    }else{
        return false;
        }
    }
@override   
public boolean devolver(){
    emprestado = false;
    return false;    
    
    }

@override
public boolean imprimir(){
    if(!emprestado){
            System.out.println("Impressão feita com sucesso!")

    }else{
            System.out.println("A revista não pode ser impresso.")
    }
        
}

public String exibir_info(){
    String statusEmprestado = emprestado? "emprestado" : "disponivel";
    System.out.println("Titulo: " + titulo + "Empresa: " + empresa + "Edição" + edicao + "Número de cópias: " + nroCopias + "Emprestado: " + emprestado);
    return statusEmprestado;
    
    }
}