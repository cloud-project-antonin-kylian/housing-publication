package com.cloud.project.antonin.kylian.housing.publication.usecase;

import com.cloud.project.antonin.kylian.housing.publication.model.HousingResponseModel;
import com.cloud.project.antonin.kylian.housing.publication.model.HousingValidatorRequestModel;

public interface HousingValidatorInputBoundary {
    HousingResponseModel execute(final Long housingId, final HousingValidatorRequestModel requestModel);
}
