package main;

public class Presidente {
	private String nombre;
	private String apellidos;
	private String fecha_eleccion;
	
	private static Presidente presidente = null;
	
	private Presidente(String nombre, String apellidos, String fecha_eleccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_eleccion = fecha_eleccion;
	}

	public static Presidente getPresidente(String nombre, String apellidos, String fecha_eleccion) {
		if(presidente == null) presidente = new Presidente(nombre, apellidos, fecha_eleccion);
		return presidente;
	}

	@Override
	public String toString() {
		return "Presidente [nombre=" + nombre + ", apellidos=" + apellidos + ", fecha_eleccion=" + fecha_eleccion + "]";
	}

}
