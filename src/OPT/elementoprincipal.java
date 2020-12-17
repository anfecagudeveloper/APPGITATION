package OPT;

import java.io.Serializable;

public class elementoprincipal implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public elementoprincipal() {
		
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(String cotizacion) {
		this.cotizacion = cotizacion;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getElaboro() {
		return elaboro;
	}
	public void setElaboro(String elaboro) {
		this.elaboro = elaboro;
	}
	public String getTagTanque() {
		return tagTanque;
	}
	public void setTanque(String tagTanque) {
		this.tagTanque = tagTanque;
	}
	public String getTagAgitador() {
		return tagAgitador;
	}
	public void setTagAgitador(String tagAgitador) {
		this.tagAgitador = tagAgitador;
	}
	public String getTipoTanque() {
		return tipoTanque;
	}
	public void setTipoTanque(String tipoTanque) {
		this.tipoTanque = tipoTanque;
	}
	public double getDiametroTanque() {
		return diametroTanque;
	}
	public void setDiametroTanque(double diametroTanque) {
		this.diametroTanque = diametroTanque;
	}
	public double getAlturaUtil() {
		return alturaUtil;
	}
	public void setAlturaUtil(double alturaUtil) {
		this.alturaUtil = alturaUtil;
	}
	public double getAlturaTotal() {
		return alturaTotal;
	}
	public void setAlturaTotal(double alturaTotal) {
		this.alturaTotal = alturaTotal;
	}
	public String getBaffles() {
		return baffles;
	}
	public void setBaffles(String baffles) {
		this.baffles = baffles;
	}
	public String getParamCirculacion() {
		return paramCirculacion;
	}
	public void setParamCirculacion(String paramCirculacion) {
		this.paramCirculacion = paramCirculacion;
	}
	public String getProceso() {
		return proceso;
	}
	public void setProceso(String proceso) {
		this.proceso = proceso;
	}
	public double getViscosidad() {
		return viscosidad;
	}
	public void setViscosidad(double viscosidad) {
		this.viscosidad = viscosidad;
	}
	public double getDensidad() {
		return densidad;
	}
	public void setDensidad(double densidad) {
		this.densidad = densidad;
	}
	public factAg[] getPropelas() {
		return propelas;
	}
	public void setPropelas(factAg[] propelas) {
		this.propelas = propelas;
	}
	public double getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	public double getDistFondo() {
		return distFondo;
	}
	public void setDistFondo(double distFondo) {
		this.distFondo = distFondo;
	}
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	public void setlEje(double lEje) {
		this.lEje=lEje;
	}
	public double getlEje() {
		return lEje;
	}
	public void setPot(double pot) {
		this.pot=pot;
	}
	public double getPot() {
		return pot;
	}
	public void setPots(double pots) {
		this.pots=pots;
	}
	public double getPots() {
		return pots;
	}
	public void setDatoCirculacion(double datoCirculacion) {
		this.datoCirculacion=datoCirculacion;
	}
	public double getDatoCirculacion() {
		return datoCirculacion;
	}
	public void setnAg(double nAg) {
		this.nAg=nAg;
	}
	public double getnAg() {
		return nAg;
	}
	public void setCaudal(double Caudal) {
		this.Caudal=Caudal;
	}
	public double getCaudal() {
		return Caudal;
	}

	public String getMat() {
		return mat;
	}
	public void setMat(String mat) {
		this.mat = mat;
	}
	public String getSch() {
		return Sch;
	}
	public void setSch(String sch) {
		Sch = sch;
	}
	public String getDiametroEje() {
		return diametroEje;
	}
	public void setDiametroEje(String diametroEje) {
		this.diametroEje = diametroEje;
	}

	public String getEstanc() {
		return estanc;
	}
	public void setEstanc(String estanc) {
		this.estanc = estanc;
	}

	public double getDistrod() {
		return distrod;
	}
	public void setDistrod(double distrod) {
		this.distrod = distrod;
	}
	public double getCrl() {
		return crl;
	}
	public void setCrl(double crl) {
		this.crl = crl;
	}
	public double getDminr() {
		return dminr;
	}
	public void setDminr(double dminr) {
		this.dminr = dminr;
	}

	public String[] getFinales() {
		return finales;
	}
	public void setFinales(String[] finales) {
		this.finales = finales;
	}
	
	public String getPesoeje() {
		return pesoeje;
	}
	public void setPesoeje(String pesoeje) {
		this.pesoeje = pesoeje;
	}
	
	public double[] getPotencias() {
		return potencias;
	}
	public void setPotencias(double[] potencias) {
		this.potencias = potencias;
	}
	

	public double[] getCaudales() {
		return caudales;
	}
	public void setCaudales(double[] caudales) {
		this.caudales = caudales;
	}


	String fecha;
	String cotizacion;
	String cliente;
	String elaboro;
	String tagTanque;
	String tagAgitador;
	String tipoTanque;
	double diametroTanque;
	double alturaUtil;
	double alturaTotal;
	String baffles;
	String paramCirculacion;
	String proceso;
	double viscosidad;
	double densidad;
	factAg[] propelas;
	double velocidad;
	double distFondo;
	double lEje;
	double pot;
	double pots;
	double ancho;
	double datoCirculacion;
	double nAg;
	double Caudal;
	String mat;
	String Sch;
	String diametroEje;
	String estanc;
	double distrod;
	double crl;
	double dminr;
	String[]finales;
	String pesoeje;
	double[] potencias;
	double[]caudales;
	
	
	
}
