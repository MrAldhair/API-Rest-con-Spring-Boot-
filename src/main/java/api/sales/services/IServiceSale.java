package api.sales.services;

import api.sales.models.Sale;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface IServiceSale {
	
	public Iterable<Sale> findAll();

	public Sale findById(Long id);

	public Sale save(Sale sale);

}
