package com.ct.plantera.dao;

import com.ct.plantera.dto.PlantDTO;

import java.util.List;

/**
 * Collection of methods to access plant data
 * Created by charlest on 11/27/17.
 */
public interface IPlantDAO {

    /**
     * Accept filter text, android return all plants contains filter text
     * @param filter plant text filter
     * @return a list of plants that contains the filter text
     */
    List<PlantDTO> fetchPlants(String filter);
}
