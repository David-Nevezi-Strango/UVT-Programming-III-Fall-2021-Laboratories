package Laboratory4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Given the following class hierarchy:
 * 
 * - Class Airplane:
 * String producer
 * int    code
 * int    numberOfEndedFlies
 * double combustibleCapacity
 * 
 * - Class FightAirplane:
 * boolean canCamouflage
 * double  ammoCapacity
 * 
 * - Class LineAirplane
 * int maximumPassengersNumber
 * 
 * - Class PersonalAirplane
 * String            actualOwner
 * List<String>      pastOwners
 * 
 * LineAirplane and PersonalAirplane implements LuxuryOptions:
 * boolean hasNoiseCancellingHeadphones
 * boolean hasTvWithTouchpadForEachPassenger
 * 
 * 1. Create the described hierarchy
 * 2. Create an ArrayList of airplanes and print it
 * 3. Create and print a dictionary which contains the airplane type as the key
 * and the number of airplanes with that type in the list as the value in the
 * following format:
 * repeat the * character N times where N is the number of airplanes of that type
 * e.g.
 * FightAirplane **     <- meaning that there are 2 FightAirplanes in the array
 * LineAirplane *****   <- meaning that there are 5 LineAirplane in the array
 * PersonalAirplane *** <- meaning that there are 3 PersonalAirplane in the array
 * 4. Print the airplanes that have noise-cancelling headphones
 * 5. Print the airplanes that had the most past owners
 * 6. Print the average combustible capacity for each type of airplane
 */

public class Exercise1 {
	public static void main(String args[]) {
		// 2. Create an ArrayList of airplanes and print it
		System.out.println("The ArrayList of airplanes:");
		List<Airplane> airplanes = createAirplanesArrayList();
		System.out.println(airplanes);

		// 3. Create and print a dictionary which contains the airplane type as the key
		// and the number of airplanes with that type in the list as the value in the
		// following format: repeat the * character N times where N is the number of
		// airplanes of that type! e.g.:
		// FightAirplane ** <- meaning there are 2 FightAirplanes in the array
		// LineAirplane ***** <- meaning there are 5 LineAirplane in the array
		// PersonalAirplane *** <- meaning there are 3 PersonalAirplane in the array
		System.out.println("The map of airplanes:");
		Map<String, Integer> numberOfAirplanes = createNumberOfAirplanesByTypeDictionary(airplanes);
		displayDictionaryInTheSpecifiedFormat(numberOfAirplanes);

		// 4. Print the airplanes that have noise-cancelling headphones
		System.out.println("Airplanes that have noise-cancelling headphones:");
		displayTheAirplanesThatHaveNoiseCancellingHeadphones(airplanes);

		// 5. Print the airplanes that had the most past owners
		System.out.println("Airplanes that had the most past owners:");
		displayTheAirplanesThatHadTheMostPastOwner(airplanes);

		// 6. Print the average combustible capacity for each type of airplane
		System.out.println("The average combustible capacity for each type of airplane:");
		displayTheAverageCombustibleCapacityForEachTypeOfAirplane(airplanes);
	}

	private static List<Airplane> createAirplanesArrayList() {
		List<Airplane> airplanes = new ArrayList<Airplane>();
		airplanes.add(new FightAirplane("Lockheed Corporation", 1001, 12, 6000, true, 5000));
		airplanes.add(new FightAirplane("Lockheed Corporation", 1002, 3, 8000, false, 8000));
		airplanes.add(new LineAirplane("Airbus", 2001, 100, 10000, 125));
		airplanes.add(new PersonalAirplane("Westland Widgeon", 3001, 20, 800, "Patrick",
				new ArrayList<String>(List.of("George", "Victor"))));
		return airplanes;
	}

	private static Map<String, Integer> createNumberOfAirplanesByTypeDictionary(List<Airplane> airplanes) {
		Map<String, Integer> dictionary = new HashMap<String, Integer>();
		dictionary.put("FightAirplane", 0);
		dictionary.put("LineAirplane", 0);
		dictionary.put("PersonalAirplane", 0);
		for (Airplane airplane : airplanes) {
			String airplaneType = airplane.getClass().getSimpleName();
			dictionary.put(airplaneType, dictionary.get(airplaneType) + 1);
		}
		return dictionary;
	}

	private static void displayDictionaryInTheSpecifiedFormat(Map<String, Integer> dictionary) {
		for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
			System.out.println(entry.getKey() + " " + "*".repeat(entry.getValue()));
		}
	}

	private static void displayTheAirplanesThatHaveNoiseCancellingHeadphones(List<Airplane> airplanes) {
		List filteredAirplanes = airplanes.stream()
				.filter(airplane -> hasNoiseCancellingHeadphones(airplane)).collect(Collectors.toList());

		for (Airplane airplane : filteredAirplanes) {
			System.out.println(airplane);
		}
	}

	private static boolean hasNoiseCancellingHeadphones(Airplane airplane) {
		return LuxuryOptions.class.isAssignableFrom(airplane.getClass())
		       && ((LuxuryOptions) airplane).hasNoiseCancellingHeadphones();
	}

	private static void displayTheAirplanesThatHadTheMostPastOwner(List<Airplane> airplanes) {
		int maximumPastOwners = 0;

		// Compute the maximum past owners number
		for (Airplane airplane : airplanes) {
			if (airplane instanceof PersonalAirplane) {
				if (((PersonalAirplane) airplane).pastOwners.size() > maximumPastOwners) {
					maximumPastOwners = ((PersonalAirplane) airplane).pastOwners.size();
				}
			}
		}

		// Print the airplanes that have the same amount of past owners
		for (Airplane airplane : airplanes) {
			if (airplane instanceof PersonalAirplane) {
				if (((PersonalAirplane) airplane).pastOwners.size() == maximumPastOwners) {
					System.out.println(airplane);
				}
			}
		}
	}

	private static void displayTheAverageCombustibleCapacityForEachTypeOfAirplane(List<Airplane> airplanes) {
		Map<String, Integer> numberOfAirplanes = createNumberOfAirplanesByTypeDictionary(airplanes);

		double fightAirplaneCombustibleCapacity = 0;
		double lineAirplaneCombustibleCapacity = 0;
		double personalAirplaneCombustibleCapacity = 0;

		for (Airplane airplane : airplanes) {
			if (airplane instanceof FightAirplane) {
				fightAirplaneCombustibleCapacity += airplane.combustibleCapacity;
			} else if (airplane instanceof LineAirplane) {
				lineAirplaneCombustibleCapacity += airplane.combustibleCapacity;
			} else {
				personalAirplaneCombustibleCapacity += airplane.combustibleCapacity;
			}
		}

		System.out.println("FightAirplane medium combustible capacity: "
				+ fightAirplaneCombustibleCapacity / numberOfAirplanes.get("FightAirplane"));
		System.out.println("LineAirplane medium combustible capacity: "
				+ lineAirplaneCombustibleCapacity / numberOfAirplanes.get("LineAirplane"));
		System.out.println("PersonalAirplane medium combustible capacity: "
				+ personalAirplaneCombustibleCapacity / numberOfAirplanes.get("PersonalAirplane"));
	}
}
