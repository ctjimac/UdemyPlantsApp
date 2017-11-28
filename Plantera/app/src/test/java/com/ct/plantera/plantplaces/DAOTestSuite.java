package com.ct.plantera.plantplaces;

import com.ct.plantera.dao.BDDTestPlantDAO;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by charlest on 11/28/17.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BDDTestPlantDAO.class,
        TestNetworkDAO.class
})
public class DAOTestSuite {
}
