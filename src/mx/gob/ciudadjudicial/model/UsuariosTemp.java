package mx.gob.ciudadjudicial.model;

public class UsuariosTemp {

	private String nombre; 
	private String apellidoP;
	private String apellidoM; 
	private String fechaNacimiento;  
	private String sexo;
	private String correo;
	private String password;
	
	public UsuariosTemp() {
		
	}
	
	public UsuariosTemp(String nombre, String apellidoP) {
		this.nombre = nombre;
		this.apellidoP = apellidoP;
	}
	
	public UsuariosTemp(String nombre, String apellidoP, String apellidoM, String fechaNacimiento, String sexo,
			String correo, String password) {
		super();
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.correo = correo;
		this.password = password;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoP() {
		return apellidoP;
	}
	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}
	public String getApellidoM() {
		return apellidoM;
	}
	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
