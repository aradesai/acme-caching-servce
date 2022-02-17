package com.acme.cache.service.caching.pojo;


import com.acme.cache.service.caching.model.DevEntityV2;
import com.acme.cache.service.caching.model.DevFormModelV2;
import org.springframework.stereotype.Service;

@Service
public class DevConverterV2 {


    public DevEntityV2 convertFormToEntity(DevFormModelV2 devFormModel){
        return new DevEntityV2(
                devFormModel.getFirstName(),
                devFormModel.getLastName(),
                devFormModel.getSalary(),
                devFormModel.getGender(),
                devFormModel.getKnownLanguages()
        );
    }

    public DevFormModelV2 convertEntityToForm(DevEntityV2 devEntity){
        return new DevFormModelV2(
                devEntity.getId(),
                devEntity.getFirstName(),
                devEntity.getLastName(),
                devEntity.getSalary(),
                devEntity.getGender(),
                devEntity.getKnownLanguages()
        );
    }
}
