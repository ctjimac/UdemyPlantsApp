package com.ct.plantera.dao;

import com.ct.plantera.dao.IPlantDAO;
import com.ct.plantera.dao.PlantDAOStub;
import com.ct.plantera.dto.PlantDTO;

import org.json.JSONException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by charlest on 11/27/17.
 */

public class TestPlantDAO {

    IPlantDAO iPlantDAO;

    @BeforeClass
    public static void setupAllTests(){
        System.out.println("BeforeClass: running init for ALL tests.");
    }

    @Before
    public void setup(){
        iPlantDAO = new PlantDAOStub();
        System.out.println("Before: running init for EACH tests.");
    }

    @Test
    public void testPlantDAO_searchForRedBud_shouldReturn_atLeastOneResult() throws IOException, JSONException {
        List<PlantDTO> plantDTOs = iPlantDAO.fetchPlants("RedBud");

        boolean redBudFound = false;

        for (PlantDTO plant : plantDTOs) {
            if(plant.getCommon().contains("RedBud")){
                redBudFound = true;
            }
        }

        assertTrue(redBudFound);
        System.out.println("TEST: Running RedBud test.");
    }

    @Test
    public void testPlantDAO_searchForOak_shouldReturn_atLeastOneWhiteOak() throws IOException, JSONException {
        List<PlantDTO> plantDTOs = iPlantDAO.fetchPlants("RedBud");

        boolean whiteOakFound = false;

        for (PlantDTO plant : plantDTOs) {
            if(plant.getGenus().equalsIgnoreCase("Quercus") &&
                    plant.getSpecies().contains("alba")){
                whiteOakFound = true;
            }
        }

        assertTrue(whiteOakFound);
        System.out.println("TEST: Running white oak test.");
    }

    public void testPlantDAO_searchForEShouldReturnAtLeastTwoResults() throws IOException, JSONException {
        List <PlantDTO> plantDTOs = iPlantDAO.fetchPlants("e");
        int size = plantDTOs.size();

        //assertThat(size, isGreaterThan)

        boolean atleastTwo = size > 2;

        assertTrue(atleastTwo);
        System.out.println("TEST: this should not run because it is not annotated. ");
    }

    @After
    public void tearDown(){
        System.out.println("After: tearing down EACH test.");
    }

    @AfterClass
    public static void teardownAllTests(){
        System.out.println("AfterClass: tearing down after ALL tests.");
    }
}
