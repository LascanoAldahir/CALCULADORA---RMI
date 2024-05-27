import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Implementacion extends UnicastRemoteObject implements interfaz {
    // Constructor
    public Implementacion() throws RemoteException {
        super();
    }

    // Implementar los métodos de la interfaz
    public String mensaje() throws RemoteException {
        return "Hola desde el servidor";
    }

    public double suma(double a, double b) throws RemoteException {
        return a + b;
    }

    public double resta(double a, double b) throws RemoteException {
        return a - b;
    }

    public double multiplicacion(double a, double b) throws RemoteException {
        return a * b;
    }

    public double division(double a, double b) throws RemoteException {
        if (b == 0) {
            throw new RemoteException("División por cero no permitida");
        }
        return a / b;
    }
}
