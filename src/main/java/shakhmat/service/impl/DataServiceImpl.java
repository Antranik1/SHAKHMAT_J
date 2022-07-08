package shakhmat.service.impl;

import java.util.List;

import shakhmat.repository.DataRepository;
import shakhmat.service.DataService;

public class DataServiceImpl implements DataService {
	
	private DataRepository dataRepository;

	@Override
	public List<String> getOuvertures() {
		return dataRepository.getOuvertures();
	}

}
