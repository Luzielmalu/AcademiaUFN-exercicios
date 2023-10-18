public class Livro  implements Imprimivel{
    private String titulo;
    private String autor;
    private String isbn;
    private boolean emprestado;

    public  Livro(String titulo, String autor, String isbn){
        

    this.titulo = titulo;
    this.autor = autor;
    this.isbn = isbn;
    this.emprestado = false;
    }
    public boolean  reservar(){
    if(!emprestado){
        emprestado = true;
        return true;
    }else{
        return false;
        }
    }
    public void devolver(){
    emprestado = false;

    
    }
    public String exibir_info(){
    String statusEmprestado = emprestado? "emprestado" : "disponivel";
    System.out.println("Titulo: " + titulo + "Autor: " + autor + "Isbn" + isbn + "Status: " + statusEmprestado );
    return statusEmprestado;
    
    }

    public String getTitulo(){
    return this.titulo;
    }
    public String getAutor(){
    return this.autor;
    }
    public String getIsbn(){
    return this.isbn;
    }
    public boolean getEmprestado(){
    return this.emprestado;
    }

    @Override
    public boolean imprimir() {
        if (!emprestado) {
            if (this instanceof Livro) {
            
            }
            return true;
        }
        return false;
    }
interface Imprimivel {
    boolean imprimir();
    }

}
