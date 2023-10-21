import java.util.ArrayList;
import java.util.List;

public class Biblioteca  {
    
    private List<Livro> catalogo;
    private List<Revista> catalogo2;
    

    public Biblioteca(){
        catalogo = new ArrayList<>();
        catalogo2 = new ArrayList<>();

    }
    public void addLivro(Livro livro){
        catalogo.add(livro);
    }
    public void addRevista(Revista revista){
        catalogo2.add(revista);
    }
    public void  remover_livro(String isbn){
      catalogo.removeIf(livro -> livro.getIsbn().equals(isbn));

    }
    public void remover_revista(String titulo){
        catalogo2.removeIf(revista -> revista.getTitulo().equals(titulo));
    }
    public List<Livro> buscar_por_titulo(String titulo){
       List<Livro> livrosEncontrados = new ArrayList<>();
       for(Livro livro : catalogo){
            if (livro.getTitulo().contains(titulo)){
                livrosEncontrados.add(livro);
            }
        
        }
        return livrosEncontrados;
    }
    
       
    public boolean emprestar_livro(String isbn){
        for (Livro livro : catalogo){
            if (livro.getIsbn().equals(isbn)){
                return livro.reservar();
            }
                
        }
        return false;
    }
    public boolean empres_revista(String titulo){
        for (Revista revista : catalogo2){
            if (revista.getTitulo().equals(titulo)){
                return revista.reservar();
            }
                
        }
        return false;
    }
    
    public void devolver_livro(String isbn){
       for (Livro livro : catalogo){
        if (livro.getIsbn().equals(isbn)){
            livro.devolver();
            break;
        }
       }
    }
    public void devolver_revista(String titulo){
        for (Revista revista : catalogo2){
        if (revista.getTitulo().equals(titulo)){
            revista.devolver();
            break;
        }
    }
    }
    public List<Livro> listar_Livros(){
        return catalogo;

    }
    
}