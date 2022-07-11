package shakhmat.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = DataRepository.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = SpringJUnitConfig.class)
public class DataRepositoryTest {

  /** Logger de la classe */
  //private static final Logger LOGGER = LogManager.getLogger(DataRepositoryTest.class);

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
