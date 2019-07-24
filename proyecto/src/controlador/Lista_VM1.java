package controlador;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.web.conexion.Conexion;

import modelo.VM1;

@Named("vm_etnia_1")
@ViewScoped

public class Lista_VM1 implements Serializable{

	private static final long serialVersionUID = 1L;

	private ArrayList<VM1> vista;
	private static int num=0;
	int con=0;
	
	public Lista_VM1() {
		
	}
	
	public void generar_vista() {
		vista = new ArrayList<>();
		Conexion c = new Conexion();
		ResultSet rs=null;
		String sql="select * from v_th_tat_upc_etnia where ROWNUM<="+getNum();
		try {
			c.conectar();
			rs=c.consultar(sql);
			con=0;
			while (rs.next()) {
				con++;
				vista.add(new VM1(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), con));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	
	public ArrayList<VM1> getVista() {
		return vista;
	}
	public void setVista(ArrayList<VM1> vista) {
		this.vista = vista;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
