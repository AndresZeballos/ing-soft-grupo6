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
    public Usuario()
    {
        this.listaPerfiles = new ArrayList<IPerfilUsuario>();
    }
    public boolean validarAcceso(String componente)
    {
        boolean permitirAcceso = true;
        boolean containsAcceso = false;
        for(IPerfilUsuario p : this.listaPerfiles)
        {
            if (p.TieneComponente(componente))
            {
                containsAcceso = true;
                permitirAcceso = permitirAcceso && p.ValidarAcceso(componente);
            }
        }
        if (!containsAcceso)
        {
            permitirAcceso = false;
        }
        return permitirAcceso;
    }
}
