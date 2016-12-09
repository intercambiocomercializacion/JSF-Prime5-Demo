package pe.sil.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.sil.web.dao.IntercambioDao;
import pe.sil.web.dao.ParametricaDetDao;
import pe.sil.web.dao.ReporteIntercambioDao;
import pe.sil.web.entities.Intercambio;
import pe.sil.web.entities.ParametricaDet;
import pe.sil.web.entities.ReporteIntercambio;
import pe.sil.web.service.IntercambioService;

@Service
public class IntercambioServiceImpl implements IntercambioService{
	@Autowired
	ReporteIntercambioDao reporteIntercambioDao;
	
	@Autowired
	IntercambioDao intercambioDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, isolation = Isolation.READ_COMMITTED)
	public List<ReporteIntercambio> obtenerResultadosIntercambio(Integer codigoPersona) {		
		return reporteIntercambioDao.obtenerResultadosIntercambio(codigoPersona);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, isolation = Isolation.READ_COMMITTED)
	public List<Intercambio> obtenerSolicitudesPorSolicitante(Integer codigoPersona) {
		return intercambioDao.obtenerSolicitudesPorSolicitante(codigoPersona);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, isolation = Isolation.READ_COMMITTED)
	public List<Intercambio> obtenerOfertasPorOfertante(Integer codigoPersona) {		
		return intercambioDao.obtenerOfertasPorOfertante(codigoPersona);
	}
}
