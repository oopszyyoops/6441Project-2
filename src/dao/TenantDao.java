package dao;

import entity.Tenant;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.List;

public interface TenantDao {
    void addTenant(Tenant tenant) throws IOException, DocumentException;
    List<Tenant> getAllTenant() throws DocumentException;

    Tenant getTenantById(Integer tenantId) throws DocumentException;

}
