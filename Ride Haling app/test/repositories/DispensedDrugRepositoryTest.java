package repositories;

import ng.Rido.data.repositories.DispensedDrugRepository;
import ng.Rido.data.repositories.DispensedDrugRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DispensedDrugRepositoryTest {

    private DispensedDrugRepository repository;
    private DispensedDrug dispensedDrug;

    @BeforeEach
    public void setUp() {
        repository = new DispensedDrugRepositoryImpl();

        Drug drug = new Drug("Paracetamol", 500, 100);

        dispensedDrug = new DispensedDrug(drug, 2);
    }

    @Test
    public void testThatDispensedDrugCanBeSaved() {
        DispensedDrug saved = repository.save(dispensedDrug);

        assertEquals(1, saved.getId());
    }

    @Test
    public void testThatDispensedDrugCanBeFoundById() {
        repository.save(dispensedDrug);

        assertEquals(dispensedDrug, repository.findById(1));
    }

    @Test
    public void testThatAllDispensedDrugsCanBeFound() {
        repository.save(dispensedDrug);

        Drug drug2 = new Drug("Septrin", 800, 50);
        DispensedDrug dispensedDrug2 = new DispensedDrug(drug2, 1);

        repository.save(dispensedDrug2);

        assertEquals(2, repository.findAll().size());
    }

    @Test
    public void testThatDispensedDrugCanBeUpdated() {
        repository.save(dispensedDrug);

        Drug newDrug = new Drug("Ibuprofen", 700, 50);
        DispensedDrug updated = new DispensedDrug(newDrug, 3);

        repository.update(1, updated);

        assertEquals(1, updated.getId());
    }
}