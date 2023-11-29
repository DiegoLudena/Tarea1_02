package tarea1;

//Creo una clase que herede Thread para que sea un hilo
public class BuscaMaxima extends Thread {
	
	//para el constructor, le digo que de parámetro va a recibir una matriz de int
	private int[] entrada;
	private int maxima;
	
	public BuscaMaxima(int[] entrada) {
		this.entrada = entrada;
	}
	
	@Override
	public void run() {
		//Busco el valor máximo dentro de la matriz
		for(int i=0;i<entrada.length;i++) {
			if(entrada[i]>maxima){
				maxima=entrada[i];
			}
		}
		System.out.println(maxima);
	}
	//devuelvo el valor máximo al Main
	public int getMaxima() {
		return maxima;
		}
}