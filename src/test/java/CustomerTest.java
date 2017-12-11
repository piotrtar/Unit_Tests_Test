import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Customer customer;
    String name;
    String surname;
    int birthyear;
    String gender;
//    ArrayList sales;
    Integer age;

    @BeforeEach
    void setUp() {
        name = "testCustomerName";
        surname = "testCustomerSurname";
        birthyear = 2000;
        gender = "Female";

        customer = new Customer(name, surname, birthyear, gender);
    }

    @Test
    void testGetName() {
        String actual = customer.getName();
        assertEquals(name, actual);
    }

    @Test
    void testSetName() {
        String testName = "testName";
        customer.setName(testName);
        String actual = customer.getName();
        assertEquals(testName, actual);
    }

    @Test
    void testGetSurname() {
        String actual = customer.getSurname();
        assertEquals(surname, actual);
    }

    @Test
    void testSetSurname() {
        String testSurName = "testSurName";
        customer.setSurname(testSurName);
        String actual = customer.getSurname();
        assertEquals(testSurName, actual);
    }

    @Test
    void testGetBirthyear() {
        int actual = customer.getBirthyear();
        assertEquals(birthyear, actual);
    }

    @Test
    void testSetBirthyear() {
        int testBirthYear = 1990;
        customer.setBirthyear(testBirthYear);
        int actual = customer.getBirthyear();
        assertEquals(testBirthYear, actual);
    }

    @Test
    void testGetGender() {
        String actual = customer.getGender();
        assertEquals(gender, actual);
    }

    @Test
    void testSetGender() {
        String testGender = "Male";
        customer.setGender(testGender);
        String actual = customer.getGender();
        assertEquals(testGender, actual);
    }

    @Test
    void testGetAge() {
        int testAge = 17;
        int actual = customer.getAge();
        assertEquals(testAge, actual);
    }

    @Test
    void testIsNameIsNotNull() {
        assertNotNull(customer.getName());
    }

    @Test
    void testIsSurNameIsNotNull() {
        assertNotNull(customer.getSurname());
    }

    @Test
    void testIsBirthyearIsCorrect() {
        assertThrows(IllegalArgumentException.class, ()-> {
            customer.setBirthyear(1500);
        });
    }

    @Test
    void testIsGenderCorrect() {
        assertThrows(IllegalArgumentException.class, ()-> {
            customer.setGender("InvalidGender");
        });
    }
}