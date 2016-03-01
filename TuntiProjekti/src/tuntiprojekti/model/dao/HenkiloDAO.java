package tuntiprojekti.model.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import tuntiprojekti.model.Henkilo;


/**
 * Henkilo-tietokohteen tietokantak‰sittelypalvelut
 * addHenkilo() 	- Lis‰‰ Henkilo
 * updateHenkilo() 	- p‰ivit‰ Henkilo
 * removeHenkilo() 	- poista Henkilo
 * findAll() 		- hae kaikki henkilot 
 * find() 			- hae tietty henkilo		 
 * @author a1404309
 *
 */

public class HenkiloDAO {
	
	/**
	 * Konstruktori
	 * lataa tietokantayhteyden ajurin
	 */
	public HenkiloDAO() throws DAOPoikkeus {
		
		try {
			Class.forName(DBConnectionProperties.getInstance().getProperty("driver")).newInstance();
		} catch(Exception e) {
			throw new DAOPoikkeus("Tietokannan ajuria ei kyetty lataamaan.", e);
		}
		
	}
	
	/**
	 * Avaa tietokantayhteyden
	 * @return avatun tietokantayhteyden
	 * @throws Exception Mik‰li yhteyden avaaminen ei onnistu
	 */
	private Connection avaaYhteys() throws DAOPoikkeus {
		
		try {
			return DriverManager.getConnection(
					DBConnectionProperties.getInstance().getProperty("url"),
					DBConnectionProperties.getInstance().getProperty("username"),
					DBConnectionProperties.getInstance().getProperty("password"));
		} catch (Exception e) {
			throw new DAOPoikkeus("Tietokantayhteyden avaaminen ep‰onnistui", e);
		}
		
	}
	
	/**
	 * Sulkee tietokantayhteyden
	 * @param yhteys Suljettava yhteys
	 */
	private void suljeYhteys(Connection yhteys) throws DAOPoikkeus {
		try {
			if (yhteys != null && !yhteys.isClosed()) {
				yhteys.close();
			}
		} catch (Exception e) {
			throw new DAOPoikkeus("Tietokantayhteys ei jostain syyst‰ suostu menem‰‰n kiinni.", e);
		}
	}

