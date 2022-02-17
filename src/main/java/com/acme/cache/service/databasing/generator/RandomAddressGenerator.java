package com.acme.cache.service.databasing.generator;


import com.acme.cache.service.databasing.model.Address;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class RandomAddressGenerator {

    private final List<String> listOfCities = Arrays.asList("GDANSK", "GDYNIA", "SOPOT", "TCZEW", "SLUPSK");
    private final List<String> listOfStreets = Arrays.asList(
            "GDANSKA", "BIALA", "CZERWONA", "GEN. HALLERA", "SLUPSKA", "KRAKOWSKA", "DLUGA", "UNII EUROPEJSKIEJ");

    public Address generateRandomAddress() {
        Address address = new Address();
        address.setCity(randomCity());
        address.setStreet(randomStreet());
        address.setNumber(randomNumber());
        return address;
    }


    private String randomCity() {
        int boundaryOfRandomCities = listOfCities.size();
        int indexOfRandomCity = new Random().nextInt(boundaryOfRandomCities);
        return listOfCities.get(indexOfRandomCity);
    }

    private String randomStreet(){
        int boundaryofrandomstreets = listOfStreets.size();
        int indexOfRandomCity = new Random().nextInt(boundaryofrandomstreets);
        return listOfStreets.get(indexOfRandomCity);

    }

    private String randomNumber() {
        Random random = new Random();
        int indexOfRandomCity = random.nextInt(300);
        String number = String.valueOf(indexOfRandomCity);
        if (random.nextBoolean()) {
            if (random.nextBoolean()) {
                if (random.nextBoolean()) {
                    number = number.concat("A");
                } else {
                    number = number.concat("B");
                }


            }
        }
        return number;
    }
}
