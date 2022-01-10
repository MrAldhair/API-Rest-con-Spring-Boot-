package api.sales.repository;

import api.sales.models.BranchOffice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RepositoryBranchOfficeTest {

    @Autowired
    RepositoryBranchOffice repositoryBranchOffice;

    @Test
    void findAll(){
        assertThat(repositoryBranchOffice.findAll()).hasSize(2);
    }

    @Test
    void findById(){
        Optional<BranchOffice> branchOffice = repositoryBranchOffice.findById(1L);
        assertTrue(branchOffice.isPresent());
        assertEquals("Sucursal 1",branchOffice.get().getName());

    }

}