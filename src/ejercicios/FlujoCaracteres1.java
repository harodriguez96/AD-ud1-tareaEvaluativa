/******************************************************************************************************************

  Nombre:   Haizea Rodriguez
  Fecha:    01/10/2024
  Modulo:   Acceso a Datos
  UD:       UD01
  Link: 	
  Descripcion del programa:   Escribe un programa en Java que lea una línea de texto desde un archivo y devuelva la misma línea, pero con las palabras 
  invertidas individualmente. Es decir, si el archivo contiene "Hola Mundo", el archivo de salida debería contener "aloH odnuM".
                                
*******************************************************************************************************************/
package ejercicios;

import java.io.*;
import java.util.*;

public class FlujoCaracteres1 {
	public static void main(String[] args) {
		File fichero = new File ("."+ File.separator + "src" + File.separator + "ejercicios" + File.separator + "frase.txt");
		
		int i;
		char caracter;
		ArrayList<Character> charList = new ArrayList<>();
		
		try (FileReader reader = new FileReader (fichero)){
			while ((i = reader.read()) != -1) {
	            caracter = (char) i;
	            /*Ir añadiendo los nuevos caracteres adelante de la cadena*/
	            charList.add(0, caracter);
			}       
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(FileWriter writer = new FileWriter(fichero)){
			for (char letra: charList) {
				writer.write(letra);
			}
			System.out.println("Se ha escrito la línea.");
		} catch (IOException e) {
            e.printStackTrace();
		}
			
	
	}
}
