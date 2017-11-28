package com.ct.plantera.service;

import com.ct.plantera.dao.IPlantDAO;
import com.ct.plantera.dao.NetworkDAO;
import com.ct.plantera.dao.PlantDAOStub;
import com.ct.plantera.dao.PlantJSONDao;
import com.ct.plantera.dao.PlantsDAO;
import com.ct.plantera.dto.PlantDTO;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * Created by charlest on 11/27/17.
 */

public class PlantService implements IPlantService {

    IPlantDAO iPlantDAO;

    public PlantService(){
        this.iPlantDAO = new PlantsDAO(new NetworkDAO());
    }

    @Override
    public List<PlantDTO> fetchPlants(String filter) throws IOException, JSONException {
        return iPlantDAO.fetchPlants(filter);
    }
}
