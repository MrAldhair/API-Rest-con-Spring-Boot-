package api.sales.repository;

import api.sales.models.Sale;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataAccessException;

import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

// Habilita el contenido de persistencia, db, repos, interfaces etc...
@DataJpaTest
class RepositorySaleTest {

    //@MockBean activa esta notaacion para hacer funcionar el test findAll_failed
    @Autowired
    RepositorySale repositorySale;


    @Test
    void findAll() {
        assertThat(repositorySale.findAll()).hasSize(2);

    }
/*
    @Test
    void findAll_failed() { //@MockBean activa esta notaacion para hacer funcionar el test en el repo
        when(repositorySale.findAll()).thenReturn(new ArrayList<>());
        assertThat(repositorySale.findAll()).isEmpty();
        //verify(repositorySale, times(1)).findAll();
        //assertThat(repositorySale.findAll()).hasSizeGreaterThan(3);
    }
*/
    @Test
    void findById() {
        Optional<Sale> sale = repositorySale.findById(2L);
        assertTrue(sale.isPresent());
        assertEquals("fulano",sale.get().getName_employee());
        /*if (sale.isPresent()) {
            assertEquals(2L, sale.get().getId_sale());
            assertEquals("fulano",sale.get().getName_employee());
        }*/

    }

    @Test
    void findById_failed() {
        Optional<Sale> sale = repositorySale.findById(3L);
        assertThrows(NoSuchElementException.class, () ->{
            sale.orElseThrow();
        });
        assertFalse(sale.isPresent());

    }

    @Test
    void save() {
        Sale sale = new Sale(3L,9,1,999.99,"Test sale 1", new Date().toString(), "fulano", "Sucursal 1", "Coahuila", "San Pedro", "Calle San Pedro",2356,27957,"Folio test1");
        repositorySale.save(sale);
        assertNotNull(sale);
        assertThat(repositorySale.findAll()).hasSize(3);
    }

    @Test
    void save_failed(){
        Sale sale = null;
        try {
            repositorySale.save(sale);
        } catch (DataAccessException e){
            System.out.println(e.getMostSpecificCause().getMessage());
        }
        assertNull(sale);
        assertThat(repositorySale.findAll()).hasSize(2);
    }

}