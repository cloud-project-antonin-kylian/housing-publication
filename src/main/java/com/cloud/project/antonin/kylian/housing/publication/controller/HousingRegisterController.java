package com.cloud.project.antonin.kylian.housing.publication.controller;

import com.cloud.project.antonin.kylian.housing.publication.model.HousingRegisterRequestModel;
import com.cloud.project.antonin.kylian.housing.publication.model.HousingResponseModel;
import com.cloud.project.antonin.kylian.housing.publication.usecase.HousingRegisterInputBoundary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HousingRegisterController {
    @Autowired
    private HousingRegisterInputBoundary housingInput;

    @PostMapping("/housings")
    final HousingResponseModel create(@RequestBody final HousingRegisterRequestModel requestModel) {
        return housingInput.execute(requestModel);
    }
}
