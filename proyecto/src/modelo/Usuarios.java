package modelo;




public class Usuarios {
	
	
	private int id;
	private String Nombre;
	private String correo;
	private String Nick;
	private String estado;
	private int estadonum;
	
	public Usuarios(int id, String nombre, String correo, String nick, String estado,int estadonum) {
		super();
		this.id = id;
		Nombre = nombre;
		this.correo = correo;
		Nick = nick;
		this.estado = estado;
		this.estadonum=estadonum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNick() {
		return Nick;
	}

	public void setNick(String nick) {
		Nick = nick;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int getEstadonum() {
		return estadonum;
	}
	public void setEstadonum(int estadonum) {
		this.estadonum = estadonum;
	}
	
}
