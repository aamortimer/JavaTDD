package employees.part1;
import employees.Countries;

/**
 * Created by amortimer on 05/09/2016.
 */
public class Address {
    private final String m_line;
    private final String m_city;
    private final String m_postalCode;
    private final String m_country;

    public Address(String line, String city, String postalCode, String county) {
        validatePostalCode(postalCode);

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

    private boolean validatePostalCode(String postalCode) {
        try {
            Countries.valueOf(postalCode);
            return true;
        } catch (Exception e) {
            return  false;
        }
    }
}
