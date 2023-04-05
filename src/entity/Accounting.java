package entity;

public class Accounting {
    Integer accountingId;
    Integer leaseId;
    Integer tenantId;
    String tenantName;
    String tenantEmail;
    String propertyId;
    String isPaid;

    public Accounting(Integer accountingId, Integer leaseId, Integer tenantId, String tenantName, String tenantEmail, String propertyId, String isPaid) {
        this.accountingId = accountingId;
        this.leaseId = leaseId;
        this.tenantId = tenantId;
        this.tenantName = tenantName;
        this.tenantEmail = tenantEmail;
        this.propertyId = propertyId;
        this.isPaid = isPaid;
    }
    public Integer getAccountingId() {
        return accountingId;
    }

    public void setAccountingId(Integer accountingId) {
        this.accountingId = accountingId;
    }
    public Accounting() {
    }

    public Integer getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(Integer leaseId) {
        this.leaseId = leaseId;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTenantEmail() {
        return tenantEmail;
    }

    public void setTenantEmail(String tenantEmail) {
        this.tenantEmail = tenantEmail;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }

    @Override
    public String toString() {
        return "Accounting{" +
                "accountingId=" + accountingId +
                ", leaseId=" + leaseId +
                ", tenantId=" + tenantId +
                ", tenantName='" + tenantName + '\'' +
                ", tenantEmail='" + tenantEmail + '\'' +
                ", propertyId='" + propertyId + '\'' +
                ", isPaid='" + isPaid + '\'' +
                '}';
    }
}
