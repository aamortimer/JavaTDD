package employees.part2;

import java.util.Date;

/**
 * Created by amortimer on 05/09/2016.
 */
public class Employee {
    private String m_name;
    private Date m_startDate;
    private String m_securityNumber;
    private Address m_address;

    public static final String SECURITY_NUMBER = "[A-Z]{2} ?([0-9]{2} ?){3}[A-Z]{1}";

    public Employee(String name, Date startDate, String securityNumber, Address address) {
        if(!isASecurityNumber(securityNumber)) {
            throw new IllegalArgumentException("Security number is not valid");
        }

        this.m_name = name;
        this.m_startDate = startDate;
        this.m_securityNumber = securityNumber;
        this.m_address = address;
    }

    public String getName() {
        return this.m_name;
    }

    public Date getStartDate() {
        return this.m_startDate;
    }

    public String getSecurityNumber() {
        return this.m_securityNumber.toUpperCase();
    }

    public Address getAddress() {
        return this.m_address;
    }

    public boolean isASecurityNumber(String securityNumber) {
        return securityNumber.matches(SECURITY_NUMBER);
    }
}
