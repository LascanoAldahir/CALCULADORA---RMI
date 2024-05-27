import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class servidor {
    public static void main(String[] args) throws RemoteException {
        try {
            // Crear una instancia de la implementación de la interfaz
            interfaz objetoRemoto = new Implementacion();
            // Crear registro RMI en un puerto específico
            Registry registro = LocateRegistry.createRegistry(1099);
            // Vincular la implementación remota con un nombre específico
            registro.rebind("ClienteRemoto", objetoRemoto);
            System.out.println("Servidor iniciado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
