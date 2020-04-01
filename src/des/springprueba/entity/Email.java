package des.springprueba.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "EMAIL")
public class Email implements Serializable {

	private static final long serialVersionUID = -7929690108419204859L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_EMAIL")
	private Long idEmail;

	@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"+"(?:[a-z0-9](?:[a-z0-9-]*"+
		        "[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",message="La dirección debe tener la forma email@email.com")
	@Column(name = "DIRECCION_EMAIL")
	private String direccionEmail;

	@ManyToOne
	@JoinColumn(name = "ID_PROFESOR")
	private Profesor profesor;

	public Long getIdEmail() {
		return idEmail;
	}

	public void setIdEmail(Long idEmail) {
		this.idEmail = idEmail;
	}

	public String getDireccionEmail() {
		return direccionEmail;
	}

	public void setDireccionEmail(String direccionEmail) {
		this.direccionEmail = direccionEmail;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	
	
}
