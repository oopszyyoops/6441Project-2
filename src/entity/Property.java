package entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Property implements RentalObserver{
    private String id;
    private String streetName;
    private String city;
    private String province;
    private String postCode;
    private List<Tenant> tenants = new ArrayList<>();
    private boolean isAvailable;

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
        if (isAvailable) {
            notifyObservers();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public List<Tenant> getTenants() {
        return tenants;
    }

    public void setTenants(List<Tenant> tenants) {
        this.tenants = tenants;
    }

    public void addObserver(Tenant tenant) {
        tenants.add(tenant);
    }

    public void removeObserver(Tenant tenant) {
        tenants.remove(tenant);
    }

    public void notifyObservers() {
        if (tenants != null){
            for (Tenant tenant : tenants) {
                tenant.update(this);
            }
        }
    }
}
