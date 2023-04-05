package dao.impl;

import org.dom4j.DocumentException;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeaseDaoImplTest {
    LeaseDaoImpl leaseDao = new LeaseDaoImpl();

    /*
     * Description: to test getNodeCount method gets the node amount from lease data file.
     * Context: leaseDao initialed above.
     * Expected result: equal.
     * */
    @Test
    public void testGetNodeCount() throws DocumentException {
        int expect = 2;
        String fileName = "mockdata/lease.xml";
        assertEquals(expect, leaseDao.getNodeCount(fileName));
    }
}