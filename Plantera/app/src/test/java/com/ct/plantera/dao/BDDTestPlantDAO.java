package com.ct.plantera.dao;

import com.ct.plantera.dao.IPlantDAO;
import com.ct.plantera.dao.NetworkDAO;
import com.ct.plantera.dao.PlantsDAO;
import com.ct.plantera.dto.PlantDTO;

import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    private void givenPlantDAOIsInitialized() throws IOException {



        NetworkDAO networkDAO = mock(NetworkDAO.class);
        when(networkDAO
                .fetch("http://plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=Quercus"))
                .thenReturn(quercusJson);

        when(networkDAO
                .fetch("http://plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=akashdkasdhkasjh"))
                .thenReturn(gibberishJson);

        when(networkDAO.fetch("http://plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=Redbud"))
                .thenReturn(redBudJson);

        iplantDAO = new PlantsDAO(networkDAO);
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

    @Test
    public void testPlantDAO_fetchShouldReturn_atLeastTwoOaks_forQuercus() throws IOException, JSONException {

        givenPlantDAOIsInitialized();

        whenSearchforQuercus();
        
        thenVerifyAtLeastTwoOaksForQuercus();
    }

    @Test
    public void testPlantDAO_fetchShouldReturnGenusQuercusForQuercus() throws IOException, JSONException {

        givenPlantDAOIsInitialized();

        whenSearchforQuercus();

        thenVerifyAllGenusAreQuercus();
    }

    private void thenVerifyAllGenusAreQuercus() {

        for (PlantDTO plant : plantDTOs){

            assertThat(plant, hasProperty("genus", containsString("Quercus")));
        }
    }


    @Test
    public void testPlantDAO_fetchShouldReturnNothing() throws IOException, JSONException {

        givenPlantDAOIsInitialized();

        whenSearchFor_RandomString();

        thenVerify_thatNothing_isReturned();
    }

    private void whenSearchforQuercus() throws IOException, JSONException {
        plantDTOs = iplantDAO.fetchPlants("Quercus");
    }

    private void thenVerifyAtLeastTwoOaksForQuercus() {
        boolean quercusRoburFound = false;

        for (PlantDTO plant : plantDTOs) {
            if(plant.getGenus().contains("Quercus")
                    && plant.getSpecies().contains("robur")
                    && plant.getCommon().contains("Oak")){
                quercusRoburFound = true;
            }
        }

        assertTrue(quercusRoburFound);

        boolean quercusAlbaFound = false;

        for (PlantDTO plant : plantDTOs) {
            if(plant.getGenus().contains("Quercus")
                    && plant.getSpecies().contains("robur")
                    && plant.getCommon().contains("Oak")){
                quercusAlbaFound = true;
            }
        }

        assertTrue(quercusAlbaFound);
    }



    private void whenSearchFor_RandomString() throws IOException, JSONException {
        plantDTOs = iplantDAO.fetchPlants("akashdkasdhkasjh");
    }

    private void thenVerify_thatNothing_isReturned(){

        int size = plantDTOs.size();

        assertEquals(0, size);

    }

    String gibberishJson = "{\"plants\":[]}-1";

    String quercusJson = "{\"plants\":[\n" +
            "{\"id\":\"5888\",\"genus\":\"Quercus\",\"species\":\"robur\",\"cultivar\":\"fastigiata\",\"common\":\"English Oak\"}," +
            "{\"id\":\"4568\",\"genus\":\"Quercus\",\"species\":\"robur\",\"cultivar\":\"purpurescens\",\"common\":\"English Oak\"}]}";


    String redBudJson = "{\"plants\":[\n" +
            "{\"id\":\"83\",\"genus\":\"Cercis\",\"species\":\"canadensis\",\"cultivar\":\"\",\"common\":\"Eastern Redbud\"}]}";

}
