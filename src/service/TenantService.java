package service;

import entity.Tenant;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.LinkedHashMap;

public interface TenantService {
    void addTenant(LinkedHashMap<String, String> tenantInfo) throws DocumentException, IOException;
    void displayAllTenant() throws DocumentException;
}
