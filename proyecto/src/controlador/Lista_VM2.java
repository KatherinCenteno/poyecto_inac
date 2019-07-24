package controlador;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.web.conexion.Conexion;

import modelo.VM1;

@Named("vista2")
@ViewScoped

public class Lista_VM2 implements Serializable
{

	private static final long serialVersionUID = 1L;
	private ArrayList<VM1> vista;
	private int num;
	int con;
	public Lista_VM2() {
		// TODO Auto-generated constructor stub
	}
	public void generar() {
		
		vista = new ArrayList<>();
		Conexion c = new Conexion();
		ResultSet rs=null;
		String sql="select * from VM_TH_TA_UP_ETNIA where ROWNUM<="+getNum();
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
	
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public ArrayList<VM1> getVista() {
		return vista;
	}
	public void setVista(ArrayList<VM1> vista) {
		this.vista = vista;
	}
}
