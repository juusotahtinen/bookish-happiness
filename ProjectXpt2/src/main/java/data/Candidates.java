package data;

public class Candidates {

	/**
	 * Ehdokkaan id
	 */
	private int ehdokas_id;
	/**
	 * Ehdokkaan sukunimi
	 */
	private String sukunimi;
	/**
	 * Ehdokkaan etunimi
	 */
	private String etunimi;
	/**
	 * Ehdokkaan edustama puolue
	 */
	private String puolue;
	/**
	 * Ehdokkaan kotipaikkakunta
	 */
	private String kotipaikkakunta;
	/**
	 * Ehdokkaan ikä
	 */
	private int ika;
	/**
	 * Miksi ehdokas pyrkii eduskuntaan
	 */
	private String miksi_eduskuntaan;
	/**
	 * Mitä asioita ehdokas haluaa edistää
	 */
	private String mita_asioita_haluat_edistaa;
	/**
	 * Ehdokkaan ammatti
	 */
	private String ammatti;
	
	
	/**
	 * @param sukunimi Ehdokkaan sukunimi
	 * @param etunimi Ehdokkaan etunimi
	 * @param puolue Ehdokkaan edustama puolue
	 * @param kotipaikkakunta Ehdokkaan kotipaikkakunta
	 * @param ika Ehdokkaan ikä
	 * @param miksi_eduskuntaan Miksi ehdokas pyrkii eduskuntaan
	 * @param mita_asioita_haluat_edistaa Mitä asioita ehdokas haluaa edistää
	 * @param ammatti Ehdokkaan ammatti
	 */
	public Candidates(String sukunimi, String etunimi, String puolue, String kotipaikkakunta, int ika, String miksi_eduskuntaan, String mita_asioita_haluat_edistaa, String ammatti) {

		this.sukunimi=sukunimi;
		this.etunimi=etunimi;
		this.puolue=puolue;
		this.kotipaikkakunta=kotipaikkakunta;
		this.ika=ika;
		this.miksi_eduskuntaan=miksi_eduskuntaan;
		this.mita_asioita_haluat_edistaa=mita_asioita_haluat_edistaa;
		this.ammatti=ammatti;
	}
	public Candidates() {

	}
	
//	public Candidates() {
//
//	}

	public int getEhdokas_id() {
		return ehdokas_id;
	}

	public void setEhdokas_id(int ehdokas_id) {
		this.ehdokas_id = ehdokas_id;
	}

	public String getPuolue() {
		return puolue;
	}

	public void setPuolue(String puolue) {
		this.puolue = puolue;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getKotipaikkakunta() {
		return kotipaikkakunta;
	}

	public void setKotipaikkakunta(String kotipaikkakunta) {
		this.kotipaikkakunta = kotipaikkakunta;
	}

	public int getIka() {
		return ika;
	}

	public void setIka(int ika) {
		this.ika = ika;
	}

	public String getMiksi_eduskuntaan() {
		return miksi_eduskuntaan;
	}

	public void setMiksi_eduskuntaan(String miksi_eduskuntaan) {
		this.miksi_eduskuntaan = miksi_eduskuntaan;
	}

	public String getMita_asioita_haluat_edistaa() {
		return mita_asioita_haluat_edistaa;
	}

	public void setMita_asioita_haluat_edistaa(String mita_asioita_haluat_edistaa) {
		this.mita_asioita_haluat_edistaa = mita_asioita_haluat_edistaa;
	}

	public String getAmmatti() {
		return ammatti;
	}

	public void setAmmatti(String ammatti) {
		this.ammatti = ammatti;
	}

	
	
	

}