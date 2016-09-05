package employees.part2;

import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by amortimer on 05/09/2016.
 */
public class EmployeeTest {
    private Employee employee;
    private Address address;
    private Date startDate;

    @Before
    public void setUp() throws Exception {
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date startDate = format.parse("January 1, 2010");

        address = new Address("37 EastPark", "Crawley", "RH10 6AN", "UK");
        employee = new Employee("Andy Mortimer", startDate, "AB121212A", address);
    }

    @Test
    public void anEmployeeHasAStartDate() {
        assertThat(employee.getStartDate(), notNullValue());
    }

    @Test
    public void anEmployeeHasAName() {
        assertThat(employee.getName(), notNullValue());
    }

    @Test
    public void anEmployeeHasSecurityNumber() {
        assertThat(employee.getSecurityNumber(), notNullValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void anEmployeeHasSecurityNumberIsValid() {
        new Employee("Andy Mortimer", startDate, "AB121212", address);
    }

    @Test
    public void anEmployeeHasAddress() {
        assertThat(employee.getAddress(), notNullValue());
    }
}