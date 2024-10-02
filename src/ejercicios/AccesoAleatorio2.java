/******************************************************************************************************************

  Nombre:   Haizea Rodriguez
  Fecha:    01/10/2024
  Modulo:   Acceso a Datos
  UD:       UD01
  Link: 	
  Descripcion del programa:   
                               
*******************************************************************************************************************/
package ejercicios;

import java.io.*;
import java.util.*;

public class AccesoAleatorio2 {

public static void main(String[] args){
		
        String dni;
        String nom;
        int peso;
		boolean found=false;
		
		Scanner keyboard = new Scanner(System.in);
		
		File fichero = new File ("."+ File.separator + "src" + File.separator + "ejercicios" + File.separator + "Marvel.dat");
		System.out.println("Introduce el DNI (con letra) del personaje para control de peso");
		String dniTeclado=keyboard.next();
		System.out.println("Introduzca su peso actual");
		int pesoTeclado=keyboard.nextInt();
		
		try (RandomAccessFile file = new RandomAccessFile(fichero, "rw")){
			file.seek(0);
            while (file.getFilePointer() < file.length()) {

            	file.skipBytes(4);// Saltar el campo 'id', que es un int (4 bytes)
            	
                dni = file.readUTF();
                nom = file.readUTF();
                
                int lengthIdentidad = file.readUnsignedShort();  // Leer la longitud del String
                file.skipBytes(lengthIdentidad);  // Saltar la longitud del String
                
                int lengthTipo = file.readUnsignedShort();  // Leer la longitud del String
                file.skipBytes(lengthTipo);  // Saltar la longitud del String

                
                long pointerPeso=file.getFilePointer();
                peso = file.readInt();
                
                file.skipBytes(4); // Saltar el campo 'altura', que es un int (4 bytes)
				
            	if (dni.equals(dniTeclado)) {
            		int diferenciaPeso=peso - pesoTeclado;
            		String result = (diferenciaPeso > 0) ? nom + " ha adelgazado " + Math.abs(diferenciaPeso) + " kilos." :
                        			(diferenciaPeso < 0) ? nom + " ha engordado " + Math.abs(diferenciaPeso) + " kilos.":
                        							  nom + " se mantiene en su peso anterior.";
            		
            		System.out.println(result);
            		file.seek(pointerPeso);
                    file.writeInt(pesoTeclado);
            		found=true;
            		break;
            	}
            }
            
            if (!found) {
            	System.out.println("El DNI no se ha encontrado.");
            }

		}catch (IOException e) {
			e.printStackTrace();
		}
		
		keyboard.close();
		
	}
}
