/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios.drivers;

import java.util.ArrayList;
import java.util.Random;
import sistemadeenvios.logic.IPerfilUsuario;
import sistemadeenvios.logic.PerfilUsuario;
import sistemadeenvios.persistence.IPerfilBuilder;
import sistemadeenvios.stubs.StubPerfilBuilder;

/**
 *
 * @author Fede
 */
public class DriverPerfil {
    public static void main(String args[]) {
        IPerfilBuilder builder = new StubPerfilBuilder();
        crearPerfil(builder);
        borrarPerfil(builder);
        modificarPerfil(builder);
        IPerfilUsuario perfil = new PerfilUsuario("nuevoPerfil");
        addPermisos(perfil);
        validarAccesoAdmin(builder);
    }

    private static void validarAccesoAdmin(IPerfilBuilder builder) {
        System.out.println("================ Validar Administrador ==================");
        IPerfilUsuario admin = builder.getPerfil("administrador");
        System.out.println("Se prueban 5 permisos al azar");
        String randomComp;
        for (int i = 0; i < 5; i++)
        {
            randomComp = randomString(10);
            System.out.println("Validar acceso a componente " + randomComp + " : "+admin.validarAcceso(randomComp));
        }
    }
    private static String randomString(int length)
    {
        Random random = new Random();
        char[] buf = new char[length];
        char[] symbols = new char[36];
        for (int idx = 0; idx < 10; ++idx)
        {
            symbols[idx] = (char) ('0' + idx);
        }
        for (int idx = 10; idx < 36; ++idx)
        {
            symbols[idx] = (char) ('a' + idx - 10);
        }

        for (int idx = 0; idx < buf.length; ++idx)
        {
            buf[idx] = symbols[random.nextInt(symbols.length)];
        }
        return new String(buf);
    }

    private static void addPermisos(IPerfilUsuario perfil) {
        System.out.println("================ Agregar Permisos ==================");
        System.out.println("addPermisos");
        System.out.println("Se agrega permiso 'nuevoEnvio'");
        perfil.agregarAcceso("nuevoEnvio");
        System.out.println("Verificar que el perfil contiene el permiso agregado \"nuevoEnvio\": " + perfil.tieneComponente("nuevoEnvio"));
        System.out.println("Verificar que el perfil NO contiene el permiso \"nuevoEnvio1\": " + perfil.tieneComponente("nuevoEnvio1"));
    }

    private static void crearPerfil(IPerfilBuilder builder) {
        System.out.println("================ Crear Perfiles ==================");
        System.out.println("crearPerfil nuevo");
        System.out.println("Debe retornar \"true\": " + builder.crearPerfil("perfilNuevo"));

        System.out.println("");
        System.out.println("crearPerfil existente");
        System.out.println("Debe retornar \"false\": " + builder.crearPerfil("funcionario"));
    }

    private static void borrarPerfil(IPerfilBuilder builder) {
        System.out.println("================ Borrar Perfiles ==================");
        System.out.println("borrarPerfil existente");
        System.out.println("Debe retornar \"true\": " + builder.borrarPerfil("funcionario"));

        System.out.println("");
        System.out.println("borrarPerfil no existente");
        System.out.println("Debe retornar \"false\": " + builder.borrarPerfil("nuevoPerfil"));

        System.out.println("");
        System.out.println("borrarPerfil administrador");
        System.out.println("Debe retornar \"false\" No se puede borrar el administrador: " + builder.borrarPerfil("administrador"));
    }

    private static void modificarPerfil(IPerfilBuilder builder) {
        ArrayList permisos = new ArrayList();
        System.out.println("================ Modificar Perfiles ==================");
        permisos.add("ConsultarEnvio");
        System.out.println("modificarPerfil existente");
        System.out.println("Debe retornar \"true\": " + builder.modificarPerfil("funcionario",permisos));

        System.out.println("");
        System.out.println("modificarPerfil no existente");
        System.out.println("Debe retornar \"false\": " + builder.modificarPerfil("nuevoPerfil",permisos));

        System.out.println("");
        System.out.println("modificarPerfil administrador");
        System.out.println("Debe retornar \"false\". No se puede modificar el perfil admin: " + builder.modificarPerfil("administrador", permisos));
    }

}
