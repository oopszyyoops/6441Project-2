package dao.impl;

import entity.Tenant;
import org.dom4j.DocumentException;
import org.junit.Test;

import static org.junit.Assert.*;

public class TenantDaoImplTest {
    TenantDaoImpl tenantDao = new TenantDaoImpl();
    /*
     * Description: to test getTenantById method get the information for Tenant by specialty ID.
     * Context: tenantDao initialed above.
     * Expected result: equal.
     * */
    @Test
    public void testGetTenantById() throws DocumentException {
        Integer id = 1;
        Tenant tenant = new Tenant(1, "Nick Lee", "nick@gmail.com", "123456789");
        assertEquals(tenant.getName(), tenantDao.getTenantById(id).getName());
        assertEquals(tenant.getEmail(), tenantDao.getTenantById(id).getEmail());
        assertEquals(tenant.getPhone(), tenantDao.getTenantById(id).getPhone());
    }
}