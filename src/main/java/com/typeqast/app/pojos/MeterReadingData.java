/**
 * 
 */
package com.typeqast.app.pojos;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class MeterReadingData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonProperty("connectionID")
	private String connectionID;

	@JsonProperty("profile")
	@NotNull
	private String profile;

	@JsonProperty("month")
	@NotNull
	private String month;

	@JsonProperty("meterReading")
	@NotNull
	private double meterReading;

	public MeterReadingData() {
		super();
	}

	public MeterReadingData(String connectionID, String profile, String month, double meterReading) {
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

	// @Override
	// public int compareTo(MeterReadings compare) {
	// int compareMonth = ((MeterReadings) compare).getMonthNum(getMonth());
	// return this.getMonthNum(getMonth()) - compareMonth;
	// }
	//
	public static Comparator<MeterReadingData> monthsComparator = new Comparator<MeterReadingData>() {

		public int compare(MeterReadingData m1, MeterReadingData m2) {
			Integer month1 = m1.getMonthNum(m1.getMonth());
			Integer month2 = m2.getMonthNum(m2.getMonth());

			// ascending order
			return month1.compareTo(month2);
		}

	};

	public static Comparator<MeterReadingData> profileComparator = new Comparator<MeterReadingData>() {

		public int compare(MeterReadingData m1, MeterReadingData m2) {
			String profile1 = m1.getProfile();
			String profile2 = m2.getProfile();

			// ascending order
			return profile1.compareTo(profile2);
		}

	};

}
