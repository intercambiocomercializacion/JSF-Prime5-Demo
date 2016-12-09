package pe.sil.web.entities;

import java.util.Date;

import pe.sil.web.common.SilEntidad;

public class Texto extends SilEntidad{
	private static final long serialVersionUID = 1L;

	private Integer TX_CodigoTexto;
	private String TX_Titulo;
	private String TX_ISBN;
	private String TX_AnioEdicion;
	private String TX_NumEdicion;
	private String TX_NumPagina;
	private String TX_Observacion;
	private Integer TX_Estado;
	private String TX_FechaRegistro;
	private Integer ED_CodigoEditorial;
	private Integer AT_CodigoAutor;
	private Integer TX_EsPublico;
	private Integer TX_EsComerciable;
	
	public Texto(){}

	public Integer getTX_CodigoTexto() {
		return TX_CodigoTexto;
	}

	public void setTX_CodigoTexto(Integer tX_CodigoTexto) {
		TX_CodigoTexto = tX_CodigoTexto;
	}

	public String getTX_Titulo() {
		return TX_Titulo;
	}

	public void setTX_Titulo(String tX_Titulo) {
		TX_Titulo = tX_Titulo;
	}

	public String getTX_ISBN() {
		return TX_ISBN;
	}

	public void setTX_ISBN(String tX_ISBN) {
		TX_ISBN = tX_ISBN;
	}

	public String getTX_AnioEdicion() {
		return TX_AnioEdicion;
	}

	public void setTX_AnioEdicion(String tX_AnioEdicion) {
		TX_AnioEdicion = tX_AnioEdicion;
	}

	public String getTX_NumEdicion() {
		return TX_NumEdicion;
	}

	public void setTX_NumEdicion(String tX_NumEdicion) {
		TX_NumEdicion = tX_NumEdicion;
	}

	public String getTX_NumPagina() {
		return TX_NumPagina;
	}

	public void setTX_NumPagina(String tX_NumPagina) {
		TX_NumPagina = tX_NumPagina;
	}

	public String getTX_Observacion() {
		return TX_Observacion;
	}

	public void setTX_Observacion(String tX_Observacion) {
		TX_Observacion = tX_Observacion;
	}

	public Integer getTX_Estado() {
		return TX_Estado;
	}

	public void setTX_Estado(Integer tX_Estado) {
		TX_Estado = tX_Estado;
	}

	public String getTX_FechaRegistro() {
		return TX_FechaRegistro;
	}

	public void setTX_FechaRegistro(String tX_FechaRegistro) {
		TX_FechaRegistro = tX_FechaRegistro;
	}

	public Integer getED_CodigoEditorial() {
		return ED_CodigoEditorial;
	}

	public void setED_CodigoEditorial(Integer eD_CodigoEditorial) {
		ED_CodigoEditorial = eD_CodigoEditorial;
	}

	public Integer getAT_CodigoAutor() {
		return AT_CodigoAutor;
	}

	public void setAT_CodigoAutor(Integer aT_CodigoAutor) {
		AT_CodigoAutor = aT_CodigoAutor;
	}

	public Integer getTX_EsPublico() {
		return TX_EsPublico;
	}

	public void setTX_EsPublico(Integer tX_EsPublico) {
		TX_EsPublico = tX_EsPublico;
	}

	public Integer getTX_EsComerciable() {
		return TX_EsComerciable;
	}

	public void setTX_EsComerciable(Integer tX_EsComerciable) {
		TX_EsComerciable = tX_EsComerciable;
	}
}
