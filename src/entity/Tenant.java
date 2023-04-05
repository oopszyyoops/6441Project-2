package entity;

import util.EmailSender;

public class Tenant {
    private int id;
    private String name;
    private String email;
    private String phone;

    public Tenant() {
    }

    public Tenant(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    private void sendEmailNotification(Property property, Tenant tenant) {
        String fromEmail = "soen6441testing@gmail.com";
        String password = "skjybtoltykehvla";
        String toEmail = "weiqi5588@gmail.com";
        String subject = "The unit (Property ID: "+ property.getId() +") is available now";
        String messageBody = "Hello " + tenant.getName() + ",\nThe unit you are looking for is available now!";

        EmailSender sender = new EmailSender(fromEmail, password, toEmail);
        sender.sendEmail(subject, messageBody);
    }

    public void update(Property property) {
        if (property.isAvailable()) {
            sendEmailNotification(property,this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
