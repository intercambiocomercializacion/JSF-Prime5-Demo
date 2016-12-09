package pe.sil.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.primefaces.component.log.Log;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.jsf.FacesContextUtils;

import pe.sil.web.entities.ReporteIntercambio;
import pe.sil.web.model.LoginModel;
import pe.sil.web.model.ReporteIntercambioModel;
import pe.sil.web.service.AutenticacionService;
import pe.sil.web.service.IntercambioService;
import pe.sil.web.service.ParametricaService;
import pe.sil.web.service.TextoService;

@Component
@Scope("request")
public class ReporteIntercambioController {
	private static final Logger log = Logger.getLogger(LoginController.class);
	
	private static final Integer TIPO_INTERCAMBIO = 4; 
	
	ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
	
	LoginModel loginModel = (LoginModel)ctx.getBean("loginModel");
	
	@Autowired
	ReporteIntercambioModel reporteIntercambioModel;// = (ReporteIntercambioModel)ctx.getBean("reporteIntercambioModel");
		
	@Autowired
	ParametricaService parametricaService;	
	
	@Autowired
	TextoService textoService;
	
	@Autowired
	IntercambioService intercambioService;	
	
		
	public ReporteIntercambioController(){}
	
	private MapModel mapModel;
	
	public MapModel getMapModel() {
		return mapModel;
	}

	public void setMapModel(MapModel mapModel) {
		this.mapModel = mapModel;
	}

	@PostConstruct
	public void init(){
		mapModel = new DefaultMapModel();		
		//cargar combos		
		cargarComboTextoOfrecido();
		cargarComboTipoIntercambio();
	}
	
	private void cargarComboTextoOfrecido(){
		reporteIntercambioModel.setCboOfrecido(textoService.obtenerTextoPublico());
		reporteIntercambioModel.setCboSolicitado(textoService.obtenerTextoPublico());
	}
	
	private void cargarComboTipoIntercambio(){
		reporteIntercambioModel.setCboTipoIntercambio(parametricaService.listarParametrosPorCab(Integer.parseInt("4")));
	}	
	
	public void filtrar(){
		//try{
			reporteIntercambioModel.setListaReporteIntercambio(intercambioService.obtenerResultadosIntercambio(Integer.parseInt("1")));
			cargarMapa();
		//}catch (Exception e ){
		//	log.error(e.toString());
		//}
	}
	
	public void limpiar(){
		/*reporteRankingProvBean.setOrdenarPor(null);
		reporteRankingProvBean.setEstadoProforma(null);
		reporteRankingProvBean.setFechaDesdeProforma(null);
		reporteRankingProvBean.setFechaHastaProforma(null);*/
	}
	
	public void cargarMapa() {
		for(ReporteIntercambio rep : reporteIntercambioModel.getListaReporteIntercambio()){
			log.debug("Bucle");
			Marker marker = new Marker(new LatLng(Double.parseDouble(rep.getLatitud()),Double.parseDouble(rep.getLongitud())), rep.getUsuario());
			mapModel.addOverlay(marker);
		}	
    }	
}
