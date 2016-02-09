package tuntiprojekti.model;

public class Henkilo {
	
	//attribuutit
	private int henk_id;
	private String etunimi;
	private String sukunimi;
	private String username;
	private String password;
	
	public Henkilo() {
		this.henk_id = 0;;
		this.etunimi = null;
		this.sukunimi = null;
		this.username = null;
		this.password = null;
	}
	public Henkilo(int henk_id, String etunimi, String sukunimi,
			String username, String password) {
		this.henk_id = henk_id;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.username = username;
		this.password = password;
	}
	public int getHenk_id() {
		return henk_id;
	}
	public void setHenk_id(int henk_id) {
		this.henk_id = henk_id;
	}
	public String getEtunimi() {
		return etunimi;
	}
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Henkilo [henk_id=" + henk_id + ", etunimi=" + etunimi
				+ ", sukunimi=" + sukunimi + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
}
