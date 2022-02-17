package com.acme.cache.service.databasing.generator;


import com.acme.cache.service.databasing.model.Building;
import com.acme.cache.service.databasing.dao.BuildingDao;
import org.springframework.web.bind.annotation.*;

@RestController
public class DatabaseFiller {

    private final RandomBuildingGenerator randomBuildingGenerator;

    private final BuildingDao buildingDao;

    public DatabaseFiller(RandomBuildingGenerator randomBuildingGenerator, BuildingDao buildingDao) {
        this.randomBuildingGenerator = randomBuildingGenerator;
        this.buildingDao = buildingDao;
    }

    @RequestMapping(value = "/fill/", method = RequestMethod.GET, params = "quantity")
    public String populateDatabaseWithRandomData(@RequestParam("quantity") int quantity){
        for (int i = 0; i < quantity; i++){
            Building building = randomBuildingGenerator.generateRandomBuilding();
            buildingDao.save(building);
        }
        return "Database filled with random data containing: " + quantity + " buildings";
    }
}
