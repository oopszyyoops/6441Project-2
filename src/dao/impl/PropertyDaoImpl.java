package dao.impl;

import dao.PropertyDao;
import dao.TenantDao;
import entity.*;
import entity.propertyfactory.ApartmentFactory;
import entity.propertyfactory.CondoFactory;
import entity.propertyfactory.HouseFactory;
import entity.propertyfactory.PropertyFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PropertyDaoImpl implements PropertyDao {

    public static Document propertyDocument;
    public void loadMockData(String fileName) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        propertyDocument = saxReader.read(fileName);
    }

    PropertyFactory apartmentFactory = new ApartmentFactory();
    PropertyFactory condoFactory = new CondoFactory();
    PropertyFactory houseFactory = new HouseFactory();

    TenantDao tenantDao = new TenantDaoImpl();
    @Override
    public void addApartment(Apartment apt) throws IOException, DocumentException {
        String dataPath = "mockdata/apartment.xml";
        loadMockData(dataPath);
        int currentNodeCount = this.getNodeCount(dataPath);
        Element rootElement = propertyDocument.getRootElement();
        Element primaryElement = rootElement.addElement("Apartment");
        String apartmentId = "A" + (currentNodeCount+1);
        primaryElement.addAttribute("id", apartmentId);
        primaryElement.addElement("Street").addText(apt.getStreetName());
        primaryElement.addElement("City").addText(apt.getCity());
        primaryElement.addElement("Province").addText(apt.getProvince());
        primaryElement.addElement("PostCode").addText(apt.getPostCode());
        primaryElement.addElement("UnitNumber").addText(String.valueOf(apt.getUnitNumber()));
        primaryElement.addElement("Bathroom").addText(String.valueOf(apt.getNumberOfBathrooms()));
        primaryElement.addElement("Bedroom").addText(String.valueOf(apt.getNumberOfBedrooms()));
        primaryElement.addElement("Square").addText(String.valueOf(apt.getSquareFootage()));
        primaryElement.addElement("Available").addText(String.valueOf(apt.isAvailable()));
        if (apt.getTenants() != null){
            Element elementTenants = primaryElement.addElement("Tenants");
            for (Tenant t : apt.getTenants()){
                elementTenants.addElement("TenantId").addText(String.valueOf(t.getId()));
            }
        }
        saveInfo(dataPath);
    }

    @Override
    public void addCondo(Condo condo) throws IOException, DocumentException {
        String dataPath = "mockdata/condo.xml";
        loadMockData(dataPath);
        int currentNodeCount = this.getNodeCount(dataPath);
        Element rootElement = propertyDocument.getRootElement();
        Element primaryElement = rootElement.addElement("Condo");
        String condoId = "C" + (currentNodeCount+1);
        primaryElement.addAttribute("id", condoId);
        primaryElement.addElement("StreetNumber").addText(condo.getStreetNumber());
        primaryElement.addElement("Street").addText(condo.getStreetName());
        primaryElement.addElement("City").addText(condo.getCity());
        primaryElement.addElement("Province").addText(condo.getProvince());
        primaryElement.addElement("PostCode").addText(condo.getPostCode());
        primaryElement.addElement("UnitNumber").addText(String.valueOf(condo.getUnitNumber()));
        primaryElement.addElement("Bathroom").addText(String.valueOf(condo.getNumberOfBathrooms()));
        primaryElement.addElement("Bedroom").addText(String.valueOf(condo.getNumberOfBedrooms()));
        primaryElement.addElement("Square").addText(String.valueOf(condo.getSquareFootage()));
        primaryElement.addElement("Available").addText(String.valueOf(condo.isAvailable()));
        if (condo.getTenants() != null){
            Element elementTenants = primaryElement.addElement("Tenants");
            for (Tenant t : condo.getTenants()){
                elementTenants.addElement("TenantId").addText(String.valueOf(t.getId()));
            }
        }
        saveInfo(dataPath);
    }

    @Override
    public void addHouse(House house) throws IOException, DocumentException {
        String dataPath = "mockdata/house.xml";
        loadMockData(dataPath);
        int currentNodeCount = this.getNodeCount(dataPath);
        Element rootElement = propertyDocument.getRootElement();
        Element primaryElement = rootElement.addElement("House");
        String houseId = "H" + (currentNodeCount+1);
        primaryElement.addAttribute("id", houseId);
        primaryElement.addElement("StreetNumber").addText(house.getStreetNumber());
        primaryElement.addElement("Street").addText(house.getStreetName());
        primaryElement.addElement("City").addText(house.getCity());
        primaryElement.addElement("Province").addText(house.getProvince());
        primaryElement.addElement("PostCode").addText(house.getPostCode());
        primaryElement.addElement("Bathroom").addText(String.valueOf(house.getNumberOfBathrooms()));
        primaryElement.addElement("Bedroom").addText(String.valueOf(house.getNumberOfBedrooms()));
        primaryElement.addElement("Square").addText(String.valueOf(house.getSquareFootage()));
        primaryElement.addElement("Available").addText(String.valueOf(house.isAvailable()));
        if (house.getTenants() != null){
            Element elementTenants = primaryElement.addElement("Tenants");
            for (Tenant t : house.getTenants()){
                elementTenants.addElement("TenantId").addText(String.valueOf(t.getId()));
            }
        }
        saveInfo(dataPath);
    }

    @Override
    public List<Apartment> getAllApartment() throws DocumentException {
        String dataPath = "mockdata/apartment.xml";
        loadMockData(dataPath);
        List<Apartment> apartmentList = new ArrayList<>();
        Element rootElement = propertyDocument.getRootElement();
        Iterator iteratorPrimary = rootElement.elementIterator();
        while (iteratorPrimary.hasNext()){
            Apartment apartment = (Apartment) apartmentFactory.createProperty();
            Element elementChild = (Element) iteratorPrimary.next();
            String elementName = elementChild.getName();
            String elementAttribute = elementChild.attributeValue("id");
            apartment.setId(elementAttribute);
            Iterator iteratorChild = elementChild.elementIterator();
            while (iteratorChild.hasNext()){
                Element element = (Element) iteratorChild.next();
                if (element.getName().equalsIgnoreCase("Street")){
                    apartment.setStreetName(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("City")){
                    apartment.setCity(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("Province")){
                    apartment.setProvince(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("PostCode")){
                    apartment.setPostCode(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("UnitNumber")){
                    apartment.setUnitNumber(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Bathroom")){
                    apartment.setNumberOfBathrooms(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Bedroom")){
                    apartment.setNumberOfBedrooms(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Square")){
                    apartment.setSquareFootage(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Available")){
                    if (element.getTextTrim().equalsIgnoreCase("true")){
                        apartment.setAvailable(true);
                    }
                    if (element.getTextTrim().equalsIgnoreCase("false")){
                        apartment.setAvailable(false);
                    }
                }
            }
            apartmentList.add(apartment);
        }
        return apartmentList;
    }

    @Override
    public List<Condo> getAllCondo() throws DocumentException {
        String dataPath = "mockdata/condo.xml";
        loadMockData(dataPath);
        List<Condo> condoList = new ArrayList<>();
        Element rootElement = propertyDocument.getRootElement();
        Iterator iteratorPrimary = rootElement.elementIterator();
        while (iteratorPrimary.hasNext()){
            Condo condo = (Condo) condoFactory.createProperty();
            Element elementChild = (Element) iteratorPrimary.next();
            String elementName = elementChild.getName();
            String elementAttribute = elementChild.attributeValue("id");
            condo.setId(elementAttribute);
            Iterator iteratorChild = elementChild.elementIterator();
            while (iteratorChild.hasNext()){
                Element element = (Element) iteratorChild.next();
                if (element.getName().equalsIgnoreCase("Street")){
                    condo.setStreetName(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("City")){
                    condo.setCity(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("Province")){
                    condo.setProvince(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("PostCode")){
                    condo.setPostCode(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("UnitNumber")){
                    condo.setUnitNumber(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Bathroom")){
                    condo.setNumberOfBathrooms(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Bedroom")){
                    condo.setNumberOfBedrooms(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Square")){
                    condo.setSquareFootage(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Available")){
                    if (element.getTextTrim().equalsIgnoreCase("true")){
                        condo.setAvailable(true);
                    }
                    if (element.getTextTrim().equalsIgnoreCase("false")){
                        condo.setAvailable(false);
                    }
                }else if (element.getName().equalsIgnoreCase("StreetNumber")){
                    condo.setStreetNumber(element.getTextTrim());
                }
            }
            condoList.add(condo);
        }
        return condoList;
    }

    @Override
    public List<House> getAllHouse() throws DocumentException {
        String dataPath = "mockdata/house.xml";
        loadMockData(dataPath);
        List<House> houseList = new ArrayList<>();
        Element rootElement = propertyDocument.getRootElement();
        Iterator iteratorPrimary = rootElement.elementIterator();
        while (iteratorPrimary.hasNext()){
            House house = (House) houseFactory.createProperty();
            Element elementChild = (Element) iteratorPrimary.next();
            String elementName = elementChild.getName();
            String elementAttribute = elementChild.attributeValue("id");
            house.setId(elementAttribute);
            Iterator iteratorChild = elementChild.elementIterator();
            while (iteratorChild.hasNext()){
                Element element = (Element) iteratorChild.next();
                if (element.getName().equalsIgnoreCase("Street")){
                    house.setStreetName(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("City")){
                    house.setCity(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("Province")){
                    house.setProvince(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("PostCode")){
                    house.setPostCode(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("Bathroom")){
                    house.setNumberOfBathrooms(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Bedroom")){
                    house.setNumberOfBedrooms(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Square")){
                    house.setSquareFootage(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Available")){
                    if (element.getTextTrim().equalsIgnoreCase("true")){
                        house.setAvailable(true);
                    }
                    if (element.getTextTrim().equalsIgnoreCase("false")){
                        house.setAvailable(false);
                    }
                }else if (element.getName().equalsIgnoreCase("StreetNumber")){
                    house.setStreetNumber(element.getTextTrim());
                }
            }
            houseList.add(house);
        }
        return houseList;
    }

    @Override
    public List<Apartment> getRentedApartment() throws DocumentException {
        String dataPath = "mockdata/apartment.xml";
        loadMockData(dataPath);
        List<Apartment> apartmentList = new ArrayList<>();
        Element rootElement = propertyDocument.getRootElement();
        Iterator iteratorPrimary = rootElement.elementIterator();
        while (iteratorPrimary.hasNext()){
            Apartment apartment = (Apartment) apartmentFactory.createProperty();
            Element elementChild = (Element) iteratorPrimary.next();
            String elementName = elementChild.getName();
            String elementAttribute = elementChild.attributeValue("id");
            apartment.setId(elementAttribute);
            Iterator iteratorChild = elementChild.elementIterator();
            while (iteratorChild.hasNext()){
                Element element = (Element) iteratorChild.next();
                if (element.getName().equalsIgnoreCase("Street")){
                    apartment.setStreetName(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("City")){
                    apartment.setCity(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("Province")){
                    apartment.setProvince(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("PostCode")){
                    apartment.setPostCode(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("UnitNumber")){
                    apartment.setUnitNumber(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Bathroom")){
                    apartment.setNumberOfBathrooms(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Bedroom")){
                    apartment.setNumberOfBedrooms(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Square")){
                    apartment.setSquareFootage(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Available")){
                    if (element.getTextTrim().equalsIgnoreCase("true")){
                        apartment.setAvailable(true);
                    }
                    if (element.getTextTrim().equalsIgnoreCase("false")){
                        apartment.setAvailable(false);
                    }
                }
            }
            if (!apartment.isAvailable()){
                apartmentList.add(apartment);
            }
        }
        return apartmentList;
    }

    @Override
    public List<Condo> getRentedCondo() throws DocumentException {
        String dataPath = "mockdata/condo.xml";
        loadMockData(dataPath);
        List<Condo> condoList = new ArrayList<>();
        Element rootElement = propertyDocument.getRootElement();
        Iterator iteratorPrimary = rootElement.elementIterator();
        while (iteratorPrimary.hasNext()){
            Condo condo = (Condo) condoFactory.createProperty();
            Element elementChild = (Element) iteratorPrimary.next();
            String elementName = elementChild.getName();
            String elementAttribute = elementChild.attributeValue("id");
            condo.setId(elementAttribute);
            Iterator iteratorChild = elementChild.elementIterator();
            while (iteratorChild.hasNext()){
                Element element = (Element) iteratorChild.next();
                if (element.getName().equalsIgnoreCase("Street")){
                    condo.setStreetName(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("City")){
                    condo.setCity(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("Province")){
                    condo.setProvince(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("PostCode")){
                    condo.setPostCode(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("UnitNumber")){
                    condo.setUnitNumber(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Bathroom")){
                    condo.setNumberOfBathrooms(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Bedroom")){
                    condo.setNumberOfBedrooms(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Square")){
                    condo.setSquareFootage(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Available")){
                    if (element.getTextTrim().equalsIgnoreCase("true")){
                        condo.setAvailable(true);
                    }
                    if (element.getTextTrim().equalsIgnoreCase("false")){
                        condo.setAvailable(false);
                    }
                }else if (element.getName().equalsIgnoreCase("StreetNumber")){
                    condo.setStreetNumber(element.getTextTrim());
                }
            }
            if (!condo.isAvailable()){
                condoList.add(condo);
            }
        }
        return condoList;
    }

    @Override
    public List<House> getRentedHouse() throws DocumentException {
        String dataPath = "mockdata/house.xml";
        loadMockData(dataPath);
        List<House> houseList = new ArrayList<>();
        Element rootElement = propertyDocument.getRootElement();
        Iterator iteratorPrimary = rootElement.elementIterator();
        while (iteratorPrimary.hasNext()){
            House house = (House) houseFactory.createProperty();
            Element elementChild = (Element) iteratorPrimary.next();
            String elementName = elementChild.getName();
            String elementAttribute = elementChild.attributeValue("id");
            house.setId(elementAttribute);
            Iterator iteratorChild = elementChild.elementIterator();
            while (iteratorChild.hasNext()){
                Element element = (Element) iteratorChild.next();
                if (element.getName().equalsIgnoreCase("Street")){
                    house.setStreetName(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("City")){
                    house.setCity(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("Province")){
                    house.setProvince(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("PostCode")){
                    house.setPostCode(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("Bathroom")){
                    house.setNumberOfBathrooms(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Bedroom")){
                    house.setNumberOfBedrooms(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Square")){
                    house.setSquareFootage(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Available")){
                    if (element.getTextTrim().equalsIgnoreCase("true")){
                        house.setAvailable(true);
                    }
                    if (element.getTextTrim().equalsIgnoreCase("false")){
                        house.setAvailable(false);
                    }
                }else if (element.getName().equalsIgnoreCase("StreetNumber")){
                    house.setStreetNumber(element.getTextTrim());
                }
            }
            if (!house.isAvailable()){
                houseList.add(house);
            }
        }
        return houseList;
    }

    @Override
    public List<Apartment> getVacantApartment() throws DocumentException {
        String dataPath = "mockdata/apartment.xml";
        loadMockData(dataPath);
        List<Apartment> apartmentList = new ArrayList<>();
        Element rootElement = propertyDocument.getRootElement();
        Iterator iteratorPrimary = rootElement.elementIterator();
        while (iteratorPrimary.hasNext()){
            Apartment apartment = (Apartment) apartmentFactory.createProperty();
            Element elementChild = (Element) iteratorPrimary.next();
            String elementName = elementChild.getName();
            String elementAttribute = elementChild.attributeValue("id");
            apartment.setId(elementAttribute);
            Iterator iteratorChild = elementChild.elementIterator();
            while (iteratorChild.hasNext()){
                Element element = (Element) iteratorChild.next();
                if (element.getName().equalsIgnoreCase("Street")){
                    apartment.setStreetName(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("City")){
                    apartment.setCity(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("Province")){
                    apartment.setProvince(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("PostCode")){
                    apartment.setPostCode(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("UnitNumber")){
                    apartment.setUnitNumber(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Bathroom")){
                    apartment.setNumberOfBathrooms(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Bedroom")){
                    apartment.setNumberOfBedrooms(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Square")){
                    apartment.setSquareFootage(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Available")){
                    if (element.getTextTrim().equalsIgnoreCase("true")){
                        apartment.setAvailable(true);
                    }
                    if (element.getTextTrim().equalsIgnoreCase("false")){
                        apartment.setAvailable(false);
                    }
                }
            }
            if (apartment.isAvailable()){
                apartmentList.add(apartment);
            }
        }
        return apartmentList;
    }

    @Override
    public List<Condo> getVacantCondo() throws DocumentException {
        String dataPath = "mockdata/condo.xml";
        loadMockData(dataPath);
        List<Condo> condoList = new ArrayList<>();
        Element rootElement = propertyDocument.getRootElement();
        Iterator iteratorPrimary = rootElement.elementIterator();
        while (iteratorPrimary.hasNext()){
            Condo condo = (Condo) condoFactory.createProperty();
            Element elementChild = (Element) iteratorPrimary.next();
            String elementName = elementChild.getName();
            String elementAttribute = elementChild.attributeValue("id");
            condo.setId(elementAttribute);
            Iterator iteratorChild = elementChild.elementIterator();
            while (iteratorChild.hasNext()){
                Element element = (Element) iteratorChild.next();
                if (element.getName().equalsIgnoreCase("Street")){
                    condo.setStreetName(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("City")){
                    condo.setCity(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("Province")){
                    condo.setProvince(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("PostCode")){
                    condo.setPostCode(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("UnitNumber")){
                    condo.setUnitNumber(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Bathroom")){
                    condo.setNumberOfBathrooms(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Bedroom")){
                    condo.setNumberOfBedrooms(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Square")){
                    condo.setSquareFootage(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Available")){
                    if (element.getTextTrim().equalsIgnoreCase("true")){
                        condo.setAvailable(true);
                    }
                    if (element.getTextTrim().equalsIgnoreCase("false")){
                        condo.setAvailable(false);
                    }
                }else if (element.getName().equalsIgnoreCase("StreetNumber")){
                    condo.setStreetNumber(element.getTextTrim());
                }
            }
            if (condo.isAvailable()){
                condoList.add(condo);
            }
        }
        return condoList;
    }

    @Override
    public List<House> getVacantHouse() throws DocumentException {
        String dataPath = "mockdata/house.xml";
        loadMockData(dataPath);
        List<House> houseList = new ArrayList<>();
        Element rootElement = propertyDocument.getRootElement();
        Iterator iteratorPrimary = rootElement.elementIterator();
        while (iteratorPrimary.hasNext()){
            House house = (House) houseFactory.createProperty();
            Element elementChild = (Element) iteratorPrimary.next();
            String elementName = elementChild.getName();
            String elementAttribute = elementChild.attributeValue("id");
            house.setId(elementAttribute);
            Iterator iteratorChild = elementChild.elementIterator();
            while (iteratorChild.hasNext()){
                Element element = (Element) iteratorChild.next();
                if (element.getName().equalsIgnoreCase("Street")){
                    house.setStreetName(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("City")){
                    house.setCity(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("Province")){
                    house.setProvince(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("PostCode")){
                    house.setPostCode(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("Bathroom")){
                    house.setNumberOfBathrooms(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Bedroom")){
                    house.setNumberOfBedrooms(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Square")){
                    house.setSquareFootage(Integer.parseInt(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("Available")){
                    if (element.getTextTrim().equalsIgnoreCase("true")){
                        house.setAvailable(true);
                    }
                    if (element.getTextTrim().equalsIgnoreCase("false")){
                        house.setAvailable(false);
                    }
                }else if (element.getName().equalsIgnoreCase("StreetNumber")){
                    house.setStreetNumber(element.getTextTrim());
                }
            }
            if (house.isAvailable()){
                houseList.add(house);
            }
        }
        return houseList;
    }

    @Override
    public Apartment getApartmentById(String apartmentId) throws DocumentException {
        String dataPath = "mockdata/apartment.xml";
        loadMockData(dataPath);
        Element rootElement = propertyDocument.getRootElement();
        Iterator iteratorPrimary = rootElement.elementIterator();
        Apartment apartment = new Apartment();
        while (iteratorPrimary.hasNext()){
            Element elementChild = (Element) iteratorPrimary.next();
            String elementAttribute = elementChild.attributeValue("id");
            if (elementAttribute.equalsIgnoreCase(String.valueOf(apartmentId))){
                apartment.setId(apartmentId);
                Iterator iteratorChild = elementChild.elementIterator();
                while (iteratorChild.hasNext()){
                    Element element = (Element) iteratorChild.next();
                    if (element.getName().equalsIgnoreCase("Street")){
                        apartment.setStreetName(element.getTextTrim());
                    }else if (element.getName().equalsIgnoreCase("City")){
                        apartment.setCity(element.getTextTrim());
                    }else if (element.getName().equalsIgnoreCase("Province")){
                        apartment.setProvince(element.getTextTrim());
                    }else if (element.getName().equalsIgnoreCase("PostCode")){
                        apartment.setPostCode(element.getTextTrim());
                    }else if (element.getName().equalsIgnoreCase("UnitNumber")){
                        apartment.setUnitNumber(Integer.parseInt(element.getTextTrim()));
                    }else if (element.getName().equalsIgnoreCase("Bathroom")){
                        apartment.setNumberOfBathrooms(Integer.parseInt(element.getTextTrim()));
                    }else if (element.getName().equalsIgnoreCase("Bedroom")){
                        apartment.setNumberOfBedrooms(Integer.parseInt(element.getTextTrim()));
                    }else if (element.getName().equalsIgnoreCase("Square")){
                        apartment.setSquareFootage(Integer.parseInt(element.getTextTrim()));
                    }else if (element.getName().equalsIgnoreCase("Available")){
                        if (element.getTextTrim().equalsIgnoreCase("true")){
                            apartment.setAvailable(true);
                        }
                        if (element.getTextTrim().equalsIgnoreCase("false")){
                            apartment.setAvailable(false);
                        }
                    }
                }
            }
        }
        List<Tenant> tenantList = getAllTenantByPropertyId(apartmentId);
        apartment.setTenants(tenantList);
        return apartment;
    }

    @Override
    public Condo getCondoById(String condoId) throws DocumentException {
        String dataPath = "mockdata/condo.xml";
        loadMockData(dataPath);
        Element rootElement = propertyDocument.getRootElement();
        Iterator iteratorPrimary = rootElement.elementIterator();
        Condo condo = new Condo();
        while (iteratorPrimary.hasNext()){
            Element elementChild = (Element) iteratorPrimary.next();
            String elementAttribute = elementChild.attributeValue("id");
            if (elementAttribute.equalsIgnoreCase(String.valueOf(condoId))){
                condo.setId(condoId);
                Iterator iteratorChild = elementChild.elementIterator();
                while (iteratorChild.hasNext()){
                    Element element = (Element) iteratorChild.next();
                    if (element.getName().equalsIgnoreCase("Street")){
                        condo.setStreetName(element.getTextTrim());
                    }else if (element.getName().equalsIgnoreCase("City")){
                        condo.setCity(element.getTextTrim());
                    }else if (element.getName().equalsIgnoreCase("Province")){
                        condo.setProvince(element.getTextTrim());
                    }else if (element.getName().equalsIgnoreCase("PostCode")){
                        condo.setPostCode(element.getTextTrim());
                    }else if (element.getName().equalsIgnoreCase("UnitNumber")){
                        condo.setUnitNumber(Integer.parseInt(element.getTextTrim()));
                    }else if (element.getName().equalsIgnoreCase("Bathroom")){
                        condo.setNumberOfBathrooms(Integer.parseInt(element.getTextTrim()));
                    }else if (element.getName().equalsIgnoreCase("Bedroom")){
                        condo.setNumberOfBedrooms(Integer.parseInt(element.getTextTrim()));
                    }else if (element.getName().equalsIgnoreCase("Square")){
                        condo.setSquareFootage(Integer.parseInt(element.getTextTrim()));
                    }else if (element.getName().equalsIgnoreCase("Available")){
                        if (element.getTextTrim().equalsIgnoreCase("true")){
                            condo.setAvailable(true);
                        }
                        if (element.getTextTrim().equalsIgnoreCase("false")){
                            condo.setAvailable(false);
                        }
                    }
                }
            }
        }
        List<Tenant> tenantList = getAllTenantByPropertyId(condoId);
        condo.setTenants(tenantList);
        return condo;
    }

    @Override
    public House getHouseById(String houseId) throws DocumentException {
        String dataPath = "mockdata/house.xml";
        loadMockData(dataPath);
        Element rootElement = propertyDocument.getRootElement();
        Iterator iteratorPrimary = rootElement.elementIterator();
        House house = new House();
        while (iteratorPrimary.hasNext()){
            Element elementChild = (Element) iteratorPrimary.next();
            String elementAttribute = elementChild.attributeValue("id");
            if (elementAttribute.equalsIgnoreCase(String.valueOf(houseId))){
                house.setId(houseId);
                Iterator iteratorChild = elementChild.elementIterator();
                while (iteratorChild.hasNext()){
                    Element element = (Element) iteratorChild.next();
                    if (element.getName().equalsIgnoreCase("Street")){
                        house.setStreetName(element.getTextTrim());
                    }else if (element.getName().equalsIgnoreCase("City")){
                        house.setCity(element.getTextTrim());
                    }else if (element.getName().equalsIgnoreCase("Province")){
                        house.setProvince(element.getTextTrim());
                    }else if (element.getName().equalsIgnoreCase("PostCode")){
                        house.setPostCode(element.getTextTrim());
                    }else if (element.getName().equalsIgnoreCase("Bathroom")){
                        house.setNumberOfBathrooms(Integer.parseInt(element.getTextTrim()));
                    }else if (element.getName().equalsIgnoreCase("Bedroom")){
                        house.setNumberOfBedrooms(Integer.parseInt(element.getTextTrim()));
                    }else if (element.getName().equalsIgnoreCase("Square")){
                        house.setSquareFootage(Integer.parseInt(element.getTextTrim()));
                    }else if (element.getName().equalsIgnoreCase("Available")){
                        if (element.getTextTrim().equalsIgnoreCase("true")){
                            house.setAvailable(true);
                        }
                        if (element.getTextTrim().equalsIgnoreCase("false")){
                            house.setAvailable(false);
                        }
                    }
                }
            }
        }
        List<Tenant> tenantList = getAllTenantByPropertyId(houseId);
        house.setTenants(tenantList);
        return house;
    }

    @Override
    public int updateAptStatusToRent(String apartmentId) throws DocumentException, IOException {
        String dataPath = "mockdata/apartment.xml";
        loadMockData(dataPath);
        Element rootElement = propertyDocument.getRootElement();
        Iterator iteratorRoot = rootElement.elementIterator();
        int updateIndicator = 0;
        while (iteratorRoot.hasNext()){
            Element elementPrimaryChild = (Element) iteratorRoot.next();
            if (apartmentId.equalsIgnoreCase(elementPrimaryChild.attributeValue("id"))){
                Iterator iteratorSecondChild = elementPrimaryChild.elementIterator();
                while (iteratorSecondChild.hasNext()){
                    Element element = (Element) iteratorSecondChild.next();
                    if (element.getName().equalsIgnoreCase("Available")){
                        if (element.getTextTrim().equalsIgnoreCase("true")) {
                            element.setText("false");
                            saveInfo(dataPath);
                            updateIndicator = 1;
                        }
                    }
                }
            }
        }
        return updateIndicator;
    }

    @Override
    public int updateCondoStatusToRent(String condoId) throws DocumentException, IOException {
        String dataPath = "mockdata/condo.xml";
        loadMockData(dataPath);
        Element rootElement = propertyDocument.getRootElement();
        Iterator iteratorRoot = rootElement.elementIterator();
        int updateIndicator = 0;
        while (iteratorRoot.hasNext()){
            Element elementPrimaryChild = (Element) iteratorRoot.next();
            if (condoId.equalsIgnoreCase(elementPrimaryChild.attributeValue("id"))){
                Iterator iteratorSecondChild = elementPrimaryChild.elementIterator();
                while (iteratorSecondChild.hasNext()){
                    Element element = (Element) iteratorSecondChild.next();
                    if (element.getName().equalsIgnoreCase("Available")){
                        if (element.getTextTrim().equalsIgnoreCase("true")) {
                            element.setText("false");
                            saveInfo(dataPath);
                            updateIndicator = 1;
                        }
                    }
                }
            }
        }
        return updateIndicator;
    }

    @Override
    public int updateHouseStatusToRent(String houseId) throws DocumentException, IOException {
        String dataPath = "mockdata/house.xml";
        loadMockData(dataPath);
        Element rootElement = propertyDocument.getRootElement();
        Iterator iteratorRoot = rootElement.elementIterator();
        int updateIndicator = 0;
        while (iteratorRoot.hasNext()){
            Element elementPrimaryChild = (Element) iteratorRoot.next();
            if (houseId.equalsIgnoreCase(elementPrimaryChild.attributeValue("id"))){
                Iterator iteratorSecondChild = elementPrimaryChild.elementIterator();
                while (iteratorSecondChild.hasNext()){
                    Element element = (Element) iteratorSecondChild.next();
                    if (element.getName().equalsIgnoreCase("Available")){
                        if (element.getTextTrim().equalsIgnoreCase("true")) {
                            element.setText("false");
                            saveInfo(dataPath);
                            updateIndicator = 1;
                        }
                    }
                }
            }
        }
        return updateIndicator;
    }

    @Override
    public List<Tenant> getAllTenantByPropertyId(String propertyId) throws DocumentException {
        String dataPath = "";
        List<Tenant> tenantList = new ArrayList<>();
        if (propertyId.startsWith("A")){
            dataPath = "mockdata/apartment.xml";
        }else if (propertyId.startsWith("C")){
            dataPath = "mockdata/condo.xml";
        } else if (propertyId.startsWith("H")) {
            dataPath = "mockdata/house.xml";
        }
        loadMockData(dataPath);
        Element rootElement = propertyDocument.getRootElement();
        Iterator iteratorPrimary = rootElement.elementIterator();
        while (iteratorPrimary.hasNext()){
            Element elementChild = (Element) iteratorPrimary.next();
            String elementAttribute = elementChild.attributeValue("id");
            if (elementAttribute.equalsIgnoreCase(String.valueOf(propertyId))){
                Iterator iteratorChild = elementChild.elementIterator();
                while (iteratorChild.hasNext()){
                    Element element = (Element) iteratorChild.next();
                    if (element.getName().equalsIgnoreCase("Tenants")){
                        Iterator iteratorTenant = element.elementIterator();
                        while (iteratorTenant.hasNext()){
                            Element elementTenant = (Element) iteratorTenant.next();
                            String tenantId = elementTenant.getTextTrim();
                            Tenant tenant = tenantDao.getTenantById(Integer.parseInt(tenantId));
                            tenantList.add(tenant);
                        }
                    }
                }
            }
        }
        return tenantList;
    }

    @Override
    public Boolean updateAvailabilityByPropertyId(String propertyId, boolean availability) throws DocumentException, IOException {
        String dataPath = "";
        if (propertyId.startsWith("A")){
            dataPath = "mockdata/apartment.xml";
        }else if (propertyId.startsWith("C")){
            dataPath = "mockdata/condo.xml";
        } else if (propertyId.startsWith("H")) {
            dataPath = "mockdata/house.xml";
        }
        loadMockData(dataPath);
        Element rootElement = propertyDocument.getRootElement();
        Iterator iteratorRoot = rootElement.elementIterator();
        boolean updateIndicator = false;
        while (iteratorRoot.hasNext()){
            Element elementPrimaryChild = (Element) iteratorRoot.next();
            if (propertyId.equalsIgnoreCase(elementPrimaryChild.attributeValue("id"))){
                Iterator iteratorSecondChild = elementPrimaryChild.elementIterator();
                while (iteratorSecondChild.hasNext()){
                    Element element = (Element) iteratorSecondChild.next();
                    if (element.getName().equalsIgnoreCase("Available")){
                        if (availability == true) {
                            element.setText("true");
                        } else {
                            element.setText("false");
                        }
                        saveInfo(dataPath);
                        updateIndicator = true;
                    }
                }
            }
        }
        return updateIndicator;
    }

    @Override
    public Boolean addPotentialTenantToProperty(String propertyId, Integer tenantId) throws DocumentException, IOException {
        String dataPath = "";
        if (propertyId.startsWith("A")){
            dataPath = "mockdata/apartment.xml";
        }else if (propertyId.startsWith("C")){
            dataPath = "mockdata/condo.xml";
        } else if (propertyId.startsWith("H")) {
            dataPath = "mockdata/house.xml";
        }
        loadMockData(dataPath);
        Element rootElement = propertyDocument.getRootElement();
        Iterator iteratorPrimary = rootElement.elementIterator();
        boolean addTenantIndicator = false;
        while (iteratorPrimary.hasNext()){
            Element elementChild = (Element) iteratorPrimary.next();
            String elementAttribute = elementChild.attributeValue("id");
            if (elementAttribute.equalsIgnoreCase(propertyId)){
                Iterator iteratorChild = elementChild.elementIterator();
                while (iteratorChild.hasNext()){
                    Element element = (Element) iteratorChild.next();
                    if (element.getName().equalsIgnoreCase("Tenants")){
                        Element elementTenant = element.addElement("TenantId");
                        elementTenant.addText(String.valueOf(tenantId));
                        saveInfo(dataPath);
                        addTenantIndicator = true;
                    }
                }
            }
        }
        return addTenantIndicator;
    }

    public void saveInfo(String fileName) throws IOException {
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(fileName));
        xmlWriter.write(propertyDocument);
        xmlWriter.flush();
        xmlWriter.close();
    }

    public int getNodeCount(String fileName) throws DocumentException {
        SAXReader saxReader1 = new SAXReader();
        Document doc = saxReader1.read(fileName);
        Element rootElement = doc.getRootElement();
        Iterator iteratorChild = rootElement.elementIterator();
        int nodeCount = 0;
        while (iteratorChild.hasNext()){
            iteratorChild.next();
            nodeCount ++;
        }
        return nodeCount;
    }
}
