package entity.propertyfactory;

import entity.Apartment;
import entity.Property;

public class ApartmentFactory implements PropertyFactory{
    @Override
    public Property createProperty() {
        return new Apartment();
    }
}
