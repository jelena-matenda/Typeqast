package com.typeqast.app.adapter;

import com.typeqast.app.pojos.MeterReadingData;
import com.typeqast.app.pojos.ProfileData;
import com.typeqast.app.pojos.dto.MeterReadingsDto;
import com.typeqast.app.pojos.dto.ProfilesRatiosDto;

public class Adapter {

	public static MeterReadingsDto toMeterReadingsDto(MeterReadingData data) {
		return new MeterReadingsDto(data.getConnectionID(), data.getProfile(), data.getMonth(), data.getMeterReading());
	}

	public static MeterReadingData fromMeterReadingsDto(MeterReadingsDto meterReadings) {
		return new MeterReadingData(meterReadings.getConnectionID(), meterReadings.getProfile(),
				meterReadings.getMonth(), meterReadings.getMeterReading());
	}

	public static ProfilesRatiosDto toProfilesRatiosDto(ProfileData data) {
		return new ProfilesRatiosDto(data.getMonth(), data.getProfileId(), data.getRatio());
	}

	public static ProfileData fromProfileRatiosDto(ProfilesRatiosDto profileRatio) {
		return new ProfileData(profileRatio.getProfile(), profileRatio.getMonth(), profileRatio.getRatio());
	}

}
