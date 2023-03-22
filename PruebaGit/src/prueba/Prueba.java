package prueba;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prueba {

	
	public static ArrayList <String> leerArchivo(String ruta) {
		
		File archivo = new File (ruta);
		
		ArrayList <String> lineasSinSeparar = new ArrayList<String>();
		
		try {
			Scanner texto = new Scanner (archivo);
			texto.nextLine();
			while (texto.hasNextLine()) {
				lineasSinSeparar.add(texto.nextLine());
			}
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		return lineasSinSeparar;
	}
	
	public static void main(String[] args) {
		String ruta = "C:\\Users\\pucho\\Downloads\\titanic.csv";
		String[] lineasSeparadas = new String[12];
		
		
		ArrayList <String> pasajeros = new ArrayList<String>();
		int totalPasajeros = 0;
		int hombres = 0;
		int mujeresF = 0;
		int hombresF = 0;
		
		
		pasajeros = leerArchivo(ruta);
		
		for(String e:pasajeros) {
			lineasSeparadas = e.split(",");
			
			
			if(lineasSeparadas[5].equals("male")) {
				hombres++;
				if(lineasSeparadas[1].equals("0")) {
					hombresF++;
				}
			} else {
				if(lineasSeparadas[1].equals("0")) {
					mujeresF++;
				}
			}
		}		
		
		
		totalPasajeros = pasajeros.size();
//***********************************************************************************
		System.out.println("Total Pasajeros: " + totalPasajeros);
		System.out.println("Total Hombres: " + hombres);
		System.out.println("Total Mujeres: " + (totalPasajeros - hombres));
		System.out.println("Hombres Fallecidos: " + hombresF + " (" + ((hombresF*100)/hombres) + "%)");
		System.out.println("Mujeres Fallecidas: " + mujeresF + " (" + (mujeresF*100/(totalPasajeros - hombres)) + "%)");
		
		
	}

}
