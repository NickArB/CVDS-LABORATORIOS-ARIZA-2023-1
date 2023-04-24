package edu.eci.cvds.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eci.cvds.model.ConfTable;
import edu.eci.cvds.repository.ConfTableRepository;

@Service
public class ConfService {

	private final ConfTableRepository ConfTableRepository;

	@Autowired
	public ConfService(ConfTableRepository ConfTableRepository) {
		this.ConfTableRepository = ConfTableRepository;
	}

	public ConfTable addConfTable(ConfTable ConfTable) {
		return ConfTableRepository.save(ConfTable);
	}

	public ConfTable getConfTable(String prop) {
		return ConfTableRepository.findById(prop).get();
	}

	public List<ConfTable> getAllConfTables() {
		return ConfTableRepository.findAll();
	}

	public ConfTable updateConfTable(ConfTable ConfTable) {
		if (ConfTableRepository.existsById(ConfTable.getConfTableId())) {
			return ConfTableRepository.save(ConfTable);
		}

		return null;
	}

	public void deleteConfTable(String ConfTableId) {
		ConfTableRepository.deleteById(ConfTableId);
	}
}