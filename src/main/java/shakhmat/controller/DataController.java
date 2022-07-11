package shakhmat.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shakhmat.service.DataService;

@RestController
@RequestMapping(path = "/data")
public class DataController {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  private final DataService dataService;

  public DataController(DataService dataService) {
    this.dataService = dataService;
  }

  @GetMapping("/ouvertureNames")
  public ResponseEntity<List<String>> getOuverturesNames() {

    final List<String> ouvertureNames = dataService.getOuvertures();
    logger.info("ouvertureNames retrieved : {}", ouvertureNames);
    return new ResponseEntity<>(ouvertureNames, HttpStatus.OK);
  }

}
