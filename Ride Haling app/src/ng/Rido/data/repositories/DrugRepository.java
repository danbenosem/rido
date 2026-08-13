package ng.Rido.data.repositories;

import java.util.List;

public interface DrugRepository {

    Drug save(Drug drug);

    Drug findByDrugName(String drugName);

    Drug findByBrand(String brandname);

    Drug findById(int id);

    List<Drug> findAll();

    void update(int id, Drug updatedDrug);

    void deleteById(int id);

    void deleteAll();
}