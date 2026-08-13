package repositories;

import ng.Rido.data.repositories.DrugRepository;
import ng.Rido.data.repositories.DrugRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrugRepositoryTest {

    private DrugRepository drugRepository;
    private Drug drug;

    @BeforeEach
    public void setUp() {
        drugRepository = new DrugRepositoryImpl();
        drug = new Drug("Paracetamol", 500, 100);
    }

    @Test
    public void testThatDrugCanBeSaved() {
        Drug savedDrug = drugRepository.save(drug);
        assertEquals(1, savedDrug.getId());
    }

    @Test
    public void testThatDrugCanBeFoundByDrugName() {
        drugRepository.save(drug);

        Drug savedDrug = drugRepository.findByDrugName("Paracetamol");

        assertEquals("Paracetamol", savedDrug.getName());
    }

    @Test
    public void testThatDrugCanBeFoundById() {
        drugRepository.save(drug);

        assertEquals(drug, drugRepository.findById(1));

        Drug drug2 = new Drug("Septrin", 800, 50);
        drugRepository.save(drug2);

        assertEquals(drug2, drugRepository.findById(2));
    }

    @Test
    public void testThatAllSavedDrugsCanBeFound() {
        drugRepository.save(drug);

        Drug drug2 = new Drug("Septrin", 800, 50);
        drugRepository.save(drug2);

        assertEquals(2, drugRepository.findAll().size());
    }

    @Test
    public void testThatDrugCanBeUpdated() {
        Drug firstDrug = drugRepository.save(drug);

        Drug secondDrug = new Drug("Ibuprofen", 700, 80);

        drugRepository.update(firstDrug.getId(), secondDrug);

        assertEquals(firstDrug.getId(), secondDrug.getId());
    }
}