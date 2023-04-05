package service.impl;

import dao.TenantDao;
import dao.impl.TenantDaoImpl;
import entity.House;
import entity.Tenant;
import org.dom4j.DocumentException;
import service.TenantService;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TenantServiceImpl implements TenantService {
    public TenantDao tenantDao = new TenantDaoImpl();

    @Override
    public void addTenant(LinkedHashMap<String, String> tenantInfo) throws DocumentException, IOException {
        Tenant tenant = new Tenant();
        for(Map.Entry<String, String> t : tenantInfo.entrySet()) {
            if (t.getKey().equalsIgnoreCase("Name")){
                tenant.setName(t.getValue());
            }else if (t.getKey().equalsIgnoreCase("Email")){
                tenant.setEmail(t.getValue());
            } else if (t.getKey().equalsIgnoreCase("Phone")) {
                tenant.setPhone(t.getValue());
            }else {
                System.out.println("cannot get the tenant information");
            }
        }
        tenantDao.addTenant(tenant);
        System.out.println("The tenant has been added");
    }

    @Override
    public void displayAllTenant() throws DocumentException {
        List<Tenant> tenantList = tenantDao.getAllTenant();
        for (Tenant t: tenantList) {
            String id = String.valueOf(t.getId());
            String name = t.getName();
            String email = t.getEmail();
            String phone = t.getPhone();
            System.out.println(id + "\t\t" + name + "\t\t\t\t" + email + "\t\t\t\t" + phone);
        }
    }
}
