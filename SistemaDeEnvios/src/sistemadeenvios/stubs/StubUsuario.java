/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios.stubs;

import java.util.ArrayList;
import sistemadeenvios.IUsuario;
import sistemadeenvios.IPerfilUsuario;

/**
 *
 * @author Andres
 */
public class StubUsuario implements IUsuario {

    private ArrayList<IPerfilUsuario> listaPerfiles;
    private String userName;
    private String password;

    public StubUsuario() {
        this.listaPerfiles = new ArrayList<IPerfilUsuario>();
        //this.permisos.add("");
        this.userName = "user";
        this.password = "pass";
    }
    public void addPerfil(IPerfilUsuario perfilUsuario)
    {
        this.listaPerfiles.add(perfilUsuario);
    }
    public boolean validarAcceso(String componente) {
        if (componente.equals("Administrar")) {
            return false;
        }
        boolean permitirAcceso = true;
        boolean containsAcceso = false;
        for(IPerfilUsuario p : this.listaPerfiles)
        {
            if (p.tieneComponente(componente))
            {
                containsAcceso = true;
                permitirAcceso = permitirAcceso && p.validarAcceso(componente);
            }
        }
        if (!containsAcceso)
        {
            permitirAcceso = false;
        }
        return permitirAcceso;
    }

    public boolean validarPassword(String password) {
        return this.password.equals(password);
    }

    public String getUserName() {
        return this.userName;
    }
}
