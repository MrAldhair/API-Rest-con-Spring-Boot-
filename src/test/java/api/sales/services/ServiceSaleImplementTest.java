package api.sales.services;

import api.sales.DataTest.DataSales;
import api.sales.models.Sale;
import api.sales.repository.RepositorySale;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@DataJpaTest
class ServiceSaleImplementTest {

    @Autowired
    RepositorySale repositorySale;

    //@InjectMocks
    //ServiceSaleImplement serviceSale;

    /*@BeforeEach
    void setUp() {

        repositorySale = mock(RepositorySale.class);
        serviceSale = new ServiceSaleImplement(repositorySale);

    }*/

    @Test
    void save() {
        Sale sale = new Sale(1L,9,1,999.99,"Test sale 1", new Date().toString(), "fulano", "Sucursal 1", "Coahuila", "San Pedro", "Calle San Pedro",2356,27957,"Folio test1");
        repositorySale.save(sale);
        assertNotNull(sale);
        //assertEquals(1L, serviceSale.findById(1L));
        //verify(repositorySale).findById(1L);
        //
    }

    @Test
    void save_failed_sale(){
        Sale sale = new Sale();
        repositorySale.save(sale);
        assertNotNull(sale);
    }

    @Test
    void findAll() {
        assertThat(repositorySale.findAll()).hasSize(2);
    }

    @Test
    void findAll_failed() {
        assertThat(repositorySale.findAll()).hasSize(3);
    }

    @Test
    void findById() {/*
        when(repositorySale.findById(1L)).thenReturn(java.util.Optional.of(DataSales.sale_1));
        when(repositorySale.findById(2L)).thenReturn(java.util.Optional.of(DataSales.sale_2));
        when(repositorySale.findById(3L)).thenReturn(java.util.Optional.of(DataSales.sale_3));

        Sale get_id = repositorySale.findById(DataSales.sale_1.getId_sale());
        Sale get_name_employee = repositorySale.findById(DataSales.sale_2.getId_sale());

        assertEquals(1L, get_id.getId_sale());
        assertEquals("fulano", get_name_employee.getName_employee());*/

        assertThat(repositorySale.findById(5L));

    }



}