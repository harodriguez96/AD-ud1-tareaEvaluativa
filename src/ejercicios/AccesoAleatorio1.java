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

public class AccesoAleatorio1 {
	public static void main(String[] args) {
		
		int [] ids= {1, 2, 3, 4, 5, 6, 7};
		String[] dnis= {"01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F"};
		String[] noms= {"Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin"};
		String[] identidades = {"Peter Parker", "Norman Osborn", "Ororo Munroe","James Howlett", "Raven Darkholme", "Tony Stark", "Zhang Tong"};
		String[] tipos = {"heroe","villano","heroe","heroe","villano","heroe","villano"};
		int[] pesos = {76,84,66,136,78,102,70};
		int[] alturas = {178,183,156,152,177,182,188};
		

		
		File fichero = new File ("."+ File.separator + "src" + File.separator + "ejercicios" + File.separator + "Marvel.dat");
		try (RandomAccessFile file = new RandomAccessFile(fichero, "rw")){
			for (int i=0; i<ids.length; i++) {
				
				file.writeInt(ids[i]);
                file.writeUTF(dnis[i]);
                file.writeUTF(noms[i]);
                file.writeUTF(identidades[i]);
                file.writeUTF(tipos[i]);
                file.writeInt(pesos[i]);
                file.writeInt(alturas[i]);
			}
			
			System.out.println("La carga de los personajes ha terminado correctamente");
			file.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

