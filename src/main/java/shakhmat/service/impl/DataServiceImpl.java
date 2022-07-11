package shakhmat.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import shakhmat.repository.DataRepository;
import shakhmat.service.DataService;

@Service
public class DataServiceImpl implements DataService {

  private DataRepository dataRepository;

  public DataServiceImpl(DataRepository dataRepository) {
    this.dataRepository = dataRepository;
  }

  @Override
  public List<String> getOuvertures() {
    try {
      return dataRepository.getAllOuverturesNames();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

}
