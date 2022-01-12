package api.sales.repository;

import org.springframework.data.repository.CrudRepository;
import api.sales.models.BranchOffice;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBranchOffice extends CrudRepository<BranchOffice, Long>{

}
