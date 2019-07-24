package controlador;

import java.io.Serializable;
import java.sql.ResultSet;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.web.conexion.Conexion;

@Named("registro")
@RequestScoped

public class REGISTRO implements Serializable {

	private static final long serialVersionUID = 1L;

	private  String Nombre = "";
	private String Contrasenia = "";
	private String mensaje_pass="";
	private boolean validar_pass=false;
	private String Correo = "";
	private String mensaje_correo="";
	private boolean validar_Correo=false;

	public REGISTRO() {

	}

	public String boton() {
		comprobar_correo();
		comprobar_pass();
		if (validar_Correo && validar_pass) {
			insertar();
			return "login.xhtml";
		}else {
			return "registro.xhtml";
		}
		
	}
	
	public void comprobar_correo() {
		
		String sql="select * from usuarios "
				+ "where correo='"+getCorreo()+"'";
		Conexion c = new Conexion();
		ResultSet rs=null;
		int i = 0;
		try {
			c.conectar();
			rs=c.consultar(sql);
			while (rs.next()) {
				i=1;
			}
		} catch (Exception e) {
			i=1;
		}
		
		if (i==1) {
			setMensaje_correo("ESTE CORREO YA SE ENCUENTRA REGISTRADO");
		}else {
			setMensaje_correo("");
			setValidar_Correo(true);
		}
		c.cerrar();
		
	}
	
	public void comprobar_pass() {
		if (getContrasenia().length()>=8) {
			setValidar_pass(true);
			setMensaje_pass("");
		}else {
			setMensaje_pass("CONTRASEÑA MENOR A 8 CARACTERES");
		}
	}
	
	
	public void insertar() {
		String sql="insert into usuarios (nombre,correo,password,estado) values"
				+ " ('"+getNombre()+"','"+getCorreo()+"','"+getContrasenia()+"',1)";
		Conexion c = new Conexion();
		try {
			c.conectar();
			c.ejecutar(sql);
			c.ejecutar("COMMIT");
		} catch (Exception e) {
			// TODO: handle exception
		}
		c.cerrar();
		
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getContrasenia() {
		return Contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		Contrasenia = contrasenia;
	}

	public String getMensaje_pass() {
		return mensaje_pass;
	}

	public void setMensaje_pass(String mensaje_pass) {
		this.mensaje_pass = mensaje_pass;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getMensaje_correo() {
		return mensaje_correo;
	}

	public void setMensaje_correo(String mensaje_correo) {
		this.mensaje_correo = mensaje_correo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isValidar_Correo() {
		return validar_Correo;
	}

	public void setValidar_Correo(boolean validar_Correo) {
		this.validar_Correo = validar_Correo;
	}

	public void setValidar_pass(boolean validar_pass) {
		this.validar_pass = validar_pass;
	}
	public boolean isValidar_pass() {
		return validar_pass;
	}
}
