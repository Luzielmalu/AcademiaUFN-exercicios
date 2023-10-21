public class Revista implements Imprimivel {
    private String titulo;
    private String empresa;
    private int edicao;
    private boolean emprestado;
    private int nroCopias;

    
    public Revista(String titulo, String empresa, int edicao, int nroCopias) {
        this.titulo = titulo;
        this.empresa = empresa;
        this.edicao = edicao;
        this.emprestado = false; 
        this.nroCopias = 1;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getEmpresa() {
        return empresa;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    public int getEdicao() {
        return edicao;
    }
    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
    public boolean isEmprestado() {
        return emprestado;
    }
    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
    public int getNroCopias() {
        return nroCopias;
    }
    public void setNroCopias(int nroCopias) {
        this.nroCopias = nroCopias;
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
