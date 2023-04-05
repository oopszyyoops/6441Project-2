package entity.propertyfactory;

import entity.House;
import entity.Property;

public class HouseFactory implements PropertyFactory{
    @Override
    public Property createProperty() {
        return new House();
    }
}
