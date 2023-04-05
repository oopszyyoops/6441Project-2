package service;

import entity.Lease;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashMap;

public interface LeaseService {
    void createApartmentLease(LinkedHashMap<String, String> rentalInfo) throws DocumentException, ParseException, IOException;
    void createCondoLease(LinkedHashMap<String, String> rentalInfo) throws DocumentException, ParseException, IOException;
    void createHouseLease(LinkedHashMap<String, String> rentalInfo) throws DocumentException, ParseException, IOException;

    void displayAllLease() throws DocumentException;

    Lease getLeaseById(Integer leaseId);
}
