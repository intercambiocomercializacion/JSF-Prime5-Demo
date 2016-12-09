package pe.sil.web.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.sil.web.entities.Intercambio;
import pe.sil.web.entities.ReporteIntercambio;

public interface IntercambioService {
	List<ReporteIntercambio> obtenerResultadosIntercambio(Integer codigoPersona);
	List<Intercambio> obtenerSolicitudesPorSolicitante(Integer codigoPersona);
	List<Intercambio> obtenerOfertasPorOfertante(Integer codigoPersona);
}
