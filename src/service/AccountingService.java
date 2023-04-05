package service;

import dao.AccountingDao;
import dao.impl.AccountingDaoImpl;
import entity.Accounting;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.List;

public class AccountingService {
    private static AccountingService instance = new AccountingService();
    AccountingService(){}

    public static AccountingService getInstance(){
        if (instance == null){
            instance = new AccountingService();
        }
        return instance;
    }

    public boolean makePayment(String leaseId, String paid) throws DocumentException, IOException {
        AccountingDao accountingDao = new AccountingDaoImpl();
        Accounting accounting = accountingDao.getAccounting(leaseId);
        boolean updateIndicator = false;

        if (accounting.getLeaseId() != null){
            accounting.setIsPaid(paid);
            updateIndicator = accountingDao.updatePayment(accounting);
        }else {
            System.out.println("Cannot find leaseId!");
        }
        return updateIndicator;
    }

    public List<Accounting> getPaidList() throws DocumentException {
        AccountingDao accountingDao = new AccountingDaoImpl();
        return accountingDao.getPaidList();
    }

    public List<Accounting> getUnpaidList() throws DocumentException {
        AccountingDao accountingDao = new AccountingDaoImpl();
        return accountingDao.getUnpaidList();
    }

}
