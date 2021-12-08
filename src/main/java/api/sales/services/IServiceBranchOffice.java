package api.sales.services;

import java.util.List;

import api.sales.models.BranchOffice;

public interface IServiceBranchOffice {
	
	public List<BranchOffice> findAll();
	
	public BranchOffice findById(Long id);

}
