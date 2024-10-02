/******************************************************************************************************************

  Nombre:   Haizea Rodriguez
  Fecha:    01/10/2024
  Modulo:   Acceso a Datos
  UD:       UD01
  Link: 	
  Descripcion del programa:   Crea un programa en Java que lea un archivo con nombres y apellidos separados por espacios, 
  y escriba en un nuevo archivo solo los nombres que tienen exactamente cinco letras.
                                
*******************************************************************************************************************/

package ejercicios;

import java.io.*;
import java.util.*;

public class FlujoCaracteres2 {
	
	public static void main(String[] args) {
		File fichero = new File ("."+ File.separator + "src" + File.separator + "ejercicios" + File.separator + "nombres.txt");
		
		String linea;
		String[] nomApe;
		ArrayList<String> nom5 = new ArrayList<>();
		
		try (BufferedReader bufr = new BufferedReader(new FileReader(fichero))){
			 while ((linea=bufr.readLine()) != null) {
				 nomApe=linea.split(" ");
				 
				 if (nomApe[0].length()==5) {
					 nom5.add(nomApe[0]);
				 }
	         }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File ("."+ File.separator + "src" + File.separator + "ejercicios" + File.separator + "nombres_out.txt")))){
			for (String nombre: nom5) {
				writer.write(nombre+"\n");
			}
			System.out.println("Se ha completado el proceso.");
		} catch (IOException e) {
            e.printStackTrace();
		}
			
	
	}

}
