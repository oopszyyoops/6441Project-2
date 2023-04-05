package dao;

import entity.Apartment;
import entity.Condo;
import entity.House;
import entity.Tenant;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface PropertyDao {
    void addApartment(Apartment apartment) throws IOException, DocumentException;
    void addCondo(Condo condo) throws IOException, DocumentException;
    void addHouse(House house) throws IOException, DocumentException;
    List<Apartment> getAllApartment() throws DocumentException;
    List<Condo> getAllCondo() throws DocumentException;
    List<House> getAllHouse() throws DocumentException;

    List<Apartment> getRentedApartment() throws DocumentException;
    List<Condo> getRentedCondo() throws DocumentException;
    List<House> getRentedHouse() throws DocumentException;

    List<Apartment> getVacantApartment() throws DocumentException;
    List<Condo> getVacantCondo() throws DocumentException;
    List<House> getVacantHouse() throws DocumentException;

    Apartment getApartmentById(String apartmentId) throws DocumentException;
    Condo getCondoById(String condoId) throws DocumentException;
    House getHouseById(String houseId) throws DocumentException;

    int updateAptStatusToRent(String apartmentId) throws DocumentException, IOException;
    int updateCondoStatusToRent(String condoId) throws DocumentException, IOException;
    int updateHouseStatusToRent(String houseId) throws DocumentException, IOException;

    List<Tenant> getAllTenantByPropertyId(String propertyId) throws DocumentException;

    Boolean updateAvailabilityByPropertyId(String propertyId, boolean availability) throws DocumentException, IOException;

    Boolean addPotentialTenantToProperty(String propertyId, Integer tenantId) throws DocumentException, IOException;
}
