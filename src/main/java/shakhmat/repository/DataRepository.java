package shakhmat.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import shakhmat.entity.DetailsOuvertureEntity;

/**
 * Classe de lecture du dossier src/main/resources/data pour récupérer les
 * fichiers
 * 
 * @author ababoyan
 *
 */
@Service
public interface DataRepository {

  /**
   * Permet de retourner toutes les ouvertures du dossier data sous forme de
   * liste
   * d'entitié
   * 
   * @return liste des ouvertures
   */
  public List<DetailsOuvertureEntity> getAllOuvertures();

  public List<String> getOuvertures();
}
