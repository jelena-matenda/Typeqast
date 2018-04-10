package com.typeqast.app.pojos.dto;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class MeterReadingsDto {

	private String connectionID;
	private String profile;
	private String month;
	private double meterReading;

	public MeterReadingsDto() {
		super();
	}

	public MeterReadingsDto(String connectionID, String profile, String month, double meterReading) {
		super();
		this.connectionID = connectionID;
		this.profile = profile;
		this.month = month;
		this.meterReading = meterReading;
	}

	public static final List<String> SHORT_MONTHS;
	public static final int NUMBER_OF_MONTHS = 12;

	static {
		SHORT_MONTHS = Arrays.asList(new DateFormatSymbols(Locale.ENGLISH).getShortMonths()).stream()
				.filter(p -> !p.isEmpty()).collect(Collectors.toList());
	}

	public String getConnectionID() {
		return connectionID;
	}

	public void setConnectionID(String connectionID) {
		this.connectionID = connectionID;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getMonth() {
		return month;
	}

	public int getMonthNum(String month) {
		return SHORT_MONTHS.indexOf(month) + 1;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public double getMeterReading() {
		return meterReading;
	}

	public void setMeterReading(Integer meterReading) {
		this.meterReading = meterReading;
	}

	@Override
	public String toString() {
		return "MeterReading [connectionID=" + connectionID + ", profile=" + profile + ", month=" + month
				+ ", meterReading=" + meterReading + "]";
	}

	// @Override
	// public int compareTo(MeterReadings comparestu) {
	// int compareage=((Student)comparestu).getStudentage();
	// /* For Ascending order*/
	// return this.studentage-compareage;
	//
	// /* For Descending order do like this */
	// //return compareage-this.studentage;
	// }

	// public int compareTo(MeterReadings compare) {
	// int compareMonth = ((MeterReadings) compare).getMonthNum(getMonth() + 1);
	// return this.getMonthNum(getMonth()+1)-compareMonth;
	// }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((connectionID == null) ? 0 : connectionID.hashCode());
		long temp;
		temp = Double.doubleToLongBits(meterReading);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeterReadingsDto other = (MeterReadingsDto) obj;
		if (connectionID == null) {
			if (other.connectionID != null)
				return false;
		} else if (!connectionID.equals(other.connectionID))
			return false;
		if (Double.doubleToLongBits(meterReading) != Double.doubleToLongBits(other.meterReading))
			return false;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		return true;
	}

	// @Override
	// public int compareTo(MeterReadings compare) {
	// int compareMonth = ((MeterReadings) compare).getMonthNum(getMonth());
	// return this.getMonthNum(getMonth()) - compareMonth;
	// }
	//
	public static Comparator<MeterReadingsDto> monthsComparator = new Comparator<MeterReadingsDto>() {

		public int compare(MeterReadingsDto m1, MeterReadingsDto m2) {
			Integer month1 = m1.getMonthNum(m1.getMonth());
			Integer month2 = m2.getMonthNum(m2.getMonth());

			// ascending order
			return month1.compareTo(month2);
		}

	};

	public static Comparator<MeterReadingsDto> profileComparator = new Comparator<MeterReadingsDto>() {

		public int compare(MeterReadingsDto m1, MeterReadingsDto m2) {
			String profile1 = m1.getProfile();
			String profile2 = m2.getProfile();

			// ascending order
			return profile1.compareTo(profile2);
		}

	};

}
