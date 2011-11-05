/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios.drivers;

import java.util.Random;
import sistemadeenvios.logic.IPerfilUsuario;
import sistemadeenvios.logic.PerfilUsuario;

/**
 *
 * @author Fede
 */
public class DriverPerfil {

    public static void main(String args[]) {
        IPerfilUsuario perfil = new PerfilUsuario("nuevoPerfil");
        probarPermisos(perfil);
        crearPerfil(perfil);
        modificarPerfil(perfil);
        borrarPerfil(perfil);
    }

    private static String randomString(int length) {
        Random random = new Random();
        char[] buf = new char[length];
        char[] symbols = new char[36];
        for (int idx = 0; idx < 10; ++idx) {
            symbols[idx] = (char) ('0' + idx);
        }
        for (int idx = 10; idx < 36; ++idx) {
            symbols[idx] = (char) ('a' + idx - 10);
        }

        for (int idx = 0; idx < buf.length; ++idx) {
            buf[idx] = symbols[random.nextInt(symbols.length)];
        }
        return new String(buf);
    }

    private static void probarPermisos(IPerfilUsuario perfil) {
        System.out.println("================ Agregar Permisos ==================");
        System.out.println("addPermisos");
        System.out.println("Se agrega permiso 'nuevoEnvio'");
        perfil.agregarAcceso("nuevoEnvio");
        System.out.println("Verificar que el perfil contiene el permiso agregado \"nuevoEnvio\": " + perfil.tieneComponente("nuevoEnvio"));
        System.out.println("Verificar que el perfil NO contiene el permiso \"nuevoEnvio1\": " + perfil.tieneComponente("nuevoEnvio1"));
        System.out.println("");
        System.out.println("Se prueban 5 permisos al azar");
        String randomComp;
        for (int i = 0; i < 5; i++) {
            randomComp = randomString(10);
            System.out.println("Validar acceso a componente " + randomComp + " : " + perfil.validarAcceso(randomComp));
        }
    }

    private static void crearPerfil(IPerfilUsuario perfil) {
        System.out.println("================ Crear Perfiles ==================");
        System.out.println("crearPerfil nuevo");
        System.out.println("Debe retornar \"true\": " + perfil.crearPerfil());

        System.out.println("");
        System.out.println("crearPerfil existente");
        System.out.println("Debe retornar \"false\": " + perfil.crearPerfil());
    }

    private static void borrarPerfil(IPerfilUsuario perfil) {
        System.out.println("================ Borrar Perfiles ==================");
        System.out.println("borrarPerfil existente");
        System.out.println("Debe retornar \"true\": " + perfil.borrarPerfil());

        System.out.println("");
        System.out.println("borrarPerfil no existente");
        System.out.println("Debe retornar \"false\": " + perfil.borrarPerfil());
    }

    private static void modificarPerfil(IPerfilUsuario perfil) {
        System.out.println("================ Modificar Perfiles ==================");
        perfil.agregarAcceso("modificarUsuario");
        perfil.agregarAcceso("crearUsuario");

        System.out.println("modificarPerfil - Agrega permisos: modificarUsuario y crearUsuario");
        System.out.println("Debe retornar \"true\": " + perfil.modificarPerfil());

        System.out.println("");
        System.out.println("Verifica permiso modificarUsuario");
        System.out.println("Debe retornar \"true\": " + perfil.validarAcceso("modificarUsuario"));

        System.out.println("");
        System.out.println("Verifica permiso crearUsuario");
        System.out.println("Debe retornar \"true\": " + perfil.validarAcceso("crearUsuario"));

        System.out.println("");
        System.out.println("Verifica permiso nuevoEnvio");
        System.out.println("Debe retornar \"true\": " + perfil.validarAcceso("nuevoEnvio"));

        System.out.println("");
        System.out.println("Se prueban 5 permisos al azar");
        String randomComp;
        for (int i = 0; i < 5; i++) {
            randomComp = randomString(10);
            System.out.println("Validar acceso a componente " + randomComp + " : " + perfil.validarAcceso(randomComp));
        }
    }
}
