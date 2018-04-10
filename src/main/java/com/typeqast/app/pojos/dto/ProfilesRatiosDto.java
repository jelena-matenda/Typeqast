package com.typeqast.app.pojos.dto;

public class ProfilesRatiosDto {


	private String month;
	private String profile;
	private double ratio;

	public ProfilesRatiosDto() {
		super();
	}

	public ProfilesRatiosDto(String month, String profile, double ratio) {
		super();
		this.month = month;
		this.profile = profile;
		this.ratio = ratio;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(Float ratio) {
		this.ratio = ratio;
	}

	@Override
	public String toString() {
		return "Profiles Ratios [month=" + month + ", profile=" + profile + ", ratio=" + ratio + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
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
		ProfilesRatiosDto other = (ProfilesRatiosDto) obj;
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
		if (Double.doubleToLongBits(ratio) != Double.doubleToLongBits(other.ratio))
			return false;
		return true;
	}
}
