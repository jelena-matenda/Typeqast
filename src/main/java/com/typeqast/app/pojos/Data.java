/**
 * 
 */
package com.typeqast.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Data {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonProperty("monthName")
	private String mMonthName;

	@JsonProperty("dataValue")
	private Double mValue;

	public Data() {
		super();
	}

	public Data(String monthName, Double value) {
		mMonthName = monthName;
		this.mValue = value;
	}

	public final String getMonthName() {
		return mMonthName;
	}

	public final void setMonthName(String monthName) {
		this.mMonthName = monthName;
	}

	public final Double getDataValue() {
		return mValue;
	}

	public final void setDataValue(Double ratio) {
		this.mValue = ratio;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Data)) {
			return false;
		}

		Data ratioData = (Data) obj;
		return this.mMonthName.equals(ratioData.getMonthName())
				&& this.mValue.doubleValue() == ratioData.getDataValue().doubleValue();
	}

	@Override
	public int hashCode() {
		int hashno = 7;
		hashno = 13 * hashno + (mMonthName == null ? 0 : mMonthName.hashCode());
		return hashno;
	}
}
