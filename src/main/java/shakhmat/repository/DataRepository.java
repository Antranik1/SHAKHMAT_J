package shakhmat.repository;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import shakhmat.entity.OuvertureRepositoryDTO;

/**
 * Classe de lecture du dossier src/main/resources/data pour récupérer les
 * fichiers
 * 
 * @author ababoyan
 *
 */
public interface DataRepository {

  /**
   * Permet de retourner toutes les ouvertures du dossier data sous forme de
   * liste
   * d'entitié
   * 
   * @return liste des ouvertures
   */
  public OuvertureRepositoryDTO findOuverture(String ouvertureName);

  public List<String> getAllOuverturesNames() throws StreamReadException, DatabindException, IOException;
}
