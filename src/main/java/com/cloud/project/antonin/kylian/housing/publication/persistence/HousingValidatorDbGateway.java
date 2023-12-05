package com.cloud.project.antonin.kylian.housing.publication.persistence;

import com.cloud.project.antonin.kylian.housing.publication.model.HousingDbRequestModel;
import com.cloud.project.antonin.kylian.housing.publication.model.HousingDbResponseModel;

public interface HousingValidatorDbGateway {
    HousingDbResponseModel update(final Long housingId, final HousingDbRequestModel housingDbRequestModel);
}
