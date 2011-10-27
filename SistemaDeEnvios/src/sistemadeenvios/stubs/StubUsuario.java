/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios.stubs;

import java.util.ArrayList;
import sistemadeenvios.IUsuario;

/**
 *
 * @author Andres
 */
public class StubUsuario implements IUsuario{

    private ArrayList<String> permisos;
    public StubUsuario()
    {
        this.permisos = new ArrayList<String>();
        this.permisos.add("");
    }
    public boolean validarAcceso(String componente) {
        return true;
    }
    public boolean validarPassword(String password)
    {
        return password.equals("user");
    }

}
