package tuntiprojekti.model;

import java.sql.Timestamp;

public class Henkilo {
	
	//attribuutit
	private int hlo_id;
	private String hlo_etunimi;
	private String hlo_sukunimi;
	private int hlo_tunnit;
	private Timestamp hlo_pvm;
	
	
	public Henkilo() {
		this.hlo_id = 0;;
		this.hlo_etunimi = null;
		this.hlo_sukunimi = null;
		this.hlo_tunnit = 0;
		this.hlo_pvm = null;
	}
	public Henkilo(int hlo_id, String hlo_etunimi, String hlo_sukunimi,
			int hlo_tunnit, Timestamp hlo_pvm) {
		this.hlo_id = hlo_id;
		this.hlo_etunimi = hlo_etunimi;
		this.hlo_sukunimi = hlo_sukunimi;
		this.hlo_tunnit = hlo_tunnit;
		this.hlo_pvm = hlo_pvm;
		
	}
	public int getHlo_id() {
		return hlo_id;
	}
	public void setHlo_id(int hlo_id) {
		this.hlo_id = hlo_id;
	}
	public String getHlo_etunimi() {
		return hlo_etunimi;
	}
	public void setHlo_etunimi(String hlo_etunimi) {
		this.hlo_etunimi = hlo_etunimi;
	}
	public String getHlo_sukunimi() {
		return hlo_sukunimi;
	}
	public void setHlo_sukunimi(String hlo_sukunimi) {
		this.hlo_sukunimi = hlo_sukunimi;
	}
	public int getHlo_tunnit() {
		return hlo_tunnit;
	}
	public void setHlo_tunnit(int hlo_tunnit) {
		this.hlo_tunnit = hlo_tunnit;
	}
	public Timestamp getHlo_pvm() {
		return hlo_pvm;
	}
	public void setHlo_pvm(Timestamp hlo_pvm) {
		this.hlo_pvm = hlo_pvm;
	}
	@Override
	public String toString() {
		return "Henkilo [hlo_id=" + hlo_id + ", hlo_etunimi=" + hlo_etunimi
				+ ", hlo_sukunimi=" + hlo_sukunimi + ", hlo_tunnit="
				+ hlo_tunnit + ", hlo_pvm=" + hlo_pvm + "]";
	}
	
	
}
