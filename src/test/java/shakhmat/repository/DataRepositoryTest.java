package shakhmat.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;

import shakhmat.entity.DetailsOuvertureEntity;
import shakhmat.repository.DataRepository;
import shakhmat.repository.impl.DataRepositoryImpl;

@SpringBootTest(classes = DataRepository.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = SpringJUnitConfig.class)
public class DataRepositoryTest {

	/** Logger de la classe */
	private static final Logger LOGGER = LogManager.getLogger(DataRepositoryTest.class);
	
	private static final String RUY_LOPEZ = "ruyLopez";
	private static final String OUVERTURE_TEST = "ouverture2";
	
	/**
	 * Classe a tester
	 */
	@Autowired
	private DataRepository dataRepository;

	@Test
	void remonterOuverturesTest() {
		List<String> listeOuvertures = new ArrayList<>();
		listeOuvertures.add(RUY_LOPEZ);
		listeOuvertures.add(OUVERTURE_TEST);
		
		assertEquals(listeOuvertures, this.dataRepository.getOuvertures());
		
	}
	
}
