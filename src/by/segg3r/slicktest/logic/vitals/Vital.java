package by.segg3r.slicktest.logic.vitals;

public class Vital {
	
	private double currentValue;	
	private double maxValue;
	private double regenerationValue;
	
	public Vital(double maxValue, double regenerationValue) {
		this.maxValue = maxValue;
		//this.currentValue = maxValue;
		this.regenerationValue = regenerationValue;
	}
	
	public Vital update(double d) {
		double regenerated = d * regenerationValue;
		add(regenerated);
		return this;
	}
	
	public Vital add(double value) {
		this.currentValue =  Math.min(maxValue, currentValue + value);
		return this;
	}
	
	public Vital setMaxValue(double maxValue) {
		this.maxValue = maxValue;
		return this;
	}
	
	public Vital setRegenerationValue(double regenerationValue) {
		this.regenerationValue = regenerationValue;
		return this;
	}
	
	public double getCurrentValue() {
		return this.currentValue;
	}
	
	public double getMaxValue() {
		return maxValue;
	}
	
}
