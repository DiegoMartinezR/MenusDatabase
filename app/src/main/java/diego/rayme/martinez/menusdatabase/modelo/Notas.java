package diego.rayme.martinez.menusdatabase.modelo;

import com.orm.dsl.Table;

import java.util.Date;
@Table
public class Notas {

    private Long id;
    private String titulo;
    private String contenido;
    private Date fecha;
    private Boolean favorito;
    private Boolean archivar;


    public Notas(String titulo, String contenido, Date fecha, Boolean favorito, Boolean archivar) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
        this.favorito = favorito;
        this.archivar = archivar;
    }

    public Notas() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }

    public Boolean getArchivar() {
        return archivar;
    }

    public void setArchivar(Boolean archivar) {
        this.archivar = archivar;
    }


    @Override
    public String toString() {
        return "Notas{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", contenido='" + contenido + '\'' +
                ", fecha=" + fecha +
                ", favorito=" + favorito +
                ", archivar=" + archivar +
                '}';
    }
}
