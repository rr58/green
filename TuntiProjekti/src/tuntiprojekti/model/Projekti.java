package tuntiprojekti.model;

public class Projekti {
	
	private int project_id;
	private String name;
	private int h_yht;
	/**
	 * @param project_id
	 * @param name
	 * @param h_yht
	 */
	public Projekti() {
		super();
		this.project_id = 0;
		this.name = null;
		this.h_yht = 0;
	}
	
	public Projekti(int project_id, String name, int h_yht) {
		super();
		this.project_id = project_id;
		this.name = name;
		this.h_yht = h_yht;
	}
	/**
	 * @return the project_id
	 */
	public int getProject_id() {
		return project_id;
	}
	/**
	 * @param project_id the project_id to set
	 */
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the h_yht
	 */
	public int getH_yht() {
		return h_yht;
	}
	/**
	 * @param h_yht the h_yht to set
	 */
	public void setH_yht(int h_yht) {
		this.h_yht = h_yht;
	}
	
	@Override
	public String toString() {
		return "Projekti [project_id=" + project_id + ", name=" + name
				+ ", h_yht=" + h_yht + "]";
	}
	
	
	
}
