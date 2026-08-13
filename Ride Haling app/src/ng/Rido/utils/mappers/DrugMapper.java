package ng.Rido.utils.mappers;

import ng.Rido.dtos.requests.AddDrugRequest;

public class DrugMapper {

    public static Drug addDrugMapper(AddDrugRequest request){

        Drug drug = new Drug(request.getName(),request.getQuantity(), request.getPrice(), request.getBrand());
        return drug;
    }
}
