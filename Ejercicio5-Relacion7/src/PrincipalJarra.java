import java.util.Scanner;

public class PrincipalJarra {
	private static final int OPCION_SALIR = 6;
	
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Jarra jarra1, jarra2, jarra3;
		int opc;

		try{
			jarra1 = crearJarra();
			jarra2 = crearJarra();
		
			do {
				mostrarMenu();
				opc = elegirOpcion();
				tratarMenu(opc, jarra1, jarra2);
			} while (opc != OPCION_SALIR);
		}catch(JarraException e){
			System.out.println(e.getMessage());
		}

	
	}
/**
 * Metodo que llena la jarra segun la cantidad
 * @return Devuelve la jarra con la cappacidad introducida
 * @throws JarraException
 */
	private static Jarra crearJarra() throws JarraException {
		int capacidad;
		Jarra jarra;
		
		System.out.println("Introduzca la capacidad inicial:");
		capacidad=Integer.parseInt(teclado.nextLine());
		
		jarra=new Jarra(capacidad);
		
		return jarra;
		
	}
/**
 * Metodo que trata el menu segun la opcion
 * @param opc
 * @param jarra1
 * @param jarra2
 */
	private static void tratarMenu(int opc, Jarra jarra1, Jarra jarra2) {

		char respuesta;

		try {

			switch (opc) {
			case 1: // llenar jarra
				respuesta = elegirJarra();
				if (respuesta == 'A') {
					jarra1.llenarJarra();
				} else {
					jarra2.llenarJarra();
				}
				break;

			case 2: // vaciar jarra
				respuesta = elegirJarra();
				if (respuesta == 'A') {
					jarra1.vaciarJarra();
				} else {
					jarra2.vaciarJarra();
				}
				break;

			case 3: 
				jarra1.volcarJarra(jarra2);
				break;

			case 4:
				jarra2.volcarJarra(jarra1);
				break;

			case 5:
				System.out.println("Jarra A: " + jarra1 + "\n" + "Jarra B: " + jarra2);
				System.out.println();
				break;

			case 6:
				System.out.println("Litros de agua consumida " + Jarra.getTotalAguaConsumida());
				System.out.println("Hasta Luego");
				break;

			}

		} catch (JarraException e) {
			System.out.println(e.getMessage());
		}

	}
/**
 * Metodo que el cuál elige que jarra elegir
 * @return devuelve la respuesta del usuario
 */
	private static char elegirJarra() {
		char respuesta;
		do {
			System.out.println("Introduce la Jarra que desea (A - B)");
			respuesta = teclado.nextLine().charAt(0);
			respuesta = Character.toUpperCase(respuesta);
		} while (respuesta != 'A' && respuesta != 'B');
		return respuesta;
	}
/**
 * Metodo que se encarga de eelgir las opciones 
 * @return
 */
	private static int elegirOpcion() {

		int opcion;

		do {
			System.out.println("Introduce una de las opciones anteriores");
			opcion = Integer.parseInt(teclado.nextLine());
		} while (opcion <= 0 || opcion > OPCION_SALIR);
		return opcion;
	}
/**
 * Metodo que muestra el menu
 */
	private static void mostrarMenu() {

		System.out.println("1. Llenar Jarra");
		System.out.println("2. Vaciar Jarra");
		System.out.println("3. Volcar Jarra A en B");
		System.out.println("4. Volcar Jarra B en A");
		System.out.println("5. Ver el estado de las Jarras");
		System.out.println("6. Salir");
		System.out.println();
	}

}
