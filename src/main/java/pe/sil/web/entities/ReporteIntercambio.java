package pe.sil.web.entities;

import pe.sil.web.common.SilEntidad;

public class ReporteIntercambio extends SilEntidad{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String tipoIntercambio;
	private String usuario;	
	private String tituloSolicitado;
	private String tituloOfrecido;
	private String latitud;
	private String longitud;
	
	public ReporteIntercambio(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipoIntercambio() {
		return tipoIntercambio;
	}

	public void setTipoIntercambio(String tipoIntercambio) {
		this.tipoIntercambio = tipoIntercambio;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTituloSolicitado() {
		return tituloSolicitado;
	}

	public void setTituloSolicitado(String tituloSolicitado) {
		this.tituloSolicitado = tituloSolicitado;
	}

	public String getTituloOfrecido() {
		return tituloOfrecido;
	}

	public void setTituloOfrecido(String tituloOfrecido) {
		this.tituloOfrecido = tituloOfrecido;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
}
