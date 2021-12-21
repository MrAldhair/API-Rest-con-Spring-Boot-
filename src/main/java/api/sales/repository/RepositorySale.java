package api.sales.repository;

import org.springframework.data.repository.CrudRepository;

import api.sales.models.Sale;

public interface RepositorySale extends CrudRepository<Sale,Long>{}
