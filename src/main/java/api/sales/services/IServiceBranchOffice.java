package api.sales.services;

import java.util.List;

import api.sales.models.BranchOffice;

public interface IServiceBranchOffice {
	
	List<BranchOffice> findAll();
	
	BranchOffice findById(Long id);

}
