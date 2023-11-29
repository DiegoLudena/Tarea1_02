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
			//System.out.println(temperaturas[i]);
		}
		
		//Estoy haciendo 4 veces el crear array parte y crear e iniciar hilo. Debería poder hacer un bucle, pero no sé como.
		//Divido la matriz temperatura en 4 partes. Le he dado vueltas hasta encontrar la clase Arrays.
		int longitud = (temperaturas.length)/4;
		int[] parte1 = Arrays.copyOfRange(temperaturas,0,longitud);
		int[] parte2 = Arrays.copyOfRange(temperaturas,longitud,2*longitud);
		int[] parte3 = Arrays.copyOfRange(temperaturas,2*longitud,3*longitud);
		int[] parte4 = Arrays.copyOfRange(temperaturas,3*longitud,4*longitud);
		
		//Creo 4 hilos, con cada una de las partes
		
		BuscaMaxima buscamaxima1 =new BuscaMaxima(parte1);
		buscamaxima1.start();
		try {
			buscamaxima1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int maxima1=buscamaxima1.getMaxima();
		
		BuscaMaxima buscamaxima2 =new BuscaMaxima(parte1);
		buscamaxima2.start();
		try {
			buscamaxima2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int maxima2=buscamaxima2.getMaxima();
		 
		BuscaMaxima buscamaxima3 =new BuscaMaxima(parte1);
		buscamaxima3.start();
		try {
			buscamaxima3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int maxima3=buscamaxima3.getMaxima();
		
		BuscaMaxima buscamaxima4 =new BuscaMaxima(parte1);
		buscamaxima4.start();
		try {
			buscamaxima4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int maxima4=buscamaxima4.getMaxima();
		

		
		//comparo las 4 temperaturas máximas: las pongo en un array y repito el bucle de buscamaxima
		int comparacion[]= {maxima1, maxima2, maxima3, maxima4};
		int maxima=maxima1;
		for(int i=0;i<comparacion.length;i++) {

			if(comparacion[i]>maxima){
				maxima=comparacion[i];
			}
		

		

		/*
		 * Funciona con un solo hilo
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
		System.out.println("La temperatura máxima de de " + maxima + "ºC");
}
}
