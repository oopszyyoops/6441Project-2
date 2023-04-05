package dao.impl;

import dao.TenantDao;
import entity.Tenant;
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

public class TenantDaoImpl implements TenantDao {
    public static Document tenantDocument;
    public void loadMockData(String fileName) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        tenantDocument = saxReader.read(fileName);
    }
    @Override
    public void addTenant(Tenant tenant) throws IOException, DocumentException {
        String dataPath = "mockdata/tenant.xml";
        loadMockData(dataPath);
        int currentNodeCount = this.getNodeCount(dataPath);
        Element rootElement = tenantDocument.getRootElement();
        Element primaryElement = rootElement.addElement("Tenant");
        String tenantId = String.valueOf(currentNodeCount+1);
        primaryElement.addAttribute("id", tenantId);
        primaryElement.addElement("Name").addText(tenant.getName());
        primaryElement.addElement("Email").addText(tenant.getEmail());
        primaryElement.addElement("Phone").addText(tenant.getPhone());
        saveInfo(dataPath);
    }

    @Override
    public List<Tenant> getAllTenant() throws DocumentException {
        String dataPath = "mockdata/tenant.xml";
        loadMockData(dataPath);
        List<Tenant> tenantList = new ArrayList<>();
        Element rootElement = tenantDocument.getRootElement();
        Iterator iteratorPrimary = rootElement.elementIterator();
        while (iteratorPrimary.hasNext()){
            Tenant tenant = new Tenant();
            Element elementChild = (Element) iteratorPrimary.next();
            String elementName = elementChild.getName();
            String elementAttribute = elementChild.attributeValue("id");
            tenant.setId(Integer.parseInt(elementAttribute));
            Iterator iteratorChild = elementChild.elementIterator();
            while (iteratorChild.hasNext()){
                Element element = (Element) iteratorChild.next();
                if (element.getName().equalsIgnoreCase("Name")){
                    tenant.setName(element.getTextTrim());
                } else if (element.getName().equalsIgnoreCase("Email")){
                    tenant.setEmail(element.getTextTrim());
                }else if (element.getName().equalsIgnoreCase("Phone")){
                    tenant.setPhone(element.getTextTrim());
                }
            }
            tenantList.add(tenant);
        }
        return tenantList;
    }

    @Override
    public Tenant getTenantById(Integer tenantId) throws DocumentException {
        String dataPath = "mockdata/tenant.xml";
        loadMockData(dataPath);
        Element rootElement = tenantDocument.getRootElement();
        Iterator iteratorPrimary = rootElement.elementIterator();
        Tenant tenant = new Tenant();
        while (iteratorPrimary.hasNext()){
            Element elementChild = (Element) iteratorPrimary.next();
            String elementAttribute = elementChild.attributeValue("id");
            if (elementAttribute.equalsIgnoreCase(String.valueOf(tenantId))){
                tenant.setId(tenantId);
                Iterator iteratorChild = elementChild.elementIterator();
                while (iteratorChild.hasNext()){
                    Element element = (Element) iteratorChild.next();
                    if (element.getName().equalsIgnoreCase("Name")){
                        tenant.setName(element.getTextTrim());
                    } else if (element.getName().equalsIgnoreCase("Email")) {
                        tenant.setEmail(element.getTextTrim());
                    }else if (element.getName().equalsIgnoreCase("Phone")) {
                        tenant.setPhone(element.getTextTrim());
                    }
                }
            }
        }
        return tenant;
    }

    public void saveInfo(String fileName) throws IOException {
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(fileName));
        xmlWriter.write(tenantDocument);
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
