package by.segg3r.slicktest.logic.vitals;

public class Vital {
	
	private double currentValue;	
	private double maxValue;
	
	public Vital(double maxValue) {
		this.maxValue = maxValue;
		this.currentValue = maxValue;
	}
	
	public Vital add(double value) {
		this.currentValue =  Math.min(maxValue, currentValue + value);
		return this;
	}
	
	public Vital setMaxValue(double maxValue) {
		this.maxValue = maxValue;
		return this;
	}

	public double getCurrentValue() {
		return this.currentValue;
	}
	
	public double getMaxValue() {
		return maxValue;
	}

	public boolean has(double value) {
		return currentValue >= value;
	}

	public void reduce(double value) {
		this.currentValue = Math.max(0, currentValue - value);
	}
	
}
