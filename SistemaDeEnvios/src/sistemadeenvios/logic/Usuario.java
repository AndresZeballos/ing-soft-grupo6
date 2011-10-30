/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios.logic;

import sistemadeenvios.logic.IUsuario;
import sistemadeenvios.persistence.IUserBuilder;
import java.util.ArrayList;

/**
 *
 * @author Fede
 */
public class Usuario implements IUsuario {

    private ArrayList<IPerfilUsuario> listaPerfiles;
    private String userName, password;

    /**
    * @return the userName
    */
    public String getUserName() {
        return userName;
    }

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
    public void addPerfil(IPerfilUsuario perfilUsuario)
    {
        this.listaPerfiles.add(perfilUsuario);
    }

    /*
     * se crea un user builder y se invoca el metodo de delete para borrar el
     * usuario de la base de datos.
     */
    public boolean borrarUsuario(){
        try:
            IUserBuilder constructor = new StubUserBuilder(this.userName);
            constructor.delete();
        catch
    }
}
