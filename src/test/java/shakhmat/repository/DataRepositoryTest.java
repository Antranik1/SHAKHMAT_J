package shakhmat.repository;

import static org.junit.Assert.assertNull;
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

import shakhmat.entity.DataEntity;
import shakhmat.repository.impl.DataRepositoryImpl;

public class DataRepositoryTest {

	/** Logger de la classe */
	private static final Logger LOGGER = LogManager.getLogger(DataRepositoryTest.class);

	/**
	 * Classe a tester
	 */
	private static DataRepositoryImpl dataRepo = new DataRepositoryImpl();

	/**
	 * JDD
	 */
	public static DataEntity testOkRuyLopez;
	public static List<DataEntity> testOkRuyLopezList = new ArrayList<>();

	@BeforeAll
	static void setup() {
		LOGGER.info("@BeforeAll - executes once before all test methods in this class");
		
		ReflectionTestUtils.setField(dataRepo, "cheminRepoData", 
	               "D:\\project\\SHAKHMAT\\SHAKHMAT_J\\src\\main\\resources\\data\\");
		
		List<String> listeCoupsRuyLopez = new ArrayList<>();
		listeCoupsRuyLopez.add("e4 e5");
		listeCoupsRuyLopez.add("Cf3 Cc6");
		listeCoupsRuyLopez.add("Fb5 a6");
		testOkRuyLopez = new DataEntity("Ruy Lopez (espagnole)", listeCoupsRuyLopez);
		testOkRuyLopezList.add(testOkRuyLopez);
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
		List<DataEntity> listeOuverture = dataRepo.getAllOuvertures();

		assertEquals(listeOuverture.get(0).getName(), testOkRuyLopezList.get(0).getName());
		assertEquals(listeOuverture.get(0).getCoups().get(0), 
				testOkRuyLopezList.get(0).getCoups().get(0));
		assertEquals(listeOuverture.get(0).getCoups().get(1), 
				testOkRuyLopezList.get(0).getCoups().get(1));
		assertEquals(listeOuverture.get(0).getCoups().get(2), 
				testOkRuyLopezList.get(0).getCoups().get(2));
	}

}
