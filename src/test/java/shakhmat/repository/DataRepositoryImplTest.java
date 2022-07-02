package shakhmat.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import shakhmat.repository.impl.DataRepositoryImpl;

@SpringBootTest(classes = DataRepositoryImpl.class)
class DataRepositoryImplTest {

  private static final String RUY_LOPEZ = "ruyLopez";

  private static final String OUVERTURE_TEST = "ouverture2";

  @Autowired
  DataRepository dataRepository;

  @Nested
  class readOuvertureFile {

    @Test
    void should_open_ouverture() {
      //GIVEN
      final String RuyLopezPath = getClass().getResource("/shakhmat/data/ok/ruyLopez.json").toString();

      //WHEN

      //THEN
      assertTrue(true);
    }

  }

}
