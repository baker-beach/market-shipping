package com.bakerbeach.market.core.service.shipping.deliverytime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.Chronology;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.chrono.GregorianChronology;

import de.jollyday.HolidayManager;

public class DeliveryCalculator {

	private int days;
	private String switchTime;
	private int switchHour;
	private int switchMinute;
	private String country;
	private List<String> holidayParams = new ArrayList<String>(0);
	private List<Integer> weekendDays = new ArrayList<Integer>();
	private List<Integer> noTimeRuleDays = new ArrayList<Integer>();

	HolidayManager m;
	
	public DeliveryCalculator(){
		weekendDays.add(6);
		weekendDays.add(7);
		noTimeRuleDays.add(6);
		noTimeRuleDays.add(7);
	}

	public Date getNextDeliveryDate(Date date) {
		return getNextDeliveryDate(date,0);
	}
	
	public Date getNextDeliveryDate(Date date, int offset) {
		LocalTime localTime = new LocalTime(date);
		int testDays = days + offset;
		Chronology chrono = GregorianChronology.getInstance();
		LocalDate ld = new LocalDate(date, chrono);
		LocalDate startDay = new LocalDate(date, chrono);
		
		if(!noTimeRuleDays.contains(startDay.getDayOfWeek()))
			if(localTime.getHourOfDay() > switchHour )
				testDays++;
			else if(localTime.getHourOfDay() == switchHour && localTime.getMinuteOfHour() > switchMinute)
				testDays++;


		for (int i = 0; i < testDays; i++) {
			do{
				ld = ld.plusDays(1);
			}while(!isDayWorkDay(ld,startDay));
		}
		return ld.toDate();
	}

	private boolean isDayWorkDay(LocalDate currentDay, LocalDate startDay) {
		if (weekendDays.contains(currentDay.getDayOfWeek()))
			return false;
		else if (isHoliday(currentDay))
			return false;
		return true;
	}

	private boolean isHoliday(LocalDate currentDay) {
		String[] a = new String[ 5 ];
		if(holidayParams.isEmpty())
			return m.isHoliday(currentDay);
		else
			return m.isHoliday(currentDay,holidayParams.toArray(a));
	}

	public String getSwitchTime() {
		return switchTime;
	}

	public void setSwitchTime(String switchTime) {
		this.switchTime = switchTime;
		String[] parts = switchTime.split(":");
		switchHour = new Integer(parts[0]);
		switchMinute = new Integer(parts[1]);
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
		m = HolidayManager.getInstance(country);
	}

	public List<String> getHolidayParams() {
		return holidayParams;
	}

	public void setHolidayParams(List<String> holidayParams) {
		this.holidayParams = holidayParams;
		
	}

	public List<Integer> getWeekendDays() {
		return weekendDays;
	}

	public void setWeekendDays(List<Integer> weekendDays) {
		this.weekendDays = weekendDays;
	}

	public List<Integer> getNoTimeRuleDays() {
		return noTimeRuleDays;
	}

	public void setNoTimeRuleDays(List<Integer> noTimeRuleDays) {
		this.noTimeRuleDays = noTimeRuleDays;
	}

}
