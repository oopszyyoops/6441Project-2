package entity;

import org.dom4j.DocumentException;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public abstract class Lease {
    protected int id;

    protected Tenant tenant;

    protected Property property;
    protected String startDate;
    protected String endDate;
    protected double rentAmount;

    protected Lease() {
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lease(Tenant tenant, Property property, String startDate, String endDate, double rentAmount) {
        this.tenant = tenant;
        this.property = property;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentAmount = rentAmount;
    }
    public void createLease() throws DocumentException, IOException, ParseException {
        createLeaseDocument();
        saveLease();
    }

    protected abstract void createLeaseDocument() throws DocumentException;

    protected abstract void saveLease() throws DocumentException, IOException, ParseException;
}
