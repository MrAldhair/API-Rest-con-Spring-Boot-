package api.sales.services;

import static api.sales.DataTest.DataBranchOffices.*;

import api.sales.models.BranchOffice;
import api.sales.models.Sale;
import api.sales.repository.RepositoryBranchOffice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static api.sales.DataTest.DataSales.sale_1;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ServiceBranchOfficeImplementTest {

    RepositoryBranchOffice repoBranchOffice;
    IServiceBranchOffice serviceBranchOffice;

    @BeforeEach
    void setUp() {
        repoBranchOffice = mock(RepositoryBranchOffice.class);
        serviceBranchOffice = new ServiceBranchOfficeImplement(repoBranchOffice);
    }


    @Test
    void findAll() {
        when(repoBranchOffice.findAll()).thenReturn(Arrays.asList(branchOffice_1,branchOffice_2));
        assertNotNull(serviceBranchOffice.findAll());
    }

    @Test
    void findById() {
        when(repoBranchOffice.findById(2L)).thenReturn(java.util.Optional.of(branchOffice_2));
        BranchOffice new_branch_office = serviceBranchOffice.findById(2L);
        assertNotNull(new_branch_office.getId_branch_office());
        assertEquals("Sucursal 2",new_branch_office.getName());
    }
}