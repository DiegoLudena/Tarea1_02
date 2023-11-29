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
			
			/*Como nextInt(int) crea un numero entre 0 y el int, pongo 80 de limite
				y luego resto 30 para que el numero esté entre -30 y 50*/
			temperaturas[i]=(temperaturaaleatoria.nextInt(80))-30;
			//System.out.println(temperaturas[i]);
		}
		
		BuscaMaxima bucle1 =new BuscaMaxima(temperaturas);
		bucle1.start();
		
        // Espero a que el hilo termine antes de continuar
        try {
            bucle1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		int temperaturamaxima=bucle1.getMaxima();
		
		System.out.println("La temperatura más alta los últimos diez años fue "
				+ temperaturamaxima + "ºC.");
	}

}
