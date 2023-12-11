package com.cloud.project.antonin.kylian.housing.publication.usecase;

import com.cloud.project.antonin.kylian.housing.publication.model.HousingDbResponseModel;
import com.cloud.project.antonin.kylian.housing.publication.model.HousingResponseModel;
import com.cloud.project.antonin.kylian.housing.publication.persistence.HousingFetcherByStatusDbGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class HousingFetcherByStatusUseCase implements HousingFetcherByStatusInputBoundary {
    @Autowired
    private HousingFetcherByStatusDbGateway housingDbGateway;

    @Override
    public List<HousingResponseModel> execute(final String status) {
        final List<HousingDbResponseModel> housingDbResponseModels = housingDbGateway.get(status);
        if (housingDbResponseModels == null) {
            return null;
        }

        List<HousingResponseModel> responseModels = new ArrayList<>();
        for (HousingDbResponseModel housingDbResponseModel : housingDbResponseModels) {
            final HousingResponseModel responseModel = new HousingResponseModel(
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
            responseModels.add(responseModel);
        }

        return responseModels;
    }
}
