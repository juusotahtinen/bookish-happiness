package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Juho
 * Data luokka kayttajatunnuksia varten
 */

@Entity
public class Account {
	/**
	 * Alustetaan id, email ja password, jotka tarkoittavat tietokantaan lahetettavia tietoja.
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String email;
	private String password;

	public Account() {
		super();
	}

	public Account(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Account(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
/**
 * Luodaan getterit ja setterit
 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return id + ": " + email + " " + password;
	}
}