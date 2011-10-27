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
public class StubUsuario implements IUsuario {

    private ArrayList<String> permisos;
    private String userName;

    public StubUsuario() {
        this.permisos = new ArrayList<String>();
        this.permisos.add("");
        this.userName = "user";
    }

    public boolean validarAcceso(String componente) {
        if (componente.equals("Administrar")) {
            return false;
        }
        return true;
    }

    public boolean validarPassword(String password) {
        return password.equals("user");
    }

    public String getUserName() {
        return this.userName;
    }
}
