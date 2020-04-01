package des.springprueba.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MODULO")
public class Modulo {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_MODULO")
	private Long idModulo;

	@Column(name = "NOMBRE_MODULO")
	private String nombreModulo;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PROFESOR_MODULO", joinColumns = @JoinColumn(name = "ID_MODULO"), inverseJoinColumns = @JoinColumn(name = "ID_PROFESOR"))
	private Set<Profesor> profesores = new HashSet<>();

	public Set<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(Set<Profesor> profesores) {
		this.profesores = profesores;
	}

	public Long getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

	public String getNombreModulo() {
		return nombreModulo;
	}

	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
	}

}
