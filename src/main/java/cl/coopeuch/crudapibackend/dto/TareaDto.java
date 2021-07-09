package cl.coopeuch.crudapibackend.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

//import com.sun.istack.NotNull;

@Entity
@Table(name = "tarea")
public class TareaDto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int identificador;
	@NotNull
	private String descripcion;
	private LocalDateTime fechaCreacion;
	@NotNull
	private Boolean vigente;
	
	public TareaDto() {	}

	public TareaDto(int identificador, String descripcion, LocalDateTime fechaCreacion, Boolean vigente) {
		super();
		this.identificador = identificador;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.vigente = vigente;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Boolean getVigente() {
		return vigente;
	}

	public void setVigente(Boolean vigente) {
		this.vigente = vigente;
	}

	@Override
	public String toString() {
		return "TareaDto [identificador=" + identificador + ", descripcion=" + descripcion + ", fechaCreacion="
				+ fechaCreacion + ", vigente=" + vigente + "]";
	}
	
	
	
	
	
}
