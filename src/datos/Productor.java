package datos;

public class Productor extends Thread {
	private Almacen almacen;
	private String nombre;

	public Productor(Almacen almacen, String nombre) {
		super();
		this.almacen = almacen;
		this.nombre = nombre;
	}

	@Override
	public void run() {
		while (true) {
			almacen.producir(nombre);
		}
	}

}
