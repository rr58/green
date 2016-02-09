package tuntiprojekti.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tuntiprojekti.model.Henkilo;


/**
 * Henkilo-tietokohteen tietokantak�sittelypalvelut
 * addHenkilo() 	- Lis�� Henkilo
 * updateHenkilo() 	- p�ivit� Henkilo
 * removeHenkilo() 	- poista Henkilo
 * findAll() 		- hae kaikki henkilot 
 * find() 			- hae tietty henkilo		 
 * @author a1404309
 *
 */

public class HenkiloDAO extends DataAccessObject {

	/**
	 * Lis�� Henkilo
	 * 
	 * @param Henkilo
	 * 			
	 * @throws SQLException
	 */
	public void addHenkilo(Henkilo henk) throws SQLException {



	}
	/**
	 * p�ivit� Henkilo
	 * 
	 * @param Henkilo
	 * 			
	 * @throws SQLException
	 */
	public void updateHenkilo(Henkilo henk) throws SQLException {



	}
	/**
	 * poista Henkilo
	 * 
	 * @param Henkilo
	 * 			
	 * @throws SQLException
	 */
	public void removeHenkilo(Henkilo henk) throws SQLException {



	}
	/**
	 * Hakee tietokannan taulusta yhden Henkilon ja luo ja palauttaa tiedot Henkilo-tyyppisen� oliona 
	 * 
	 * @return Henkilo yksi Henkilo
	 */
	public Henkilo find(int henkilo_valinta) {
		
		Henkilo henkilo = null;
		
		return henkilo;
	}
	
	/**
	 * Hakee tietokannan taulusta kaikki Henkilot, sek� luo ja palauttaa tiedot Henkilo-tyyppisten olioiden listana (ArrayList) 
	 * 
	 * @return ArrayList<Henkilo> Lista Henkil�it�
	 */
	public ArrayList<Henkilo> findAll() {
		
		ArrayList<Henkilo> henkilot = new ArrayList<Henkilo>();
		
		return henkilot;
	}
	/**
	 * Lukee tietokannasta taulusta yhden tietorivin (Henkilon tiedot). Luo ja palauttaa tietojen perusteella Henkilo-tyyppisen olion
	 * 
	 * @param rs
	 *            tietokannasta kyselyll� haettu tulostaulu
	 * @return Henkilo henkilo-olio
	 */
	private Henkilo readHenkilo(ResultSet rs) {
		
		try {
			// Haetaan yhden Henkilon tiedot kyselyn tulostaulun (ResultSet-tyyppinen rs-olion) aktiiviselta tietorivilt�
			int henk_id = rs.getInt("henk_id");
			String etunimi = rs.getString("etunimi");
			String sukunimi = rs.getString("sukunimi");
			String username = rs.getString("username");
			String password = rs.getString("password");
			
			//  Luodaan ja palautetaan uusi Henkilo
			return new Henkilo(henk_id, etunimi, sukunimi, username, password);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}