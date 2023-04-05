package entity;

import dao.LeaseDao;
import dao.impl.LeaseDaoImpl;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.text.ParseException;

public class HouseLease extends Lease{
    LeaseDao leaseDao = new LeaseDaoImpl();
    public HouseLease(Tenant tenant, Property property, String startDate, String endDate, double rentAmount) {
        super(tenant, property, startDate, endDate, rentAmount);
    }

    public HouseLease() {
    }

    @Override
    protected void createLeaseDocument() throws DocumentException {
        String leaseId = String.valueOf(leaseDao.getNodeCount("mockdata/lease.xml") + 1);

        String tenantId = String.valueOf(tenant.getId());
        String tenantName = tenant.getName();
        String tenantEmail = tenant.getEmail();
        String tenantPhone = tenant.getPhone();

        String apartmentId = property.getId();
        String StreetName = property.getStreetName();
        String city = property.getCity();
        String province = property.getProvince();
        String postcode = property.getPostCode();
        String address = StreetName + "," + city + "," + province + "," + postcode;

        System.out.println("\n The lease is being proceed by the system, please check below summary:\n");
        System.out.println("**************************** Lease review ****************************\n");
        System.out.println("Lease ID: " + leaseId);

        System.out.println("Tenant ID: " + tenantId);
        System.out.println("Tenant Name: " + tenantName);
        System.out.println("Tenant Email: " + tenantEmail);
        System.out.println("Tenant Phone No.: " + tenantPhone + "\n");

        System.out.println("Apartment ID: " + apartmentId);
        System.out.println("Address: " + address);
        System.out.println("Start date" + startDate);
        System.out.println("End date" + endDate);
        System.out.println("Rent amount: $" + rentAmount + "\n");
        System.out.println("***********************************************************************\n");
    }

    @Override
    protected void saveLease() throws DocumentException, IOException, ParseException {
        leaseDao.addCondoLease(this);
        System.out.println("--> The lease has been saved");
    }
}
