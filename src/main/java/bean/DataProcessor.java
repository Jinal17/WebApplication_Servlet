package main.java.bean;

/*
 * @author Justin Carlitti
 * This class represents the Data Processor which is responsible for calculating the 
 * mean and standard Deviation
 */

public class DataProcessor {

	/*
	 * Responsible for calculating the mean
	 * @returns: a float
	 * @param: nums that is represented as String from the Data Field on the Survey form
	 */
	public float mean(String nums) {
		
		float mean = 0;
		
		String[] values = nums.split(",");
		
		for(String value : values) {
			mean += Integer.parseInt(value);
		}
		
		return mean/values.length;
		
	}
	
	/*
	 * Responsible for calculating the Std Dev
	 * @return: a double
	 * @param: nums that is represented as String from the Data Field on the Survey form
	 * @param: a double mean that can be obtained from calling the other method in this class on the 
	 * same number set 
	 */
	public double stdDev(String nums, double mean) {
		
		double stdDev = 0.0;
		double sum = 0.0;
		
		String[] values = nums.split(",");
		
		for(String value : values) {
			
			sum += Math.pow((Integer.parseInt(value) - mean), 2);
			
		}
		
		stdDev = Math.sqrt(sum/values.length);
		
		return stdDev;
		
	}
	
}
