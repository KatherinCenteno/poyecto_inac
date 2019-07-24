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


@Named("graficas")
@RequestScoped
public class Graficas {


    private LineChartModel lineModel2;
    private LineChartModel zoomModel;
    private CartesianChartModel combinedModel;
    private CartesianChartModel fillToZero;
    private LineChartModel areaModel;
    private BarChartModel barModel;
    private HorizontalBarChartModel horizontalBarModel;
    private PieChartModel pieModel2;
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
 
    private void createPieModels() {
        createPieModel2();
    }
 
    
    
 
    private void createPieModel2() {
        pieModel2 = new PieChartModel();
        Conexion c = new Conexion();
        ResultSet rs = null;
        String sql1="SELECT COUNT(*) FROM tb_nacimientos_2015_2016 where anio_nac=2015";
        String sql2="SELECT COUNT(*) FROM tb_nacimientos_2015_2016 where anio_nac=2016";
        try {
			c.conectar();
			rs=c.consultar(sql1);
			while (rs.next()) {
				anio_2015=rs.getInt(1);
				pieModel2.set("2015",anio_2015);
			}
			rs=null;
			rs=c.consultar(sql2);
			while (rs.next()) {
				
				anio_2016=rs.getInt(1);
				pieModel2.set("2016", anio_2016);
			}
			
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
