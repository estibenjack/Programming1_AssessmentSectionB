package p1;

// for debugging: import java.util.Arrays;

/**
 * Steven J****** (********)
 * 
 * int[][] temperatures = { 
           {15, 18, 20, 22, 19, 21, 23, 17, 16, 18 },         // Tokyo
           {30, 32, 31, 29, 28, 33, 34, 30, 31, 32, 29 },     // New York
           {-5, 0, 3, -2, -1, 1, 2, -3, 0, 1 },               // Moscow
           {25, 27, 26, 28, 29, 30, 27, 26, 25 },             // Sydney
           {10, 12, 15, 14, 13, 11, 12, 14, 15, 13, 12 },     // London
           {35, 37, 36, 34, 33, 32, 31, 30, 36, 35, 34, 33 }, // Dubai
           {5, 7, 10, 8, 6, 9, 11, 7, 8, 6 },                 // Toronto
           {0, 2, 5, 3, 1, 4, 6, 2, 3, 1 },                   // Berlin
           {28, 30, 27, 29, 31, 32, 30, 28, 29, 27 }          // Rome
       };
		    
String[] cityNames = new String[]{ "Tokyo", "New York", "Moscow", "Sydney", 
            "London", "Dubai", "Toronto", "Berlin", "Rome" };
 * 
 */
public class WeatherData {

	public static void main(String[] args) {
		
		int[][] temperatures = { 
		           {15, 18, 20, 22, 19, 21, 23, 17, 16, 18 },         // Tokyo
		           {30, 32, 31, 29, 28, 33, 34, 30, 31, 32, 29 },     // New York
		           {-5, 0, 3, -2, -1, 1, 2, -3, 0, 1 },               // Moscow
		           {25, 27, 26, 28, 29, 30, 27, 26, 25 },             // Sydney
		           {10, 12, 15, 14, 13, 11, 12, 14, 15, 13, 12 },     // London
		           {35, 37, 36, 34, 33, 32, 31, 30, 36, 35, 34, 33 }, // Dubai
		           {5, 7, 10, 8, 6, 9, 11, 7, 8, 6 },                 // Toronto
		           {0, 2, 5, 3, 1, 4, 6, 2, 3, 1 },                   // Berlin
		           {28, 30, 27, 29, 31, 32, 30, 28, 29, 27 }          // Rome
		       };
				    
		String[] cityNames = new String[]{ "Tokyo", "New York", "Moscow", "Sydney", 
		            "London", "Dubai", "Toronto", "Berlin", "Rome" };
		
		double[] averageTemps = new double[temperatures.length];
		for (int i=0; i<temperatures.length; i++) {
			averageTemps[i] = getAvgTemperature(temperatures[i]);
		}
		// print the headers
		System.out.println("*******************************************************************");
		System.out.printf("%-15s%-15s%-15s%-15s%-15s%n", "City", "Avg Temp", "High Temp", "Low Temp", "Climate");
		
		// trying nested for loops to display code
//		System.out.println(Arrays.toString(averageTemps));
		for (int i=0; i<temperatures.length; i++) {
			System.out.printf("%-15s%-15.2f%-15d%-15d%-15s", cityNames[i],
															getAvgTemperature(temperatures[i]),
															getHighestTemp(temperatures[i]), 
															getLowestTemp(temperatures[i]), 
															getClimate(averageTemps[i]));
			System.out.println();
		}
		
		// print 'city with highest av...' and 'city with lowest av...'
		
//		for (int i=0; i<temperatures.length; i++) {
//			averageTemps[i] = getAvgTemperature(temperatures[i]);
//		}
		
		System.out.println("City with the Highest Average Temperature: " + getHighestAvgCity(averageTemps));
		System.out.println("City with the Lowest Average Temperature: " + getLowestAvgCity(averageTemps));
	}
	
