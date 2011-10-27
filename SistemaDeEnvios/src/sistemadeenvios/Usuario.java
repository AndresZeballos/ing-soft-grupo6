/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios;

import java.util.ArrayList;

/**
 *
 * @author Fede
 */
public class Usuario implements IUsuario {

    private ArrayList<IPerfilUsuario> listaPerfiles;
    private String userName, password;
    
    public Usuario(String userName, String password)
    {
        this.listaPerfiles = new ArrayList<IPerfilUsuario>();
        this.userName = userName;
        this.password = password;
    }

    public boolean validarPassword(String password)
    {
        return this.password.equals(password);
    }
    
    public boolean validarAcceso(String componente)
    {
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

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }
}
