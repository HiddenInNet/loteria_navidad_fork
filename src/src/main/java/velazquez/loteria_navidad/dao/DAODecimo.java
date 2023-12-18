package velazquez.loteria_navidad.dao;

import velazquez.loteria_navidad.models.Decimo;
import velazquez.loteria_navidad.models.Usuario;

import java.util.ArrayList;

public interface DAODecimo {

    /**
     * Devuelve un array con todos los decimos que pertenecen al usuario introducido.
     *
     * @param usuario
     * @return ArrayList<Decimo>
     */
    public ArrayList<Decimo> getDecimos(Usuario usuario);

    /**
     * Introducimos el decimo que queremos añadir a la base de datos.
     *
     * @param decimo
     * @return boolean
     */
    public boolean addDecimo(Decimo decimo);

    /**
     * Elimina un decimo de la base de datos indicando su numero.
     *
     * @param numero
     * @return boolean
     */
    public boolean deleteDecimo(int numero);

}
