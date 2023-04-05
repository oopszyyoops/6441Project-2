package dao.impl;

import dao.LeaseDao;
import dao.PropertyDao;
import dao.TenantDao;
import entity.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class LeaseDaoImpl implements LeaseDao {

    TenantDao tenantDao = new TenantDaoImpl();
    PropertyDao propertyDao = new PropertyDaoImpl();
    public static Document leaseDocument;
    public void loadMockData(String fileName) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        leaseDocument = saxReader.read(fileName);
    }
    @Override
    public void addApartmentLease(Lease apartmentLease) throws DocumentException, IOException, ParseException {
        Tenant tenant = apartmentLease.getTenant();
        Property property = apartmentLease.getProperty();

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

        String dataPath = "mockdata/lease.xml";
        loadMockData(dataPath);
        int currentNodeCount = this.getNodeCount(dataPath);
        Element rootElement = leaseDocument.getRootElement();
        Element primaryElement = rootElement.addElement("Lease");
        String leaseId = String.valueOf(currentNodeCount+1);
        primaryElement.addAttribute("id", leaseId);
        primaryElement.addElement("TenantId").addText(tenantId);
        primaryElement.addElement("tenantName").addText(tenantName);
        primaryElement.addElement("TenantEmail").addText(tenantEmail);
        primaryElement.addElement("TenantPhone").addText(tenantPhone);

        primaryElement.addElement("PropertyId").addText(apartmentId);
        primaryElement.addElement("Address").addText(address);
        primaryElement.addElement("StartDate").addText(apartmentLease.getStartDate());
        primaryElement.addElement("EndDate").addText(apartmentLease.getEndDate());
        primaryElement.addElement("RentAmount").addText(String.valueOf(apartmentLease.getRentAmount()));
        saveInfo(dataPath);
    }

    @Override
    public void addCondoLease(Lease condoLease) throws DocumentException, IOException, ParseException {
        addApartmentLease(condoLease);
    }

    @Override
    public void addHouseLease(Lease houseLease) throws DocumentException, IOException, ParseException {
        addApartmentLease(houseLease);
    }

    public void saveInfo(String fileName) throws IOException {
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(fileName));
        xmlWriter.write(leaseDocument);
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

    @Override
    public List<LinkedHashMap<String, String>> getAllLease() throws DocumentException {
        String dataPath = "mockdata/lease.xml";
        loadMockData(dataPath);
        List<LinkedHashMap<String, String>> leaseList = new ArrayList<>();
        Element rootElement = leaseDocument.getRootElement();
        Iterator iteratorPrimary = rootElement.elementIterator();
        while (iteratorPrimary.hasNext()){
            LinkedHashMap<String, String> leaseEntity = new LinkedHashMap<>();
            Element elementChild = (Element) iteratorPrimary.next();
            String elementAttribute = elementChild.attributeValue("id");
            leaseEntity.put("id",elementAttribute);
            Iterator iteratorChild = elementChild.elementIterator();
            while (iteratorChild.hasNext()){
                Element element = (Element) iteratorChild.next();
                if (element.getName().equalsIgnoreCase("TenantId")){
                    leaseEntity.put("TenantId", element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("tenantName")){
                    leaseEntity.put("tenantName", element.getTextTrim());
                } else if (element.getName().equalsIgnoreCase("TenantEmail")){
                    leaseEntity.put("TenantEmail", element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("TenantPhone")){
                    leaseEntity.put("TenantPhone", element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("PropertyId")){
                    leaseEntity.put("PropertyId", element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("Address")){
                    leaseEntity.put("Address", element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("StartDate")){
                    leaseEntity.put("StartDate", element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("EndDate")){
                    leaseEntity.put("EndDate", element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("RentAmount")){
                    leaseEntity.put("RentAmount", element.getTextTrim());
                }
            }
            leaseList.add(leaseEntity);
        }
        return leaseList;
    }

    @Override
    public Lease getLeaseById(Integer leaseId) throws DocumentException {
        String dataPath = "mockdata/lease.xml";
        loadMockData(dataPath);
        Element rootElement = leaseDocument.getRootElement();
        Iterator iteratorPrimary = rootElement.elementIterator();
        Lease lease = new ApartmentLease();
        while (iteratorPrimary.hasNext()){
            Element elementChild = (Element) iteratorPrimary.next();
            String elementAttribute = elementChild.attributeValue("id");
            if (elementAttribute.equalsIgnoreCase(String.valueOf(leaseId))){
                lease.setId(leaseId);
                Iterator iteratorChild = elementChild.elementIterator();
                while (iteratorChild.hasNext()){
                    Element element = (Element) iteratorChild.next();
                    if (element.getName().equalsIgnoreCase("TenantId")){
                        String tenantId = element.getTextTrim();
                        Tenant tenant = tenantDao.getTenantById(Integer.parseInt(tenantId));
                        lease.setTenant(tenant);
                    }else if (element.getName().equalsIgnoreCase("PropertyId")){
                        String propertyId = element.getTextTrim();
                        if (propertyId.startsWith("A")){
                            Property property = new Apartment();
                            property = propertyDao.getApartmentById(propertyId);
                            lease.setProperty(property);
                        }else if (propertyId.startsWith("C")){
                            Property property = new Condo();
                            property = propertyDao.getCondoById(propertyId);
                            lease.setProperty(property);
                        } else if (propertyId.startsWith("H")) {
                            Property property = new House();
                            property = propertyDao.getHouseById(propertyId);
                            lease.setProperty(property);
                        }
                    }else if (element.getName().equalsIgnoreCase("StartDate")){
                       String startDate = element.getTextTrim();
                       lease.setStartDate(startDate);
                    }else if (element.getName().equalsIgnoreCase("EndDate")){
                        String endDate = element.getTextTrim();
                        lease.setEndDate(endDate);
                    }else if (element.getName().equalsIgnoreCase("RentAmount")){
                        String rentAmount = element.getTextTrim();
                        lease.setRentAmount(Double.parseDouble(rentAmount));
                    }
                }
            }
        }
        return lease;
    }
}
