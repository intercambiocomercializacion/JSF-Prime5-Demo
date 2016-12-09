package pe.sil.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.sil.web.common.SilDao;
import pe.sil.web.entities.Intercambio;

public interface IntercambioDao extends SilDao<Intercambio> {
	List<Intercambio> obtenerSolicitudesPorSolicitante(@Param("codigoPersona") Integer codigoPersona);
	List<Intercambio> obtenerOfertasPorOfertante(@Param("codigoPersona") Integer codigoPersona);
}
