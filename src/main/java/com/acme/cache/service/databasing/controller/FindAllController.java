package com.acme.cache.service.databasing.controller;

import com.acme.cache.service.databasing.dao.BuildingJdbcDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class FindAllController {

    private final BuildingJdbcDao buildingJdbcDao;

    public FindAllController(BuildingJdbcDao buildingJdbcDao) {
        this.buildingJdbcDao = buildingJdbcDao;
    }

    @GetMapping(value = "/db/list-buildings-row-mapper")
        public ModelAndView getAllBuildings() throws IOException {
            ModelAndView modelAndView = new ModelAndView("buildings-list");
            modelAndView.addObject("buildingsList", buildingJdbcDao.getAll());
            return modelAndView;
    }

    @GetMapping(value = "/db/list-buildings-bean-property")
    public ModelAndView getAllBuildingsWithBeanRowMapper() throws IOException {
        ModelAndView modelAndView = new ModelAndView("buildings-list");
        modelAndView.addObject("buildingsList", buildingJdbcDao.getAll());
        return modelAndView;
    }
}
