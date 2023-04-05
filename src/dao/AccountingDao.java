package dao;

import entity.Accounting;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.List;

public interface AccountingDao {
    boolean addPayment(Accounting accounting) throws DocumentException;
    boolean updatePayment(Accounting accounting) throws DocumentException, IOException;
    List<Accounting> getPaidList() throws DocumentException;
    List<Accounting> getUnpaidList() throws DocumentException;

    Accounting getAccounting(String leaseId) throws DocumentException;
}
