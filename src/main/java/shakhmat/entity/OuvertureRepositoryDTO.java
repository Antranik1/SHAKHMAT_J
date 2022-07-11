package shakhmat.entity;

import java.util.List;

/**
 * Objet représentant le détail des ouvertures 
 * exemple : 
 * {
 *		"nom":"Ruy Lopez (espagnole)",
 *		"variante": "Classique",
 *		"coups":["e4 e5", "Cf3 Cc6", "Fb5 a6"]
 *	}
 * 
 * @author ababoyan
 *
 */
public class OuvertureRepositoryDTO {
	
	private String name;
	private String variante;
	private List<String> coups;
	
	public OuvertureRepositoryDTO(String name, String variante, List<String> coups) {
		super();
		this.name = name;
		this.variante = variante;
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

	/**
	 * @return the variante
	 */
	public String getVariante() {
		return variante;
	}

	/**
	 * @param variante the variante to set
	 */
	public void setVariante(String variante) {
		this.variante = variante;
	}
	
}
