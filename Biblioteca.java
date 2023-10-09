public class Biblioteca {
    
    public static void main(String[] args) throws Exception {
        Livro l1 = new Livro("O principe", "Nicolau Maquiavel", 224, 5);
        
        
        l1.virarPagina();
        System.out.println(("Após virar a página"));
        l1.retrocederPagina();
        l1.IrParaPagina(100);
        System.out.print(("Ir para página 100"));
        
    
        
    }
    
}

        

