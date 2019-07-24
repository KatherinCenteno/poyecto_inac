package controlador;


import java.io.Serializable;
import java.sql.ResultSet;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.DonutChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.primefaces.model.chart.OhlcChartModel;
import org.primefaces.model.chart.PieChartModel;

import com.web.conexion.Conexion;


@Named("graficas_sexo")
@RequestScoped
public class Grafica_sexo {


    private LineChartModel lineModel2;
    private LineChartModel zoomModel;
    private CartesianChartModel combinedModel;
    private CartesianChartModel fillToZero;
    private LineChartModel areaModel;
    private BarChartModel barModel;
    private HorizontalBarChartModel horizontalBarModel;
    private PieChartModel pieModel2;
    private PieChartModel pieModel3;
    private DonutChartModel donutModel2;
    private MeterGaugeChartModel meterGaugeModel2;
    private BubbleChartModel bubbleModel2;
    private OhlcChartModel ohlcModel;
    private OhlcChartModel ohlcModel2;
    private BarChartModel animatedModel2;
    private LineChartModel multiAxisModel;
    private LineChartModel dateModel;
    private int anio_2015;
    private int anio_2016;
    private int hom1;
    private int hom2;
    private int muj1;
    private int muj2;
 
    @PostConstruct
    public void init() {
        createPieModels();
    }
 
    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public LineChartModel getLineModel2() {
        return lineModel2;
    }
 
    public LineChartModel getZoomModel() {
        return zoomModel;
    }
 
    public CartesianChartModel getCombinedModel() {
        return combinedModel;
    }
 
    public CartesianChartModel getAreaModel() {
        return areaModel;
    }
 
    public PieChartModel getPieModel2() {
        return pieModel2;
    }
 
    public MeterGaugeChartModel getMeterGaugeModel2() {
        return meterGaugeModel2;
    }
 
    public DonutChartModel getDonutModel2() {
        return donutModel2;
    }
 
    public CartesianChartModel getFillToZero() {
        return fillToZero;
    }
 
    public BubbleChartModel getBubbleModel2() {
        return bubbleModel2;
    }
 
    public OhlcChartModel getOhlcModel() {
        return ohlcModel;
    }
 
    public OhlcChartModel getOhlcModel2() {
        return ohlcModel2;
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
 
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }
 
    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }
 
    public LineChartModel getMultiAxisModel() {
        return multiAxisModel;
    }
 
    public LineChartModel getDateModel() {
        return dateModel;
    }
    
    
    public PieChartModel getPieModel3() {
		return pieModel3;
	}

	public void setPieModel3(PieChartModel pieModel3) {
		this.pieModel3 = pieModel3;
	}

	public void setPieModel2(PieChartModel pieModel2) {
		this.pieModel2 = pieModel2;
	}

	private void createPieModels() {
        createPieModel2();
        createPieModel3();
    }

    
    
    
    
    
 
    public int getHom1() {
		return hom1;
	}

	public void setHom1(int hom1) {
		this.hom1 = hom1;
	}

	public int getHom2() {
		return hom2;
	}

	public void setHom2(int hom2) {
		this.hom2 = hom2;
	}

	public int getMuj1() {
		return muj1;
	}

	public void setMuj1(int muj1) {
		this.muj1 = muj1;
	}

	public int getMuj2() {
		return muj2;
	}

	public void setMuj2(int muj2) {
		this.muj2 = muj2;
	}

	private void createPieModel2() {
        pieModel2 = new PieChartModel();
        Conexion c = new Conexion();
        ResultSet rs = null;
        String sql1="select count(*) from tb_nacimientos_2015_2016 where sexo=1 and anio_nac=2015";
        String sql2="select count(*) from tb_nacimientos_2015_2016 where sexo=2 and anio_nac=2015";
        try {
			c.conectar();
			rs=c.consultar(sql1);
			while (rs.next()) {
				hom1=rs.getInt(1);
				pieModel2.set("HOMBRES",hom1);
			}
			rs=null;
			rs=c.consultar(sql2);
			while (rs.next()) {
				
				muj1=rs.getInt(1);
				pieModel2.set("MUJERES", muj1);
			}
			rs=null;
			
		} catch (Exception e) {
			c.cerrar();
		}
        c.cerrar();
        pieModel2.setTitle("Número de Nacimientos");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(200);
        pieModel2.setShadow(false);
    }

	private void createPieModel3() {
        pieModel3 = new PieChartModel();
        Conexion c = new Conexion();
        ResultSet rs = null;
        String sql1="select count(*) from tb_nacimientos_2015_2016 where sexo=1 and anio_nac=2016";
        String sql2="select count(*) from tb_nacimientos_2015_2016 where sexo=2 and anio_nac=2016";
        try {
			c.conectar();
			rs=c.consultar(sql1);
			while (rs.next()) {
				hom2=rs.getInt(1);
				pieModel3.set("HOMBRES",hom2);
			}
			rs=null;
			rs=c.consultar(sql2);
			while (rs.next()) {
				
				muj2=rs.getInt(1);
				pieModel3.set("MUJERES", muj2);
			}
			rs=null;
			
		} catch (Exception e) {
			c.cerrar();
		}
        c.cerrar();
        pieModel3.setTitle("Número de Nacimientos");
        pieModel3.setLegendPosition("e");
        pieModel3.setFill(false);
        pieModel3.setShowDataLabels(true);
        pieModel3.setDiameter(200);
        pieModel3.setShadow(false);
    }
	
	
	
	
	public int getAnio_2015() {
		return anio_2015;
	}

	public void setAnio_2015(int anio_2015) {
		this.anio_2015 = anio_2015;
	}

	public int getAnio_2016() {
		return anio_2016;
	}

	public void setAnio_2016(int anio_2016) {
		this.anio_2016 = anio_2016;
	}

}

