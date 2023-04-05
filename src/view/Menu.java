package view;


import dao.AccountingDao;
import entity.Accounting;
import org.dom4j.DocumentException;
import service.AccountingService;
import service.LeaseService;
import service.PropertyService;
import service.TenantService;
import service.impl.LeaseServiceImpl;
import service.impl.PropertyServiceImpl;
import service.impl.TenantServiceImpl;
import util.InputValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;

public class Menu {
    public static void main(String[] args) throws IOException, DocumentException, ParseException {
        PropertyService propertyService = new PropertyServiceImpl();
        TenantService tenantService = new TenantServiceImpl();
        LeaseService leaseService = new LeaseServiceImpl();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.print("******** Rental Management System **********\n");
            System.out.print("1 Add a property\n");
            System.out.print("2 Add a tenant\n");
            System.out.print("3 Rent a unit\n");
            System.out.print("4 Display properties\n");
            System.out.print("5 Display tenants\n");
            System.out.print("6 Display rented units\n");
            System.out.print("7 Display vacant units\n");
            System.out.print("8 Display all leases\n");
            System.out.print("9 Add a potential tenant to property\n");
            System.out.print("10 Enable property to be available\n");
            System.out.print("11 Accounting System\n");
            System.out.print("12 Exit\n\n");

            String choice = br.readLine();
            if (!InputValidation.isNumeric(choice)){
                System.out.println("\nInvalidate input, please input again");
            }else if (Integer.parseInt(choice)<13 && Integer.parseInt(choice)>0){
                int intChoice = Integer.parseInt(choice);
                switch (intChoice) {
                    case 1:
                        while (true){
                            System.out.print("******** Property Type **********\n");
                            System.out.print("1 Apartment\n");
                            System.out.print("2 Condo\n");
                            System.out.print("3 House\n");
                            System.out.print("4 Return main menu\n");
                            System.out.print("Please choose property type:");
                            int skipCase1Loop = 0;
                            String strTypeChoice = br.readLine();
                            if (!InputValidation.isNumeric(strTypeChoice)){
                                System.out.println("\nInvalidate input, please choose correct option");
                            }else {
                                int typeChoice = Integer.parseInt(strTypeChoice);
                                if (typeChoice > 0 && typeChoice < 5){
                                    switch (typeChoice) {
                                        case 1:
                                            LinkedHashMap<String, String> aptInfo = new LinkedHashMap<>();
                                            System.out.print("\nPlease input street name:");
                                            String streetName = br.readLine();
                                            aptInfo.put("Street", streetName);
                                            while (true){
                                                System.out.print("\nPlease input city:");
                                                String city = br.readLine();
                                                if (InputValidation.isString(city)) {
                                                    aptInfo.put("City", city);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate city name(must be string), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input Province:");
                                                String province = br.readLine();
                                                if (InputValidation.isString(province)) {
                                                    aptInfo.put("Province", province);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate province name(must be string), please input again!\n");
                                                }
                                            }
                                            System.out.print("\nPlease input post code:");
                                            String postcode = br.readLine();
                                            aptInfo.put("Postcode", postcode);
                                            while (true){
                                                System.out.print("\nPlease input unit number:");
                                                String unitNumber = br.readLine();
                                                if (InputValidation.isNumeric(unitNumber)) {
                                                    aptInfo.put("UnitNumber", unitNumber);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate unit number(must be integer), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input the number of bathroom:");
                                                String bathroomNumber = br.readLine();
                                                if (InputValidation.isNumeric(bathroomNumber)) {
                                                    aptInfo.put("Bathroom", bathroomNumber);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate input(must be integer), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input the number of bedroom:");
                                                String bedroomNumber = br.readLine();
                                                if (InputValidation.isNumeric(bedroomNumber)) {
                                                    aptInfo.put("Bedroom", bedroomNumber);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate input(must be integer), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input square footage:");
                                                String square = br.readLine();
                                                if (InputValidation.isNumeric(square)) {
                                                    aptInfo.put("Square", square);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate input(must be integer), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input availability( 1-True, 2-False ):");
                                                String isAvailable = br.readLine();
                                                if (isAvailable.equals("1")) {
                                                    aptInfo.put("Available", "1");
                                                    break;
                                                }else if (isAvailable.equals("2")){
                                                    aptInfo.put("Available", "2");
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate input(must be number 1 or 2), please input again!\n");
                                                }
                                            }
                                            propertyService.addApartment(aptInfo);
                                            break;
                                        case 2:
                                            LinkedHashMap<String, String> condoInfo = new LinkedHashMap<>();
                                            while (true){
                                                System.out.print("\nPlease input street number:");
                                                String streetNumber = br.readLine();
                                                if (InputValidation.isNumeric(streetNumber)) {
                                                    condoInfo.put("StreetNumber", streetNumber);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate street number(must be integer), please input again!\n");
                                                }
                                            }
                                            System.out.print("\nPlease input street name:");
                                            String streetNameCondo = br.readLine();
                                            condoInfo.put("Street", streetNameCondo);
                                            while (true){
                                                System.out.print("\nPlease input city:");
                                                String city = br.readLine();
                                                if (InputValidation.isString(city)) {
                                                    condoInfo.put("City", city);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate city name(must be string), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input Province:");
                                                String province = br.readLine();
                                                if (InputValidation.isString(province)) {
                                                    condoInfo.put("Province", province);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate province name(must be string), please input again!\n");
                                                }
                                            }
                                            System.out.print("\nPlease input post code:");
                                            String postcodeCondo = br.readLine();
                                            condoInfo.put("Postcode",postcodeCondo);
                                            while (true){
                                                System.out.print("\nPlease input unit number:");
                                                String unitNumber = br.readLine();
                                                if (InputValidation.isNumeric(unitNumber)) {
                                                    condoInfo.put("UnitNumber", unitNumber);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate unit number(must be integer), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input the number of bathroom:");
                                                String bathroomNumber = br.readLine();
                                                if (InputValidation.isNumeric(bathroomNumber)) {
                                                    condoInfo.put("Bathroom", bathroomNumber);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate input(must be integer), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input the number of bedroom:");
                                                String bedroomNumber = br.readLine();
                                                if (InputValidation.isNumeric(bedroomNumber)) {
                                                    condoInfo.put("Bedroom", bedroomNumber);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate input(must be integer), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input square footage:");
                                                String square = br.readLine();
                                                if (InputValidation.isNumeric(square)) {
                                                    condoInfo.put("Square", square);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate input(must be integer), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input availability( 1-True, 2-False ):");
                                                String isAvailable = br.readLine();
                                                if (isAvailable.equals("1")) {
                                                    condoInfo.put("Available", "1");
                                                    break;
                                                }else if (isAvailable.equals("2")){
                                                    condoInfo.put("Available", "2");
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate input(must be number 1 or 2), please input again!\n");
                                                }
                                            }
                                            propertyService.addCondo(condoInfo);
                                            break;
                                        case 3:
                                            LinkedHashMap<String, String> houseInfo = new LinkedHashMap<>();
                                            while (true){
                                                System.out.print("\nPlease input street number:");
                                                String streetNumber = br.readLine();
                                                if (InputValidation.isNumeric(streetNumber)) {
                                                    houseInfo.put("StreetNumber", streetNumber);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate street number(must be integer), please input again!\n");
                                                }
                                            }
                                            System.out.print("\nPlease input street name:");
                                            String streetNameHouse = br.readLine();
                                            houseInfo.put("Street", streetNameHouse);
                                            while (true){
                                                System.out.print("\nPlease input city:");
                                                String city = br.readLine();
                                                if (InputValidation.isString(city)) {
                                                    houseInfo.put("City", city);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate city name(must be string), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input Province:");
                                                String province = br.readLine();
                                                if (InputValidation.isString(province)) {
                                                    houseInfo.put("Province", province);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate province name(must be string), please input again!\n");
                                                }
                                            }
                                            System.out.print("\nPlease input post code:");
                                            String postcodeHouse = br.readLine();
                                            houseInfo.put("Postcode", postcodeHouse);
                                            while (true){
                                                System.out.print("\nPlease input the number of bathroom:");
                                                String bathroomNumber = br.readLine();
                                                if (InputValidation.isNumeric(bathroomNumber)) {
                                                    houseInfo.put("Bathroom", bathroomNumber);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate input(must be integer), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input the number of bedroom:");
                                                String bedroomNumber = br.readLine();
                                                if (InputValidation.isNumeric(bedroomNumber)) {
                                                    houseInfo.put("Bedroom", bedroomNumber);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate input(must be integer), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input square footage:");
                                                String square = br.readLine();
                                                if (InputValidation.isNumeric(square)) {
                                                    houseInfo.put("Square", square);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate input(must be integer), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input availability( 1-True, 2-False ):");
                                                String isAvailable = br.readLine();
                                                if (isAvailable.equals("1")) {
                                                    houseInfo.put("Available", "1");
                                                    break;
                                                }else if (isAvailable.equals("2")){
                                                    houseInfo.put("Available", "2");
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate input(must be number 1 or 2), please input again!\n");
                                                }
                                            }
                                            propertyService.addHouse(houseInfo);
                                            break;
                                        case 4:
                                            skipCase1Loop = 1;
                                            break;
                                    }
                                }else {
                                    System.out.println("\nInvalidate input, please choose again");
                                }
                            }
                            if (skipCase1Loop == 1){
                                break;
                            }
                        }
                        break;
                    case 2:
                        LinkedHashMap<String, String> tenantInfo = new LinkedHashMap<>();
                        System.out.print("\nPlease input full name:");
                        String fullName = br.readLine();
                        tenantInfo.put("Name", fullName);
                        while (true){
                            System.out.print("\nPlease input email address:");
                            String email = br.readLine();
                            if (InputValidation.isEmail(email)) {
                                tenantInfo.put("Email", email);
                                break;
                            }else {
                                System.out.print("\nInvalidate email address, please input again!\n");
                            }
                        }
                        while (true){
                            System.out.print("\nPlease input phone number:");
                            String phone = br.readLine();
                            if (!InputValidation.isString(phone)) {
                                tenantInfo.put("Phone", phone);
                                break;
                            }else {
                                System.out.print("\nInvalidate phone number, please input again!\n");
                            }
                        }
                        tenantService.addTenant(tenantInfo);
                        break;
                    case 3:
                        while (true){
                            System.out.print("******** Rent Unit **********\n");
                            System.out.print("1 Apartment\n");
                            System.out.print("2 Condo\n");
                            System.out.print("3 House\n");
                            System.out.print("4 Return main menu\n");
                            System.out.print("Please choose property type to rent:");
                            int skipCase3Loop = 0;
                            String strTypeChoice = br.readLine();
                            if (!InputValidation.isNumeric(strTypeChoice)){
                                System.out.println("\nInvalidate input, please choose correct option");
                            }else {
                                int typeChoice = Integer.parseInt(strTypeChoice);
                                if (typeChoice > 0 && typeChoice < 5){
                                    switch (typeChoice) {
                                        case 1:
                                            LinkedHashMap<String, String> rentalInfo = new LinkedHashMap<>();
                                            System.out.print("\nPlease input apartment id:");
                                            String apartmentId = br.readLine();
                                            rentalInfo.put("propertyId", apartmentId);
                                            while (true){
                                                System.out.print("\nPlease input tenant id:");
                                                String tenantId = br.readLine();
                                                if (InputValidation.isNumeric(tenantId)) {
                                                    rentalInfo.put("tenantId", tenantId);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate tenant id(must be integer), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input start date (yyyy/MM/dd):");
                                                String startDate = br.readLine();
                                                if (InputValidation.isDate(startDate)) {
                                                    rentalInfo.put("startDate", startDate);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate start date(must be yyyy/MM/dd), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input end date (yyyy/MM/dd):");
                                                String endDate = br.readLine();
                                                if (InputValidation.isDate(endDate)) {
                                                    rentalInfo.put("endDate", endDate);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate end date(must be yyyy/MM/dd), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input rent amount (xx.xx):");
                                                String rentAmount = br.readLine();
                                                if (InputValidation.isDecimalNumeric(rentAmount)) {
                                                    rentalInfo.put("rentAmount", rentAmount);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate unit number(must be integer), please input again!\n");
                                                }
                                            }
                                            leaseService.createApartmentLease(rentalInfo);
                                            break;
                                        case 2:
                                            LinkedHashMap<String, String> rentalInfoCondo = new LinkedHashMap<>();
                                            System.out.print("\nPlease input condo id:");
                                            String condoId = br.readLine();
                                            rentalInfoCondo.put("propertyId", condoId);
                                            while (true){
                                                System.out.print("\nPlease input tenant id:");
                                                String tenantId = br.readLine();
                                                if (InputValidation.isNumeric(tenantId)) {
                                                    rentalInfoCondo.put("tenantId", tenantId);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate tenant id(must be integer), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input start date (yyyy/MM/dd):");
                                                String startDate = br.readLine();
                                                if (InputValidation.isDate(startDate)) {
                                                    rentalInfoCondo.put("startDate", startDate);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate start date(must be yyyy/MM/dd), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input end date (yyyy/MM/dd):");
                                                String endDate = br.readLine();
                                                if (InputValidation.isDate(endDate)) {
                                                    rentalInfoCondo.put("endDate", endDate);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate end date(must be yyyy/MM/dd), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input rent amount (xx.xx):");
                                                String rentAmount = br.readLine();
                                                if (InputValidation.isDecimalNumeric(rentAmount)) {
                                                    rentalInfoCondo.put("rentAmount", rentAmount);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate unit number(must be integer), please input again!\n");
                                                }
                                            }
                                            leaseService.createCondoLease(rentalInfoCondo);
                                            break;
                                        case 3:
                                            LinkedHashMap<String, String> rentalInfoHouse = new LinkedHashMap<>();
                                            System.out.print("\nPlease input house id:");
                                            String houseId = br.readLine();
                                            rentalInfoHouse.put("propertyId", houseId);
                                            while (true){
                                                System.out.print("\nPlease input tenant id:");
                                                String tenantId = br.readLine();
                                                if (InputValidation.isNumeric(tenantId)) {
                                                    rentalInfoHouse.put("tenantId", tenantId);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate tenant id(must be integer), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input start date (yyyy/MM/dd):");
                                                String startDate = br.readLine();
                                                if (InputValidation.isDate(startDate)) {
                                                    rentalInfoHouse.put("startDate", startDate);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate start date(must be yyyy/MM/dd), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input end date (yyyy/MM/dd):");
                                                String endDate = br.readLine();
                                                if (InputValidation.isDate(endDate)) {
                                                    rentalInfoHouse.put("endDate", endDate);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate end date(must be yyyy/MM/dd), please input again!\n");
                                                }
                                            }
                                            while (true){
                                                System.out.print("\nPlease input rent amount (xx.xx):");
                                                String rentAmount = br.readLine();
                                                if (InputValidation.isDecimalNumeric(rentAmount)) {
                                                    rentalInfoHouse.put("rentAmount", rentAmount);
                                                    break;
                                                }else {
                                                    System.out.print("\nInvalidate unit number(must be integer), please input again!\n");
                                                }
                                            }
                                            leaseService.createHouseLease(rentalInfoHouse);
                                            break;
                                        case 4:
                                            skipCase3Loop = 1;
                                            break;
                                    }
                                }else {
                                    System.out.println("\nInvalidate input, please choose again");
                                }
                            }
                            if (skipCase3Loop == 1){
                                break;
                            }
                        }
                        break;
                    case 4:
                        System.out.print("************************************************* Apartment ***********************************************\n");
                        System.out.println("ID" + "\t\t" + "Address" + "\t\t\t\t\t\t\t\t\t\t\t" + "Bathroom"
                        + "\t\t" + "Bedroom" + "\t\t" + "Square" + "\t\t" + "Available");
                        propertyService.displayAllApartment();
                        System.out.print("***********************************************************************************************************\n\n");

                        System.out.print("************************************************* Condo ***************************************************\n");
                        System.out.println("ID" + "\t\t" + "Address" + "\t\t\t\t\t\t\t\t\t\t\t" + "Bathroom"
                                + "\t\t" + "Bedroom" + "\t\t" + "Square" + "\t\t" + "Available");
                        propertyService.displayAllCondo();
                        System.out.print("***********************************************************************************************************\n\n");

                        System.out.print("************************************************* House ***************************************************\n");
                        System.out.println("ID" + "\t\t" + "Address" + "\t\t\t\t\t\t\t\t\t\t\t" + "Bathroom"
                                + "\t\t" + "Bedroom" + "\t\t" + "Square" + "\t\t" + "Available");
                        propertyService.displayAllHouse();
                        System.out.print("***********************************************************************************************************\n\n");
                        break;
                    case 5:
                        System.out.print("************************************************* Tenant ***********************************************\n");
                        System.out.println("ID" + "\t\t" + "Name" + "\t\t\t\t\t\t" + "Email" + "\t\t\t\t\t\t" + "Phone No.");
                        tenantService.displayAllTenant();
                        System.out.print("***********************************************************************************************************\n\n");
                        break;
                    case 6:
                        System.out.print("************************************************* Rented Apartment ***********************************************\n");
                        System.out.println("ID" + "\t\t" + "Address" + "\t\t\t\t\t\t\t\t\t\t\t" + "Bathroom"
                                + "\t\t" + "Bedroom" + "\t\t" + "Square" + "\t\t" + "Rented");
                        propertyService.displayRentedApartment();
                        System.out.print("***********************************************************************************************************\n\n");

                        System.out.print("************************************************* Rented Condo ***************************************************\n");
                        System.out.println("ID" + "\t\t" + "Address" + "\t\t\t\t\t\t\t\t\t\t\t" + "Bathroom"
                                + "\t\t" + "Bedroom" + "\t\t" + "Square" + "\t\t" + "Rented");
                        propertyService.displayRentedCondo();
                        System.out.print("***********************************************************************************************************\n\n");

                        System.out.print("************************************************* Rented House ***************************************************\n");
                        System.out.println("ID" + "\t\t" + "Address" + "\t\t\t\t\t\t\t\t\t\t\t" + "Bathroom"
                                + "\t\t" + "Bedroom" + "\t\t" + "Square" + "\t\t" + "Rented");
                        propertyService.displayRentedHouse();
                        System.out.print("***********************************************************************************************************\n\n");
                        break;
                    case 7:
                        System.out.print("************************************************* Vacant Apartment ***********************************************\n");
                        System.out.println("ID" + "\t\t" + "Address" + "\t\t\t\t\t\t\t\t\t\t\t" + "Bathroom"
                                + "\t\t" + "Bedroom" + "\t\t" + "Square" + "\t\t" + "Rented");
                        propertyService.displayVacantApartment();
                        System.out.print("***********************************************************************************************************\n\n");

                        System.out.print("************************************************* Vacant Condo ***************************************************\n");
                        System.out.println("ID" + "\t\t" + "Address" + "\t\t\t\t\t\t\t\t\t\t\t" + "Bathroom"
                                + "\t\t" + "Bedroom" + "\t\t" + "Square" + "\t\t" + "Rented");
                        propertyService.displayVacantCondo();
                        System.out.print("***********************************************************************************************************\n\n");

                        System.out.print("************************************************* Vacant House ***************************************************\n");
                        System.out.println("ID" + "\t\t" + "Address" + "\t\t\t\t\t\t\t\t\t\t\t" + "Bathroom"
                                + "\t\t" + "Bedroom" + "\t\t" + "Square" + "\t\t" + "Rented");
                        propertyService.displayVacantHouse();
                        System.out.print("***********************************************************************************************************\n\n");
                        break;
                    case 8:
                        System.out.print("************************************************* Lease Summary ***************************************************\n");
                        System.out.println("Lease ID" + "\t" + "Tenant ID" + "\t" + "Tenant name" + "\t\t" + "Tenant Email" + "\t\t" +
                                "Tenant Phone" + "\t" + "Property ID" + "\t\t" + "Address" + "\t\t\t\t\t\t\t" + "Start date" + "\t\t\t" +
                                "EndDate" + "\t\t\t" + "RentAmount");
                        leaseService.displayAllLease();
                        System.out.print("*******************************************************************************************************************\n");
                        break;
                    case 9:
                        int tenantId;
                        while (true){
                            System.out.print("\nPlease input tenant ID:");
                            String strTenantId = br.readLine();
                            if (InputValidation.isNumeric(strTenantId)) {
                                tenantId = Integer.parseInt(strTenantId);
                                break;
                            }else {
                                System.out.print("\nInvalidate tenant ID, please input again!\n");
                            }
                        }
                        System.out.print("\nPlease input property ID:");
                        String propertyId = br.readLine();
                        boolean addCheck = propertyService.addPotentialTenant(propertyId, tenantId);
                        if (addCheck){
                            System.out.println("The potential tenant has been added into the property");
                        }else {
                            System.out.println("Failed to add potential tenant");
                        }
                        break;
                    case 10:
                        System.out.print("\nPlease input property ID:");
                        String strPropertyId = br.readLine();
                        boolean addChangeCheck = propertyService.updatePropertyAvailability(strPropertyId, true);
                        if (addChangeCheck){
                            System.out.println("Updated successfully");
                        }else {
                            System.out.println("Failed to update");
                        }
                        break;
                    case 11:
                        while (true){
                            System.out.print("******** Accounting System **********\n");
                            System.out.print("1 Change payment to paid\n");
                            System.out.print("2 Change payment to unpaid\n");
                            System.out.print("3 Display paid list\n");
                            System.out.print("4 Display unpaid list\n");
                            System.out.print("5 return to main menu\n");
                            System.out.print("Please choose option:");
                            int skipCase1Loop = 0;
                            String strTypeChoice = br.readLine();
                            if (!InputValidation.isNumeric(strTypeChoice)){
                                System.out.println("\nInvalidate input, please choose correct option");
                            }else {
                                int typeChoice = Integer.parseInt(strTypeChoice);
                                if (typeChoice > 0 && typeChoice < 6){
                                    switch (typeChoice) {
                                        case 1:
                                            System.out.print("\nPlease input lease ID:");
                                            String leaseId = br.readLine();
                                            boolean changeCheck = AccountingService.getInstance().makePayment(leaseId, "Yes");
                                            if (changeCheck){
                                                System.out.println("Payment has been updated");
                                            }else {
                                                System.out.println("Failed to update");
                                            }
                                            break;
                                        case 2:
                                            System.out.print("\nPlease input lease ID:");
                                            String leaseIdNoPaid = br.readLine();
                                            boolean changeCheckNoPaid = AccountingService.getInstance().makePayment(leaseIdNoPaid, "No");
                                            if (changeCheckNoPaid){
                                                System.out.println("Payment has been updated");
                                            }else {
                                                System.out.println("Failed to update");
                                            }
                                            break;
                                        case 3:
                                            List<Accounting> paidList = AccountingService.getInstance().getPaidList();
                                            System.out.print("************************************************* Paid Summary ***************************************************\n");
                                            System.out.println("Lease ID" + "\t\t" + "Tenant ID" + "\t\t" + "Tenant name" + "\t\t" + "Tenant Email" +
                                                    "\t\t" + "Property ID" + "\t\t" + "isPaid" );
                                            if (paidList != null){
                                                for (Accounting accounting : paidList) {
                                                    System.out.println(accounting.getLeaseId() + "\t\t\t\t\t" + accounting.getTenantId()
                                                            + "\t\t\t" + accounting.getTenantName() + "\t\t" + accounting.getTenantEmail() +
                                                            "\t\t" + accounting.getPropertyId() + "\t\t\t\t" + accounting.getIsPaid() );
                                                }
                                            }else {
                                                System.out.println("No paid info");
                                            }
                                            System.out.print("*******************************************************************************************************************\n");
                                            break;
                                        case 4:
                                            List<Accounting> unpaidList = AccountingService.getInstance().getUnpaidList();
                                            System.out.print("************************************************* Unpaid Summary ***************************************************\n");
                                            System.out.println("Lease ID" + "\t\t" + "Tenant ID" + "\t\t" + "Tenant name" + "\t\t" + "Tenant Email" +
                                                    "\t\t" + "Property ID" + "\t\t" + "isPaid" );
                                            if (unpaidList != null){
                                                for (Accounting accounting : unpaidList) {
                                                    System.out.println(accounting.getLeaseId() + "\t\t\t\t\t" + accounting.getTenantId()
                                                            + "\t\t\t" + accounting.getTenantName() + "\t\t" + accounting.getTenantEmail() +
                                                            "\t\t" + accounting.getPropertyId() + "\t\t\t\t" + accounting.getIsPaid() );
                                                }
                                            }else {
                                                System.out.println("No unpaid info");
                                            }
                                            System.out.print("*******************************************************************************************************************\n");
                                            break;
                                        case 5:
                                            skipCase1Loop = 1;
                                            break;
                                    }
                                }else {
                                    System.out.println("\nInvalidate input, please choose again");
                                }
                            }
                            if (skipCase1Loop == 1){
                                break;
                            }
                        }
                        break;
                    case 12:
                        System.exit(0);
                        break;
                }
            }else {
                System.out.println("\nInvalidate input, please input again");
            }

        }
    }
}
