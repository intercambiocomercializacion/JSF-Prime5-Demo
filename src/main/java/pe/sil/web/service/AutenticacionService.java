package pe.sil.web.service;

import java.util.List;

import pe.sil.web.entities.OpcionesMenu;
import pe.sil.web.entities.Usuario;

public interface AutenticacionService {
	Usuario autenticarUsuario(Usuario usuario);
	List<OpcionesMenu> obtenerOpcionesMenu();
}
