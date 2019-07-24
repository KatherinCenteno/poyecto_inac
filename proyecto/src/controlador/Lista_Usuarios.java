package controlador;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.web.conexion.Conexion;

import modelo.Usuarios;

@Named("usuarios")
@ViewScoped
public class Lista_Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	private static ArrayList<Usuarios> user = null;

	public Lista_Usuarios() {

		if (user == null) {
			user = new ArrayList<>();
		}
		generar_lista();

	}

	public void generar_lista() {
		Conexion c = new Conexion();
		ResultSet rs = null;
		String sql="select id_usuario,nombre,correo,estado,nick from usuarios";
		try {
			c.conectar();
			rs=c.consultar(sql);
			String estado;
			while (rs.next()) {
				if (rs.getInt(4)==1) {
					 estado="ACTIVO";
				}else {
					estado="BLOQUEADO";
				}
				user.add(new Usuarios(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5), estado,rs.getInt(4)));
			}
		} catch (Exception e) {
			c.cerrar();
		}
		c.cerrar();
	}
	
	public ArrayList<Usuarios> getUser() {
		return user;
	}
	public void setUser(ArrayList<Usuarios> user) {
		this.user = user;
	}

}
