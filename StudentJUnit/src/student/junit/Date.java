package student.junit;

public class Date {

	private int day, month, year;

	public Date(int day, int month, int year) {
		setDay(day);
		setMonth(month);
		setYear(year);
	}
	
	// Getter and setter for day.
	public void setDay(int day) {
		if (day < 1 || day > 31) {
			throw new IllegalArgumentException("Bad day: " + day);
		}
		this.day = day;
	}
	public int getDay() {
		return day;
	}
	
	// Getter and setter for month.
	public void setMonth(int month) {
		if (month < 1 || month > 12) {
			throw new IllegalArgumentException("Bad month: " + month);
		}
		this.month = month;
	}
	public int getMonth() {
		return month;
	}
	
	// Getter and setter for year.
	public void setYear(int year) {
		this.year = year;
	}
	public int getYear() {
		return year;
	} 
		
	// Create a new date, by adding a specified offset to an existing date.
	public static Date dateByDays(Date aDate, int days) {

		int deltaYears = days / 365;
		days = days % 365;
		int deltaMonths = days / 31;
		days = days % 31;
		
		int day = aDate.getDay() + days;
		if (day > 31) {
			day -= 31;
			deltaMonths++;
		}
		else if (day < 0) {
			day += 31;
			deltaMonths--;
		}
		
		int month = aDate.getMonth() + deltaMonths;
		if (month > 11) {
			month -= 12;
			deltaYears++;
		}
		else if (month < 0) {
			month += 12;
			deltaYears--;
		}
		
		return new Date(day, month, aDate.getYear() + deltaYears);
	}

	// Determine if another object contains the same date as this object.
	@Override
	public boolean equals(Object other) { 
		
		// If the two object references point to the same object, then the values must be equal!
		if (other == this) 
			return true; 
		
		// If the other object isn't a Date, then the values must be different! 
		if (!(other instanceof Date)) 
			return false;	

		// Compare the day, month, and year values.
		Date otherDate = (Date)other;
		return this.day == otherDate.day && this.month == otherDate.month && this.year == otherDate.year;
	}
	
	// When you implement equals(), you're meant to implement hashCode() too.
	@Override 
	public int hashCode() {
		return this.toString().hashCode();
	}
	
	// Will make JUnit test failures clearer.
	@Override
	public String toString() {
		return String.format("%02d/%02d/%04d", day, month, year);
	}
}
