package main.java.bean;

/*
 * @author Justin Carlitti
 * This class represents the DataBean
 * 
 */

public class DataBean {
	
	//The DataBean has two attributes to hold the mean and standard deviation.
	private float mean;
	private double stdDev;
	
	public float getMean() {
		
		return this.mean;
		
	}
	
	public void setMean(float mean) {
		
		this.mean = mean;
		
	}
	
	public double getStdDev() {
		
		return this.stdDev;
		
	}
	
	public void setStdDev(double stdDev) {
		
		this.stdDev = stdDev;
		
	}

}
