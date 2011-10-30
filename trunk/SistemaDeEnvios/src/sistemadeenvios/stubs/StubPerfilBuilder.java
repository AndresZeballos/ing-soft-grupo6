/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios.stubs;

import sistemadeenvios.persistence.IPerfilBuilder;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author agustin
 */
public class StubPerfilBuilder implements IPerfilBuilder{
    public String getPerfilName() throws SQLException{
        if (true)
        {
            return "consulta";
        }
        else
        {
            throw new SQLException();
        }
    }

    public boolean existePerfil(String perfilName) throws SQLException{
        if (true)
        {
            return true;
        }
        else{
            throw new SQLException();
        }
    }

    public ArrayList<String> getPermisos(String perfilName) throws SQLException{
        if (true)
        {
            ArrayList<String> permisos = new ArrayList<String>();
            permisos.add("prueba");
            return permisos;
        }
        else
        {
            throw new SQLException();
        }
    }
}
