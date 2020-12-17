package OPT;

import java.io.Serializable;

public class factAg implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipo;
	private String diametro;
	private double Kp;
	private double Nq;
	private double diacalc;
	private double peso;
	
	public factAg(String tipo, String diametro, double kp, double nq,double diacalc,double peso) {
		super();
		this.tipo = tipo;
		this.diametro = diametro;
		Kp = kp;
		Nq = nq;
		this.diacalc=diacalc;
		this.peso=peso;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getDiametro() {
		return diametro;
	}
	
	public void setDiametro(String diametro) {
		this.diametro = diametro;
	}
	
	public double getKp() {
		return Kp;
	}
	
	public void setKp(double kp) {
		Kp = kp;
	}
	
	public double getNq() {
		return Nq;
	}
	
	public void setNq(double nq) {
		Nq = nq;
	}
	
	public void setDiacalc(double diacalc) {
		this.diacalc=diacalc;
	}
	
	public double getDiacalc() {
		return diacalc;
	}

	@Override
	public String toString() {
		return "factAg [tipo=" + tipo + ", diametro=" + diametro + ", Kp=" + Kp + ", Nq=" + Nq + ", diacalc=" + diacalc
				+ ", peso=" + peso + "]";
	}
	
	
	
	
}
