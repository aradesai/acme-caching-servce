package com.acme.cache.service.caching.api.controller;

import com.acme.cache.service.caching.dal.DeveloperDaoV2;
import com.acme.cache.service.caching.model.DevEntityV2;
import com.acme.cache.service.caching.model.GenderV2;
import com.acme.cache.service.caching.model.ProgrammingLanguagesV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.EnumSet;


@RestController
public class PopulateDBControllerV2 {

    private DeveloperDaoV2 developerDao;

    public PopulateDBControllerV2(DeveloperDaoV2 developerDao) {
        this.developerDao = developerDao;
    }

    @GetMapping(path = "/create-test-data")
    public RedirectView populateDBWithExampleData() {
        DevEntityV2 dev3k
                = new DevEntityV2("Kristoff", "Jawowski",
                3000, GenderV2.MALE, EnumSet.of(ProgrammingLanguagesV2.JAVA, ProgrammingLanguagesV2.JAVA_SCRIPT));
        developerDao.save(dev3k);
        DevEntityV2 dev15k
                = new DevEntityV2("Maria", "von Magdala",
                15000, GenderV2.FEMALE, EnumSet.of(ProgrammingLanguagesV2.C_PLUS_PLUS, ProgrammingLanguagesV2.PYTHON));
        developerDao.save(dev15k);
        DevEntityV2 dev25k
                = new DevEntityV2("TINKY", "WINKI",
                15000, GenderV2.OTHER, EnumSet.of(ProgrammingLanguagesV2.JAVA));
        developerDao.save(dev25k);
        return new RedirectView("/");
    }

}
