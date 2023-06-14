import org.apache.commons.csv.CSVParser;
import uy.edu.um.prog2.adt.MyLinkedList.*;

import uy.edu.um.prog2.adt.Hash.*;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class ProgMain {

            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                int opcion;

                    try {
                        do {
                            mostrarMenu();
                            System.out.print("Ingrese una opción: ");
                            opcion = scanner.nextInt();

                            switch (opcion) {
                                case 0:
                                    CVSreader.cargardatos();
                                    break;
                                case 1:
                                    try {
                                        listarPilotosMencionadosEnMes(scanner);
                                    } catch (Exception e) {
                                        System.out.println("Algun dato ingresado es incorrecto");
                                    }
                                    break;
                                case 2:
                                    try {
                                        listarUsuariosConMasTweets(scanner);
                                    } catch (Exception e) {
                                        System.out.println("Algun dato ingresado es incorrecto");
                                    }
                                    break;
                                case 3:
                                    try {
                                        contarHashtagsDistintos(scanner);
                                    } catch (Exception e) {
                                        System.out.println("Fecha inválida. Por favor, ingrese una fecha válida en el formato YYYY-MM-DD.");
                                    }
                                    break;
                                case 4:
                                    try {
                                        hashtagMasUsado(scanner);
                                    } catch (Exception e) {
                                        System.out.println("Algun dato ingresado es incorrecto");
                                    }
                                    break;
                                case 5:
                                    try {
                                        listarCuentasConMasFavoritos(scanner);
                                    } catch (Exception e) {
                                        System.out.println("Algun dato ingresado es incorrecto");
                                    }
                                    break;
                                case 6:
                                    try {
                                        contarTweetsConPalabra(scanner);
                                    } catch (Exception e) {
                                        System.out.println("Algun dato ingresado es incorrecto");
                                    }
                                    break;
                                case 7:
                                    System.out.println("¡Hasta luego!");
                                    break;
                                default:
                                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                                    break;
                            }
                        } while (opcion != 7);
                    } catch (Exception e) {
                        System.out.println("Algun dato ingresado es incorrecto");

                    }
                }



            public static void mostrarMenu() {
                System.out.println("MENU");
                System.out.println("0. Cargar datos");
                System.out.println("1. Listar los 10 pilotos activos más mencionados en un mes");
                System.out.println("2. Listar los 15 usuarios con más tweets");
                System.out.println("3. Contar la cantidad de hashtags distintos para un día dado");
                System.out.println("4. Mostrar el hashtag más usado para un día dado");
                System.out.println("5. Listar las 7 cuentas con más favoritos");
                System.out.println("6. Contar la cantidad de tweets con una palabra o frase específica");
                System.out.println("7. Salir");
            }



        public static void listarPilotosMencionadosEnMes(Scanner scanner) {
            System.out.print("Ingrese el año (YYYY): ");
            String anioInput = scanner.next();
            System.out.print("Ingrese el mes (MM): ");
            String mesInput = scanner.next();

            // Validar el formato de fecha
            Pattern anioPattern = Pattern.compile("\\d{4}");
            Pattern mesPattern = Pattern.compile("\\d{2}");

            if (!anioPattern.matcher(anioInput).matches() || !mesPattern.matcher(mesInput).matches()) {
                System.out.println("Fecha inválida. Por favor, ingrese una fecha válida en el formato YYYY-MM.");
                return;
            }

            int anio = Integer.parseInt(anioInput);
            int mes = Integer.parseInt(mesInput);



            // Lógica para listar pilotos mencionados en un mes y año específicos
            System.out.println("Opción 1 seleccionada. Año: " + anio + ", Mes: " + mes);
        }


    public static void listarUsuariosConMasTweets(Scanner scanner) {
            // Lógica para listar usuarios con más tweets
            System.out.println("Opción 2 seleccionada.");
        }

        public static void contarHashtagsDistintos(Scanner scanner) {
            System.out.print("Ingrese la fecha (YYYY-MM-DD): ");
            String fechaInput = scanner.next();

            // Validar el formato de fecha
            Pattern fechaPattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");

            if (!fechaPattern.matcher(fechaInput).matches()) {
                System.out.println("Fecha inválida. Por favor, ingrese una fecha válida en el formato YYYY-MM-DD.");
                return;
            }

            LocalDate fecha = LocalDate.parse(fechaInput);




            // Lógica para contar hashtags distintos para una fecha específica
            System.out.println("Opción 3 seleccionada. Fecha: " + fecha);
        }


        public static void hashtagMasUsado(Scanner scanner) {
            System.out.print("Ingrese la fecha (YYYY-MM-DD): ");
            String fechaInput = scanner.next();

            // Validar el formato de fecha
            Pattern fechaPattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");

            if (!fechaPattern.matcher(fechaInput).matches()) {
                System.out.println("Fecha inválida. Por favor, ingrese una fecha válida en el formato YYYY-MM-DD.");
                return;
            }

            LocalDate fecha = LocalDate.parse(fechaInput);

            // Lógica para mostrar el hashtag más usado para una fecha específica
            System.out.println("Opción 4 seleccionada. Fecha: " + fecha);
        }


        public static void listarCuentasConMasFavoritos(Scanner scanner) {
            // Lógica para listar cuentas con más favoritos
            System.out.println("Opción 5 seleccionada.");
        }

        public static void contarTweetsConPalabra(Scanner scanner) {
            System.out.print("Ingrese la palabra o frase específica: ");
            scanner.nextLine(); // Consumir el salto de línea anterior
            String palabra = scanner.nextLine();



            // Lógica para contar tweets con una palabra o frase específica
            System.out.println("Opción 6 seleccionada. Palabra o frase: " + palabra);
        }

        public static void mostrar(Scanner scanner){

        }
}








