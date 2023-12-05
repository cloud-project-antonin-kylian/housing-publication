package com.cloud.project.antonin.kylian.housing.publication.usecase;

import com.cloud.project.antonin.kylian.housing.publication.entity.Housing;
import com.cloud.project.antonin.kylian.housing.publication.entity.HousingFactory;
import com.cloud.project.antonin.kylian.housing.publication.model.HousingDbRequestModel;
import com.cloud.project.antonin.kylian.housing.publication.model.HousingRegisterRequestModel;
import com.cloud.project.antonin.kylian.housing.publication.model.HousingResponseModel;
import com.cloud.project.antonin.kylian.housing.publication.persistence.HousingRegisterDbGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HousingRegisterUseCase implements HousingRegisterInputBoundary {
    @Autowired
    private HousingFactory housingFactory;

    @Autowired
    private HousingRegisterDbGateway housingDbGateway;

    @Override
    public HousingResponseModel execute(HousingRegisterRequestModel requestModel) {
        final Housing housing = housingFactory.create(
                requestModel.id(),
                requestModel.title(),
                requestModel.description(),
                requestModel.price(),
                requestModel.size(),
                requestModel.nbBedrooms(),
                requestModel.city(),
                requestModel.type(),
                requestModel.owner(),
                requestModel.equipments(),
                "WAITING"
        );

        final HousingDbRequestModel housingDbRequestModel = new HousingDbRequestModel(
                housing.id(),
                housing.title(),
                housing.description(),
                housing.price(),
                housing.size(),
                housing.nbBedrooms(),
                housing.city(),
                housing.type(),
                housing.owner(),
                housing.equipments(),
                housing.status()
        );

        housingDbGateway.save(housingDbRequestModel);

        return new HousingResponseModel(
                housing.id(),
                housing.title(),
                housing.description(),
                housing.price(),
                housing.size(),
                housing.nbBedrooms(),
                housing.city(),
                housing.type(),
                housing.owner(),
                housing.equipments(),
                housing.status()
        );
    }
}
