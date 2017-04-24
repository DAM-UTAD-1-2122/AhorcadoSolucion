package JuegoAhorcado;

import java.util.HashSet;
import java.util.Set;

public class Palabra {
	//Para almacenar la palabra que hay que adivinar
	private String p_oculta;
	//Para almacenar la parte que se ha adivinado de la palabra
	private char[] p_visible;
	/**
	 * Constructor que genera una palabra de forma aleatoria (p_oculta)
	 * también inicializa un Array (p_visible) con "_" en cada una de las letras
	 * estos subrayados se irán sustituyendo según se vayan adividando las letras
	 */
	public Palabra() {
		String[] palabras = { "BATMAN", "SUPERMAN", "HULK", "CENICIENTA",
				"SPIDERMAN", "PINOCHO", "LOBEZNO" };
		int n = (int)Math.floor(Math.random()* palabras.length);
		p_oculta = palabras[n];
		p_visible = new char[p_oculta.length()];
		for (int i = 0; i < p_visible.length; i++) {
			p_visible[i] = '_';
		}
	}
	
	/**
	 * Método que sirve para saber si se ha adivinado la palabra
	 * @return devuelve true si la palabra oculta (p_oculta) tiene el mismo contenido que la parte visible (p_visible) false en caso contrario
	 */
	public boolean esta_adivinada(){
		return p_oculta.equals(String .valueOf(p_visible));
	}

	/**
	 * Método que sirve para mostrar la parte visible de la palabra (p_visible)
	 * Se imprimen las letras separadas por un espacio y un salto de línea al final
	 */
	public void mostrar_visible() {
		for (int i = 0; i < p_visible.length; i++) 
			System.out.print(p_visible[i] + " ");
		System.out.println();
	}

	
	/**
	 * Método que busca las letras en la palabra (p_oculta) y además, en caso de encontrarla la pone en la parte visible (p_visible) en su posición correcta
	 * de este modo cuando se imprime la parte visible  
	 * @param c El carácter a buscar en la palabra completa (p_oculta)
	 * @return Se devuelve el número de aciertos, es decir, el número de veces que aparece c en el palabra (p_oculta)
	 */
	public int buscar(char c) {
		int aciertos = 0;
		for (int i = 0; i < p_oculta.length(); i++)
			if (p_oculta.charAt(i) == c){
				aciertos++;
				p_visible[i]=c;
			}
		return aciertos;
	}
	
	/**
	 * Método que cuenta el número de letras diferentes que tiene la palabra (p_oculta)
	 * @return número de letras diferentes
	 */
    public int letras_diferentes(){
    	Set<Character> letras = new HashSet<Character>();
        for (int i=0;i<p_oculta.length() ;i++){
            if(p_oculta.charAt(i) != ' '){
              letras.add(p_oculta.charAt(i));
            }
        }
        return letras.size();
    }
}
