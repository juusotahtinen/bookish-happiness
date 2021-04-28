package data;

/**
 * 
 * @author Leevi Palo
 * Data luokka kysymysten lukua tietokannasta varten
 *
 */

public class Kysymykset {
	
	/**
	 * Alustetaan id ja kysymys, jotka tarkoittavat tietokannasta saatuja kysymyksia ja niiden id:ta
	 */
	private int id;
	private String kysymys;
	
	/**
	 * Setter ja Getter rakenne ylla alustetuille muuttujille
	 */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}

}
