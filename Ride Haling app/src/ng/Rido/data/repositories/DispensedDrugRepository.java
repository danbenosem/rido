package ng.Rido.data.repositories;

import java.util.List;

public interface DispensedDrugRepository {

    DispensedDrug save(DispensedDrug dispensedDrug);

    DispensedDrug findById(int id);

    List<DispensedDrug> findAll();

    void update(int id, DispensedDrug updatedDispensedDrug);

    void deleteById(int id);

    void deleteAll();
}