/**
 * @author Pedro J. Camacho
 */
package JuegoAhorcado;
public class Ahorcado {

	public static void main(String[] args) {
		int intentos; 
		char letra;

		//Se generan los tres objetos necesarios para la partida 
		Palabra miPalabra = new Palabra();
		//El número de intentos será igual al número de letras diferentes que tiene la palabra
		intentos = miPalabra.letras_diferentes();
		Marcador miMarcador = new Marcador(intentos);
		Mensajes misMensajes = new Mensajes();
		
		//Se muestra el mensaje donde se indica el tema del juego
		misMensajes.mensaje_inicial();
		
		// Game Loop
		do {
			//Se muestra el marcador de la partida
			miMarcador.mostrarMarcador();
			//Se muestra la parte visible de la palabra (inicialmente con ninguna letra)
			miPalabra.mostrar_visible();
			//Se solicita una palabra
			letra = misMensajes.pedir_letra();
			//Se comprueba si es un acierto o un error, se actualiza el marcador y se muestra el mensaje correspondiente
			if (miPalabra.buscar(letra)>0){
				miMarcador.acertar(letra);
				misMensajes.acierto();
			} else {
				miMarcador.fallar(letra);
				misMensajes.fallo();
			}
			System.out.println();
			//Se repite el bucle mientras haya intentos disponibles y la palabra no haya sido descubierta
		} while (!miMarcador.finJuego() && !miPalabra.esta_adivinada());
		//Al terminar el juego, se muestra el mensaje de victoria o derrota
		if (miPalabra.esta_adivinada()){
			misMensajes.ganar();
		}
		else misMensajes.perder();
		//Para finalizar, se muestra la palabra oculta
		miPalabra.mostrar_visible();
	}
}
