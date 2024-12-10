import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        CambioMoneda cambiarMoneda = new CambioMoneda();
        Scanner teclado= new Scanner(System.in);
        boolean encendido =true;


        while (encendido){

            try {
                int opcion = menu(teclado);
                encendido = opciones(opcion, teclado, cambiarMoneda);

              if (encendido == false) {
                  ConvertirDatos.HistorialDeConversiones historial = new ConvertirDatos.HistorialDeConversiones();
                  historial.guardarJson(cambiarMoneda);
              }

            } catch (InputMismatchException e) {
                System.out.println("Carácter Inválido, sólo se aceptan números");
                teclado.next();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
    private static int menu(Scanner consola) {
        System.out.println( """
                         ****************************** CONVIERTE TU MONEDA *****************************
                             1) Dolar >>>> Peso Chileno
                             2) Dolar >>>> Peso Argentino
                             3) Dolar >>>> Peso Uruguayo
                             4) Peso Chileno >>>> Real Brasileño
                             5) Peso Chileno >>>> Sol Peruano
                             6) Peso Uruguayo >>> Peso Chileno
                             7) Salir
                         ***********************************************************************************************
                         Elige una opcion\s""");

        return consola.nextInt();
    }

    public static boolean opciones(int opcion,Scanner teclado,CambioMoneda cambiarMoneda) throws IOException {

        boolean encendido = true;


            switch (opcion){
                case 1:
                    System.out.println("Ingrese el monto a convertir");
                    cambiarMoneda.monedasACambiar("USD","CLP");
                  break;
                case 2 :
                    System.out.println("Ingrese el monto a convertir");
                    cambiarMoneda.monedasACambiar("USD","ARS");

                    break;
                case 3:
                    System.out.println("Ingrese el monto a convertir");
                    cambiarMoneda.monedasACambiar("USD","UYU");

                    break;
                case 4:
                    System.out.println("Ingrese el monto a convertir");
                    cambiarMoneda.monedasACambiar("CLP","BRL");
                    break;
                case 5:
                    System.out.println("Ingrese el monto a convertir");
                    cambiarMoneda.monedasACambiar("CLP","PEN");
                    break;
                case 6:
                    System.out.println("Ingrese el monto a convertir");
                    cambiarMoneda.monedasACambiar("UYU","CLP");
                    break;
                case 7:
                    System.out.println("""
                            Hasta pronto ;)
                            fin del programa....
                            """);
                    encendido = false;
                    break;
                default:
                    System.out.println("*¡Opcion incorrecta, intente nuevamente!*");
                    return encendido;
            }

            if(encendido){
                double monto = teclado.nextInt();
                cambiarMoneda.setMonto(monto);

                cambiarMoneda.resultado();

                while (encendido) {
                    System.out.println("""
                            Desea realizar otra conversión?
                            1) Sí.
                            2) No,salir.
                            """);
                    opcion = teclado.nextInt();
                    if (opcion ==1){
                        break;
                    }
                    if (opcion == 2) {
                        System.out.println("""
                                Hasta pronto ;)
                            fin del programa....""");
                        encendido = false;
                    } else {
                        System.out.println("¡Opcion incorrecta!");
                        System.out.println("porfavor intente nuevamente");
                    }

                }
            }


            return encendido;
    }
}
