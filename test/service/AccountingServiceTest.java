package service;

import dao.AccountingDao;
import dao.impl.AccountingDaoImpl;
import entity.Accounting;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class AccountingServiceTest {
    AccountingService accountingService = new AccountingService();
    /*
     * Description: to test makePayment method makes the payment in accounting date file.
     * Context: accountingService initialed above. leaseId and paid which are to update the info of accounting data.
     * Expected result: true.
     * */
    @Test
    public void testMakePayment() throws IOException, DocumentException {
        String leaseId = "2";
        String paid = "Yes";
        assertTrue(accountingService.makePayment(leaseId, paid));
    }
}