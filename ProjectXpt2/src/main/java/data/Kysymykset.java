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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	public Kysymykset(String kysymys) {
		this.kysymys=kysymys;
	}
	
	public Kysymykset(int kysymys_id, String kysymys) {
		this.kysymys_id=kysymys_id;
		this.kysymys=kysymys;
	}
	
	public Kysymykset(String kysymys_id, String kysymys) {
		this.setKysymys_id(kysymys_id);
		this.kysymys=kysymys;
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
	public void setKysymys_id(String kysymys_id) {
		try {
			this.kysymys_id = Integer.parseInt(kysymys_id);	
		}
		catch (NumberFormatException | NullPointerException e) {
			
		}
	}
	
	public String toString() {
		return "  "+kysymys;
	}

}
