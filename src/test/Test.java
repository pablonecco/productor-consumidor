package test;

import datos.Almacen;
import datos.Consumidor;
import datos.Productor;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int consumidores = 20;
		int productores = 3;
		Almacen almacen = new Almacen();
		
		for (int i = 0; i < productores; i++) {
			new Productor(almacen, "Productor " + i).start();
		}

		for (int i = 0; i < consumidores; i++) {
			new Consumidor(almacen, "Consumidor " + i).start();
		}


	}

}
