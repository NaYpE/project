package mx.gob.ciudadjudicial.model;

public class Expedientes {
	

	private int expediente;
    private String tomo; 
    private String partidojuicio; 
    private String juzgado; 
    private String actor; 
    private String abogadoPatrono;
    private String autorizados; 
    private String demandado; 
    private String abogadoPatrono2; 
    private String autorizados2; 
    private String juez; 
    private String srio;
    private String fecha; 
    
    public Expedientes() {
		
	}
    
	public Expedientes(int expediente, String tomo, String partidojuicio, String juzgado, String actor,
			String abogadoPatrono, String autorizados, String demandado, String abogadoPatrono2, String autorizados2,
			String juez, String srio, String fecha) {
		
		this.expediente = expediente;
		this.tomo = tomo;
		this.partidojuicio = partidojuicio;
		this.juzgado = juzgado;
		this.actor = actor;
		this.abogadoPatrono = abogadoPatrono;
		this.autorizados = autorizados;
		this.demandado = demandado;
		this.abogadoPatrono2 = abogadoPatrono2;
		this.autorizados2 = autorizados2;
		this.juez = juez;
		this.srio = srio;
		this.fecha = fecha;
	}

	
	
	public int getExpediente() {
		return expediente;
	}


	public void setExpediente(int expediente) {
		this.expediente = expediente;
	}


	
	public String getTomo() {
		return tomo;
	}


	/**
	 * @param tomo the tomo to set
	 */
	public void setTomo(String tomo) {
		this.tomo = tomo;
	}


	/**
	 * @return the partidojuicio
	 */
	public String getPartidojuicio() {
		return partidojuicio;
	}


	/**
	 * @param partidojuicio the partidojuicio to set
	 */
	public void setPartidojuicio(String partidojuicio) {
		this.partidojuicio = partidojuicio;
	}


	/**
	 * @return the juzgado
	 */
	public String getJuzgado() {
		return juzgado;
	}


	/**
	 * @param juzgado the juzgado to set
	 */
	public void setJuzgado(String juzgado) {
		this.juzgado = juzgado;
	}


	/**
	 * @return the actor
	 */
	public String getActor() {
		return actor;
	}


	/**
	 * @param actor the actor to set
	 */
	public void setActor(String actor) {
		this.actor = actor;
	}


	/**
	 * @return the abogadoPatrono
	 */
	public String getAbogadoPatrono() {
		return abogadoPatrono;
	}


	/**
	 * @param abogadoPatrono the abogadoPatrono to set
	 */
	public void setAbogadoPatrono(String abogadoPatrono) {
		this.abogadoPatrono = abogadoPatrono;
	}


	/**
	 * @return the autorizados
	 */
	public String getAutorizados() {
		return autorizados;
	}


	/**
	 * @param autorizados the autorizados to set
	 */
	public void setAutorizados(String autorizados) {
		this.autorizados = autorizados;
	}


	/**
	 * @return the demandado
	 */
	public String getDemandado() {
		return demandado;
	}


	/**
	 * @param demandado the demandado to set
	 */
	public void setDemandado(String demandado) {
		this.demandado = demandado;
	}


	/**
	 * @return the abogadoPatrono2
	 */
	public String getAbogadoPatrono2() {
		return abogadoPatrono2;
	}


	/**
	 * @param abogadoPatrono2 the abogadoPatrono2 to set
	 */
	public void setAbogadoPatrono2(String abogadoPatrono2) {
		this.abogadoPatrono2 = abogadoPatrono2;
	}


	/**
	 * @return the autorizados2
	 */
	public String getAutorizados2() {
		return autorizados2;
	}


	/**
	 * @param autorizados2 the autorizados2 to set
	 */
	public void setAutorizados2(String autorizados2) {
		this.autorizados2 = autorizados2;
	}


	/**
	 * @return the juez
	 */
	public String getJuez() {
		return juez;
	}


	/**
	 * @param juez the juez to set
	 */
	public void setJuez(String juez) {
		this.juez = juez;
	}


	/**
	 * @return the srio
	 */
	public String getSrio() {
		return srio;
	}


	/**
	 * @param srio the srio to set
	 */
	public void setSrio(String srio) {
		this.srio = srio;
	}


	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}


	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Expedientes [expediente=" + expediente + ", tomo=" + tomo + ", partidojuicio=" + partidojuicio
				+ ", juzgado=" + juzgado + ", actor=" + actor + ", abogadoPatrono=" + abogadoPatrono + ", autorizados="
				+ autorizados + ", demandado=" + demandado + ", abogadoPatrono2=" + abogadoPatrono2 + ", autorizados2="
				+ autorizados2 + ", juez=" + juez + ", srio=" + srio + ", fecha=" + fecha + "]";
	}
	
    
    
}


