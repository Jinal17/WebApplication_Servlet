package main.java.bean;

/*
 * @author Justin Carlitti
 * This class represents the DataBean. 
 * It is used to hold Mean & Standard Deviation based on the input
 */

public class DataBean {

	// The DataBean has two attributes to hold the mean and standard deviation.
	private double mean;
	private double stdDev;

	public DataBean(double mean, double stdDev) {
		this.mean = mean;
		this.stdDev = stdDev;
	}

	public double getMean() {

		return this.mean;

	}

	public void setMean(double mean) {

		this.mean = mean;

	}

	public double getStdDev() {

		return this.stdDev;

	}

	public void setStdDev(double stdDev) {

		this.stdDev = stdDev;

	}

}
