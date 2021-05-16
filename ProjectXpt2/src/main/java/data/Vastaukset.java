package data;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Leevi Palo
 * Data luokka ehdokkaiden vastausten lukua ja tallentamista varten 
 *
 */
@Entity
public class Vastaukset {
	
	/**
	 * Alustetaan muuttujat vastaajan id, ehdokkaan vastaus ja kysymyksen id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int ehdokas_id;
	private int kysymys_id;
	private int vastaus;
	
	
	public Vastaukset() {
		super();
	}
	
	public Vastaukset(int ehdokas_id, int kysymys_id, int vastaus) {
		super();
		this.ehdokas_id = ehdokas_id;
		this.kysymys_id = kysymys_id;
		this.vastaus = vastaus;

		
	}

	
	public int getEhdokas_id() {
		return ehdokas_id;
	}
	public void setEhdokas_id(int ehdokas_id) {
		this.ehdokas_id = ehdokas_id;
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


