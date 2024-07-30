package datos;

import java.util.concurrent.Semaphore;

public class Almacen {
	private final int MAX_PRODUCTOR = 20;
	private int producto = 0;
	private Semaphore productor = new Semaphore(MAX_PRODUCTOR);
	private Semaphore consumidor = new Semaphore(0);
	private Semaphore mutex = new Semaphore(1);

	public void producir(String nombreProductor) {
		System.out.println("El productor: " + nombreProductor + " está intentando producir");

		try {
			productor.acquire();
			mutex.acquire();
			producto = producto + 1;
			System.out.println("El productor: " + nombreProductor + " almacenó un producto");
			mutex.release();
			Thread.sleep(500);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			consumidor.release();
		}

	}

	public void consumir(String nombreConsumidor) {
		System.out.println("El consumidor: " + nombreConsumidor + " está intentando consumir");

		try {
			consumidor.acquire();
			mutex.acquire();
			producto = producto - 1;
			System.out.println("El consumidor: " + nombreConsumidor + " consumió un producto");
			mutex.release();
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			productor.release();
		}
	}
}
