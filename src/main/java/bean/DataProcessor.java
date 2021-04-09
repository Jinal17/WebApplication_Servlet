package main.java.bean;

/*
 * @author Justin Carlitti
 * This class represents the Data Processor which is responsible for calculating the 
 * mean and standard Deviation
 */

public class DataProcessor {

	String nums;

	public DataProcessor(String nums) {
		this.nums = nums;
	}

	public DataBean calculate() {
		double mean = mean();
		double sd = stdDev(mean);
		DataBean dataBean = new DataBean(mean, sd);
		return dataBean;
	}

	/*
	 * Responsible for calculating the mean
	 * 
	 * @returns: a double
	 * 
	 * @param: nums that is represented as String from the Data Field on the Survey
	 * form
	 */
	public double mean() {

		String[] values = this.nums.split(",");
		double sum = 0;
		for (String value : values) {
			sum += Integer.parseInt(value);
		}
		return sum / values.length; // get mean

	}

	/*
	 * Responsible for calculating the Std Dev
	 * 
	 * @return: a double
	 * 
	 * @param: nums that is represented as String from the Data Field on the Survey
	 * form
	 * 
	 * @param: a double mean that can be obtained from calling the other method in
	 * this class on the same number set
	 */
	public double stdDev(double mean) {

		double stdDev = 0.0;
		double sum = 0.0;

		String[] values = this.nums.split(",");

		for (String value : values) {

			sum += Math.pow((Integer.parseInt(value) - mean), 2);

		}

		stdDev = Math.sqrt(sum / values.length);

		return stdDev;

	}

}
