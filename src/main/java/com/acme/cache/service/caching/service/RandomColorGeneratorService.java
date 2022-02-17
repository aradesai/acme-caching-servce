package com.acme.cache.service.caching.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomColorGeneratorService {

    private final Logger log = LoggerFactory.getLogger(RandomColorGeneratorService.class);

    @Cacheable(value = "color", unless = "#buttonNumber % 2 == 0")
    public Integer[] generateRandomRGB(int buttonNumber){
        Integer[] rgbArr = new Integer[3];
        rgbArr[0] = new Random().nextInt(256);
        rgbArr[1] = new Random().nextInt(256);
        rgbArr[2] = new Random().nextInt(256);
        log.info(String.format("Created new color r: %d g: %d b: %d  . Used button id: %d", rgbArr[0], rgbArr[1], rgbArr[2], buttonNumber));
        return rgbArr;
    }

}
