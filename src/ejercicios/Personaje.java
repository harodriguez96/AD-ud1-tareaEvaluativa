/******************************************************************************************************************

  Nombre:   Haizea Rodriguez
  Fecha:    01/10/2024
  Modulo:   Acceso a Datos
  UD:       UD01
  Link: 	
  Descripcion del programa:   
                               
*******************************************************************************************************************/
package ejercicios;

import java.io.Serializable;

public class Personaje implements Serializable {
	
	private int id;
	private String dni;
	private String nom;
	private String identidad;
	private String tipo;
	private int peso;
	private int altura;
	
	public Personaje(int id, String dni, String nom, String identidad, String tipo, int peso, int altura)  {
		this.id=id;
		this.dni=dni;
		this.nom=nom;
		this.identidad=identidad;
		this.tipo=tipo;
		this.peso=peso;
		this.altura=altura;
	
	}

	public int getId() {
		return id;
	}

	public String getDni() {
		return dni;
	}

	public String getNom() {
		return nom;
	}

	public String getTipo() {
		return tipo;
	}

	public String getIdentidad() {
		return identidad;
	}

	public int getPeso() {
		return peso;
	}

	public int getAltura() {
		return altura;
	}
	
	public String toString() {
		   String formato = String.format("%s%9s%s%-10s%s%-20s%s%-10s%s%s%s%s%s", "Personaje [dni=", dni, ", nombre=", nom, ", identidad=", identidad, ", tipo=", tipo, ", peso=", peso, ", altura=", altura, "]" );
		   return formato;
	   }

	
}
