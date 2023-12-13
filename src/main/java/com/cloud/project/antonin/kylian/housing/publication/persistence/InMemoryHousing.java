package com.cloud.project.antonin.kylian.housing.publication.persistence;

import com.cloud.project.antonin.kylian.housing.publication.entity.*;
import com.cloud.project.antonin.kylian.housing.publication.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InMemoryHousing implements HousingRegisterDbGateway, HousingFetcherByStatusDbGateway, HousingValidatorDbGateway {
    @Autowired
    private InMemoryHousingRepository housingRepository;

    @Override
    public List<HousingDbResponseModel> get(final String status) {
        List<HousingDataMapper> housingDataMappers = housingRepository.getByStatus(status);
        List<HousingDbResponseModel> responseModels = new ArrayList<>();

        for (HousingDataMapper housingDataMapper : housingDataMappers) {
            final HousingDbResponseModel responseModel = generateDbRespFromDataMapper(housingDataMapper);
            responseModels.add(responseModel);
        }

        return responseModels;
    }

    @Override
    public void save(final HousingDbRequestModel housingDbRequestModel) {
        final HousingDataMapper housingDataMapper = generateDataMapperFromDbReq(housingDbRequestModel);
        housingRepository.save(housingDataMapper);
    }

    @Override
    public HousingDbResponseModel update(final Long housingId, final HousingDbRequestModel housingDbRequestModel) {
        HousingDbResponseModel responseModel = null;

        final Optional<HousingDataMapper> dbResp = housingRepository.findById(housingId);
        if (dbResp.isPresent()) {
            final HousingDataMapper housingDataMapper = dbResp.get();
            housingDataMapper.setStatus(housingDbRequestModel.status());
            housingRepository.save(housingDataMapper);
            responseModel = generateDbRespFromDataMapper(housingDataMapper);
        }

        return responseModel;
    }

    private HousingDbResponseModel generateDbRespFromDataMapper(final HousingDataMapper housingDataMapper) {
        final Area area = new Area(housingDataMapper.getCity().getArea().getId(), housingDataMapper.getCity().getArea().getName());
        final City city = new City(housingDataMapper.getCity().getId(), housingDataMapper.getCity().getName(), area);
        final Type type = new Type(housingDataMapper.getType().getId(), housingDataMapper.getType().getName());
        final Owner owner = new Owner(housingDataMapper.getOwner().getId(), housingDataMapper.getOwner().getName());
        final Set<Equipment> equipments = new HashSet<>();
        for (EquipmentDataMapper equipment : housingDataMapper.getEquipments()) {
            equipments.add(new Equipment(equipment.getId(), equipment.getName()));
        }

        return new HousingDbResponseModel(
                housingDataMapper.getId(),
                housingDataMapper.getTitle(),
                housingDataMapper.getDescription(),
                housingDataMapper.getPrice(),
                housingDataMapper.getSize(),
                housingDataMapper.getNbBedrooms(),
                city,
                type,
                owner,
                equipments,
                housingDataMapper.getStatus()
        );
    }

    private HousingDataMapper generateDataMapperFromDbReq(final HousingDbRequestModel dbReq) {
        final AreaDataMapper areaDataMapper = new AreaDataMapper(dbReq.city().area().id(), dbReq.city().area().name());
        final CityDataMapper cityDataMapper = new CityDataMapper(dbReq.city().id(), dbReq.city().name(), areaDataMapper);
        final TypeDataMapper typeDataMapper = new TypeDataMapper(dbReq.type().id(), dbReq.type().name());
        final OwnerDataMapper ownerDataMapper = new OwnerDataMapper(dbReq.owner().id(), dbReq.owner().name());
        final Set<EquipmentDataMapper> equipmentDataMapperSet = new HashSet<>();
        for (Equipment equipment : dbReq.equipments()) {
            equipmentDataMapperSet.add(new EquipmentDataMapper(equipment.id(), equipment.name()));
        }
        return new HousingDataMapper(
                dbReq.id(),
                dbReq.title(),
                dbReq.description(),
                dbReq.price(),
                dbReq.size(),
                dbReq.nbBedrooms(),
                cityDataMapper,
                typeDataMapper,
                ownerDataMapper,
                equipmentDataMapperSet,
                dbReq.status());
    }
}
