package ng.Rido.data.repositories;

import java.util.ArrayList;
import java.util.List;

public class DrugRepositoryImpl implements DrugRepository {

    private static int count = 0;
    private static List<Drug> drugs = new ArrayList<>();

    @Override
    public Drug save(Drug drug) {
        if (findByDrugName(drug.getName()) == null) {
            drug.setId(++count);
            drugs.add(drug);
            return drug;
        }
        return null;
    }

    @Override
    public Drug findByDrugName(String drugName) {
        for (Drug drug : drugs) {
            if (drug.getName().equals(drugName)) {
                return drug;
            }
        }
        return null;
    }

    @Override
    public Drug findByBrand(String brand) {
        for (Drug drug : drugs) {
            if (drug.getBrand().equals(brand)) {
                return drug;
            }
        }
        return null;

    }

    @Override
    public Drug findById(int id) {
        for (Drug drug : drugs) {
            if (drug.getId() == id) {
                return drug;
            }
        }
        return null;
    }

    @Override
    public List<Drug> findAll() {
        return new ArrayList<>(drugs);
    }

    @Override
    public void update(int id, Drug updatedDrug) {
        updatedDrug.setId(id);

        for (int i = 0; i < drugs.size(); i++) {
            if (drugs.get(i).getId() == id) {
                drugs.set(i, updatedDrug);
                return;
            }
        }
    }

    @Override
    public void deleteById(int id) {
        Drug drug = findById(id);
        if (drug != null) {
            drugs.remove(drug);
        }
    }

    @Override
    public void deleteAll() {
        drugs.clear();
    }
}