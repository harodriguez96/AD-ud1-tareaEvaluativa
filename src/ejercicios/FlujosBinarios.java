/******************************************************************************************************************

  Nombre:   Haizea Rodriguez
  Fecha:    01/10/2024
  Modulo:   Acceso a Datos
  UD:       UD01
  Link: 	
  Descripcion del programa:   Realiza un programa en Java que lea la cabecera de un fichero PDF y verifique si realmente se trata de un archivo PDF válido. 
  Para que un archivo sea un PDF válido, debe comenzar con la siguiente secuencia de bytes: {37, 80, 68, 70}. 
  Si la cabecera no coincide con esta secuencia, el programa debe informar al usuario de que el archivo no es válido (1 punto)
                                
*******************************************************************************************************************/
package ejercicios;

import java.io.*;
import java.util.*;

public class FlujosBinarios {

	public static void main(String[] args) {
		File fichero = new File ("."+ File.separator + "src" + File.separator + "ejercicios" + File.separator + "matricula.pdf");
		byte[] headerPdf = {37, 80, 68, 70};
		byte[] headerRead = new byte[headerPdf.length];
		
		
		
		try (InputStream inputStream = new FileInputStream(fichero);) {
			inputStream.read(headerRead);
		
			if (!Arrays.equals(headerRead, headerPdf)) {
	            System.out.println("El archivo no es valido");
	        } else {
	        	System.out.println("El archivo tiene formato PDF");
	        }
		
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
