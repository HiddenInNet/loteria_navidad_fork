package velazquez.loteria_navidad.dao;

import velazquez.loteria_navidad.models.Usuario;
import velazquez.loteria_navidad.db.PoolDBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUsuarioImpl implements DAOUsuario {


    public DAOUsuarioImpl() {
    }

    @Override
    public Usuario getUsuario(String userName) {

        Usuario usuario = null;
        Connection con = null;

        try {
            String sql = "SELECT * FROM usuarios WHERE usuario=?";

            PoolDBContext pool = new PoolDBContext();
            con = pool.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, userName);

            ResultSet rs = statement.executeQuery();
            // Como el campo de búsqueda es la clave solo debería obtener un resultado
            // si no es así estaremos machacando cada vez el valor de customer y
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPassword(rs.getString("password"));
                usuario.setRole(rs.getString("role"));
                usuario.setNombre(rs.getString("nombre"));

            }
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return usuario;
    }

    @Override
    public boolean registerUsuario(Usuario usuario) {
        int resultado = 0;
        Connection con = null;

        try {
            String sql = "INSERT INTO usuarios VALUES(?,?,?,?)";

            PoolDBContext pool = new PoolDBContext();
            con = pool.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, usuario.getUsuario());
            statement.setString(2, usuario.getPassword());
            statement.setString(3, usuario.getRole());
            statement.setString(4, usuario.getNombre());

            resultado = statement.executeUpdate();

            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return (resultado != 0);
    }

    @Override
    public boolean changePassword(String userName, String password) {
        int resultado = 0;
        Connection con = null;

        try {
            String sql = "UPDATE Usuario SET contraseña = ? WHERE nombreUsuario = ?";

            PoolDBContext pool = new PoolDBContext();
            con = pool.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, password);
            statement.setString(2, userName);

            resultado = statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return (resultado != 0);
    }
}
