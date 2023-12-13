package com.cloud.project.antonin.kylian.housing.publication.controller;

import com.cloud.project.antonin.kylian.housing.publication.model.HousingResponseModel;
import com.cloud.project.antonin.kylian.housing.publication.usecase.HousingFetcherByStatusInputBoundary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HousingFetcherByStatusController {
    @Autowired
    private HousingFetcherByStatusInputBoundary housingInput;

    @GetMapping("/housings")
    final List<HousingResponseModel> read(@RequestParam(name = "status") final String status) {
        return housingInput.execute(status);
    }
}