	/**
	 * Lis‰‰ Henkilo
	 * 
	 * @param Henkilo
	 * 			
	 * @throws SQLException
	 */
	public void addHenkilo(Henkilo h) throws DAOPoikkeus {
		
		//avataan yhteys
		Connection yhteys = avaaYhteys();
		
		try {
			//alustetaan sql-lause
			String sql = "INSERT INTO henkilo(hlo_etunimi, hlo_sukunimi, hlo_tunnit, hlo_pvm) "
					+ "VALUES(?, ?, ?, ?)";
			PreparedStatement lause = yhteys.prepareStatement(sql);
			//t‰ytet‰‰n puuttuvat tiedot
			lause.setString(1, h.getHlo_etunimi());
			lause.setString(2, h.getHlo_sukunimi());
			lause.setInt(3, h.getHlo_tunnit());
			lause.setTimestamp(4, h.getHlo_pvm());
			
		} catch (Exception e) {
			throw new DAOPoikkeus("Henkilˆn lis‰‰misyritys aiheutti virheen", e);
		} finally {
			suljeYhteys(yhteys);
		}
		
		
	}
	/**
	 * p‰ivit‰ Henkilo
	 * 
	 * @param Henkilo
	 * 			
	 * @throws SQLException
	 */
	public void updateHenkilo(Henkilo h) throws DAOPoikkeus {

		Connection yhteys = avaaYhteys();
		
		try {
			//alustetaan sql-lause
			String sql = "UPDATE henkilo SET "
						+ "hlo_etunimi = ?, "
						+ "hlo_sukunimi = ?, "
						+ "hlo_tunnit = ?, "
						+ "hlo_pvm = ? "
						+ "WHERE hlo_id = ?;";
			PreparedStatement lause = yhteys.prepareStatement(sql);
			//t‰ytet‰‰n puuttuvat tiedot
			lause.setString(1, h.getHlo_etunimi());
			lause.setString(2, h.getHlo_sukunimi());
			lause.setInt(3, h.getHlo_tunnit());
			lause.setTimestamp(4, h.getHlo_pvm());
			lause.setInt(5, h.getHlo_id());
			
		} catch (Exception e) {
			throw new DAOPoikkeus("Henkilˆn lis‰‰misyritys aiheutti virheen", e);
		} finally {
			suljeYhteys(yhteys);
		}

	}
	/**
	 * poista Henkilo
	 * 
	 * @param Henkilo
	 * 			
	 * @throws SQLException
	 */
	public void removeHenkilo(Henkilo h) throws DAOPoikkeus {

		Connection yhteys = avaaYhteys();
		
		try {
			
			//alustetaan sql-lause
			String sql = "DELETE FROM henkilo WHERE hlo_id=?;";
			PreparedStatement lause = yhteys.prepareStatement(sql);
			
			//t‰ytet‰‰n puuttuvat tiedot
			lause.setInt(1, h.getHlo_id());
			
			//suoritetaan lause
			lause.executeUpdate();
			System.out.println("POISTETTIIN HENKIL÷ TIETOKANNASTA: ");
			
		} catch(Exception e) {
			throw new DAOPoikkeus("Henkilˆn poistamissyritys aiheutti virheen", e);
		} finally {
			suljeYhteys(yhteys);
		}

	}
	/**
	 * Hakee tietokannan taulusta yhden Henkilon ja luo ja palauttaa tiedot Henkilo-tyyppisen‰ oliona 
	 * 
	 * @return Henkilo yksi Henkilo
	 */
	public Henkilo find(int henkilo_valinta) {
		
		Henkilo henkilo = null;
		
		return henkilo;
	}
	
	/**
	 * Hakee tietokannan taulusta kaikki Henkilot, sek‰ luo ja palauttaa tiedot Henkilo-tyyppisten olioiden listana (ArrayList) 
	 * 
	 * @return ArrayList<Henkilo> Lista Henkilˆit‰
	 */
	public ArrayList<Henkilo> findAll() throws DAOPoikkeus {
		
		ArrayList<Henkilo> henkilot = new ArrayList<Henkilo>();
		Henkilo henkilo = null;
		
		Connection yhteys = avaaYhteys();
		
		try {
			
			//suoritetaan haku
			String sql="SELECT id, hlo_etunimi, hlo_sukunimi, hlo_tunnit, hlo_pvm FROM henkilo";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);
			
			//k‰yd‰‰n hakutulokset l‰pi
			while(tulokset.next()) {
				henkilo = readHenkilo(tulokset);
				
				henkilot.add(henkilo);
			}
		
		} catch (Exception e) {
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		}finally {
			suljeYhteys(yhteys);		
		}
		
		return henkilot;
	}
	/**
	 * Lukee tietokannasta taulusta yhden tietorivin (Henkilon tiedot). Luo ja palauttaa tietojen perusteella Henkilo-tyyppisen olion
	 * 
	 * @param rs
	 *            tietokannasta kyselyll‰ haettu tulostaulu
	 * @return Henkilo henkilo-olio
	 */
	private Henkilo readHenkilo(ResultSet rs) {
		
		try {
			// Haetaan yhden Henkilon tiedot kyselyn tulostaulun (ResultSet-tyyppinen rs-olion) aktiiviselta tietorivilt‰
			int hlo_id = rs.getInt("hlo_id");
			String hlo_etunimi = rs.getString("hlo_etunimi");
			String hlo_sukunimi = rs.getString("hlo_sukunimi");
			int hlo_tunnit = rs.getInt("hlo_tunnit");
			Timestamp hlo_pvm = rs.getTimestamp("hlo_pvm");
			
			//  Luodaan ja palautetaan uusi Henkilo
			return new Henkilo(hlo_id, hlo_etunimi, hlo_sukunimi, hlo_tunnit, hlo_pvm);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}