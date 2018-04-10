package com.typeqast.app.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.typeqast.app.pojos.MeterReadingData;
import com.typeqast.app.pojos.ProfileData;


public class MeterReadingsValidations {

	public static void main(String[] args) {

		String filePath = "meter.csv";
		List<MeterReadingData> list = processMeterReadingData(filePath);
		int i = 0;
		// for (MeterReadingData MeterReadingData : list) {
		// i++;
		// System.out.println(MeterReadingData.toString());
		// System.out.println(MeterReadingData.getMonthNum(MeterReadingData.getMonth()));
		// }
		//
		boolean meterCheck = meterCheck(list);

		// for (MeterReadingData MeterReadingData : list) {
		// i++;
		// System.out.println(MeterReadingData.toString());
		// System.out.println(MeterReadingData.getMonthNum(MeterReadingData.getMonth()));
		// }

		System.err.println(meterCheck);
	}

	private static final String COMMA = ",";

	public static List<MeterReadingData> processMeterReadingData(String inputFilePath) {
		List<MeterReadingData> inputList = new ArrayList<MeterReadingData>();
		 InputStream stream = null;
		 try {
		 stream = new FileInputStream(inputFilePath);
		
		
		 BufferedReader br = new BufferedReader(new
		 InputStreamReader(stream));
		 inputList =
		 br.lines().skip(1).map(mapToMeterReadingData).collect(Collectors.toList());
		 br.close();
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
		
		
//		try (Reader reader = Files.newBufferedReader(Paths.get(inputFilePath));) {
//			ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
//			strategy.setType(MeterReadingData.class);
//			String[] memberFieldsToBindTo = { "connectionID", "profile", "month", "meterReading" };
//			strategy.setColumnMapping(memberFieldsToBindTo);
//
//			CsvToBean csvToBean = new CsvToBeanBuilder(reader).withMappingStrategy(strategy).withSkipLines(1)
//					.withIgnoreLeadingWhiteSpace(true).build();
//
//			inputList = csvToBean.parse();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		InputStream is = MeterReadingDataValidations.class.getResourceAsStream(inputFilePath);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//	        try (FileInputStream fis = new FileInputStream(inputFilePath);
//	                InputStreamReader isr = new InputStreamReader(fis, 
//	                        StandardCharsets.UTF_8);
//	                CSVReader reader = new CSVReader(isr)) {
//	            String[] p;
//	            // skip first line
//	            reader.readNext();
//
//	            while ((p = reader.readNext()) != null) {
//
//	                	inputList.add( new MeterReadingData(p[0], p[1], p[2],
//	                			 Double.parseDouble(p[3])));
//	                
//	            }
//	        } catch (FileNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		return inputList;
	}

	 private static Function<String, MeterReadingData> mapToMeterReadingData =
	 (line) -> {
	 String[] p = line.split(COMMA);// a CSV has comma separated lines
	 MeterReadingData item = new MeterReadingData(p[0], p[1], p[2],
	 Double.parseDouble(p[3]));
	 return item;
	 };

	public static boolean meterCheck(List<MeterReadingData> meterList) {
		Collections.sort(meterList, MeterReadingData.monthsComparator);
		printList(meterList);
		Collections.sort(meterList, MeterReadingData.profileComparator);
		printList(meterList);
		for (int i = 0, j = 1; j < meterList.size(); i++, j++) {
			if (meterList.get(i).getProfile().equals(meterList.get(j).getProfile())) {
				if (meterList.get(i).getMeterReading() >= meterList.get(j).getMeterReading()) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean consumptionCheck(List<MeterReadingData> meterList) {

		return false;
	}

	public boolean ratiosProfilesCheck(List<MeterReadingData> meterList, List<ProfileData> ratiosList) {
		List<String> allMeterReadingDataProfiles = getAllMeterReadingDataProfiles(meterList);
		List<String> allProfileRatiosProfiles = ProfileRatiosValidations.getAllProfileRatiosProfiles(ratiosList);
		for (String profile : allMeterReadingDataProfiles) {
			if (!allProfileRatiosProfiles.contains(profile)) {
				return false;
			}
		}
		return true;
	}

	public static List<String> getAllMeterReadingDataProfiles(List<MeterReadingData> meterList) {
		List<String> profileList = new ArrayList<String>();
		for (MeterReadingData MeterReadingData : meterList) {
			if (!profileList.contains(MeterReadingData.getProfile())) {
				profileList.add(MeterReadingData.getProfile());
			}
		}
		return profileList;
	}

	public static void printList(List<MeterReadingData> meterList) {
		int i = 0;
		for (MeterReadingData MeterReadingData : meterList) {
			i++;
			System.out.println(MeterReadingData.toString());
		}

	}

	public static String getProjectDir() {
		try {
			Class<?> callingClass = Class.forName(Thread.currentThread().getStackTrace()[2].getClassName());
			URL url = callingClass.getProtectionDomain().getCodeSource().getLocation();
			URI parentDir = url.toURI().resolve("..").resolve("..");
			return parentDir.getPath();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return "";
	}

}
