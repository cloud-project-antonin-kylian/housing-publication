package com.cloud.project.antonin.kylian.housing.publication.persistence;

import com.cloud.project.antonin.kylian.housing.publication.model.HousingDbResponseModel;

import java.util.List;

public interface HousingFetcherByStatusDbGateway {
    List<HousingDbResponseModel> get(final String status);
}
