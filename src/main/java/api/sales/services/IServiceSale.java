package api.sales.services;

import api.sales.models.Sale;
import java.util.List;

public interface IServiceSale {
	
	List<Sale> findAll();

	Sale findById(Long id);

	Sale save(Sale sale);

}
