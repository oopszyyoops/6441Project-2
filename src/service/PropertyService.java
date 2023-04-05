package service;

import entity.Apartment;
import entity.Condo;
import entity.House;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.LinkedHashMap;

public interface PropertyService {
    void addApartment(LinkedHashMap<String, String> tenantInfo) throws DocumentException, IOException;
    void addCondo(LinkedHashMap<String, String> condoInfo) throws DocumentException, IOException;
    void addHouse(LinkedHashMap<String, String> condoInfo) throws DocumentException, IOException;

    void displayAllApartment() throws DocumentException;
    void displayAllCondo() throws DocumentException;
    void displayAllHouse() throws DocumentException;

    void displayRentedApartment() throws DocumentException;
    void displayRentedCondo() throws DocumentException;
    void displayRentedHouse() throws DocumentException;

    void displayVacantApartment() throws DocumentException;
    void displayVacantCondo() throws DocumentException;
    void displayVacantHouse() throws DocumentException;

    boolean addPotentialTenant(String propertyId, Integer tenantId) throws DocumentException, IOException;
    boolean updatePropertyAvailability(String propertyId, boolean availability) throws DocumentException, IOException;
}

