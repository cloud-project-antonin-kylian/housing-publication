package com.cloud.project.antonin.kylian.housing.publication.usecase;

import com.cloud.project.antonin.kylian.housing.publication.model.HousingRegisterRequestModel;
import com.cloud.project.antonin.kylian.housing.publication.model.HousingResponseModel;

public interface HousingRegisterInputBoundary {
    HousingResponseModel execute(final HousingRegisterRequestModel RequestModel);
}
