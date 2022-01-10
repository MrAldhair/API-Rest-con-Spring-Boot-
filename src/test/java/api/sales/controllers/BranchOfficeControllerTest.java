package api.sales.controllers;

import api.sales.models.BranchOffice;
import api.sales.services.IServiceBranchOffice;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Arrays;
import java.util.List;

import static api.sales.DataTest.DataSales.sale_1;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static api.sales.DataTest.DataBranchOffices.*;

@SpringBootTest
@AutoConfigureMockMvc
class BranchOfficeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IServiceBranchOffice serviceBranchOffice;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void listar() throws Exception{
        //Given that
        List<BranchOffice> branchOffices = Arrays.asList(branchOffice_1,branchOffice_2);
        when(serviceBranchOffice.findAll()).thenReturn(branchOffices);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/ListBranchOffice").contentType(MediaType.APPLICATION_JSON))
                //Then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Sucursal 1"))
                .andExpect(jsonPath("$[1].state").value("Queretaro"));
        //.andExpect(content().json(objectMapper.))


    }

    @Test
    void ver() throws Exception{

        when(serviceBranchOffice.findById(2L)).thenReturn(branchOffice_2);
        //When: llamada a la controlador mediante la ruta
        mockMvc.perform(MockMvcRequestBuilders.get("/ListBranchOffice/2").contentType(MediaType.APPLICATION_JSON))
                //Then: los resultados esperados
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Sucursal 2"));
                //.andExpect(jsonPath("$.name_branch_office").value("Sucursal 1"));

    }
}