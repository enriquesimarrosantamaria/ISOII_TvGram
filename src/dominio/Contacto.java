package dominio;

public class Contacto {
	private String nombre;
	private String numero;
	public Contacto(String nombre) {
		super();
		this.nombre = nombre;
	
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
