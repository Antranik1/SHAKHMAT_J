package shakhmat.repository.impl;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;

import shakhmat.entity.DataEntity;
import shakhmat.repository.DataRepository;

public class DataRepositoryImpl implements DataRepository {

	/** Logger de la classe */
	private static final Logger LOGGER = LogManager.getLogger(DataRepositoryImpl.class);

	@Value("${chemin.data}")
	private String cheminRepoData;

	@Override
	public List<DataEntity> getAllOuvertures() {
		List<DataEntity> listeDesOuvertures = new ArrayList<DataEntity>();
		LOGGER.info("------------- cheminRepoData : " + cheminRepoData);
		List<Path> result = new ArrayList<>();
		// Lecture du dossier cheminRepoData
		try (Stream<Path> paths = Files.walk(Paths.get(cheminRepoData))) {
			result = paths.filter(Files::isRegularFile).collect(Collectors.toList());
		} catch (final IOException pIOException) {
			LOGGER.error("Erreur lors de la lecture du repertoire : " + pIOException.getMessage());
		}
		LOGGER.info(result);
		
		for (Iterator<Path> iterator = result.iterator(); iterator.hasNext();) {
			Path path = (Path) iterator.next();
			
			// lecture du json
			JSONParser parser = new JSONParser();
			try {
				Object obj = parser.parse(new FileReader(path.toString()));
				
				JSONObject jsonObject = (JSONObject) obj;
				String nomOuverture = (String) jsonObject.get("nom");
				List<String> coups = (List<String>) jsonObject.get("coups");
				
				DataEntity ouverture = new DataEntity(nomOuverture, coups);

				listeDesOuvertures.add(ouverture);
			}catch (Exception e) {
				LOGGER.error(e);
			}
		}
		return listeDesOuvertures;
	}

}
