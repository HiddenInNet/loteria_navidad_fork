package velazquez.loteria_navidad.models;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String usuario;     // Nombre de usuario
    private String password;    // Contraseña del usuario
    private String role;        // Rol
    private String nombre;      // Nombre completo

    public Usuario() {}

    public Usuario(String usuario, String password, String nombre, String role) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.role = role;
    }

    // --- [ GETTERS & SETTERS ] ---

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

