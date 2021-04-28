package data;

import java.util.ArrayList;

/**
 * 
 * @author Leevi Palo
 * Data luokka ehdokkaiden vastausten lukua tietokannasta varten
 *
 */

public class Vastaukset {
	
	/**
	 * Alustetaan muuttujat vastaajan id, ehdokkaan vastaus ja kysymyksen id
	 */
	private int vastaaja_id;
	private int vastaus;
	private int kysymys_id;
	
	public int getVastaaja_id() {
		return vastaaja_id;
	}
	public void setVastaaja_id(int vastaaja_id) {
		this.vastaaja_id = vastaaja_id;
	}
	public int getVastaus() {
		return vastaus;
	}
	public void setVastaus(int vastaus) {
		this.vastaus = vastaus;
	}
	public int getKysymys_id() {
		return kysymys_id;
	}
	public void setKysymys_id(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}
	

}


