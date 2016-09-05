package employees.part1;

import org.junit.Before;
import org.junit.Test;

import static com.specialistholidays.helpers.isAPostalCode.isAPostalCode;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;


/**
 * Created by amortimer on 05/09/2016.
 */
public class AddressTest {
    Address address;

    @Before
    public void setUp() throws Exception {
        address = new Address("37 EastPark", "Crawley", "RH10 6AN", "UK");
    }

    @Test
    public void anAddressHasALine_notNullValue() {
        assertThat(address.getLine(), notNullValue());
    }

    @Test
    public void anAddressHasACity_notNullValue() {
        assertThat(address.getCity(), notNullValue());
    }

    @Test
    public void anAddressHasAPostalCode_notNullValue() {
        assertThat(address.getPostalCode(), notNullValue());
    }

    @Test
    public void anAddressHasACountry_notNullValue() {
        assertThat(address.getCountry(), notNullValue());
    }

    @Test
    public void anAddressCountryCanBeUK_equals_true() {
        Address newAddress = new Address("37 EastPark", "Crawley", "RH10 6AN", "UK");
        assertEquals("UK", newAddress.getCountry());
    }

    @Test
    public void anAddressCountryCanBeUS_equals_true() {
        Address newAddress = new Address("37 EastPark", "Crawley", "RH10 6AN", "US");
        assertEquals("US", newAddress.getCountry());
    }

    @Test
    public void anAddressPostCode_isPostalCode() {
        assertThat(address.getPostalCode(), isAPostalCode());
    }
}