package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Leevi Palo
 * Data luokka kysymysten lukua tietokannasta varten
 *
 */
@Entity
public class Kysymykset {
	
	/**
	 * Alustetaan id ja kysymys, jotka tarkoittavat tietokannasta saatuja kysymyksia ja niiden id:ta
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int kysymys_id;
	private String kysymys;
	
	/**
	 * Setter ja Getter rakenne ylla alustetuille muuttujille
	 */
	
	public Kysymykset () {
		
	}
	
	public Kysymykset(int kysymys_id) {
		this.kysymys_id=kysymys_id;
	}
	

	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	public int getKysymys_id() {
		return kysymys_id;
	}
	public void setKysymys_id(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}
	
	public String toString() {
		return kysymys_id+":  "+kysymys;
	}

}
