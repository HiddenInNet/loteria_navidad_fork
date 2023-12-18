package velazquez.loteria_navidad.dao;
import velazquez.loteria_navidad.models.Usuario;

public interface DAOUsuario {

    public Usuario getUsuario(String userName);

    public boolean registerUsuario(Usuario usuario);

    public boolean changePassword(String userName, String password);
}
