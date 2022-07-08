package shakhmat.repository.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
// import org.json.simple.JSONArray;
// import org.json.simple.JSONObject;
// import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import shakhmat.entity.DetailsOuvertureEntity;
import shakhmat.entity.Ouvertures;
import shakhmat.repository.DataRepository;

public class DataRepositoryImpl implements DataRepository {

  /** Logger de la classe */
  private static final Logger LOGGER = LogManager.getLogger(DataRepositoryImpl.class);

  @Value("${chemin.data}")
  private String cheminRepoData;

  @Value("${chemin.data.liste.ouvertures}")
  private String cheminRepoDataOuvertures;

  private final static String NOM_FICHIER_GLOBAL_OUVERTURES = "ouvertures.json";

  @Override
  public List<DetailsOuvertureEntity> getAllOuvertures() {
    //		List<DataEntity> listeDesOuvertures = new ArrayList<DataEntity>();
    //		LOGGER.info("------------- cheminRepoData : " + cheminRepoData);
    //		// Lecture du dossier cheminRepoData
    //		final List<Path> result = extractFiles();
    //		LOGGER.info(result);
    //		
    //		for (Iterator<Path> iterator = result.iterator(); iterator.hasNext();) {
    //			Path path = (Path) iterator.next();
    //			
    //			// lecture du json
    //			JSONParser parser = new JSONParser();
    //			try {
    //				Object obj = parser.parse(new FileReader(path.toString()));
    //				
    //				JSONObject jsonObject = (JSONObject) obj;
    //				String nomOuverture = (String) jsonObject.get("nom");
    //				List<String> coups = (List<String>) jsonObject.get("coups");
    //				
    //				DataEntity ouverture = new DataEntity(nomOuverture, coups);
    //
    //				listeDesOuvertures.add(ouverture);
    //			}catch (Exception e) {
    //				LOGGER.error(e);
    //			}
    //		}
    //		return listeDesOuvertures;
    return null;
  }

  /**
   * Permet de remonter les fichiers contenus dans le repertoire cheminRepoData
   * 
   * @param result liste des chemins vide
   * @return list remplie
   */
  private List<Path> extractFiles() {
    List<Path> result = new ArrayList<>();
    try (Stream<Path> paths = Files.walk(Paths.get(cheminRepoDataOuvertures))) {
      result = paths.filter(Files::isRegularFile).collect(Collectors.toList());
    } catch (final IOException pIOException) {
      LOGGER.error("Erreur lors de la lecture du repertoire : " + pIOException.getMessage());
    }
    return result;
  }

  private Ouvertures readOuvertureFile(final Path pathOuvertures) {
    Ouvertures ouvertures = new Ouvertures();
    String content;
    try {
      content = Files.readString(pathOuvertures);
      final Gson gson = new GsonBuilder().create();
      ouvertures = gson.fromJson(content, Ouvertures.class);
    } catch (final IOException pIOException) {
      LOGGER.error(pIOException);
    }
    return ouvertures;
  }

  @Override
  public List<String> getOuvertures() {
    LOGGER.info("------------- cheminRepoData : " + cheminRepoDataOuvertures);
    final Path chemin = Paths.get(cheminRepoDataOuvertures.concat(NOM_FICHIER_GLOBAL_OUVERTURES));
    return readOuvertureFile(chemin).getOuvertures();
  }

}
