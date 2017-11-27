package com.ct.plantera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.ct.plantera.dto.PlantDTO;
import com.ct.plantera.service.IPlantService;
import com.ct.plantera.service.PlantService;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    IPlantService plantService;

    private AutoCompleteTextView actPlantName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actPlantName = (AutoCompleteTextView) findViewById(R.id.actPlantName);

        plantService = new PlantService();
    }

    public void searchPlants(View v) {
        List<PlantDTO> plantDTOs = plantService.fetchPlants(actPlantName.getText().toString());

        for(PlantDTO plantDTO : plantDTOs){


            Toast.makeText(MainActivity.this, plantDTO.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
