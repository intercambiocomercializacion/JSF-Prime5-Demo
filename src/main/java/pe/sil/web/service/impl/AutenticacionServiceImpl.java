package pe.sil.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.sil.web.dao.OpcionesMenuDao;
import pe.sil.web.dao.UsuarioDao;
import pe.sil.web.entities.OpcionesMenu;
import pe.sil.web.entities.Usuario;
import pe.sil.web.service.AutenticacionService;

@Service
public class AutenticacionServiceImpl implements  AutenticacionService{

	@Autowired
	UsuarioDao usuarioDao;
	
	@Autowired
	OpcionesMenuDao opcionesMenuDao;	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, isolation = Isolation.READ_COMMITTED)
	public Usuario autenticarUsuario(Usuario usuario) {
		return usuarioDao.autenticarUsuario(usuario.getUS_usuario(), usuario.getUS_contrasenia());
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, isolation = Isolation.READ_COMMITTED)
	public List<OpcionesMenu> obtenerOpcionesMenu() {		
		return opcionesMenuDao.obtenerOpcionesMenu();
	}
}
