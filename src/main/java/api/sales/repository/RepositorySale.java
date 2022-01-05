package api.sales.repository;

import api.sales.models.Sale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Acceder a la base de datos y realizar operaciones practicamente (DAO, Data Access Object)
@Repository
public interface RepositorySale extends CrudRepository<Sale,Long> {

}
