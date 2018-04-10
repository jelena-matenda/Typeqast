package com.typeqast.app.services.interfaces;

import java.util.List;

import com.typeqast.app.pojos.dto.ProfilesRatiosDto;

public interface IMeterService {
	
//	List<ProfilesRatios> getAllData();
//	
//	void addData(List<ProfilesRatios> profileRatiosList);

	List<ProfilesRatiosDto> getAllArticles();

	void addProfileRatios(List<ProfilesRatiosDto> profileRatiosList);

}
