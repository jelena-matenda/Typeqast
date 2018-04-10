package com.typeqast.app.services.interfaces;

import java.util.List;

import com.typeqast.app.pojos.ProfileData;
import com.typeqast.app.pojos.dto.ProfilesRatiosDto;

public interface IProfileService {

	// List<ProfilesRatios> getAllData();
	//
	// void addData(List<ProfilesRatios> profileRatiosList);

	List<ProfileData> getAllArticles();

	void addProfileRatios(List<ProfilesRatiosDto> profileRatiosList);

}
