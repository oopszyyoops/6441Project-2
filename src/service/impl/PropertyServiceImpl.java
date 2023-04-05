package service.impl;

import dao.PropertyDao;
import dao.TenantDao;
import dao.impl.PropertyDaoImpl;
import dao.impl.TenantDaoImpl;
import entity.Apartment;
import entity.Condo;
import entity.House;
import entity.Property;
import entity.propertyfactory.ApartmentFactory;
import entity.propertyfactory.CondoFactory;
import entity.propertyfactory.HouseFactory;
import entity.propertyfactory.PropertyFactory;
import org.dom4j.DocumentException;
import service.PropertyService;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PropertyServiceImpl implements PropertyService {
    PropertyDao propertyDao = new PropertyDaoImpl();
    TenantDao tenantDao = new TenantDaoImpl();
    PropertyFactory apartmentFactory = new ApartmentFactory();
    PropertyFactory condoFactory = new CondoFactory();
    PropertyFactory houseFactory = new HouseFactory();
    @Override
    public void addApartment(LinkedHashMap<String, String> aptInfo) throws DocumentException, IOException {
        Apartment apartment = (Apartment) apartmentFactory.createProperty();
        for(Map.Entry<String, String> a : aptInfo.entrySet()) {
            if (a.getKey().equalsIgnoreCase("Street")){
                apartment.setStreetName(a.getValue());
            } else if (a.getKey().equalsIgnoreCase("City")) {
                apartment.setCity(a.getValue());
            } else if (a.getKey().equalsIgnoreCase("Province")) {
                apartment.setProvince(a.getValue());
            } else if (a.getKey().equalsIgnoreCase("Postcode")) {
                apartment.setPostCode(a.getValue());
            } else if (a.getKey().equalsIgnoreCase("UnitNumber")) {
                apartment.setUnitNumber(Integer.parseInt(a.getValue()));
            } else if (a.getKey().equalsIgnoreCase("Bathroom")) {
                apartment.setNumberOfBathrooms(Integer.parseInt(a.getValue()));
            } else if (a.getKey().equalsIgnoreCase("Bedroom")) {
                apartment.setNumberOfBedrooms(Integer.parseInt(a.getValue()));
            } else if (a.getKey().equalsIgnoreCase("Square")) {
                apartment.setSquareFootage(Integer.parseInt(a.getValue()));
            } else if (a.getKey().equalsIgnoreCase("Available")){
                if (a.getValue().equalsIgnoreCase("1")){
                    apartment.setAvailable(true);
                } else if (a.getValue().equalsIgnoreCase("2")) {
                    apartment.setAvailable(false);
                }
            }else {
                System.out.println("Cannot find the apartment information");
            }
        }
        propertyDao.addApartment(apartment);
        System.out.println("The apartment has been added");
    }

    @Override
    public void addCondo(LinkedHashMap<String, String> condoInfo) throws DocumentException, IOException {
        Condo condo = (Condo) condoFactory.createProperty();
        for(Map.Entry<String, String> a : condoInfo.entrySet()) {
            if (a.getKey().equalsIgnoreCase("Street")){
                condo.setStreetName(a.getValue());
            } else if (a.getKey().equalsIgnoreCase("City")) {
                condo.setCity(a.getValue());
            } else if (a.getKey().equalsIgnoreCase("Province")) {
                condo.setProvince(a.getValue());
            } else if (a.getKey().equalsIgnoreCase("Postcode")) {
                condo.setPostCode(a.getValue());
            } else if (a.getKey().equalsIgnoreCase("UnitNumber")) {
                condo.setUnitNumber(Integer.parseInt(a.getValue()));
            } else if (a.getKey().equalsIgnoreCase("Bathroom")) {
                condo.setNumberOfBathrooms(Integer.parseInt(a.getValue()));
            } else if (a.getKey().equalsIgnoreCase("Bedroom")) {
                condo.setNumberOfBedrooms(Integer.parseInt(a.getValue()));
            } else if (a.getKey().equalsIgnoreCase("Square")) {
                condo.setSquareFootage(Integer.parseInt(a.getValue()));
            } else if (a.getKey().equalsIgnoreCase("Available")){
                if (a.getValue().equalsIgnoreCase("1")){
                    condo.setAvailable(true);
                } else if (a.getValue().equalsIgnoreCase("2")) {
                    condo.setAvailable(false);
                }
            }else if (a.getKey().equalsIgnoreCase("StreetNumber")){
                condo.setStreetNumber(a.getValue());
            }else {
                System.out.println("Cannot find the apartment information");
            }
        }
        propertyDao.addCondo(condo);
        System.out.println("The condo has been added");
    }

    @Override
    public void addHouse(LinkedHashMap<String, String> houseInfo) throws DocumentException, IOException{
        House house = (House) houseFactory.createProperty();
        for (Map.Entry<String, String> a : houseInfo.entrySet()) {
            if (a.getKey().equalsIgnoreCase("Street")) {
                house.setStreetName(a.getValue());
            } else if (a.getKey().equalsIgnoreCase("City")) {
                house.setCity(a.getValue());
            } else if (a.getKey().equalsIgnoreCase("Province")) {
                house.setProvince(a.getValue());
            } else if (a.getKey().equalsIgnoreCase("Postcode")) {
                house.setPostCode(a.getValue());
            } else if (a.getKey().equalsIgnoreCase("StreetNumber")) {
                house.setStreetNumber(a.getValue());
            } else if (a.getKey().equalsIgnoreCase("Bathroom")) {
                house.setNumberOfBathrooms(Integer.parseInt(a.getValue()));
            } else if (a.getKey().equalsIgnoreCase("Bedroom")) {
                house.setNumberOfBedrooms(Integer.parseInt(a.getValue()));
            } else if (a.getKey().equalsIgnoreCase("Square")) {
                house.setSquareFootage(Integer.parseInt(a.getValue()));
            } else if (a.getKey().equalsIgnoreCase("Available")) {
                if (a.getValue().equalsIgnoreCase("1")) {
                    house.setAvailable(true);
                } else if (a.getValue().equalsIgnoreCase("2")) {
                    house.setAvailable(false);
                }
            } else {
                System.out.println("Cannot find the apartment information");
            }
        }

        propertyDao.addHouse(house);
        System.out.println("The house has been added");
    }

    @Override
    public void displayAllApartment() throws DocumentException {
        List<Apartment> apartmentList = propertyDao.getAllApartment();
        for (Apartment a: apartmentList) {
            String id = a.getId();
            String StreetName = a.getStreetName();
            String city = a.getCity();
            String province = a.getProvince();
            String postcode = a.getPostCode();
            String unitNumber = String.valueOf(a.getUnitNumber());
            String bathroomNumber = String.valueOf(a.getNumberOfBathrooms());
            String bedroomNumber = String.valueOf(a.getNumberOfBedrooms());
            String square = String.valueOf(a.getSquareFootage());
            String available = String.valueOf(a.isAvailable());
            System.out.println(id + "\t\t" + unitNumber + " - " + StreetName + "," + city + "," + province
            + "," + postcode + "\t\t\t\t" +  bathroomNumber + "\t\t\t" + bedroomNumber + "\t\t\t" + square
            + "\t\t\t" + available);
        }
    }

    @Override
    public void displayAllCondo() throws DocumentException {
        List<Condo> condoList = propertyDao.getAllCondo();
        for (Condo a: condoList) {
            String id = a.getId();
            String StreetName = a.getStreetName();
            String city = a.getCity();
            String province = a.getProvince();
            String postcode = a.getPostCode();
            String unitNumber = String.valueOf(a.getUnitNumber());
            String bathroomNumber = String.valueOf(a.getNumberOfBathrooms());
            String bedroomNumber = String.valueOf(a.getNumberOfBedrooms());
            String square = String.valueOf(a.getSquareFootage());
            String available = String.valueOf(a.isAvailable());
            String streetNumber = a.getStreetNumber();
            System.out.println(id + "\t\t" + unitNumber + " - " + streetNumber + " " + StreetName + "," + city + "," + province
                    + "," + postcode + "\t\t\t\t" +  bathroomNumber + "\t\t\t" + bedroomNumber + "\t\t\t" + square
                    + "\t\t\t" + available);
        }
    }

    @Override
    public void displayAllHouse() throws DocumentException {
        List<House> houseList = propertyDao.getAllHouse();
        for (House a: houseList) {
            String id = a.getId();
            String StreetName = a.getStreetName();
            String city = a.getCity();
            String province = a.getProvince();
            String postcode = a.getPostCode();
            String bathroomNumber = String.valueOf(a.getNumberOfBathrooms());
            String bedroomNumber = String.valueOf(a.getNumberOfBedrooms());
            String square = String.valueOf(a.getSquareFootage());
            String available = String.valueOf(a.isAvailable());
            String streetNumber = a.getStreetNumber();
            System.out.println(id + "\t\t" + streetNumber + " " + StreetName + "," + city + "," + province
                    + "," + postcode + "\t\t\t\t" +  bathroomNumber + "\t\t\t" + bedroomNumber + "\t\t\t" + square
                    + "\t\t\t" + available);
        }
    }

    @Override
    public void displayRentedApartment() throws DocumentException {
        List<Apartment> apartmentList = propertyDao.getRentedApartment();
        for (Apartment a: apartmentList) {
            String id = a.getId();
            String StreetName = a.getStreetName();
            String city = a.getCity();
            String province = a.getProvince();
            String postcode = a.getPostCode();
            String unitNumber = String.valueOf(a.getUnitNumber());
            String bathroomNumber = String.valueOf(a.getNumberOfBathrooms());
            String bedroomNumber = String.valueOf(a.getNumberOfBedrooms());
            String square = String.valueOf(a.getSquareFootage());
            String available = "Yes";
            System.out.println(id + "\t\t" + unitNumber + " - " + StreetName + "," + city + "," + province
                    + "," + postcode + "\t\t\t\t" +  bathroomNumber + "\t\t\t" + bedroomNumber + "\t\t\t" + square
                    + "\t\t\t" + available);
        }
    }

    @Override
    public void displayRentedCondo() throws DocumentException {
        List<Condo> condoList = propertyDao.getRentedCondo();
        for (Condo a: condoList) {
            String id = a.getId();
            String StreetName = a.getStreetName();
            String city = a.getCity();
            String province = a.getProvince();
            String postcode = a.getPostCode();
            String unitNumber = String.valueOf(a.getUnitNumber());
            String bathroomNumber = String.valueOf(a.getNumberOfBathrooms());
            String bedroomNumber = String.valueOf(a.getNumberOfBedrooms());
            String square = String.valueOf(a.getSquareFootage());
            String available = "Yes";
            String streetNumber = a.getStreetNumber();
            System.out.println(id + "\t\t" + unitNumber + " - " + streetNumber + " " + StreetName + "," + city + "," + province
                    + "," + postcode + "\t\t\t\t" +  bathroomNumber + "\t\t\t" + bedroomNumber + "\t\t\t" + square
                    + "\t\t\t" + available);
        }
    }

    @Override
    public void displayRentedHouse() throws DocumentException {
        List<House> houseList = propertyDao.getRentedHouse();
        for (House a: houseList) {
            String id = a.getId();
            String StreetName = a.getStreetName();
            String city = a.getCity();
            String province = a.getProvince();
            String postcode = a.getPostCode();
            String bathroomNumber = String.valueOf(a.getNumberOfBathrooms());
            String bedroomNumber = String.valueOf(a.getNumberOfBedrooms());
            String square = String.valueOf(a.getSquareFootage());
            String available = "Yes";
            String streetNumber = a.getStreetNumber();
            System.out.println(id + "\t\t" + streetNumber + " " + StreetName + "," + city + "," + province
                    + "," + postcode + "\t\t\t\t" +  bathroomNumber + "\t\t\t" + bedroomNumber + "\t\t\t" + square
                    + "\t\t\t" + available);
        }
    }

    @Override
    public void displayVacantApartment() throws DocumentException {
        List<Apartment> apartmentList = propertyDao.getVacantApartment();
        for (Apartment a: apartmentList) {
            String id = a.getId();
            String StreetName = a.getStreetName();
            String city = a.getCity();
            String province = a.getProvince();
            String postcode = a.getPostCode();
            String unitNumber = String.valueOf(a.getUnitNumber());
            String bathroomNumber = String.valueOf(a.getNumberOfBathrooms());
            String bedroomNumber = String.valueOf(a.getNumberOfBedrooms());
            String square = String.valueOf(a.getSquareFootage());
            String available = "No";
            System.out.println(id + "\t\t" + unitNumber + " - " + StreetName + "," + city + "," + province
                    + "," + postcode + "\t\t\t\t" +  bathroomNumber + "\t\t\t" + bedroomNumber + "\t\t\t" + square
                    + "\t\t\t" + available);
        }
    }

    @Override
    public void displayVacantCondo() throws DocumentException {
        List<Condo> condoList = propertyDao.getVacantCondo();
        for (Condo a: condoList) {
            String id = a.getId();
            String StreetName = a.getStreetName();
            String city = a.getCity();
            String province = a.getProvince();
            String postcode = a.getPostCode();
            String unitNumber = String.valueOf(a.getUnitNumber());
            String bathroomNumber = String.valueOf(a.getNumberOfBathrooms());
            String bedroomNumber = String.valueOf(a.getNumberOfBedrooms());
            String square = String.valueOf(a.getSquareFootage());
            String available = "No";
            String streetNumber = a.getStreetNumber();
            System.out.println(id + "\t\t" + unitNumber + " - " + streetNumber + " " + StreetName + "," + city + "," + province
                    + "," + postcode + "\t\t\t\t" +  bathroomNumber + "\t\t\t" + bedroomNumber + "\t\t\t" + square
                    + "\t\t\t" + available);
        }
    }

    @Override
    public void displayVacantHouse() throws DocumentException {
        List<House> houseList = propertyDao.getVacantHouse();
        for (House a: houseList) {
            String id = a.getId();
            String StreetName = a.getStreetName();
            String city = a.getCity();
            String province = a.getProvince();
            String postcode = a.getPostCode();
            String bathroomNumber = String.valueOf(a.getNumberOfBathrooms());
            String bedroomNumber = String.valueOf(a.getNumberOfBedrooms());
            String square = String.valueOf(a.getSquareFootage());
            String available = "No";
            String streetNumber = a.getStreetNumber();
            System.out.println(id + "\t\t" + streetNumber + " " + StreetName + "," + city + "," + province
                    + "," + postcode + "\t\t\t\t" +  bathroomNumber + "\t\t\t" + bedroomNumber + "\t\t\t" + square
                    + "\t\t\t" + available);
        }
    }

    @Override
    public boolean addPotentialTenant(String propertyId, Integer tenantId) throws DocumentException, IOException {
        boolean addPotentialTenant = false;
        boolean findProperty = false;
        boolean findTenant = false;
        if (propertyId.startsWith("A")){
            if (propertyDao.getApartmentById(propertyId) != null){
                findProperty = true;
            }
        }else if (propertyId.startsWith("C")){
            if (propertyDao.getCondoById(propertyId) != null){
                findProperty = true;
            }
        } else if (propertyId.startsWith("H")) {
            if (propertyDao.getHouseById(propertyId) != null){
                findProperty = true;
            }
        }
        if (tenantDao.getTenantById(tenantId) != null){
            findTenant = true;
        }
        if (findProperty && findTenant){
            addPotentialTenant = propertyDao.addPotentialTenantToProperty(propertyId, tenantId);
        }else {
            System.out.println("The property ID or Tenant ID is not exist, please check");
        }
        return addPotentialTenant;
    }

    @Override
    public boolean updatePropertyAvailability(String propertyId, boolean availability) throws DocumentException, IOException {
        boolean findProperty = false;
        boolean updateIndicator = false;
        Property property = null;
        if (propertyId.startsWith("A")){
            property = propertyDao.getApartmentById(propertyId);
            if (propertyId != null){
                findProperty = true;
            }
        }else if (propertyId.startsWith("C")){
            property = propertyDao.getCondoById(propertyId);
            if (propertyId != null){
                findProperty = true;
            }
        } else if (propertyId.startsWith("H")) {
            property = propertyDao.getHouseById(propertyId);
            if (propertyId != null){
                findProperty = true;
            }
        }
        if (findProperty){
            if(property.isAvailable()){
                System.out.println("The property is already available, no need to change now!");
            }else {
                property.setAvailable(availability);
                updateIndicator = propertyDao.updateAvailabilityByPropertyId(propertyId, availability);
            }
        }else {
            System.out.println("Cannot find the property ID!");
        }
        return updateIndicator;
    }
}
