package com.specialistholidays.helpers;

import employees.part2.Employee;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by amortimer on 05/09/2016.
 */
public class isValidSecurityNumber extends TypeSafeMatcher<String> {
    @Override
    public boolean matchesSafely(String code)  {
        String regex = Employee.SECURITY_NUMBER;
        return code.matches(regex);
    }

    @Override
    public void describeTo(Description description) {

    }

    @Factory
    public static Matcher<String> isValidSecurityNumber() {
        return new isValidSecurityNumber();
    }
}
