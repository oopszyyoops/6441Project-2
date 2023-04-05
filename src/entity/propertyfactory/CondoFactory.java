package entity.propertyfactory;

import entity.Condo;
import entity.Property;

public class CondoFactory implements PropertyFactory{
    @Override
    public Property createProperty() {
        return new Condo();
    }
}
