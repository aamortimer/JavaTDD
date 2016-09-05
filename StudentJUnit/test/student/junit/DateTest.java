package student.junit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static student.junit.Date.dateByDays;

/**
 * Created by amortimer on 05/09/2016.
 */
public class DateTest {
    private Date date;

    @Before
    public void setUp() throws Exception {
        date = new Date(15,01,1977);
    }

   @Test(expected = IllegalArgumentException.class)
   public void setDay_dayOutOfRangeEnd_Throws() throws Exception {
        date.setDay(32);
   }

    @Test(expected =  IllegalArgumentException.class)
    public void setDay_dayOutOfRangeBeginning_Throws() throws Exception {
        date.setDay(0);
    }

    @Test
    public void dateByDays_addZeroDays_isEquals() throws Exception {
        assertEquals(date, dateByDays(date, 0));
    }

    @Test
    public void dateByDays_addOneDay_isEquals() throws Exception {
        Date tomorrow = dateByDays(date, 1);
        assertEquals(16, tomorrow.getDay());
    }

    @Test
    public void dateByDays_minusOneDay_isEquals() throws Exception {
        Date yesterday = dateByDays(date, -1);
        assertEquals(14, yesterday.getDay());
    }

    @Test
    public void dateByDays_nextMonth_isEquals() throws Exception {
        Date nextMonth = dateByDays(date, 33);
        assertEquals(02, nextMonth.getMonth());
    }

    @Test
    public void dateByDays_nextYear_isEquals() throws Exception {
        Date nextMonth = dateByDays(date, 366);
        assertEquals(1978, nextMonth.getYear());
    }

    @Test
    public void dateByDays_newYear_isEquals() throws Exception {
        Date newYear = new Date(31,12,2016);
        Date nextMonth = dateByDays(newYear, 1);
        Date expectedDate = new Date(01,01,2017);
        assertEquals(expectedDate, nextMonth);
    }

    @Test
    public void dateNull_isFalse() throws Exception {
        assertFalse(date.equals(null));
    }

    @Test
    public void dateNonDateObject_isFalse() throws Exception {
        assertFalse(date.equals(""));
    }
}