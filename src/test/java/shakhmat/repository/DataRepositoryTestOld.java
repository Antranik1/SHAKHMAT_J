package shakhmat.repository;

//import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import shakhmat.entity.OuvertureRepositoryDTO;
import shakhmat.repository.impl.DataRepositoryImpl;

public class DataRepositoryTestOld {

	/** Logger de la classe */
	private static final Logger LOGGER = LogManager.getLogger(DataRepositoryTestOld.class);
	
	private static final String RUY_LOPEZ = "ruyLopez";
	private static final String OUVERTURE_TEST = "ouverture2";

	/**
	 * Classe a tester
	 */
	private static DataRepositoryImpl dataRepo = new DataRepositoryImpl();

	/**
	 * JDD
	 */
	public static OuvertureRepositoryDTO testOkRuyLopez;
	public static List<OuvertureRepositoryDTO> testOkRuyLopezList = new ArrayList<>();

	@BeforeAll
	static void setup() {
		LOGGER.info("@BeforeAll - executes once before all test methods in this class");
		
		ReflectionTestUtils.setField(dataRepo, "cheminRepoData", 
	               "D:\\project\\SHAKHMAT\\SHAKHMAT_J\\src\\main\\resources\\data\\");
		
		ReflectionTestUtils.setField(dataRepo, "cheminRepoDataOuvertures", 
	               "D:\\project\\SHAKHMAT\\SHAKHMAT_J\\src\\main\\resources\\data\\ouvertures\\");
		
		List<String> listeCoupsRuyLopez = new ArrayList<>();
		listeCoupsRuyLopez.add("e4 e5");
		listeCoupsRuyLopez.add("Cf3 Cc6");
		listeCoupsRuyLopez.add("Fb5 a6");
//		testOkRuyLopez = new DetailsOuvertureEntity("Ruy Lopez (espagnole)", listeCoupsRuyLopez);
//		testOkRuyLopezList.add(testOkRuyLopez);
	}

	@BeforeEach
	void init() {
		LOGGER.info("@BeforeEach - executes before each test method in this class");
	}

	@AfterEach
	void tearDown() {
		LOGGER.info("@AfterEach - executed after each test method.");
	}

	@AfterAll
	static void done() {
		LOGGER.info("@AfterAll - executed after all test methods.");
	}

	@Test
	public void testLectureRepertoireData() {
		LOGGER.info("Ceci est un message de test");
		List<OuvertureRepositoryDTO> listeOuverture = dataRepo.getAllOuvertures();

		assertEquals(listeOuverture.get(0).getName(), testOkRuyLopezList.get(0).getName());
		assertEquals(listeOuverture.get(0).getCoups().get(0), 
				testOkRuyLopezList.get(0).getCoups().get(0));
		assertEquals(listeOuverture.get(0).getCoups().get(1), 
				testOkRuyLopezList.get(0).getCoups().get(1));
		assertEquals(listeOuverture.get(0).getCoups().get(2), 
				testOkRuyLopezList.get(0).getCoups().get(2));
	}
	
	@Test
	void remonterOuverturesTest() {
		List<String> listeOuvertures = new ArrayList<>();
		listeOuvertures.add(RUY_LOPEZ);
		listeOuvertures.add(OUVERTURE_TEST);
		
		assertEquals(listeOuvertures, dataRepo.getOuvertures());
		
	}

}
