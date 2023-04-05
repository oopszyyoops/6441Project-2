package dao;

import entity.Lease;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;

public interface LeaseDao {
    void addApartmentLease(Lease apartmentLease) throws DocumentException, IOException, ParseException;
    void addCondoLease(Lease condoLease) throws DocumentException, IOException, ParseException;

    void addHouseLease(Lease houseLease) throws DocumentException, IOException, ParseException;
    int getNodeCount(String fileName) throws DocumentException;
    List<LinkedHashMap<String, String>> getAllLease() throws DocumentException;;

    Lease getLeaseById(Integer leaseId) throws DocumentException;
}
