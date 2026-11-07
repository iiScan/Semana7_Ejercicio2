import java.util.Scanner;

public class MainSistemaSeguridad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int MAX = 3;
        SistemaSeguridad[] sistemas = new SistemaSeguridad[MAX];

        int indiceActual = 0;
        int opcion;

        do {
            System.out.println("\n--- MENÚ DE SISTEMAS DE SEGURIDAD ---");
            System.out.println("1. Ingresar nuevo sistema");
            System.out.println("2. Registrar intento fallido (por índice)");
            System.out.println("3. Reiniciar contador (por índice)");
            System.out.println("4. Mostrar estado (por índice)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    if (indiceActual < MAX) {
                        System.out.print("Ingrese el nombre del nuevo sistema: ");
                        String nombre = sc.nextLine();
                        sistemas[indiceActual] = new SistemaSeguridad(nombre);
                        System.out.println("Sistema registrado en el índice: " + indiceActual);
                        indiceActual++;
                    } else {
                        System.out.println("Error: No hay más memoria disponible en el arreglo.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el índice del sistema a vulnerar (0 a " + (indiceActual - 1) + "): ");
                    int indFallo = Integer.parseInt(sc.nextLine());

                    if (indFallo >= 0 && indFallo < indiceActual) {
                        sistemas[indFallo].registrarIntentoFallido();
                        System.out.println("Intento fallido registrado.");
                    } else {
                        System.out.println("Índice no válido o sistema no registrado aún.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el índice del sistema a reiniciar (0 a " + (indiceActual - 1) + "): ");
                    int indReinicio = Integer.parseInt(sc.nextLine());

                    if (indReinicio >= 0 && indReinicio < indiceActual) {
                        sistemas[indReinicio].reiniciarContador();
                        System.out.println("Contador reiniciado a 0.");
                    } else {
                        System.out.println("Índice no válido o sistema no registrado aún.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el índice del sistema a consultar (0 a " + (indiceActual - 1) + "): ");
                    int indMostrar = Integer.parseInt(sc.nextLine());

                    if (indMostrar >= 0 && indMostrar < indiceActual) {
                        sistemas[indMostrar].mostrarEstado();
                    } else {
                        System.out.println("Índice no válido o sistema no registrado aún.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}