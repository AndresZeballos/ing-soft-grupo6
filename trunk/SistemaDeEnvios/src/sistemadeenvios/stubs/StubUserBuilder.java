/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios.stubs;

import sistemadeenvios.persistence.IUserBuilder;
import sistemadeenvios.logic.IUsuario;

/**
 *
 * @author Fede
 */
public class StubUserBuilder implements IUserBuilder{
    public IUsuario getUser(String userName)
    {
        IUsuario nuevoUsuario = null;
        if (userName.equalsIgnoreCase("admin"))
        {
            nuevoUsuario = new sistemadeenvios.stubs.UsuarioAdministrador();
        }
        else if (userName.equalsIgnoreCase("consultar"))
        {
            nuevoUsuario = new sistemadeenvios.logic.Usuario("consultar", "consultar");
            sistemadeenvios.logic.IPerfilUsuario perfil = new StubPerfilConsultar();
            nuevoUsuario.addPerfil(perfil);
        }
        return nuevoUsuario;
    }
}
