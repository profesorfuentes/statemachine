package ar.edu.tecnica;

import java.util.Scanner;

public class BotApp {
    // Definición de estados como constantes
    private static final int MENU_PRINCIPAL = 0;
    private static final int CONSULTA_EXPEDIENTE = 1;
    private static final int CONSULTA_RECLAMOS = 2;
    private static final int SOLICITAR_TURNO = 3;
    private static final int EXPEDIENTE_DNI = 4;
    private static final int EXPEDIENTE_LEGAJO = 5;
    private static final int RECLAMO_CUIT = 7;
    private static final int RECLAMO_NUMERO = 8;
    private static final int VOLVER_MENU_PRINCIPAL = 9;
    private static final int TURNO_RECONSIDERACIONES = 10;
    private static final int TURNO_RECLAMOS = 11;
    private static final int DNI_IMPRIMIR = 12;
    private static final int DNI_SOLICITAR_INFORME = 13;
    private static final int LEGAJO_IMPRIMIR = 14;
    private static final int LEGAJO_DAR_BAJA = 15;
    private static final int LEGAJO_INICIAR_RECLAMO = 16;
    private static final int CUIT_IMPRIMIR = 17;
    private static final int CUIT_CERRAR_RECLAMO = 18;
    private static final int CUIT_MODIFICAR_RECLAMO = 19;
    private static final int NUMERO_IMPRIMIR = 20;
    private static final int NUMERO_ELIMINAR_RECLAMO = 21;
    private static final int RECONSIDERACIONES_AGENDAR_TURNO = 22;
    private static final int RECLAMOS_AGENDAR_TURNO = 23;

    // Definición de la matriz de transición de estados
    private static final int[][] state_machine = {
        {CONSULTA_EXPEDIENTE, CONSULTA_RECLAMOS, SOLICITAR_TURNO},     // MENU_PRINCIPAL
        {EXPEDIENTE_DNI, EXPEDIENTE_LEGAJO},                           // CONSULTA_EXPEDIENTE
        {RECLAMO_CUIT, RECLAMO_NUMERO},                                // CONSULTA_RECLAMOS
        {TURNO_RECONSIDERACIONES, TURNO_RECLAMOS},                     // SOLICITAR_TURNO
        {DNI_IMPRIMIR, DNI_SOLICITAR_INFORME},                         // EXPEDIENTE_DNI
        {LEGAJO_IMPRIMIR, LEGAJO_DAR_BAJA, LEGAJO_INICIAR_RECLAMO},    // EXPEDIENTE_LEGAJO
        {CUIT_IMPRIMIR, CUIT_CERRAR_RECLAMO, CUIT_MODIFICAR_RECLAMO},  // RECLAMO_CUIT
        {NUMERO_IMPRIMIR, NUMERO_ELIMINAR_RECLAMO},                    // RECLAMO_NUMERO
        {MENU_PRINCIPAL, MENU_PRINCIPAL},                              // VOLVER_MENU_PRINCIPAL
        {RECONSIDERACIONES_AGENDAR_TURNO, MENU_PRINCIPAL},             // TURNO_RECONSIDERACIONES
        {RECLAMOS_AGENDAR_TURNO, MENU_PRINCIPAL}                       // TURNO_RECLAMOS
    };

    private static int estado = MENU_PRINCIPAL;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            mostrarMenu();
            System.out.print("Ingrese una opción: ");
            int input = scanner.nextInt();
            if (input == 0) {
                estado = MENU_PRINCIPAL; // Reinicia al menú principal
            } else {
                estado = state_machine[estado][input - 1]; // Navega al nuevo estado
            }
        }
    }

    private static void mostrarMenu() {
        switch (estado) {
            case MENU_PRINCIPAL -> System.out.println("""
                Menú principal:
                1 - Consulta de expediente
                2 - Consulta de reclamos
                3 - Solicitar turno
                0 - Salir
                """);
            case CONSULTA_EXPEDIENTE -> System.out.println("""
                Consulta de expediente:
                1 - Por DNI
                2 - Por legajo
                0 - Volver al menú principal
                """);
            case EXPEDIENTE_DNI -> System.out.println("""
                Consulta expediente por DNI:
                1 - Imprimir
                2 - Solicitar informe
                0 - Volver
                """);
            case EXPEDIENTE_LEGAJO -> System.out.println("""
                Consulta expediente por legajo:
                1 - Imprimir
                2 - Dar de baja
                3 - Iniciar reclamo
                0 - Volver
                """);
            case CONSULTA_RECLAMOS -> System.out.println("""
                Consulta de reclamos:
                1 - Por CUIT
                2 - Por número de reclamo
                0 - Volver al menú principal
                """);
            case RECLAMO_CUIT -> System.out.println("""
                Consulta de reclamos por CUIT:
                1 - Imprimir
                2 - Cerrar reclamo
                3 - Modificar reclamo
                0 - Volver
                """);
            case RECLAMO_NUMERO -> System.out.println("""
                Consulta de reclamos por número de reclamo:
                1 - Imprimir
                2 - Eliminar reclamo
                0 - Volver
                """);
            case SOLICITAR_TURNO -> System.out.println("""
                Solicitar turno:
                1 - Reconsideraciones
                2 - Reclamos
                0 - Volver al menú principal
                """);
            case TURNO_RECONSIDERACIONES -> System.out.println("""
                Solicitar turno para reconsideraciones:
                1 - Agendar turno
                0 - Volver
                """);
            case TURNO_RECLAMOS -> System.out.println("""
                Solicitar turno para reclamos:
                1 - Agendar turno
                0 - Volver
                """);
            default -> System.out.println("Opción no válida.");
        }
    }
}
