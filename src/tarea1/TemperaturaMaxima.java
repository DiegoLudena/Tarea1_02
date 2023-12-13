package tarea1;

import java.util.*;

public class TemperaturaMaxima {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creo la matriz de temperaturas
		int[] temperaturas = new int[3650];
		//Creo el bucle para rellenarla de forma aleatoria
		for(int i=0;i<temperaturas.length;i++) {
						
		//Creo el objeto Random
		Random temperaturaaleatoria= new Random();
			
		/*Como nextInt(int) crea un numero entre 0 y uno menos que el int, pongo 81 de limite
			y luego resto 30 para que el numero esté entre -30 y 50*/
		temperaturas[i]=(temperaturaaleatoria.nextInt(81))-30;
		}
		
		int longitud = (temperaturas.length)/10;
		int comienzo = 0;

		//Creo una matrix de 10 hilos
		BuscaMaxima arrayBuscaMaxima[] = new BuscaMaxima[10];
		int[] maxima = new int[10];
		
		//Lanzo los hilos
		
		for(int i=0;i<10;i++) {
			// Creo el hilo con la matriz correspondiente
		    arrayBuscaMaxima[i] = new BuscaMaxima(Arrays.copyOfRange(temperaturas, comienzo, comienzo + longitud));

		    // Muevo la modificación de comienzo y longitud después de la creación del hilo
		    comienzo += longitud;
		    longitud = temperaturas.length / 10; // Restablezco la longitud a su valor original

		    // Inicio el hilo
		    arrayBuscaMaxima[i].start();
		    
		    //Espero a que los hilos terminen
		    try {
				arrayBuscaMaxima[i].join();
			} catch (InterruptedException e) {
		
				e.printStackTrace();
			}
		    
		    //Devuelvo el resultado maximo
		    maxima[i] = arrayBuscaMaxima[i].getMaxima();				
		}
					
		//comparo las 4 temperaturas máximas: las pongo en un array y repito el bucle de buscamaxima
		int comparacion=maxima[0];
		for(int i=0;i<maxima.length-1;i++) {

			if(comparacion<maxima[i]){
				comparacion=maxima[i];
			}
	}
		System.out.println("La temperatura máxima de de " + comparacion + "ºC");
}
}
