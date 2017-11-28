package com.ct.plantera.plantplaces;

import com.ct.plantera.dao.NetworkDAO;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by charlest on 11/27/17.
 */

public class TestNetworkDAO {

    NetworkDAO networkDAO;

    @Before
    public void setup(){
        networkDAO = new NetworkDAO();
    }

    @Test()
    public void fetchShouldSuccess_whenGivenValidUri() throws IOException {
        String result = networkDAO.fetch("http://plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=asdasdd");

        assertEquals("{\"plants\":[]}-1", result);
    }
}
