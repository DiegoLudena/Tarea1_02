package tarea1;

import java.util.Random;

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
			System.out.println(temperaturas[i]);
		}
		
		/*
		*Creo el hilo
		*BuscaMaxima bucle1 =new BuscaMaxima(temperaturas);
		*bucle1.start();
		
        * Espero a que el hilo termine antes de continuar. Si no hago esto, no devuelve bien 
        * la temperatura máxima, devuelve 0* 

         *   try {
				bucle1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  
		int temperaturamaxima=bucle1.getMaxima();
		
		System.out.println("La temperatura más alta los últimos diez años fue "
				+ temperaturamaxima + "ºC.");
		*/
	}
}
