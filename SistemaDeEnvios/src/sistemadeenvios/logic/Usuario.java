/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios.logic;

import sistemadeenvios.logic.PerfilAdministrador;
import sistemadeenvios.logic.PerfilUsuario;
import sistemadeenvios.persistence.IPerfilBuilder;
import sistemadeenvios.persistence.IUserBuilder;
import sistemadeenvios.stubs.StubUserBuilder;
import sistemadeenvios.stubs.StubPerfilConsultar;
import java.util.ArrayList;
import java.sql.SQLException;

/*
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

    public Usuario(String userName) throws SQLException{
        IUserBuilder userBuilder = new StubUserBuilder();
        try{
            this.userName = userBuilder.getUserName(userName);
            this.password = userBuilder.getPassword(userName);
            IPerfilUsuario nuevoPerfil = null;
            for (IPerfilBuilder p : userBuilder.getPerfiles(userName)){
                if (p.getPerfilName() == "admin"){
                     nuevoPerfil = new PerfilAdministrador();
                }
                else if (p.getPerfilName() == "usuario"){
                    nuevoPerfil = new PerfilUsuario();
                }
                else if (p.getPerfilName() == "consultar"){
                    nuevoPerfil = new PerfilConsultar();
                }
                for (String s : p.getPermisos(userName))
                {
                    nuevoPerfil.agregarAcceso(s, true);
                }
                this.listaPerfiles.add(nuevoPerfil);
            }
        }
        catch (SQLException ex){
            throw ex;
        }
    }

    public Usuario(String userName, String password,
                                    ArrayList<String> listaPerfiles){
        for (String s : listaPerfiles){
            IPerfilUsuario perfil = new StubPerfilConsultar();
        }
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

    public boolean addPerfil(IPerfilUsuario perfilUsuario)
    {
        this.listaPerfiles.add(perfilUsuario);
        return true;
    }

    /*
     * se crea un user builder y se invoca el metodo de delete para borrar el
     * usuario de la base de datos.
     */

    public boolean crearUsuario()
    {
        return true;
    }

    public boolean borrarUsuario(){
        try
        {
            IUserBuilder constructor = new StubUserBuilder();
            constructor.borrarUsuario(this.userName);
            return true;
        }
        catch (SQLException ex)
        {
            return false;
        }
    }

    public boolean modificarUsuario()
    {
        return true;
    }
}
