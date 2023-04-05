package dao.impl;

import dao.AccountingDao;
import entity.Accounting;
import entity.Apartment;
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

public class AccountingDaoImpl implements AccountingDao {
    public static Document accountingDocument;
    public void loadMockData(String fileName) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        accountingDocument = saxReader.read(fileName);
    }
    @Override
    public boolean addPayment(Accounting accounting) throws DocumentException {
        String dataPath = "mockdata/accounting.xml";
        loadMockData(dataPath);
        boolean addIndicator = false;
        String accountingId = String.valueOf(getNodeCount()+1);
        String leaseId = String.valueOf(accounting.getLeaseId());
        String tenantId = String.valueOf(accounting.getTenantId());
        String tenantName = accounting.getTenantName();
        String tenantEmail = accounting.getTenantEmail();
        String propertyId = accounting.getPropertyId();
        String isPaid = accounting.getIsPaid();

        Element rootElement = accountingDocument.getRootElement();
        Element primaryElement = rootElement.addElement("Payment");
        primaryElement.addAttribute("id", accountingId);
        primaryElement.addElement("leaseId").addText(leaseId);
        primaryElement.addElement("tenantId").addText(tenantId);
        primaryElement.addElement("tenantName").addText(tenantName);
        primaryElement.addElement("tenantEmail").addText(tenantEmail);
        primaryElement.addElement("propertyId").addText(propertyId);
        primaryElement.addElement("isPaid").addText(isPaid);
        try {
            saveInfo(dataPath);
            addIndicator = true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return addIndicator;
    }

    @Override
    public boolean updatePayment(Accounting accounting) throws DocumentException, IOException {
        String dataPath = "mockdata/accounting.xml";
        loadMockData(dataPath);
        Element rootElement = accountingDocument.getRootElement();
        Iterator iteratorRoot = rootElement.elementIterator();
        boolean updateIndicator = false;
        while (iteratorRoot.hasNext()){
            Element elementPrimaryChild = (Element) iteratorRoot.next();
            if (String.valueOf(accounting.getAccountingId()).equalsIgnoreCase(elementPrimaryChild.attributeValue("id"))){
                Iterator iteratorSecondChild = elementPrimaryChild.elementIterator();
                while (iteratorSecondChild.hasNext()){
                    Element element = (Element) iteratorSecondChild.next();
                    if (element.getName().equalsIgnoreCase("isPaid")){
                            element.setText(accounting.getIsPaid());
                            saveInfo(dataPath);
                            updateIndicator = true;
                        }
                    }
                }
        }
        return updateIndicator;
    }

    @Override
    public List<Accounting> getPaidList() throws DocumentException {
        String dataPath = "mockdata/accounting.xml";
        loadMockData(dataPath);
        List<Accounting> accountings = new ArrayList<>();
        Element rootElement = accountingDocument.getRootElement();
        Iterator iteratorPrimary = rootElement.elementIterator();
        while (iteratorPrimary.hasNext()){
            Accounting accounting = new Accounting();
            Element elementChild = (Element) iteratorPrimary.next();
            String elementName = elementChild.getName();
            String elementAttribute = elementChild.attributeValue("id");
            accounting.setAccountingId(Integer.parseInt(elementAttribute));
            Iterator iteratorChild = elementChild.elementIterator();
            while (iteratorChild.hasNext()){
                Element element = (Element) iteratorChild.next();
                if (element.getName().equalsIgnoreCase("leaseId")){
                    accounting.setLeaseId(Integer.valueOf(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("tenantId")){
                    accounting.setTenantId(Integer.valueOf(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("tenantName")){
                    accounting.setTenantName(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("tenantEmail")){
                    accounting.setTenantEmail(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("propertyId")){
                    accounting.setPropertyId(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("isPaid")){
                    accounting.setIsPaid(element.getTextTrim());
                }
            }
            if ("Yes".equalsIgnoreCase(accounting.getIsPaid())){
                accountings.add(accounting);
            }
        }

        return accountings;
    }

    @Override
    public List<Accounting> getUnpaidList() throws DocumentException {
        String dataPath = "mockdata/accounting.xml";
        loadMockData(dataPath);
        List<Accounting> accountings = new ArrayList<>();
        Element rootElement = accountingDocument.getRootElement();
        Iterator iteratorPrimary = rootElement.elementIterator();
        while (iteratorPrimary.hasNext()){
            Accounting accounting = new Accounting();
            Element elementChild = (Element) iteratorPrimary.next();
            String elementName = elementChild.getName();
            String elementAttribute = elementChild.attributeValue("id");
            accounting.setAccountingId(Integer.parseInt(elementAttribute));
            Iterator iteratorChild = elementChild.elementIterator();
            while (iteratorChild.hasNext()){
                Element element = (Element) iteratorChild.next();
                if (element.getName().equalsIgnoreCase("leaseId")){
                    accounting.setLeaseId(Integer.valueOf(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("tenantId")){
                    accounting.setTenantId(Integer.valueOf(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("tenantName")){
                    accounting.setTenantName(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("tenantEmail")){
                    accounting.setTenantEmail(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("propertyId")){
                    accounting.setPropertyId(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("isPaid")){
                    accounting.setIsPaid(element.getTextTrim());
                }
            }
            if ("No".equalsIgnoreCase(accounting.getIsPaid())){
                accountings.add(accounting);
            }
        }

        return accountings;
    }

    @Override
    public Accounting getAccounting(String leaseId) throws DocumentException {{
        String dataPath = "mockdata/accounting.xml";
        loadMockData(dataPath);
        Accounting accounting = new Accounting();
        Element rootElement = accountingDocument.getRootElement();
        Iterator iteratorPrimary = rootElement.elementIterator();
        while (iteratorPrimary.hasNext()){
            Accounting act = new Accounting();
            Element elementChild = (Element) iteratorPrimary.next();
            String elementName = elementChild.getName();
            String elementAttribute = elementChild.attributeValue("id");
            act.setAccountingId(Integer.parseInt(elementAttribute));
            Iterator iteratorChild = elementChild.elementIterator();
            while (iteratorChild.hasNext()){
                Element element = (Element) iteratorChild.next();
                if (element.getName().equalsIgnoreCase("leaseId")){
                    if (leaseId.equalsIgnoreCase(element.getTextTrim())){
                        act.setLeaseId(Integer.valueOf(leaseId));
                    }
                }else if (element.getName().equalsIgnoreCase("tenantId")){
                    act.setTenantId(Integer.valueOf(element.getTextTrim()));
                }else if (element.getName().equalsIgnoreCase("tenantName")){
                    act.setTenantName(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("tenantEmail")){
                    act.setTenantEmail(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("propertyId")){
                    act.setPropertyId(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("isPaid")){
                    act.setIsPaid(element.getTextTrim());
                }
            }
            if (act.getLeaseId() != null){
               accounting = act;
               break;
            }
        }
        return accounting;
        }
    }

    public void saveInfo(String fileName) throws IOException {
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(fileName));
        xmlWriter.write(accountingDocument);
        xmlWriter.flush();
        xmlWriter.close();
    }

    public int getNodeCount() throws DocumentException {
        SAXReader saxReader1 = new SAXReader();
        Document doc = saxReader1.read("mockdata/accounting.xml");
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
