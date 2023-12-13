package com.cloud.project.antonin.kylian.housing.publication.usecase;

import com.cloud.project.antonin.kylian.housing.publication.model.HousingResponseModel;

import java.util.List;

public interface HousingFetcherByStatusInputBoundary {
    List<HousingResponseModel> execute(final String status);
}
