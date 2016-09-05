package com.specialistholidays.helpers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by amortimer on 05/09/2016.
 */
public class isAPostalCode extends TypeSafeMatcher<String> {

    @Override
    public boolean matchesSafely(String code)  {
        String regex = "[A-Z]{1,2}[0-9]{1,2}\\s*([0-9][A-Z]{2})?";
        return code.matches(regex);
    }

    @Override
    public void describeTo(Description description) {

    }

    @Factory
    public static Matcher<String> isAPostalCode() {
        return new isAPostalCode();
    }
}
