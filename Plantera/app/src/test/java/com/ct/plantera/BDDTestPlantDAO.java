package com.ct.plantera;

import com.ct.plantera.dao.IPlantDAO;
import com.ct.plantera.dao.PlantsDAO;
import com.ct.plantera.dto.PlantDTO;

import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertTrue;

/**
 * Created by charlest on 11/27/17.
 */

public class BDDTestPlantDAO {

    IPlantDAO iplantDAO;

    private List<PlantDTO> plantDTOs;

    @Test
    public void testPlantDAO_fetchShouldReturnResultsFound_forRedbud() throws IOException, JSONException {

        givenPlantDAOIsInitialized();

        whenSearchForRedBud();

        thenVerifyAtAleastOneCercisCanadensis();

    }

    private void givenPlantDAOIsInitialized(){
        iplantDAO = new PlantsDAO();
    }

    private void whenSearchForRedBud() throws IOException, JSONException {
        plantDTOs = iplantDAO.fetchPlants("Redbud");
    }

    private void thenVerifyAtAleastOneCercisCanadensis() {
        boolean redBudFound = false;

        for (PlantDTO plant : plantDTOs) {
            if(plant.getGenus().contains("Cercis") && plant.getSpecies().contains("canadensis")){
                redBudFound = true;
            }
        }

        assertTrue(redBudFound);
        System.out.println("TEST: Running RedBud test.");
    }
}
