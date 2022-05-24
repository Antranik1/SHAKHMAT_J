package shakhmat.repository;

import java.util.List;

import shakhmat.entity.DataEntity;

/**
 * Classe de lecture du dossier src/main/resources/data pour récupérer les
 * fichiers
 * 
 * @author ababoyan
 *
 */
public interface DataRepository {

	/**
	 * Permet de retourner toutes les ouvertures du dossier data sous forme de liste
	 * d'entitié
	 * 
	 * @return liste des ouvertures
	 */
	public List<DataEntity> getAllOuvertures();
}
