package employees.part2;
import employees.Countries;

/**
 * Created by amortimer on 05/09/2016.
 */
public class Address {
    private final String m_line;
    private final String m_city;
    private final String m_postalCode;
    private final String m_country;

    public static final String POSTCODE = "[A-Z]{1,2}[0-9]{1,2}\\s*([0-9][A-Z]{2})?";

    public Address(String line, String city, String postalCode, String county) {
        if(!isValidateCountry(county)) {
            throw new IllegalArgumentException("Country is not valid");
        }

        if (!isValidPostalCode(postalCode)) {
            throw new IllegalArgumentException("Postal code is not valid");
        }

        this.m_line = line;
        this.m_city = city;
        this.m_postalCode = postalCode;
        this.m_country = county;
    }

    public String getLine() {
        return m_line;
    }

    public String getCity() {
        return m_city;
    }

    public String getPostalCode() {
        return m_postalCode;
    }

    public String getCountry() {
       return m_country;
    }


    private boolean isValidPostalCode(String postalCode) {
        return postalCode.matches(POSTCODE);
    }

    private boolean isValidateCountry(String country) {
        try {
            Countries.valueOf(country);
            return true;
        } catch (Exception e) {
            return  false;
        }
    }
}
