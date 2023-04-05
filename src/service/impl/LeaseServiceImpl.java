package service.impl;

import dao.AccountingDao;
import dao.LeaseDao;
import dao.PropertyDao;
import dao.TenantDao;
import dao.impl.AccountingDaoImpl;
import dao.impl.LeaseDaoImpl;
import dao.impl.PropertyDaoImpl;
import dao.impl.TenantDaoImpl;
import entity.*;
import org.dom4j.DocumentException;
import service.LeaseService;

import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LeaseServiceImpl implements LeaseService {
    PropertyDao propertyDao = new PropertyDaoImpl();
    TenantDao tenantDao = new TenantDaoImpl();
    LeaseDao leaseDao = new LeaseDaoImpl();
    AccountingDao accountingDao = new AccountingDaoImpl();
    @Override
    public void createApartmentLease(LinkedHashMap<String, String> rentalInfo) throws DocumentException, ParseException, IOException {
        int tenantId = 0;
        String propertyId = null;
        double rentAmount = 0;
        String leaseEndDate = null, leaseStartDate = null;
        for(Map.Entry<String, String> a : rentalInfo.entrySet()) {
            if (a.getKey().equalsIgnoreCase("propertyId")){
                propertyId = a.getValue();
            }else if (a.getKey().equalsIgnoreCase("tenantId")){
                tenantId = Integer.parseInt(a.getValue());
            }else if (a.getKey().equalsIgnoreCase("startDate")){
                leaseStartDate = a.getValue();
            }else if (a.getKey().equalsIgnoreCase("endDate")){
                leaseEndDate = a.getValue();
            }else if (a.getKey().equalsIgnoreCase("rentAmount")){
                rentAmount = Double.parseDouble(a.getValue());
            }
        }
        Tenant tenant = tenantDao.getTenantById(tenantId);
        Property apartment = propertyDao.getApartmentById(propertyId);
        if (tenant == null){
            System.out.println("Not abel to create lease - Tenant ID is not exist");
        }else if (apartment == null){
            System.out.println("Not abel to create lease - Apartment ID is not exist");
        }else {
            int updateIndicator = propertyDao.updateAptStatusToRent(apartment.getId());
            if (updateIndicator == 1){
                Lease apartmentLease = new ApartmentLease(tenant, apartment, leaseStartDate, leaseEndDate, rentAmount);
                apartmentLease.createLease();

                Accounting accounting =  new Accounting();
                accounting.setIsPaid("No");
                accounting.setPropertyId(propertyId);
                accounting.setTenantEmail(tenant.getEmail());
                accounting.setLeaseId(leaseDao.getNodeCount("mockdata/lease.xml"));
                accounting.setTenantName(tenant.getName());
                accounting.setTenantId(tenant.getId());
                accountingDao.addPayment(accounting);

                System.out.println("--> The apartment ID: " + apartment.getId() + " has been updated to rented status");
            }else {
                System.out.println("Create lease failed, the property is being rented now");
            }
        }
    }

    @Override
    public void createCondoLease(LinkedHashMap<String, String> rentalInfo) throws DocumentException, ParseException, IOException {
        int tenantId = 0;
        String propertyId = null;
        double rentAmount = 0;
        String leaseEndDate = null, leaseStartDate = null;
        for(Map.Entry<String, String> a : rentalInfo.entrySet()) {
            if (a.getKey().equalsIgnoreCase("propertyId")){
                propertyId = a.getValue();
            }else if (a.getKey().equalsIgnoreCase("tenantId")){
                tenantId = Integer.parseInt(a.getValue());
            }else if (a.getKey().equalsIgnoreCase("startDate")){
                leaseStartDate = a.getValue();
            }else if (a.getKey().equalsIgnoreCase("endDate")){
                leaseEndDate = a.getValue();
            }else if (a.getKey().equalsIgnoreCase("rentAmount")){
                rentAmount = Double.parseDouble(a.getValue());
            }
        }
        Tenant tenant = tenantDao.getTenantById(tenantId);
        Property condo = propertyDao.getCondoById(propertyId);
        if (tenant == null){
            System.out.println("Not abel to create lease - Tenant ID is not exist");
        }else if (condo == null){
            System.out.println("Not abel to create lease - Condo ID is not exist");
        }else {
            int updateIndicator = propertyDao.updateCondoStatusToRent(condo.getId());
            if (updateIndicator == 1){
                Lease apartmentLease = new ApartmentLease(tenant, condo, leaseStartDate, leaseEndDate, rentAmount);
                apartmentLease.createLease();

                Accounting accounting =  new Accounting();
                accounting.setIsPaid("No");
                accounting.setPropertyId(propertyId);
                accounting.setTenantEmail(tenant.getEmail());
                accounting.setLeaseId(leaseDao.getNodeCount("mockdata/lease.xml"));
                accounting.setTenantName(tenant.getName());
                accounting.setTenantId(tenant.getId());
                accountingDao.addPayment(accounting);

                System.out.println("--> The condo ID: " + condo.getId() + " has been updated to rented status");
            }else {
                System.out.println("Create lease failed, the property is being rented now");
            }
        }
    }

    @Override
    public void createHouseLease(LinkedHashMap<String, String> rentalInfo) throws DocumentException, ParseException, IOException {
        int tenantId = 0;
        String propertyId = null;
        double rentAmount = 0;
        String leaseEndDate = null, leaseStartDate = null;
        for(Map.Entry<String, String> a : rentalInfo.entrySet()) {
            if (a.getKey().equalsIgnoreCase("propertyId")){
                propertyId = a.getValue();
            }else if (a.getKey().equalsIgnoreCase("tenantId")){
                tenantId = Integer.parseInt(a.getValue());
            }else if (a.getKey().equalsIgnoreCase("startDate")){
                leaseStartDate = a.getValue();
            }else if (a.getKey().equalsIgnoreCase("endDate")){
                leaseEndDate = a.getValue();
            }else if (a.getKey().equalsIgnoreCase("rentAmount")){
                rentAmount = Double.parseDouble(a.getValue());
            }
        }
        Tenant tenant = tenantDao.getTenantById(tenantId);
        Property house = propertyDao.getHouseById(propertyId);
        if (tenant == null){
            System.out.println("Not abel to create lease - Tenant ID is not exist");
        }else if (house == null){
            System.out.println("Not abel to create lease - House ID is not exist");
        }else {
            int updateIndicator = propertyDao.updateHouseStatusToRent(house.getId());
            if (updateIndicator == 1){
                Lease apartmentLease = new ApartmentLease(tenant, house, leaseStartDate, leaseEndDate, rentAmount);
                apartmentLease.createLease();

                Accounting accounting =  new Accounting();
                accounting.setIsPaid("No");
                accounting.setPropertyId(propertyId);
                accounting.setTenantEmail(tenant.getEmail());
                accounting.setLeaseId(leaseDao.getNodeCount("mockdata/lease.xml"));
                accounting.setTenantName(tenant.getName());
                accounting.setTenantId(tenant.getId());
                accountingDao.addPayment(accounting);

                System.out.println("--> The house ID: " + house.getId() + " has been updated to rented status");
            }else {
                System.out.println("Create lease failed, the property is being rented now");
            }
        }
    }

    @Override
    public void displayAllLease() throws DocumentException {
        List<LinkedHashMap<String, String>> leaseList = leaseDao.getAllLease();
        String leaseId = null, tenantId = null, tenantName = null, tenantEmail = null,tenantPhone = null;
        String propertyId = null, address = null, startDate = null, endDate = null, rentAmount = null;
        for (int i = 0; i < leaseList.size(); i++) {
            LinkedHashMap<String,String> leaseInfo = leaseList.get(i);
            for(Map.Entry<String, String> a : leaseInfo.entrySet()) {
                if ("TenantId".equalsIgnoreCase(a.getKey())){
                    tenantId = a.getValue();
                }else if ("tenantName".equalsIgnoreCase(a.getKey())){
                    tenantName = a.getValue();
                }else if ("TenantEmail".equalsIgnoreCase(a.getKey())){
                    tenantEmail = a.getValue();
                }else if ("TenantPhone".equalsIgnoreCase(a.getKey())){
                    tenantPhone = a.getValue();
                }else if ("PropertyId".equalsIgnoreCase(a.getKey())){
                    propertyId = a.getValue();
                }else if ("Address".equalsIgnoreCase(a.getKey())){
                    address = a.getValue();
                }else if ("StartDate".equalsIgnoreCase(a.getKey())){
                    startDate = a.getValue();
                }else if ("EndDate".equalsIgnoreCase(a.getKey())){
                    endDate = a.getValue();
                }else if ("RentAmount".equalsIgnoreCase(a.getKey())){
                    rentAmount = a.getValue();
                }else if ("id".equalsIgnoreCase(a.getKey())){
                    leaseId = a.getValue();
                }
            }
            System.out.println(leaseId + "\t\t\t\t" + tenantId + "\t\t" + tenantName + "\t\t" + tenantEmail + "\t\t" +
                    tenantPhone + "\t\t" + propertyId + "\t\t\t\t" + address + "\t\t" + startDate + "\t\t" +
                    endDate + "\t\t" + rentAmount);
        }
    }

    @Override
    public Lease getLeaseById(Integer leaseId) {
        return null;
    }
}
