package services;
import java.time.LocalDate;

import ng.Rido.data.repositories.DrugRepository;
import ng.Rido.data.repositories.DrugRepositoryImpl;
import ng.Rido.dtos.requests.AddDrugRequest;
import ng.Rido.services.ChemistService;
import ng.Rido.services.ChemistServiceImpl;
import ng.Rido.utils.mappers.DrugMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChemistServiceTest {

    private DrugRepository drugRepository =  new DrugRepositoryImpl();


    @Test
    public void testThatChemistCanAddDrug(){

        ChemistService addedDrug = new ChemistServiceImpl();
        AddDrugRequest request = new AddDrugRequest();

        request.setBrand("emzor");
        request.setName("paracetamol");
        request.setQuantity(10);
        request.setExpiryDate(LocalDate.of(2027,12,1));

        Drug drug= DrugMapper.addDrugMapper(request);
        drugRepository.save(drug);
        assertEquals()







    }
}
