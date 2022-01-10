package api.sales.controllers;

import api.sales.DataTest.DataSales;
import api.sales.models.Sale;
import api.sales.repository.RepositorySale;
import api.sales.services.IServiceSale;
import api.sales.services.ServiceSaleImplement;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static api.sales.DataTest.DataSales.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

//@WebMvcTest no funciono el contexto de esta anotacion para los test que realice
@SpringBootTest
@AutoConfigureMockMvc
class SaleControllerTest {

    @Autowired
    private MockMvc mockMvc; //contexto simulador de toda la parte web
    @MockBean
    private IServiceSale serviceSale;
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void create() throws Exception {
        //Given that
        when(serviceSale.save(sale_1)).thenReturn(sale_1);
        //when

        mockMvc.perform(MockMvcRequestBuilders.post("/crear").contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(sale_1)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
                //.andExpect(jsonPath("$.name_employee").value("Fulano"))
                //.andExpect(jsonPath("$.['name_employee']").value("Fulano"));
    }

    @Test
    void mostrar() throws Exception {
        //Given that
        List<Sale> sales = Arrays.asList(sale_1,sale_2,sale_3);
        when(serviceSale.findAll()).thenReturn(sales);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/listar").contentType(MediaType.APPLICATION_JSON))
        //Then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name_employee").value("Fulano"))
                .andExpect(jsonPath("$[1].name_employee").value("Fulana"))
                .andExpect(jsonPath("$[2].name_employee").value("Mangana"));
                //.andExpect(content().json(objectMapper.))

    }

    @Test
    void mostrarPorId() throws Exception{
        //Sale sale = new Sale(1L,9,1,999.99,"Test sale 1", new Date().toString(), "fulano", "Sucursal 1", "Coahuila", "San Pedro", "Calle San Pedro",2356,27957,"Folio test1");
        //Given that
        when(serviceSale.findById(1L)).thenReturn(sale_1);
        //When: llamada a la controlador mediante la ruta
        mockMvc.perform(MockMvcRequestBuilders.get("/listar/1").contentType(MediaType.APPLICATION_JSON))
                //Then: los resultados esperados
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name_employee").value("Fulano"))
                .andExpect(jsonPath("$.name_branch_office").value("Sucursal 1"));

    }

}
