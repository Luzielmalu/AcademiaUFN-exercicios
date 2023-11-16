package apresentacaoJpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;





@Entity
public class Administracao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "administracao")
    private List<Usuario> usuarios = new ArrayList<>();

    private String nome;


    private String tipoUsuario;

    public Administracao() {
    }


    public Administracao(Integer id, String nome, String tipoUsuario) {
        this.id = id;
        this.nome = nome;
        this.tipoUsuario = tipoUsuario;
    }

    public Administracao(Integer id, String nome, String tipoUsuario, List<Usuario> usuarios) {
        this.id = id;
        this.nome = nome;
        this.tipoUsuario = tipoUsuario;
        this.usuarios = usuarios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    @Override
    public String toString() {
        return "Administracao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                '}';
    }
}
