package datos;

public class Consumidor extends Thread {
	private Almacen almacen;
	private String nombre;

	public Consumidor(Almacen almacen, String nombre) {
		super();
		this.almacen = almacen;
		this.nombre = nombre;
	}
	
	@Override
	public void run () {
		while (true) {
			almacen.consumir(nombre);
		}
	}

}
