package com.ct.plantera.dao;

import com.ct.plantera.dto.FlowerDTO;
import com.ct.plantera.dto.PlantDTO;
import com.ct.plantera.dto.TreeDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by charlest on 11/27/17.
 */

public class PlantDAOStub implements IPlantDAO{
    @Override
    public List<PlantDTO> fetchPlants(String filter) {
        List<PlantDTO> allPlants = new ArrayList<>();
        TreeDTO plantDTO = new TreeDTO();
        plantDTO.setGenus("Cercis");
        plantDTO.setSpecies("canadensis");
        plantDTO.setCommon("Eastern RedBud");
        plantDTO.setSize(30);
        plantDTO.setType("tree");
        plantDTO.setFallColor("Yellowish");
        allPlants.add(plantDTO);


        FlowerDTO flower = new FlowerDTO();
        flower.setGenus("Tropoleum");
        flower.setSpecies("spp");
        flower.setCommon("Nasturtium");
        flower.setType("flower");
        allPlants.add(flower);

        return allPlants;
    }
}
