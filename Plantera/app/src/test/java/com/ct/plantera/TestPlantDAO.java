package com.ct.plantera;

import com.ct.plantera.dao.IPlantDAO;
import com.ct.plantera.dao.PlantDAOStub;
import com.ct.plantera.dto.PlantDTO;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by charlest on 11/27/17.
 */

public class TestPlantDAO {

    IPlantDAO iPlantDAO;

    @Before
    public void setup(){
        iPlantDAO = new PlantDAOStub();
    }

    @Test
    public void testPlantDAO_searchForRedBud_shouldReturn_atLeastOneResult(){
        List<PlantDTO> plantDTOs = iPlantDAO.fetchPlants("RedBud");

        boolean redBudFound = false;

        for (PlantDTO plant : plantDTOs) {
            if(plant.getCommon().contains("RedBud")){
                redBudFound = true;
            }
        }

        assertTrue(redBudFound);
    }
}
