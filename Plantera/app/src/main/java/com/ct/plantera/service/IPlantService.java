package com.ct.plantera.service;

import com.ct.plantera.dto.PlantDTO;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * Business logic for fetching and managing plants
 * Created by charlest on 11/27/17.
 */

public interface IPlantService {

    /**
     * Returns
     */
    List<PlantDTO> fetchPlants(String filter) throws IOException, JSONException;
}
