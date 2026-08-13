package ng.Rido.services;

import ng.Rido.data.repositories.DrugRepository;
import ng.Rido.data.repositories.DrugRepositoryImpl;
import ng.Rido.dtos.requests.AddDrugRequest;
import ng.Rido.utils.mappers.DrugMapper;

public class  ChemistServiceImpl implements ChemistService {
    private DrugRepository drugRepository = new DrugRepositoryImpl();


    @Override
    public String addDrug(AddDrugRequest request) {
        if (drugRepository.findById(request.getId())!=null) return "Drug exists";

        Drug drug = DrugMapper.addDrugMapper(request);
        drugRepository.save(drug);
        return "addition successful";

    }
}
