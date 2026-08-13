package ng.Rido.data.repositories;

import java.util.ArrayList;
import java.util.List;

public class DispensedDrugRepositoryImpl implements DispensedDrugRepository {

    private int count = 0;
    private List<DispensedDrug> dispensedDrugs = new ArrayList<>();

    @Override
    public DispensedDrug save(DispensedDrug dispensedDrug) {
        if (findById(dispensedDrug.getId()) == null) {
            dispensedDrug.setId(++count);
            dispensedDrugs.add(dispensedDrug);
            return dispensedDrug;
        }
        return null;
    }

    @Override
    public DispensedDrug findById(int id) {
        for (DispensedDrug dispensedDrug : dispensedDrugs) {
            if (dispensedDrug.getId() == id) {
                return dispensedDrug;
            }
        }
        return null;
    }

    @Override
    public List<DispensedDrug> findAll() {
        return new ArrayList<>(dispensedDrugs);
    }

    @Override
    public void update(int id, DispensedDrug updatedDispensedDrug) {
        updatedDispensedDrug.setId(id);

        for (int index = 0; index < dispensedDrugs.size(); index++) {
            if (dispensedDrugs.get(index).getId() == id) {
                dispensedDrugs.set(index, updatedDispensedDrug);
                return;
            }
        }
    }

    @Override
    public void deleteById(int id) {
        DispensedDrug dispensedDrug = findById(id);

        if (dispensedDrug != null) {
            dispensedDrugs.remove(dispensedDrug);
        }
    }

    @Override
    public void deleteAll() {
        dispensedDrugs.clear();
    }
}