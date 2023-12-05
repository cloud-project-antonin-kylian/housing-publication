    package com.cloud.project.antonin.kylian.housing.publication.controller;

    import com.cloud.project.antonin.kylian.housing.publication.model.HousingResponseModel;
    import com.cloud.project.antonin.kylian.housing.publication.model.HousingValidatorRequestModel;
    import com.cloud.project.antonin.kylian.housing.publication.usecase.HousingValidatorInputBoundary;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PutMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class HousingValidatorController {
        @Autowired
        private HousingValidatorInputBoundary housingInput;

        @PutMapping("/housings/{id}")
        public HousingResponseModel update(@PathVariable("id") final Long housingId, @RequestBody final HousingValidatorRequestModel requestModel) {
            return housingInput.execute(housingId, requestModel);
        }
    }
