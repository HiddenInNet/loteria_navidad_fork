package velazquez.loteria_navidad.dao;

import velazquez.loteria_navidad.db.PoolDBContext;
import velazquez.loteria_navidad.models.Decimo;
import velazquez.loteria_navidad.models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAODecimoImpl implements DAODecimo{

    @Override
    public ArrayList<Decimo> getDecimos(Usuario usuario) {

        ArrayList<Decimo> decimos = null;
        Decimo decimo = null;

        try {
            String sql = "SELECT * FROM decimos WHERE usuario = ?";

            Connection con = null;
            PoolDBContext pool = new PoolDBContext();
            con = pool.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, usuario.getUsuario());

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                decimo = new Decimo();
                decimo.setNumero(rs.getInt("numero"));
                decimo.setGrupo(rs.getString("grupo"));
                decimo.setCantidad(rs.getInt("cantidad"));
                decimo.setFraccion(rs.getString("fraccion"));
                decimo.setSerie(rs.getString("serie"));
                decimo.setUsuario(rs.getString("usuario"));

                decimos.add(decimo);
            }
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return decimos;
    }

    @Override
    public boolean addDecimo(Decimo decimo) {
        int resultado = 0;

        try {
            String sql = "INSERT INTO decimos VALUES (?,?,?,?,?,?)";

            Connection con = null;
            PoolDBContext pool = new PoolDBContext();
            con = pool.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, decimo.getNumero());
            statement.setString(2, decimo.getGrupo());
            statement.setInt(3, decimo.getCantidad());
            statement.setString(4, decimo.getFraccion());
            statement.setString(5, decimo.getSerie());
            statement.setString(6, decimo.getUsuario());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return (resultado != 0);
    }

    @Override
    public boolean deleteDecimo(int numero) {

        return false;
    }
}
