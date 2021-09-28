package pe.edu.upeu.parcial.Parcial.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="paciente")

public class Paciente {
	
	private long Idpaciente;
	private String DNI;
	private String Nombre;
	private String Apellido;
	private String Direccion;
	private String telefono;
	public Paciente() {
		super();
	}
	public Paciente(long idpaciente, String dNI, String nombre, String apellido, String direccion, String telefono) {
		super();
		Idpaciente = idpaciente;
		DNI = dNI;
		Nombre = nombre;
		Apellido = apellido;
		Direccion = direccion;
		this.telefono = telefono;
	}
	public long getIdpaciente() {
		return Idpaciente;
	}
	public void setIdpaciente(long idpaciente) {
		Idpaciente = idpaciente;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
}
