package dao.impl;

import org.dom4j.DocumentException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class PropertyDaoImplTest {

    PropertyDaoImpl propertyDao = new PropertyDaoImpl();

    /*
     * Description: to test updateAptStatusToRent method updates the information for Apartment.
     * Context: propertyDao initialed above.
     * Expected result: equal.
     * */
    @Test
    public void testUpdateAptStatusToRent() throws IOException, DocumentException {
        int updateIndicator = 0;
        String id = "A1";
        assertEquals(updateIndicator, propertyDao.updateAptStatusToRent(id));
    }
    /*
     * Description: to test updateCondoStatusToRent method updates the information for Condo.
     * Context: propertyDao initialed above.
     * Expected result: equal.
     * */
    @Test
    public void testUpdateCondoStatusToRent() throws IOException, DocumentException {
        int updateIndicator = 0;
        String id = "C1";
        assertEquals(updateIndicator, propertyDao.updateCondoStatusToRent(id));
    }
    /*
     * Description: to test updateHouseStatusToRent method updates the information for House.
     * Context: propertyDao initialed above.
     * Expected result: equal.
     * */
    @Test
    public void testUpdateHouseStatusToRent() throws IOException, DocumentException {
        int updateIndicator = 0;
        String id = "H2";
        assertEquals(updateIndicator, propertyDao.updateHouseStatusToRent(id));

    }
}