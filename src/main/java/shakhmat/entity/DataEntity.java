package shakhmat.entity;

import java.util.List;

/**
 * Objet représentant les ouvertures 
 * exemple : 
 * {
 *		"nom":"Ruy Lopez (espagnole)",
 *		"coups":["e4 e5", "Cf3 Cc6", "Fb5 a6"]
 *	}
 * 
 * @author ababoyan
 *
 */
public class DataEntity {
	
	private String name;
	private List<String> coups;
	
	public DataEntity(String name, List<String> coups) {
		super();
		this.name = name;
		this.coups = coups;
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
	 * @return the coups
	 */
	public List<String> getCoups() {
		return coups;
	}

	/**
	 * @param coups the coups to set
	 */
	public void setCoups(List<String> coups) {
		this.coups = coups;
	}
	
}
