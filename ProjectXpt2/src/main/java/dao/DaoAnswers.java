package dao;

import java.sql.*;
import java.util.ArrayList;

import data.Candidates;
import data.Kysymykset;
import data.Vastaukset;

/**
 * 
 * @author Leevi Palo
 * @author Juho Hamalainen
 *
 */

public class DaoAnswers {

	/**
	 * Alustetaan tarvittavat muuttujat: tietokannan osoite, kayttajatunnus ja salasana
	 */
	
	private String dbURL;
	private String username;
	private String password;
	
	/**
	 * Muodostin oliolle
	 * @param dbURL tietokannan osoite
	 * @param username tietokannan kayttajatunnus
	 * @param password tietokannan salasana
	 */
	
	public DaoAnswers(String dbURL, String username, String password) {
		this.dbURL = dbURL;
		this.username = username;
		this.password = password;
		
	}
	



	/**
	 * Juhon koodia
	 * @return
	 */
	
	public ArrayList<Vastaukset> SelectEhdokkaanVastaukset() {

		ArrayList<Vastaukset> list = new ArrayList<Vastaukset>();

		try {

			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Connection conn = DriverManager.getConnection(dbURL, username, password);

			String sql2 = "SELECT * FROM vastaukset";

			Statement statement2 = conn.createStatement();
			ResultSet result = statement2.executeQuery(sql2);

			while (result.next()) {
				Vastaukset v = new Vastaukset();
				v.setKysymys_id(result.getInt("KYSYMYS_ID"));
				v.setEhdokas_id(result.getInt("EHDOKAS_ID"));
				v.setVastaus(result.getInt("vastaus"));
				list.add(v);

			}
			return list;

		} catch (SQLException ex) {
			return null;
		}

	}
	
	/**
	 * Juhon koodia
	 * @param ehdokas_id
	 * @return
	 * @throws SQLException
	 */
	
	public Candidates EhdokkaanTiedot(Integer ehdokas_id) throws SQLException {
		
		Candidates f =new Candidates();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection conn = DriverManager.getConnection(dbURL, username, password);

		try {
			
			String sql="select ehdokas_id, etunimi, sukunimi, puolue from ehdokkaat where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ehdokas_id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				
				f.setEhdokas_id(RS.getInt("ehdokas_id"));
				f.setSukunimi(RS.getString("sukunimi"));
				f.setEtunimi(RS.getString("etunimi"));
				f.setPuolue(RS.getString("puolue"));
				
			}
			return f;
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	/**
	 * Leevin koodia
	 * Haetaan tietokannasta kysymykset ja niiden id ja lisataan ArrayListiin jonka tyyppi on Kysymykset
	 * @return palautetaan ArrayList joka sisaltaa kysymykset ja niiden id:n
	 */
	 
	
	public ArrayList<Kysymykset> Select() {
		
		/**
		 * Luodaan ArrayList joka palautetaan
		 */
		
		ArrayList<Kysymykset> list = new ArrayList<Kysymykset>();
		
		/**
		 * Try Catch rakenne tietokannan yhteyden luomiseen ja kayttoon
		 */
		 
		try {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
			/**
			 * Yhteyden luonti
			 */
			
		    Connection conn = DriverManager.getConnection(dbURL, username, password);
		    
		    /**
		     * SQL lause ja sen suoritus
		     */
			
			String sql2 = "SELECT * FROM kysymykset";
			 
			Statement statement2 = conn.createStatement();
			ResultSet result = statement2.executeQuery(sql2);
			 
			/**
			 * While loop jossa tallennetaan ArrayListiin halutut tiedot
			 */
			 
			while (result.next()){
				
				/**
				 * Luodaan Kysymykset tyyppinen olio johon tallennetaan ylla mainitut arvot
				 */
				
				Kysymykset k = new Kysymykset();
				k.setKysymys_id(result.getString("KYSYMYS_ID"));
				k.setKysymys(result.getString("KYSYMYS"));
				
				/**
				 * Lisataan olio listaan
				 */
				
				list.add(k);

			    
			}
			return list;
			
			
			
		} catch (SQLException ex) {
		    return null;
		}


	}
	
	
}




