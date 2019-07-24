package modelo;

public class VM1 {

	private String anio;
	private String ubicacion;
	private String etnia;
	private int total;
	private int con;
	public VM1(String anio, String ubicacion, String etnia, int total, int con) {
		super();
		this.anio = anio;
		this.ubicacion = ubicacion;
		this.etnia = etnia;
		this.total = total;
		this.con = con;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getEtnia() {
		return etnia;
	}
	public void setEtnia(String etnia) {
		this.etnia = etnia;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCon() {
		return con;
	}
	public void setCon(int con) {
		this.con = con;
	}
	
	
	
	
	
	
}
