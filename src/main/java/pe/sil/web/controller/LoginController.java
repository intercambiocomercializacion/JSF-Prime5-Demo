package pe.sil.web.controller;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import org.apache.log4j.Logger;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.jsf.FacesContextUtils;

import pe.sil.web.entities.OpcionesMenu;
import pe.sil.web.entities.Usuario;
import pe.sil.web.model.LoginModel;
import pe.sil.web.service.AutenticacionService;
import pe.sil.web.service.IntercambioService;

@Component
@Scope("request")
public class LoginController {
	private static final Logger log = Logger.getLogger(LoginController.class);
	
	ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
	//@Autowired
	LoginModel loginModel = (LoginModel)ctx.getBean("loginModel");
	
	@Autowired
	AutenticacionService autenticacionService;
	
	@Autowired
	IntercambioService intercambioService;
	
	HttpServletRequest request;
	
	public String iniciarSesion(){
		log.info("Executing iniciarSesion()");
		request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String view = "login.xhtml";
		
		Usuario usuario = autenticar();
		System.out.println(request);
		if(usuario != null){
			request.getSession().setAttribute("username", loginModel.getUsuario());
			loginModel.setIdUsuario(usuario.getPE_CodigoPersona());
			loginModel.setNombres(usuario.getPE_Nombre());
			loginModel.setApellidos(usuario.getPE_ApellidoPaterno() + " " + usuario.getPE_ApellidoMaterno());
			loginModel.setUbigeo(usuario.getUbigeo());
			cargarOpcionesMenu();
			view = "principal?faces-redirect=true";
		}else{
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,
																			 "Acceso fallido!",
																			 "Usuario o password inválido."));
			view = "login.xhtml";
		}
		return view;
	}
	
	public String cerrarSesion(){
		log.info("Executing cerrarSesion()");
		try { 
		ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletRequest httpServletRequest=(HttpServletRequest)ctx.getRequest();
		httpServletRequest.getSession().removeAttribute("username");
		HttpSession session=(HttpSession) ctx.getSession(false);
		session.invalidate();
		
		System.out.println("ctx.getRequestContextPath() " +ctx.getRequestContextPath());
    	ctx.redirect(ctx.getRequestContextPath() );  	    
		} catch (IOException ex) {
			log.info(ex.toString());	
		}
		return "";
	}
	
	public void cargarOfertadosSolicitados(){
		log.info("obtener");
		obtenerMisSolicitudes();
		obtenerMisOfertas();
	}
	
	private void obtenerMisSolicitudes(){
		Integer id = loginModel.getIdUsuario();
		log.info("id :" + id);
		loginModel.setListaSolicitados(intercambioService.obtenerSolicitudesPorSolicitante(id));
	}
	
	private void obtenerMisOfertas(){
		Integer id = loginModel.getIdUsuario();
		log.info("id :" + id);
		loginModel.setListaOfertados(intercambioService.obtenerOfertasPorOfertante(id));
	}	
	
	private Usuario autenticar(){
		Usuario usuario = new Usuario();
		usuario.setUS_usuario(loginModel.getUsuario());
		usuario.setUS_contrasenia(loginModel.getPassword());
		usuario = autenticacionService.autenticarUsuario(usuario);				
		return usuario;
	} 	
		
	public void cargarOpcionesMenu(){    
		MenuModel menu = loginModel.getMenu();
    	menu = new DefaultMenuModel();    	
    	DefaultSubMenu submenu = null;
    	DefaultMenuItem item = null;
    	
    	submenu = new DefaultSubMenu("Comercializacion");
    	item = new DefaultMenuItem("Comercializacion");
    	item.setUrl("comercializacion.xhtml");
    	submenu.addElement(item);
    	menu.addElement(submenu);
    	
    	submenu = new DefaultSubMenu("Intercambio");
    	item = new DefaultMenuItem("Intercambio");
    	item.setUrl("intercambio1.xhtml");
    	submenu.addElement(item);
    	menu.addElement(submenu);
    	loginModel.setMenu(menu);    	
	}
	
	
}