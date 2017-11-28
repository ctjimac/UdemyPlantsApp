package com.ct.plantera;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ct.plantera.dto.PlantDTO;
import com.ct.plantera.service.IPlantService;
import com.ct.plantera.service.PlantService;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private IPlantService plantService;

    private AutoCompleteTextView actPlantName;

    private ListView listView;

    private List<PlantDTO> plantDTOs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actPlantName = (AutoCompleteTextView) findViewById(R.id.actPlantName);
        listView = (ListView) findViewById(R.id.listView);

        plantService = new PlantService();
    }

    public void searchPlants(View v) throws IOException, JSONException {
        PlantSearchTask plantSearchTask = new PlantSearchTask();
        plantSearchTask.execute(actPlantName.getText().toString());
    }

    private class PlantSearchTask extends AsyncTask<String, Integer, List<PlantDTO>>{

        @Override
        protected List<PlantDTO> doInBackground(String... strings) {
            List<PlantDTO> plantDTOs = null;

            try{
                plantDTOs = plantService.fetchPlants(strings[0]);

            }catch (Exception e){
                e.printStackTrace();
            }

            return plantDTOs;
        }

        @Override
        protected void onPostExecute(List<PlantDTO> plantDTOs) {
            ArrayAdapter<PlantDTO> plantDTOArrayAdapter = new ArrayAdapter<PlantDTO>(
                    MainActivity.this,
                    android.R.layout.simple_list_item_1,
                    plantDTOs);

            listView.setAdapter(plantDTOArrayAdapter);

            setPlantDTOs(plantDTOs);
        }
    }

    public List<PlantDTO> getPlantDTOs() {
        return plantDTOs;
    }

    public void setPlantDTOs(List<PlantDTO> plantDTOs) {
        this.plantDTOs = plantDTOs;
    }

}
