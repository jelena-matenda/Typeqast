package com.typeqast.app.utils;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.typeqast.app.pojos.ProfileData;

public class ProfileRatiosValidations {

	public static List<ProfileData> processProfilesRatios(List<ProfileData> list) {
		List<ProfileData> inputList = new ArrayList<ProfileData>();

		assertTrue("Sum of ratios isn't 1", validateRatios(list));

		// List<ProfilesRatios> distinctElements =
		// list.stream().filter(distinctByKey(p ->
		// p.)).collect(Collectors.toList());

		return inputList;
	}

	public static boolean validateRatios(List<ProfileData> list) {
		Map<String, Double> listByProfile = list.stream().collect(
				Collectors.groupingBy(ProfileData::getProfileId, Collectors.summingDouble(ProfileData::getRatio)));

		Collection<Double> ratiosSum = listByProfile.values();
		for (Double sum : ratiosSum) {
			if (sum != 1)
				return false;
		}
		return true;
	}

	public static List<String> getAllProfileRatiosProfiles(List<ProfileData> ratiosList) {
		List<String> profileList = new ArrayList<String>();
		for (ProfileData ratio : ratiosList) {
			if (!profileList.contains(ratio.getProfileId())) {
				profileList.add(ratio.getProfileId());
			}
		}
		return profileList;
	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> map = new ConcurrentHashMap<>();
		return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

}
