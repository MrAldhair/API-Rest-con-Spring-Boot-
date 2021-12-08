package api.sales.services;

import java.util.List;
import api.sales.models.Sale;

public interface IServiceSale {
	
	public List<Sale> findAll();
	
	public Sale save(Sale sale);

}
