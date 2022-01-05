package api.sales.services;

import api.sales.models.Sale;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceSale {
	
	public List<Sale> findAll();

	public Sale findById(Long id);

	public Sale save(Sale sale);

}
