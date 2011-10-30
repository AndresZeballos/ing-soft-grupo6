/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios.stubs;


import java.sql.SQLException;
import sistemadeenvios.persistence.IUserBuilder;
import sistemadeenvios.persistence.IUserBuilder;
import sistemadeenvios.logic.IUsuario;
import sistemadeenvios.logic.Usuario;
import sistemadeenvios.logic.UsuarioAdministrador;
import sistemadeenvios.stubs.StubPerfilConsultar;

/*
 * @author Fede
 */
public class StubUserBuilder implements IUserBuilder{

    public String getUserName(String userName) throws SQLException
    {
            IUsuario nuevoUsuario = null;
            if (userName.equalsIgnoreCase("admin"))
            {
                //nuevoUsuario = new UsuarioAdministrador();
                return "admin";
            }
            else if (userName.equalsIgnoreCase("usuario"))
            {
//                nuevoUsuario = new Usuario("consultar");
//                sistemadeenvios.logic.IPerfilUsuario perfil = new StubPerfilConsultar();
//                nuevoUsuario.addPerfil(perfil);
                return "usuario";
            }
            else if (userName.equalsIgnoreCase("consulta"))
            {
                return "consulta";
            }
            else
            {
                throw new SQLException();
            }
    }

    public String getPassword(String userName) throws SQLException
    {
        if (true)
        {
            return "1234";
        }
        else
        {
            throw new SQLException();
        }
    }

    public ArrayList<IPerfilBuilder> getPerfiles(String userName) throws SQLException
    {
        ArrayList
    }

    public void crearUsuario(String userName, String password,
                      ArrayList<String> perfiles) throws SQLException
    {
        if false
        {
            return new SQLException();
        }
    }
    void borrarUsuario(String userName) throws SQLException;
    void modificarUsuario(String userName, String password,
                          ArrayList<String> perfiles) throws SQLException;

}

