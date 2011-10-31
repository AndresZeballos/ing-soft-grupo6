/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios.stubs;

import sistemadeenvios.persistence.IPerfilBuilder;
import java.util.ArrayList;

/**
 *
 * @author agustin
 */
public class StubPerfilBuilder implements IPerfilBuilder {
    /*public String getPerfilName() throws SQLException{
    if (true)
    {
    return "consulta";
    }
    else
    {
    throw new SQLException();
    }
    }*/

    public boolean existePerfil(String perfilName) {
        return true;
    }

    public ArrayList<String> getPermisos(String perfilName) {
        ArrayList<String> permisos = new ArrayList<String>();
        //permisos.add("prueba");
        return permisos;
    }
}
