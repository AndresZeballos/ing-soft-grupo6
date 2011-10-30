/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios.stubs;

import java.util.ArrayList;
import sistemadeenvios.logic.IUsuario;
import sistemadeenvios.logic.IPerfilUsuario;
import java.sql.SQLException;

/**
 *
 * @author Andres
 */
public class StubUsuario implements IUsuario {

    private ArrayList<IPerfilUsuario> listaPerfiles;
    private String userName;
    private String password;


    public String getUserName() {
        return this.userName;
    }

    public StubUsuario() {
        this.listaPerfiles = new ArrayList<IPerfilUsuario>();
        //this.permisos.add("");
        this.userName = "user";
        this.password = "pass";
    }
    public boolean addPerfil(IPerfilUsuario perfilUsuario)
    {
        try{
            this.listaPerfiles.add(perfilUsuario);
            IUserBuilder constructor = new StubUserBuilder(this.userName);
            constructor.addPerfil(perfilUsuario);
            return true;
        }
        catch (SQLException ex){
            return false;
        }
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

    boolean crearUsuario();
    boolean borrarUsuario();
    boolean modificarUsuario();
}
