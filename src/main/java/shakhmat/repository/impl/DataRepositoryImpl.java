package shakhmat.repository.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import shakhmat.entity.OuvertureRepositoryDTO;
import shakhmat.repository.DataRepository;
import shakhmat.repository.RepositoryConfiguration;

@Service
public class DataRepositoryImpl implements DataRepository {

  @Autowired
  private RepositoryConfiguration repositoryConfiguration;

  /** Logger de la classe */
  private final Logger logger = LoggerFactory.getLogger(DataRepositoryImpl.class);

  private ObjectMapper mapper = new ObjectMapper();

  private final static String NOM_FICHIER_GLOBAL_OUVERTURES = "ouvertures.json";

  @Override
  public OuvertureRepositoryDTO findOuverture(String ouvertureName) {
    return null;
  }

  @Override
  public List<String> getAllOuverturesNames() throws StreamReadException, DatabindException, IOException {
    final InputStream is = getClass()
      .getResourceAsStream(repositoryConfiguration.getOuverturePath() + NOM_FICHIER_GLOBAL_OUVERTURES);
    return mapper.readValue(is, new TypeReference<List<String>>() {});
  }

  //  @Override
  //  public List<OuvertureRepositoryDTO> getAllOuvertures() {
  //    //		List<DataEntity> listeDesOuvertures = new ArrayList<DataEntity>();
  //    //		LOGGER.info("------------- cheminRepoData : " + cheminRepoData);
  //    //		// Lecture du dossier cheminRepoData
  //    //		final List<Path> result = extractFiles();
  //    //		LOGGER.info(result);
  //    //		
  //    //		for (Iterator<Path> iterator = result.iterator(); iterator.hasNext();) {
  //    //			Path path = (Path) iterator.next();
  //    //			
  //    //			// lecture du json
  //    //			JSONParser parser = new JSONParser();
  //    //			try {
  //    //				Object obj = parser.parse(new FileReader(path.toString()));
  //    //				
  //    //				JSONObject jsonObject = (JSONObject) obj;
  //    //				String nomOuverture = (String) jsonObject.get("nom");
  //    //				List<String> coups = (List<String>) jsonObject.get("coups");
  //    //				
  //    //				DataEntity ouverture = new DataEntity(nomOuverture, coups);
  //    //
  //    //				listeDesOuvertures.add(ouverture);
  //    //			}catch (Exception e) {
  //    //				LOGGER.error(e);
  //    //			}
  //    //		}
  //    //		return listeDesOuvertures;
  //    return null;
  //  }
  //
  //  /**
  //   * Permet de remonter les fichiers contenus dans le repertoire cheminRepoData
  //   * 
  //   * @param result liste des chemins vide
  //   * @return list remplie
  //   */
  //  private List<Path> extractFiles() {
  //    List<Path> result = new ArrayList<>();
  //    try (Stream<Path> paths = Files.walk(Paths.get(cheminRepoDataOuvertures))) {
  //      result = paths.filter(Files::isRegularFile).collect(Collectors.toList());
  //    } catch (final IOException pIOException) {
  //      LOGGER.error("Erreur lors de la lecture du repertoire : " + pIOException.getMessage());
  //    }
  //    return result;
  //  }
  //
  //  private Ouvertures readOuvertureFile(final Path pathOuvertures) {
  //    Ouvertures ouvertures = new Ouvertures();
  //    String content;
  //    try {
  //      content = Files.readString(pathOuvertures);
  //      final Gson gson = new GsonBuilder().create();
  //      ouvertures = gson.fromJson(content, Ouvertures.class);
  //    } catch (final IOException pIOException) {
  //      LOGGER.error(pIOException);
  //    }
  //    return ouvertures;
  //  }
  //
  //  @Override
  //  public List<String> getOuvertures() {
  //    LOGGER.info("------------- cheminRepoData : " + cheminRepoDataOuvertures);
  //    final Path chemin = Paths.get(cheminRepoDataOuvertures.concat(NOM_FICHIER_GLOBAL_OUVERTURES));
  //    return readOuvertureFile(chemin).getOuvertures();
  //  }

}
