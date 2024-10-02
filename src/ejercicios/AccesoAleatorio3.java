/******************************************************************************************************************

  Nombre:   Haizea Rodriguez
  Fecha:    01/10/2024
  Modulo:   Acceso a Datos
  UD:       UD01
  Link: 	
  Descripcion del programa:   
                               
*******************************************************************************************************************/
package ejercicios;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class AccesoAleatorio3 {
	
public static void main(String[] args){
		
		int id;
        String dni;
        String nom;
        String identidad;
        String tipo;
        int peso;
        int altura;
        ArrayList<Personaje> personajeArray = new ArrayList<>();
		boolean found=false;

		Scanner keyboard = new Scanner(System.in);
		
		File fichero = new File ("."+ File.separator + "src" + File.separator + "ejercicios" + File.separator + "Marvel.dat");
		System.out.println("Introduce un tipo de personaje");
		String tipoTeclado=keyboard.nextLine();

		try (RandomAccessFile file = new RandomAccessFile(fichero, "r")){
			file.seek(0);
            while (file.getFilePointer() < file.length()) {

            	id = file.readInt();
                dni = file.readUTF();
                nom = file.readUTF();
                identidad = file.readUTF();
                tipo = file.readUTF();
                peso = file.readInt();
                altura = file.readInt();
                
				
            	if (tipo.equals(tipoTeclado)) {
            		Personaje unPersonaje = new Personaje(id,dni,nom,identidad,tipo,peso,altura);
            		personajeArray.add(unPersonaje);
            		found=true;
            	}
            }
            
            if (!found) {
            	System.out.println("No exite tipos "+ tipoTeclado+" en el fichero.");
            } else {
            	System.out.println("Se han encontrado " +personajeArray.size()+" " +tipoTeclado+"s");
            	 for (Personaje p : personajeArray) {
                     System.out.println(p);
                 }
            }

		}catch (IOException e) {
			e.printStackTrace();
		}
		
		keyboard.close();
}
}
