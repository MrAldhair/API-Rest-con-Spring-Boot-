package api.sales.services;

import org.springframework.beans.factory.annotation.Autowired;
import api.sales.models.Sale;
import api.sales.repository.RepositorySale;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // Se registra como @Service en el contenedor de Spring
public class ServiceSaleImplement implements IServiceSale{

	@Autowired // inyección de dependencias (inyectar un bean en el componente actual)
	private RepositorySale repoSale;

	public ServiceSaleImplement(RepositorySale repoSale) {
		this.repoSale = repoSale;
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Sale> findAll() {
		return repoSale.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Sale findById(Long id) {
		return repoSale.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Sale save(Sale sale) {
		return repoSale.save(sale);
	}

}
