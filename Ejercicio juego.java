package Apuesta;

	import java.util.*;

	public class Juego{

	    public static void main(String []args){

	        Scanner entrada = new Scanner(System.in);
	        Scanner seguir = new Scanner(System.in);
	        String eleccion = "", deNuevo = "";

	        int a = 0, b = 0;
	        int ganadas = 0, perdidas = 0, partidasTotales = 0;
	        boolean pase = false;

	        do {

	            a = (int) (Math.random() * 100 + 2);
	            b = (int) (Math.random() * 100 + 2);
	            if (a == b) {
	                a = a - 1;
	            }
	            do {
	                System.out.print("¿A quien apuestas? A o B:");
	                eleccion = entrada.nextLine();
	                if (eleccion.equalsIgnoreCase("a") || eleccion.equalsIgnoreCase("b")) {
	                    pase = true;
	                }
	            } while (pase == false);
	            System.out.println("A: " + a + " | B: " + b);
	            if (eleccion.equalsIgnoreCase("a")) {
	                if (a > b) {
	                    ganadas += 1;
	                    System.out.println("Has Ganado!!!");
	                } else {
	                    perdidas += 1;
	                    System.out.println("Has perdido!!!");
	                }
	            } else {
	                if (b > a) {
	                    ganadas += 1;
	                    System.out.println("Has Ganado!!!");
	                } else {
	                    perdidas += 1;
	                    System.out.println("Has Perdido!!!");
	                }

	                System.out.println("Partidas Ganadas " + ganadas + " | Partidas perdidas" + perdidas);
	                partidasTotales += 1;
	                System.out.print("¿Jugar de nuevo? S/N:");
	                deNuevo = seguir.nextLine();

	            }
	        }while (deNuevo.equalsIgnoreCase("S")) ;

	            System.out.println("Partidas Totales: " + partidasTotales);
	            System.out.println("Partidas Ganadas : " + ganadas);
	            System.out.println("Partidas Perdidas: " + perdidas);
	            System.out.println("Gracias por usar el juego, hasta luego");


	    }
	}