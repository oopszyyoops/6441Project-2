package util;

import org.junit.Test;

import static org.junit.Assert.*;

public class InputValidationTest {

    InputValidation inputValidation = new InputValidation();
    /*
     * Description: to test isNumeric method makes sure that input is numeric.
     * Context: inputValidation initialed above. str initialed with appropriate data type.
     * Expected result: true.
     * */
    @Test
    public void testIsNumeric() {
        String str = "5";
        assertTrue(inputValidation.isNumeric(str));
    }
    /*
     * Description: to test isDate method makes sure that input is a date.
     * Context: inputValidation initialed above. str initialed with appropriate data type.
     * Expected result: true.
     * */
    @Test
    public void testIsDate() {
        String str = "2023/06/18";
        assertTrue(inputValidation.isDate(str));
    }
    /*
     * Description: to test isEmail method makes sure that input is an email.
     * Context: inputValidation initialed above. str initialed with appropriate data type.
     * Expected result: true.
     * */
    @Test
    public void testIsEmail() {
        String str = "test@gmail.com";
        assertTrue(inputValidation.isEmail(str));
    }
    /*
     * Description: to test isString method makes sure that input is a String.
     * Context: inputValidation initialed above. str initialed with appropriate data type.
     * Expected result: false.
     * */
    @Test
    public void testIsString() {
        String str = "string123";
        assertFalse(inputValidation.isString(str));
    }

    @Test
    /*
     * Description: to test isDecimalNumeric method makes sure that input is decimal numeric.
     * Context: inputValidation initialed above. str initialed with appropriate data type.
     * Expected result: true.
     * */
    public void testIsDecimalNumeric() {
        String str = "43.12";
        assertTrue(inputValidation.isDecimalNumeric(str));
    }
}