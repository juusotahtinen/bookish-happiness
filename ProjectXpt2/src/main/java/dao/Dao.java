package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Candidates;

import java.sql.Connection;



public class Dao {
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	public Dao(String url, String user, String pass) {
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	
	/**
	 * Luodaan yhteys tietokantaan
	 * @return true
	 */
	public boolean getConnection() {
		try {
	        if (conn == null || conn.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	                throw new SQLException(e);
	            }
	            conn = DriverManager.getConnection(url, user, pass);
	        }
	        return true;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/**
	 * Katkaistaan yhteys tietokantaan
	 * 
	 */
	protected void disconnect() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
	
	/**
	 * @author juuso
	 * Suoritetaan sql-lause jolla listataan kaikkien ehdokkaiden kaikki tiedot
	 * @return listCandidates
	 * @throws SQLException
	 */
	public ArrayList<Candidates> listAllCandidates() throws SQLException {
        ArrayList<Candidates> listCandidates = new ArrayList<>();
         
        String sql = "SELECT * FROM ehdokkaat ORDER BY sukunimi, etunimi ASC";
         
        getConnection();
         
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	Candidates f=new Candidates();
			f.setEhdokas_id(resultSet.getInt("ehdokas_id"));
			f.setSukunimi(resultSet.getString("sukunimi"));
			f.setEtunimi(resultSet.getString("etunimi"));
			f.setPuolue(resultSet.getString("puolue"));
			listCandidates.add(f);
        }  

        return listCandidates;
	}
	
	/**
	 * @author riku
	 * Suoritetaan sql-lause jolla valitaan ehdokkaista yksi ehdokas ehdokas_id:n perusteella
	 * @param ehdokas_id
	 * @return candidateInfo
	 */
	public ArrayList<Candidates> getEhdokasInfo(String ehdokas_id) {
		ArrayList<Candidates> candidateInfo = new ArrayList<Candidates>();
		try {
			String sql="select * from ehdokkaat where ehdokas_id=?";
			getConnection();
	         
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, ehdokas_id);
	        ResultSet RS = statement.executeQuery();

			while (RS.next()){
				Candidates p=new Candidates();
				p.setEhdokas_id(RS.getInt("ehdokas_id"));
				p.setSukunimi(RS.getString("sukunimi"));
				p.setEtunimi(RS.getString("etunimi"));
				p.setPuolue(RS.getString("puolue"));
				p.setKotipaikkakunta(RS.getString("kotipaikkakunta"));
				p.setIka(RS.getInt("ika"));
				p.setMiksi_eduskuntaan(RS.getString("miksi_eduskuntaan"));
				p.setMita_asioita_haluat_edistaa(RS.getString("mita_asioita_haluat_edistaa"));
				p.setAmmatti(RS.getString("ammatti"));
				candidateInfo.add(p);
			}
			return candidateInfo;
		}
		
		
		catch(SQLException e) {
			return null;
		}

	}	
	/**
	 * @author riku
	 * Suoritetaan sql-lause jolla muokataan ehdokas_id:n mukaan sukunimi, etunimi ja puolue
	 * @param ehdokas_id, sukunimi, etunimi, puolue
	 * @return listAllCandidates
	 */
	public ArrayList<Candidates> updateCandis(String sukunimi, String etunimi, String puolue, int ehdokas_id) {
	try {
		String sql="update ehdokkaat set sukunimi=?, etunimi=?, puolue=? where ehdokas_id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, sukunimi);
		pstmt.setString(2, etunimi);
		pstmt.setString(3, puolue);
		pstmt.setInt(4, ehdokas_id);
		pstmt.executeUpdate();
		return listAllCandidates();
	}
	catch(SQLException e) {
		return null;
	}
}

	
	/**
	 * @author juuso
	 * Suoritetaan sql-lause jolla poistetaan ehdokas_id:n mukaisen ehdokkaan tiedot tietokannasta
	 * @param ehdokas_id
	 * @return candidateInfo
	 */
	public ArrayList<Candidates> deleteEhdokasInfo(String ehdokas_id) {
		ArrayList<Candidates> candidateInfo = new ArrayList<Candidates>();
		try {
			String sql="delete from ehdokkaat where ehdokas_id=?";
			getConnection();
	         
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, ehdokas_id);
	        statement.executeUpdate();

			return candidateInfo;
		}
		
		
		catch(SQLException e) {
			return null;
		}
	}
	

	/**
	 * Suoritetaan sql-lause jolla luetaan ehdokas_id:n mukaisen ehdokkaan tiedot tietokannasta
	 * @param ehdokas_id
	 * @return f
	 */
	public Candidates readCandidates(String ehdokas_id) {
		Candidates f=null;
		try {
			String sql="select * from ehdokkaat where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ehdokas_id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				f=new Candidates();
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
	 * @author juuso
	 * Suoritetaan sql-lause jolla lähetetään uuden ehdokkaan tiedot tietokantaan
	 * @param f
	 * @return listAllCandidates
	 */
	public ArrayList<Candidates> insert(Candidates f) {
		try {
			String sql="insert into ehdokkaat(sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti)values(?, ?, ?, ?, ?, ?, ?, ?)";
			getConnection();
			PreparedStatement pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, f.getSukunimi());
			pstmt.setString(2, f.getEtunimi());
			pstmt.setString(3, f.getPuolue());
			pstmt.setString(4, f.getKotipaikkakunta());
			pstmt.setInt(5, f.getIka());
			pstmt.setString(6, f.getMiksi_eduskuntaan());
			pstmt.setString(7, f.getMita_asioita_haluat_edistaa());
			pstmt.setString(8, f.getAmmatti());
					
			pstmt.executeUpdate();
			return listAllCandidates();
		}
		catch(SQLException e) {
			return null;
		}
	}
	
		
}

