/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios.stubs;

import java.util.ArrayList;
import sistemadeenvios.logic.IPerfilUsuario;
import sistemadeenvios.persistence.IUserBuilder;

/*
 * @author Fede
 */
public class StubUserBuilder implements IUserBuilder {

    public boolean existeUserName(String userName) {
        return true;
    }

    public String getPassword(String userName) {
        return userName;
    }

    public ArrayList<IPerfilUsuario> getPerfiles(String userName) {
        ArrayList<IPerfilUsuario> listaPerfiles = new ArrayList<IPerfilUsuario>();
        if (userName.equalsIgnoreCase("admin")) {
            listaPerfiles.add(new StubPerfilAdministrador());
        } else if (userName.equalsIgnoreCase("funcionario")) {
            listaPerfiles.add(new StubPerfilFuncionario());
        } else /* if (userName.equalsIgnoreCase("consultor")) */ {
            listaPerfiles.add(new StubPerfilConsultar());
        }
        return listaPerfiles;
    }

    public void crearUsuario(String userName, String password,
            ArrayList<String> perfiles) {
    }

    public void borrarUsuario(String userName) {
    }

    public void modificarUsuario(String userName, String password,
            ArrayList<String> perfiles) {
    }
}
