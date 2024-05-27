import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class cliente {
    public static void main(String[] args) throws RemoteException {
        // Obtener el registro
        Registry registro;
        try {
            registro = LocateRegistry.getRegistry("localhost", 1099);
            // Crear instancia de la implementación de la interfaz
            interfaz objetoRemoto = (interfaz) registro.lookup("ClienteRemoto");
            
            // Mensaje del servidor
            String mensaje = objetoRemoto.mensaje();
            System.out.println(mensaje);
            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;

            while (continuar) {
                System.out.println("Seleccione la operación: suma, resta, multiplicacion, division");
                String operacion = scanner.nextLine();

                System.out.println("Ingrese el primer número:");
                double num1 = scanner.nextDouble();

                System.out.println("Ingrese el segundo número:");
                double num2 = scanner.nextDouble();

                double resultado = 0;

                switch (operacion) {
                    case "suma":
                        resultado = objetoRemoto.suma(num1, num2);
                        break;
                    case "resta":
                        resultado = objetoRemoto.resta(num1, num2);
                        break;
                    case "multiplicacion":
                        resultado = objetoRemoto.multiplicacion(num1, num2);
                        break;
                    case "division":
                        try {
                            resultado = objetoRemoto.division(num1, num2);
                        } catch (RemoteException e) {
                            System.out.println("Error: " + e.getMessage());
                            continue;
                        }
                        break;
                    default:
                        System.out.println("Operación no válida.");
                        continue;
                }

                System.out.println("El resultado de la " + operacion + " es: " + resultado);
                
                scanner.nextLine(); // Consumir la nueva línea pendiente

                System.out.println("¿Desea realizar otra operación? (s/n)");
                String respuesta = scanner.nextLine();
                if (respuesta.equalsIgnoreCase("n")) {
                    continuar = false;
                }
            }
            
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
