public class Revista implements Imprimivel {
    private String titulo;
    private String empresa;
    private int edicao;
    private boolean emprestado;
    private int nroCopias;

    
    public Revista(String titulo, String empresa, int edicao) {
        this.titulo = titulo;
        this.empresa = empresa;
        this.edicao = edicao;
        this.emprestado = false; 
        this.nroCopias = 1;
    }

    
    public boolean reservar() {
        if (!emprestado) {
            emprestado = true;
            return true;
        }
        return false;
    }

    
    public void devolver() {
        emprestado = false;
    }

    
    public String exibir_info() {
        return "Título: " + titulo + "\nEmpresa: " + empresa + "\nEdição: " + edicao + "\nEmpréstimo: " + emprestado + "\nNúmero de cópias: " + nroCopias;
    }

    
    @Override
    public boolean imprimir() {
        if (!emprestado) {
            if (this instanceof Revista) {
                nroCopias++;
            }
            return true;
        }
        return false;
    }
}


interface Imprimivel {
    boolean imprimir();
}
