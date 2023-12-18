package velazquez.loteria_navidad.models;

import java.io.Serializable;

public class Decimo implements Serializable {

    private Integer numero;     // Numero
    private String grupo;       // Grupo
    private Integer cantidad;   // Numero de decimos
    private String fraccion;    // Fraccion
    private String serie;       // Serie
    private String usuario;    // Usuario a quien pertenece el decimo

    public Decimo () {}

    public Decimo(Integer numero, String grupo, Integer cantidad, String fraccion, String serie, String usuario) {
        this.numero = numero;
        this.grupo = grupo;
        this.cantidad = cantidad;
        this.fraccion = fraccion;
        this.serie = serie;
        this.usuario = usuario;
    }

    // --- [ GETTERS & SETTERS ] ---

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getFraccion() {
        return fraccion;
    }

    public void setFraccion(String fraccion) {
        this.fraccion = fraccion;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
