package api.sales.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import api.sales.models.Sale;
import api.sales.repository.RepositorySale;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceSaleImplement implements IServiceSale{
	
	@Autowired
	private RepositorySale repoSale;

	@Override
	@Transactional(readOnly = true)
	public List<Sale> findAll() {
		
		return (List<Sale>) repoSale.findAll();
	}

	@Override
	@Transactional
	public Sale save(Sale sale) {		
		return repoSale.save(sale);
	}

}
