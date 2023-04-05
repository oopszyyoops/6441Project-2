package dao.impl;

import entity.Accounting;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class AccountingDaoImplTest {
    AccountingDaoImpl accountingDao = new AccountingDaoImpl();
    Accounting accounting = new Accounting(3, 3, 3, "Andy Yang", "andy@gmail.com", "H1", "Yes");

    /*
    * Description: to test addPayment method adds new payment into accounting data file.
    * Context: accounting initialed above.
    * Expected result: true.
    * */
    @Test
    public void testAddPayment() throws DocumentException {
        assertTrue(accountingDao.addPayment(accounting));
    }

    /*
     * Description: to test updatePayment method updates payment in accounting data file.
     * Context: accounting initialed above.
     * Expected result: true.
     * */
    @Test
    public void testUpdatePayment() throws IOException, DocumentException {
        assertTrue(accountingDao.updatePayment(accounting));
    }

    /*
     * Description: to test getPayment method gets payment from accounting data file.
     * Context: accounting initialed above, leaseId which represents accounting info compared.
     * Expected result: all same.
     * */
    @Test
    public void testGetAccounting() throws DocumentException {
        String leaseId = "3";
        assertEquals(accounting.getTenantId(), accountingDao.getAccounting(leaseId).getTenantId());
        assertEquals(accounting.getTenantName(), accountingDao.getAccounting(leaseId).getTenantName());
        assertEquals(accounting.getTenantEmail(), accountingDao.getAccounting(leaseId).getTenantEmail());
        assertEquals(accounting.getPropertyId(), accountingDao.getAccounting(leaseId).getPropertyId());
        assertEquals(accounting.getIsPaid(), accountingDao.getAccounting(leaseId).getIsPaid());

    }
}