import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Menu {
    private final String monedasDisponibles = """
                #USD 
                #ARS 
                #BRL 
                #COP 
                #EUR """;

    public void mostrarMenuPrincipal(){
        System.out.println("Que quiere hacer? \n");
        String menuPrincipal = """
                1) Conversión
                2) Historial de conversiones
                3) Salir""";
        System.out.println(menuPrincipal);
    }

    public int leerOpcionPrincipal(){
        Scanner lectura = new Scanner(System.in);
        System.out.println("Elija una opción válida:");
        return lectura.nextInt();
    }

    public void mostrarMenuMonedas(String denominacion){
        System.out.println("Seleccione la denominación: " + denominacion + ": \n");
        System.out.println(monedasDisponibles);
        System.out.println("###########################################################");
    }

    public String leerOpcionMoneda(){
        Scanner lectura = new Scanner(System.in);
        String opcion = lectura.nextLine().toLowerCase();
        while (!monedasDisponibles.toLowerCase().contains(opcion)) {
            System.out.println("No disponible");
            System.out.println("Elija una opción válida:");
            System.out.println("################################################################");
            opcion = lectura.nextLine().toLowerCase();
        }
        return opcion.toUpperCase();
    }

    public Double leerCantidadACambiar(){
        System.out.println("#####################################################################");
        System.out.println("Seleccione la cantidad que desea cambiar: \n");
        Scanner lectura = new Scanner(System.in);
        double cantidad;
        while (!lectura.hasNextDouble()) {
            System.out.println("######################################################################");
            System.out.println("No es un número válido");
            System.out.println("Ingrese una cantidad válida:");
            lectura.nextLine();
        }
        cantidad = lectura.nextDouble();
        lectura.nextLine();
        return cantidad;
    }

    public Double cantidadObtenida(String monedaBase, Double cantidadCambiar, Double tasaDeConversion, String monedaFinal){
        Double resultado = cantidadCambiar * tasaDeConversion;
        System.out.println("#########################################################################");
        System.out.println(cantidadCambiar + " " + monedaBase + " es igual a: " + resultado + " " + monedaFinal);
        return resultado;
    }

    public void imprimirConversiones(ArrayList<Conversion> listaDeConversiones) {
        if (listaDeConversiones.isEmpty()) {
            System.out.println("No se realizo la conversion.");
        } else {
            System.out.println("Historial de conversiones:");
            for (int i = 0; i < listaDeConversiones.size(); i++) {
                Conversion conversion = listaDeConversiones.get(i);
                System.out.println("Conversión " + (i + 1) + ":");
                System.out.println("Moneda origen: " + conversion.getMonedaBase());
                System.out.println("Moneda objetivo: " + conversion.getMonedaObjetivo());
                System.out.println("Cantidad a cambiar: " + conversion.getCantidadACambiar());
                System.out.println("Cantidad obtenida: " + conversion.getCantidadEnMonedaObjetivo());
                System.out.println("-----------------------------------------");
            }
        }
    }

}

