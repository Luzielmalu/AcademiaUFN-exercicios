public class Livro {
    private String titulo;
    private String autor;
    private int nroPaginas;
    private int paginaAtual;


public Livro(String titulo, String autor, int nroPaginas, int paginaAtual){
            this.titulo = titulo;
            this.autor = autor;
            this.nroPaginas = nroPaginas;
            this.paginaAtual = 1;

        System.out.println("Titulo: " + this.titulo );
        System.out.println("Autor: " + this.autor);
        System.out.println("Numero de páginas: " + this.nroPaginas);
        System.out.println("Página atual: " + this.paginaAtual);
        
        
        }
        public String getInformacoes(){
            return "Titulo: " + this.titulo + "Autor: " + this.autor + "Páginas: " + this.nroPaginas + "Página atual: " + this.paginaAtual + ".";
        }
        public int getPaginaAtual(){
            return this.paginaAtual;
        }
        public int getNroPaginas(){
            return this.nroPaginas;
        }
        public void virarPagina(){
            this.IrParaPagina(this.getPaginaAtual()+ 1);
        }
        public void retrocederPagina(){
            this.IrParaPagina(this.getPaginaAtual()- 1);
        }
        public void IrParaPagina(int pagina){
            if(pagina > this.getNroPaginas()){
                return;
            }
            if (pagina < 1){
                return;
            }
            this.setPagina(pagina);
        }
        private void setPagina(int pagina){
            this.paginaAtual = pagina;
        }
       
}

