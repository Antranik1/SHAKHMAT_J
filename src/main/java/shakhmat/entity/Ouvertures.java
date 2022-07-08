package shakhmat.entity;

import java.util.List;

/**
 * Objet représentant la liste des ouvertures 
 * 
 * exemple : 
 * {
 *   "ouvertures": [ruyLopez, ouverture2]
 * }
 * 
 * @author ababoyan
 *
 */
public class Ouvertures {
	
	private List<String> ouvertures;
	
	public Ouvertures(List<String> ouvertures) {
		super();
		this.ouvertures = ouvertures;
	}
	
	public Ouvertures() {
	}

	/**
	 * @return the ouvertures
	 */
	public List<String> getOuvertures() {
		return ouvertures;
	}

	/**
	 * @param ouvertures the ouvertures to set
	 */
	public void setOuvertures(List<String> ouvertures) {
		this.ouvertures = ouvertures;
	}

}
