package shakhmat.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

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
    void should_open_ouverture() throws StreamReadException, DatabindException, IOException {
      //GIVEN
      final String ruyLopez = RUY_LOPEZ;
      final String ouverture2 = OUVERTURE_TEST;

      //WHEN
      List<String> ouvertureNames = dataRepository.getAllOuverturesNames();

      //THEN
      assertTrue(ouvertureNames.contains(ruyLopez));
    }

  }

}
