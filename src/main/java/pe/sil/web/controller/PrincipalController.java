package pe.sil.web.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

//import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.TabChangeEvent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.jsf.FacesContextUtils;

import pe.sil.web.model.LoginModel;
import pe.sil.web.model.PrincipalModel;
import pe.sil.web.model.ReporteIntercambioModel;

@Controller
@Scope("session")
public class PrincipalController {
	//private static final Logger log = Logger.getLogger(PrincipalController.class);
	
	ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
	
	@Autowired
	LoginModel loginModel;
	
	@Autowired
	PrincipalModel principalModel;
	
	@Autowired
	ReporteIntercambioModel reporteIntercambioModel;
	
	public void init(){
		
	}	
}