	/**
	 * Method to return the average temperature of an array of ints
	 * @param tempArray
	 * @return
	 */
	public static double getAvgTemperature (int[] tempArray) {
		double totalTemps = 0;
		for (int temp : tempArray) {
			totalTemps += temp;
		}
		return (totalTemps / tempArray.length);
		
	}
	
	/**
	 * Method to return the highest temperature in an array of ints
	 * @param tempArray
	 * @return
	 */
	public static int getHighestTemp (int[] tempArray) {
		int highestTemp = tempArray[0];
		for (int i=1; i<tempArray.length; i++) {
			if (tempArray[i] > highestTemp) {
				highestTemp = tempArray[i];
			}
		}
		return highestTemp;
	}
	
	/**
	 * Method to return the lowest temperature in an array of ints
	 * @param tempArray
	 * @return
	 */
	public static int getLowestTemp (int[] tempArray) {
		int lowestTemp = tempArray[0];
		for (int i=1; i<tempArray.length; i++) {
			if (tempArray[i] < lowestTemp) {
				lowestTemp = tempArray[i];
			}
		}
		return lowestTemp;
	}
	
	/**
	 * Method to return the name of the city with the highest average temperature in an array of doubles
	 * @param avgArray
	 * @return
	 */
	public static String getHighestAvgCity (double[] avgArray) {
		int highestAvgIndex = 0;
		double highestAvgValue = avgArray[0];
		for (int i=1; i<avgArray.length; i++) {
			if (avgArray[i] > highestAvgValue) {
				highestAvgIndex = i;
				highestAvgValue = avgArray[i];
			}
		}
		switch (highestAvgIndex) {
		case 0:
			return "TOKYO";
		case 1:
			return "NEW YORK";
		case 2:
			return "MOSCOW";
		case 3:
			return "SYDNEY";
		case 4:
			return "LONDON";
		case 5:
			return "DUBAI";
		case 6:
			return "TORONTO";
		case 7:
			return "BERLIN";
		case 8:
			return "BERLIN";
		case 9:
			return "ROME";
			default: 
				return "UNKNOWN";

		}
	}
	
	/**
	 * Method to return the name of the city with the lowest average temperature in an array of doubles
	 * @param avgArray
	 * @return
	 */
	public static String getLowestAvgCity (double[] avgArray) {
		int lowestAvgIndex = 0;
		double lowestAvgValue = avgArray[0];
		for (int i=1; i<avgArray.length; i++) {
			if (avgArray[i] < lowestAvgValue) {
				lowestAvgIndex = i;
				lowestAvgValue = avgArray[i];
			}
		}
		switch (lowestAvgIndex) {
		case 0:
			return "TOKYO";
		case 1:
			return "NEW YORK";
		case 2:
			return "MOSCOW";
		case 3:
			return "SYDNEY";
		case 4:
			return "LONDON";
		case 5:
			return "DUBAI";
		case 6:
			return "TORONTO";
		case 7:
			return "BERLIN";
		case 8:
			return "BERLIN";
		case 9:
			return "ROME";
			default: 
				return "UNKNOWN";

		}
	}
	
	/**
	 * Method to return a colour coded temperature description with a matching emoticon
	 * @param avgArray
	 * @return
	 */
	public static String getClimate(double avgArray) {
		String climate = "";
			if (avgArray>=25 && avgArray<=35) {
				climate = "\033[0;31mHot \uD83E\uDD75\033[0;97m";
			} else if (avgArray>=15 && avgArray<=24) {
				climate = "\033[38;5;208mWarm \u2600\033[0;97m";
			} else if (avgArray>=5 && avgArray<=14) {
				climate = "\033[0;34mCool \u2744\033[0;97m";
			} else if (avgArray>= -10 && avgArray<=4) {
				climate = "\033[0;30mCold \u26C4\033[0;97m";
			} else {
				climate = "\033[0;30mUNKNOWN";
			}
			
		return climate;
	}
}
