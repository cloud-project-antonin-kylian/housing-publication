package com.cloud.project.antonin.kylian.housing.publication.usecase;

import com.cloud.project.antonin.kylian.housing.publication.entity.Housing;
import com.cloud.project.antonin.kylian.housing.publication.entity.HousingFactory;
import com.cloud.project.antonin.kylian.housing.publication.model.HousingDbRequestModel;
import com.cloud.project.antonin.kylian.housing.publication.model.HousingDbResponseModel;
import com.cloud.project.antonin.kylian.housing.publication.model.HousingResponseModel;
import com.cloud.project.antonin.kylian.housing.publication.model.HousingValidatorRequestModel;
import com.cloud.project.antonin.kylian.housing.publication.persistence.HousingValidatorDbGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HousingValidatorUseCase implements HousingValidatorInputBoundary {
    @Autowired
    private HousingFactory housingFactory;

    @Autowired
    private HousingValidatorDbGateway housingDbGateway;

    @Override
    public HousingResponseModel execute(final Long housingId, final HousingValidatorRequestModel requestModel) {
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
                requestModel.status()
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

        final HousingDbResponseModel housingDbResponseModel = housingDbGateway.update(housingId, housingDbRequestModel);

        return new HousingResponseModel(
                housingDbResponseModel.id(),
                housingDbResponseModel.title(),
                housingDbResponseModel.description(),
                housingDbResponseModel.price(),
                housingDbResponseModel.size(),
                housingDbResponseModel.nbBedrooms(),
                housingDbResponseModel.city(),
                housingDbResponseModel.type(),
                housingDbResponseModel.owner(),
                housingDbResponseModel.equipments(),
                housingDbResponseModel.status()
        );
    }
}
