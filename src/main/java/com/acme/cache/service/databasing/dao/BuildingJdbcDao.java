package com.acme.cache.service.databasing.dao;

import com.acme.cache.service.databasing.mapper.BuildingFromDBRowMapper;
import com.acme.cache.service.databasing.model.BuildingFromDB;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class BuildingJdbcDao {

    private String sqlQuery = "SELECT\n" +
            "BUILDINGS.ID,\n" +
            "BUILDINGS.BUILDING_TYPE,\n" +
            "ADDRESSES.CITY,\n" +
            "ADDRESSES.STREET,\n" +
            "ADDRESSES.NUMBER\n" +
            "FROM BUILDINGS\n" +
            "INNER JOIN\n" +
            "ADDRESSES ON ADDRESSES.ID = BUILDINGS.ADDRESS_ID";

    private final JdbcTemplate jdbcTemplate;


    public BuildingJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BuildingFromDB> getAll() throws IOException {
        List<BuildingFromDB>resultList = jdbcTemplate.query(sqlQuery, new BuildingFromDBRowMapper());
        return resultList;
    }

    public List<BuildingFromDB> getAllBeanPropertyRowMapper() throws IOException {
        BeanPropertyRowMapper beanPropertyRowMapper = new BeanPropertyRowMapper(BuildingFromDB.class);
        beanPropertyRowMapper.setPrimitivesDefaultedForNullValue(true);
        List<BuildingFromDB>resultList = jdbcTemplate.query(sqlQuery, beanPropertyRowMapper);
        return resultList;
    }
}
