package com.typeqast.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.typeqast.app.pojos.ProfileData;
import com.typeqast.app.pojos.dto.ProfilesRatiosDto;
import com.typeqast.app.services.interfaces.IProfileService;

@RestController
public class ProfileController {

	@Autowired
	IProfileService profileService;

	// @RequestMapping(value = "/profiles", method = RequestMethod.GET, produces
	// = { MediaType.APPLICATION_JSON_VALUE })
	// public ResponseEntity<List<ProfilesRatios>> getAllReadings() {
	// List<ProfilesRatios> readingsList = profileService.getAllData();
	// if (readingsList.isEmpty())
	// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	// return new ResponseEntity<List<ProfilesRatios>>(readingsList,
	// HttpStatus.OK);
	// }

	@RequestMapping(value = "/profiles", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> importReadings(@RequestBody List<ProfilesRatiosDto> inputList) {
		profileService.addProfileRatios(inputList);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/profiles", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ProfileData>> getAllArticles() {
		List<ProfileData> list = profileService.getAllArticles();
		return new ResponseEntity<List<ProfileData>>(list, HttpStatus.OK);
	}

}
