package com.ct.plantera.dao;

import com.ct.plantera.dto.PlantDTO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by charlest on 11/27/17.
 */

public class PlantsDAO implements IPlantDAO {

    private NetworkDAO networkDAO;

    public PlantsDAO(){
        this.networkDAO = new NetworkDAO();
    }

    @Override
    public List<PlantDTO> fetchPlants(String filter) throws IOException, JSONException {
        ArrayList<PlantDTO> allPlants = new ArrayList<>();

        String request = networkDAO.fetch("http://plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=" + filter);

        JSONObject root = new JSONObject(request);

        JSONArray plants = root.getJSONArray("plants");

        for(int i = 0; i < plants.length(); i++){
            JSONObject jsonObject = plants.getJSONObject(i);

            PlantDTO plantDTO = new PlantDTO();
            plantDTO.setGuid(jsonObject.getInt("id"));
            plantDTO.setGenus(jsonObject.getString("genus"));
            plantDTO.setSpecies(jsonObject.getString("species"));
            plantDTO.setCultivar(jsonObject.getString("cultivar"));
            plantDTO.setCommon(jsonObject.getString("common"));

            allPlants.add(plantDTO);
        }

        return allPlants;
    }
}
