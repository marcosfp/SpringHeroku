package des.springprueba.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROL")
public class Rol {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROL")
	private int idRol;

	@Column(name = "NOMBRE_ROL")
	private String nombreRol;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PROFESOR_ROL", joinColumns = @JoinColumn(name = "ID_ROL"), inverseJoinColumns = @JoinColumn(name = "ID_PROFESOR"))
    private Set<Profesor> profesores;

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public Set<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(Set<Profesor> profesor) {
		profesores = profesor;
	}
    
    
}
