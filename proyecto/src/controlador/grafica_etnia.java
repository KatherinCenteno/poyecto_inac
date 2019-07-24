package controlador;

import java.io.Serializable;
import java.sql.ResultSet;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

import com.web.conexion.Conexion;

@Named("barras")
@RequestScoped

public class grafica_etnia implements Serializable {

	private LineChartModel lineModel1;

	private BarChartModel barModel;
	private int nivel1=0;
	private int nivel2=0;
	private int nivel3=0;
	private int nivel4=0;
	private int nivel5=0;
	private int nivel6=0;
	private int nivel7=0;
	private int nivel8=0;
	private int nivel9=0;

	public grafica_etnia() {
		// TODO Auto-generated constructor stub
		controles();
		createBarModels();
	}
	
	@PostConstruct
	public void init() {
		controles();
		createBarModels();
	}

	public void itemSelect(ItemSelectEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
				"Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public LineChartModel getLineModel1() {
		return lineModel1;
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	public int getNivel1() {
		return nivel1;
	}

	public void setNivel1(int nivel1) {
		this.nivel1 = nivel1;
	}

	public int getNivel2() {
		return nivel2;
	}

	public void setNivel2(int nivel2) {
		this.nivel2 = nivel2;
	}

	public int getNivel3() {
		return nivel3;
	}

	public void setNivel3(int nivel3) {
		this.nivel3 = nivel3;
	}

	public int getNivel4() {
		return nivel4;
	}

	public void setNivel4(int nivel4) {
		this.nivel4 = nivel4;
	}

	public int getNivel5() {
		return nivel5;
	}

	public void setNivel5(int nivel5) {
		this.nivel5 = nivel5;
	}

	public int getNivel6() {
		return nivel6;
	}

	public void setNivel6(int nivel6) {
		this.nivel6 = nivel6;
	}

	public int getNivel7() {
		return nivel7;
	}

	public void setNivel7(int nivel7) {
		this.nivel7 = nivel7;
	}

	public int getNivel8() {
		return nivel8;
	}

	public void setNivel8(int nivel8) {
		this.nivel8 = nivel8;
	}

	public int getNivel9() {
		return nivel9;
	}

	public void setNivel9(int nivel9) {
		this.nivel9 = nivel9;
	}


	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();

		ChartSeries nivel1 = new ChartSeries();
		nivel1.setLabel("Indígena");
		nivel1.set("Indígena", getNivel1());

		ChartSeries nivel2 = new ChartSeries();
		nivel2.setLabel("Afroecuatoriano/Afrodescenciente");
		nivel2.set("Afroecuatoriano/Afrodescenciente", getNivel2());

		ChartSeries nivel3 = new ChartSeries();
		nivel3.setLabel("Negra");
		nivel3.set("Negra", getNivel3());

		ChartSeries nivel4 = new ChartSeries();
		nivel4.setLabel("Mulata");
		nivel4.set("Mulata", getNivel4());

		ChartSeries nivel5 = new ChartSeries();
		nivel5.setLabel("Montubio");
		nivel5.set("Montubio", getNivel5());

		ChartSeries nivel6 = new ChartSeries();
		nivel6.setLabel("Mestizo");
		nivel6.set("Mestizo", getNivel6());

		ChartSeries nivel7 = new ChartSeries();
		nivel7.setLabel("Blanca");
		nivel7.set("Blanca", getNivel7());

		ChartSeries nivel8 = new ChartSeries();
		nivel8.setLabel("Otra");
		nivel8.set("Otra", getNivel8());

		ChartSeries nivel9 = new ChartSeries();
		nivel9.setLabel("Ignorado");
		nivel9.set("Ignorado", getNivel9());


		model.addSeries(nivel1);
		model.addSeries(nivel2);
		model.addSeries(nivel3);
		model.addSeries(nivel4);
		model.addSeries(nivel5);
		model.addSeries(nivel6);
		model.addSeries(nivel7);
		model.addSeries(nivel8);
		model.addSeries(nivel9);
		return model;
	}

	private void createBarModels() {
		createBarModel();
	}

	private void createBarModel() {
		barModel = initBarModel();

		barModel.setTitle("ETNIA DE LOS NACIDOS");

		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("ETNIA");

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("RECIEN NACIDOS");
		yAxis.setMin(0);
		yAxis.setMax(900);
	}

	private void controles() {
		Conexion c = new Conexion();
		ResultSet rs = null;
		int n1, n2, n3, n4, n5, n6, n7, n8, n9, n10;

		try {
			c.conectar();;
			String sql1 = "select COUNT(*) from tb_nacimientos_2015_2016 where etnia=1";
			rs = c.consultar(sql1);
			while (rs.next()) {
				n1 = rs.getInt(1);
				setNivel1(n1);
			}
			// nivel 2
			String sql2 = "select COUNT(*) from tb_nacimientos_2015_2016 where etnia=2";
			rs = c.consultar(sql2);

			while (rs.next()) {
				n2 = rs.getInt(1);
				setNivel2(n2);
			}

			// nivel 3

			String sql3 = "select COUNT(*) from tb_nacimientos_2015_2016 where etnia=3";
			rs = c.consultar(sql3);

			while (rs.next()) {
				n3 = rs.getInt(1);
				setNivel3(n3);
			}

			// nivel 4

			String sql4 = "select COUNT(*) from tb_nacimientos_2015_2016 where etnia=4";
			rs = c.consultar(sql4);

			while (rs.next()) {
				n4 = rs.getInt(1);
				setNivel4(n4);
			}

			// nivel 5
			String sql5 = "select COUNT(*) from tb_nacimientos_2015_2016 where etnia=5";
			rs = c.consultar(sql5);

			while (rs.next()) {
				n5 = rs.getInt(1);
				setNivel5(n5);
			}

			// nivel 6
			String sql6 = "select COUNT(*) from tb_nacimientos_2015_2016 where etnia=6";
			rs = c.consultar(sql6);

			while (rs.next()) {
				n6 = rs.getInt(1);
				setNivel6(n6);
			}

			// nivel 7

			String sql7 = "select COUNT(*) from tb_nacimientos_2015_2016 where etnia=7";
			rs = c.consultar(sql7);

			while (rs.next()) {
				n7 = rs.getInt(1);
				setNivel7(n7);
			}

			// nivel 8
			String sql8 = "select COUNT(*) from tb_nacimientos_2015_2016 where etnia=8";
			rs = c.consultar(sql8);

			while (rs.next()) {
				n8 = rs.getInt(1);
				setNivel8(n8);
			}

			// nivel 9
			String sql9 = "select COUNT(*) from tb_nacimientos_2015_2016 where etnia=9";
			rs = c.consultar(sql9);

			while (rs.next()) {
				n9 = rs.getInt(1);
				setNivel9(n9);
			}

			// nivel10

		
		} catch (Exception e) {
			// TODO: handle exception
		}

		c.cerrar();
	}

}
