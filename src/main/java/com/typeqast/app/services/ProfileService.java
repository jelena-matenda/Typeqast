package com.typeqast.app.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.typeqast.app.adapter.Adapter;
import com.typeqast.app.pojos.ProfileData;
import com.typeqast.app.pojos.dto.ProfilesRatiosDto;
import com.typeqast.app.repositories.DataRepository;
import com.typeqast.app.repositories.ProfileRepository;
import com.typeqast.app.services.interfaces.IProfileService;

@Service
public class ProfileService implements IProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private DataRepository dataRepository;

	public ProfileService(ProfileRepository profileRepository, DataRepository dataRepository) {
		this.profileRepository = profileRepository;
		this.dataRepository = dataRepository;
	}

	private List<ProfilesRatiosDto> profileRatios = new ArrayList<ProfilesRatiosDto>();

	public static List<ProfilesRatiosDto> getProfilesRatios(List<ProfilesRatiosDto> list) {
		List<ProfilesRatiosDto> verifiedList = new ArrayList<ProfilesRatiosDto>();
		validateRatios(list);

		return verifiedList;
	}

	// @Override
	// public List<ProfilesRatios> getAllData() {
	//
	// return profileRatios;
	// }
	//
	// @Override
	// public void addData(List<ProfilesRatios> profileRatiosList) {
	// for (ProfilesRatios receivedProfileRatio : profileRatiosList) {
	// ProfilesRatios item = new ProfilesRatios(receivedProfileRatio.getMonth(),
	// receivedProfileRatio.getProfile(),
	// receivedProfileRatio.getRatio());
	// profileRatios.add(item);
	// // System.out.println(item);
	// }
	//
	// }

	@Override
	public List<ProfileData> getAllArticles() {
		List<ProfileData> list = new ArrayList<>();
		profileRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public void addProfileRatios(List<ProfilesRatiosDto> profileRatiosList) {

		for (ProfilesRatiosDto profilesRatio : profileRatiosList) {
			profileRepository.save(Adapter.fromProfileRatiosDto(profilesRatio));
			System.out.println(Adapter.fromProfileRatiosDto(profilesRatio).toString());
		}
	}

	public static boolean validateRatios(List<ProfilesRatiosDto> list) {
		Map<String, Double> listByProfile = list.stream().collect(Collectors.groupingBy(ProfilesRatiosDto::getProfile,
				Collectors.summingDouble(ProfilesRatiosDto::getRatio)));

		Collection<Double> ratiosSum = listByProfile.values();
		for (Double sum : ratiosSum) {
			if (sum != 1)
				return false;
		}
		return true;
	}

	public static List<String> getAllProfileRatiosProfiles(List<ProfilesRatiosDto> ratiosList) {
		List<String> profileList = new ArrayList<String>();
		for (ProfilesRatiosDto ratio : ratiosList) {
			if (!profileList.contains(ratio.getProfile())) {
				profileList.add(ratio.getProfile());
			}
		}
		return profileList;
	}

}
