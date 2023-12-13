package com.cloud.project.antonin.kylian.housing.publication.persistence;

import com.cloud.project.antonin.kylian.housing.publication.model.HousingDbRequestModel;

public interface HousingRegisterDbGateway {
    void save(final HousingDbRequestModel housingDbRequestModel);
}
