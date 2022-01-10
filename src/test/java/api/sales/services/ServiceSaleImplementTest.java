package api.sales.services;

import api.sales.models.Sale;
import api.sales.repository.RepositorySale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static api.sales.DataTest.DataSales.*;

@SpringBootTest
class ServiceSaleImplementTest {

    RepositorySale repositorySale;
    IServiceSale serviceSale;

    @BeforeEach//Por cada metdo
    void setUp() {
        repositorySale = mock(RepositorySale.class);
        serviceSale = new ServiceSaleImplement(repositorySale);
    }

    @Test
    void findAll() {
        //ArrayList sales = new ArrayList<>();
        when(repositorySale.findAll()).thenReturn(Arrays.asList(sale_1,sale_2,sale_3));
        assertNotNull(serviceSale.findAll());
    }

    @Test
    void findById() {
        //cuando se invoque la venta con el id 1
        when(repositorySale.findById(1L)).thenReturn(java.util.Optional.of(sale_1));
        Sale new_sale = serviceSale.findById(1L);
        assertNotNull(new_sale.getId_sale());
        assertEquals("Fulano",new_sale.getName_employee());
        //verify(repositorySale).findById(1L);
    }

    @Test
    void save() {
        Sale sale = new Sale(3L,9,1,999.99,"Test sale 1", new Date().toString(), "Fulano", "Sucursal 1", "Coahuila", "San Pedro", "Calle San Pedro",2356,27957,"Folio test1");
        when(repositorySale.save(any(Sale.class))).thenReturn(sale);
        //Sale new_sale = serviceSale.save(sale);
        assertNotNull(serviceSale.save(new Sale()));

    }
}