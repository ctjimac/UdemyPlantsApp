package com.ct.plantera;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.ct.plantera.dto.PlantDTO;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * Created by charlest on 11/28/17.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void searchForRedBudShouldReturn_atLeastOneResult(){
        Context context = InstrumentationRegistry.getContext();

        onView(withId(R.id.actPlantName)).perform(typeText("RedBud"));

        onView(withId(R.id.btnSearch)).perform(click());

        List<PlantDTO> plantDTOs = rule.getActivity().getPlantDTOs();

        assertThat(plantDTOs, not(empty()));
    }
}