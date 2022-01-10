package api.sales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.sales.models.BranchOffice;
import api.sales.repository.RepositoryBranchOffice;

@Service
public class ServiceBranchOfficeImplement implements IServiceBranchOffice{
	
	@Autowired
	private RepositoryBranchOffice repoBranchOffice;

	public ServiceBranchOfficeImplement(RepositoryBranchOffice repoBranchOffice) {
		this.repoBranchOffice = repoBranchOffice;
	}

	@Override
	@Transactional
	public List<BranchOffice> findAll() {
		return (List<BranchOffice>) repoBranchOffice.findAll();
		
	}

	@Override
	@Transactional
	public BranchOffice findById(Long id) {
		return repoBranchOffice.findById(id).orElse(null);
		
	}

}
