package controlador;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.web.conexion.Conexion;

@Named("con")
@ViewScoped

public class Consulta implements Serializable {

	static final long serialVersionUID = 1L;
	private List<String> lista_etnia;
	private static String etnia = "";
	private List<String> lista_provincia;
	private static String provincia = "";
	private List<String> lista_canton;
	private static String canton = "";
	private static String anio = "";
	private static String trimestre = "";
	private List<String> lista_trimestre;
	private static String consulta_realizada = "0";

	public Consulta() {
		generar_lista_etnia();
		generar_lista_provinica();
		generar_trimestre();
	}

	public void generar_lista_etnia() {
		lista_etnia = new ArrayList<>();
		Conexion c = new Conexion();
		ResultSet rs = null;
		String sql = "select descripcion_etnia from  tb_etnia";
		try {
			c.conectar();
			rs = c.consultar(sql);
			while (rs.next()) {
				lista_etnia.add(rs.getString(1));
			}
		} catch (Exception e) {
			c.cerrar();
		}
		c.cerrar();
	}

	public void generar_lista_provinica() {
		lista_provincia = new ArrayList<>();
		Conexion c = new Conexion();
		ResultSet rs = null;
		String sql = "select provincia,cod_prov from ubicacion_geografica GROUP by provincia,cod_prov order BY cod_prov";
		try {
			c.conectar();
			rs = c.consultar(sql);
			while (rs.next()) {
				lista_provincia.add(rs.getString(1));
			}
		} catch (Exception e) {
			c.cerrar();
		}
		c.cerrar();

	}

	public void generar_lista_canton(AjaxBehaviorEvent event) {
		lista_canton = new ArrayList<>();
		Conexion c = new Conexion();
		ResultSet rs = null;
		String sql = "select canton,cod_cant from ubicacion_geografica where "
				+ "cod_prov=(select cod_prov from ubicacion_geografica  " + "where provincia = '" + getProvincia()
				+ "' GROUP by cod_prov) GROUP BY canton , cod_cant ORDER by cod_cant";
		try {
			c.conectar();
			rs = c.consultar(sql);
			while (rs.next()) {
				lista_canton.add(rs.getString(1));
			}
		} catch (Exception e) {
			c.cerrar();
		}
		c.cerrar();
	}

	public void generar_trimestre() {
		lista_trimestre = new ArrayList<>();
		lista_trimestre.add("1");
		lista_trimestre.add("2");
		lista_trimestre.add("3");
		lista_trimestre.add("4");
	}

	public void boton_consultar() {

		// Conexion c = new Conexion();
		// System.out.println(getAnio()+" "+getEtnia()+" "+getProvincia()+"
		// "+getCanton());
		int r1 = 0;
		int r2 = 0;
		int tr=Integer.parseInt(getTrimestre());
		if (tr== 1) {
			r1 = 1;
			r2 = 3;
		} else if (tr==2) {
			r1 = 4;
			r2 = 6;
		} else if (tr== 3) {
			r1 = 7;
			r2 = 9;
		} else if (tr== 4) {
			r1 = 10;
			r2 = 12;
		}

		Conexion c = new Conexion();
		String sql = "select count(*) from tb_nacimientos_2015_2016 tg where "
				+ "tg.prov_nac=(SELECT ub.cod_prov FROM ubicacion_geografica ub where ub.provincia='" + getProvincia()
				+ "' GROUP BY ub.cod_prov)"
				+ " and tg.cant_nac=(SELECT ubc.cod_cant FROM ubicacion_geografica ubc where ubc.canton='" + getCanton()
				+ "' GROUP BY ubc.cod_cant)" + " and tg.anio_nac=" + getAnio() + " and tg.mes_nac>=" + r1
				+ " and tg.mes_nac<=" + r2;
		//System.out.println(sql);
		ResultSet rs = null;
		int acum = 0;
		try {
			c.conectar();
			rs = c.consultar(sql);
			while (rs.next()) {
				System.out.println("resul: "+rs.getInt(1));
				acum = rs.getInt(1);
			}
		} catch (Exception e) {
			c.cerrar();
		}
		
		consulta_realizada=""+acum;
		//System.out.println(consulta_realizada);
		
		c.cerrar();

	}

	public List<String> getLista_etnia() {
		return lista_etnia;
	}

	public void setLista_etnia(List<String> lista_etnia) {
		this.lista_etnia = lista_etnia;
	}

	public String getEtnia() {
		return etnia;
	}

	public void setEtnia(String etnia) {
		this.etnia = etnia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<String> getLista_provincia() {
		return lista_provincia;
	}

	public void setLista_provincia(List<String> lista_provincia) {
		this.lista_provincia = lista_provincia;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public List<String> getLista_canton() {
		return lista_canton;
	}

	public void setLista_canton(List<String> lista_canton) {
		this.lista_canton = lista_canton;
	}

	public String getCanton() {
		return canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getTrimestre() {
		return trimestre;
	}

	public void setTrimestre(String trimestre) {
		this.trimestre = trimestre;
	}

	public List<String> getLista_trimestre() {
		return lista_trimestre;
	}

	public void setLista_trimestre(List<String> lista_trimestre) {
		this.lista_trimestre = lista_trimestre;
	}

	public String getConsulta_realizada() {
		return consulta_realizada;
	}

	public void setConsulta_realizada(String consulta_realizada) {
		this.consulta_realizada = consulta_realizada;
	}

	
	
}
