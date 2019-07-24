package controlador;

import java.io.Serializable;
import java.sql.ResultSet;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.web.conexion.Conexion;


@Named("log")
@RequestScoped


public class Login implements Serializable{

	private static final long serialVersionUID = 1L;
	private static String ususario;
	private static String password;
	private static String mensaje="";
	private static String pagina;
	private  String bloque="";
	
	public Login() {
	}
	
	
	public String iniciar() {
		
		String sql="select  * from usuarios where correo='"+getUsusario()+"' and password = '"+getPassword()+"'";
		Conexion c = new Conexion();
		ResultSet rs= null;
		System.out.println(getUsusario()+" "+getPassword());
		int i = 0;
		try {
			c.conectar();
			rs=c.consultar(sql);
			while (rs.next()) {
				if (rs.getInt(5)==1) {
					i=1;
				}else {
					i=2;
				}
			}
			c.cerrar();
		} catch (Exception e) {
			i=0;
		}
		if (i==0) {

			mensaje="CORREO O CONTRAÑA ERRONEOS";
			return "login.xhtml";
		}else if (i==1) {
			return "Menu_us.xhtml";
		}else {
			bloque="USUARIO ACTUALMENTE SIN PERMISOS DE ACCESO";
			return "login.xhtml";
		}
			
		
	}
	
	
	public String getUsusario() {
		return ususario;
	}

	public void setUsusario(String ususario) {
		this.ususario = ususario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public static String getPagina() {
		return pagina;
	}
	public static void setPagina(String pagina) {
		Login.pagina = pagina;
	}
	public String getBloque() {
		return bloque;
	}
	public void setBloque(String bloque) {
		this.bloque = bloque;
	}
}
