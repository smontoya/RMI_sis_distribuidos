package rmi;

import eda.Usuario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi_interface.Interface;

/**
 *
 * @author Daniel Wladdimiro Cottet
 * @title Taller de sistemas distribuidos - Clase 1
 */

public class Usuarios extends UnicastRemoteObject implements Interface {
    
    static ArrayList<Usuario> usuarios;
    
    static Logger logger;

    public Usuarios() throws RemoteException {
        logger = Logger.getLogger(getClass().getName());
        logger.log(Level.INFO, "Se ha instanciado la clase de Usuarios del Servidor");
        usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario(0, "admin", "admin", "Administracion", "1-1"));
    }

    /*
     * Debo escribir todos los métodos que se encuentran en la interface
     */
    // Por cada metodo se escribe Override que se utiliza para que utilize este metodo en vez del metodo del padre
    /*
    public ArrayList<Usuario> verTweets() throws RemoteException {
        logger.log(Level.INFO, "Se desea ver los usuarios del servidor1");
        //Inicializamos el arreglo de tweets para retornarnos al cliente
        ArrayList<Usuario> tweets = new ArrayList<>();
        
        //Agregamos un tweet a la lista
        Usuario tweet = new Usuario(1, "@dwladdimiroc", "Terremoto en Chile");
        tweets.add(tweet);
        
        //Agregamos un segundo tweet a la lista
        tweet = new Usuario(2, "@24hrs", "Grado 8.2");
        tweets.add(tweet);
        
        //Agregamos un tercer tweet a la lista
        tweet = new Usuario(3, "@biobio", "Estaremos reportando");
        tweets.add(tweet);
        
        logger.log(Level.INFO, "Retorno de tweets");
        //Retornarnos todos los tweets
        return tweets;
    }
*/
    @Override
    public ArrayList listar() throws RemoteException {
        return Usuarios.usuarios;
    }

    @Override
    public Object ver(int id) throws RemoteException {
        for (Usuario usuario : usuarios){
            if (usuario.getIdUsuario() == id)
                return usuario;
        }
        return null;
    }

    @Override
    public void editar(Object elemento) throws RemoteException {
        Usuario usuario = (Usuario) elemento;
        for (int i = 0; i < usuarios.size();i++){
            Usuario user = usuarios.get(i);
            if (user.getIdUsuario() == usuario.getIdUsuario()){
              usuarios.set(i, usuario);
            }
        }
    }

    @Override
    public void agregar(Object elemento) throws RemoteException {
        usuarios.add((Usuario)elemento);
    }

}
