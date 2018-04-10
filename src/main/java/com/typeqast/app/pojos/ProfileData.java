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
public class ProfileData {
	
	@Override
	public String toString() {
		return "ProfileData [profileId=" + profileId + ", month=" + month + ", ratio=" + ratio + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonProperty("profileId")
	private String profileId;

	@JsonProperty("month")
	private String month;
	
	@JsonProperty("ratio")
	private double ratio;

	public ProfileData() {
		super();
	}

	public ProfileData(String profileId, String month, double ratio) {
		super();
		this.profileId = profileId;
		this.month = month;
		this.ratio = ratio;
	}



	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((profileId == null) ? 0 : profileId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(ratio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		ProfileData other = (ProfileData) obj;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (profileId == null) {
			if (other.profileId != null)
				return false;
		} else if (!profileId.equals(other.profileId))
			return false;
		if (Double.doubleToLongBits(ratio) != Double.doubleToLongBits(other.ratio))
			return false;
		return true;
	}





}
