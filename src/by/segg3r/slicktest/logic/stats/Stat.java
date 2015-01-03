package by.segg3r.slicktest.logic.stats;

import java.util.ArrayList;
import java.util.List;

public class Stat {

	private double baseValue;
	private List<Double> modifiers = new ArrayList<Double>();
	private List<Double> multipliers = new ArrayList<Double>();
	private boolean reversed;
	
	public Stat(double baseValue) {
		this(baseValue, false);
	}
	
	public Stat(double baseValue, boolean reversed) {
		super();
		this.baseValue = baseValue;
		this.reversed = reversed;
	}
	
	public double getValue() {
		double result = baseValue;
		for (double modifier : modifiers) {
			result += modifier;
		}
		for (double multiplier : multipliers) {
			result *= multiplier;
		}
		return reversed ? 1. / result : result;		
	}
	
	public void addModifier(double modifier) {
		this.modifiers.add(modifier);
	}
	
	public void addMultiplier(double multiplier) {
		this.multipliers.add(multiplier);
	}
	
	public void removeModifier(double modifier) {
		this.modifiers.remove(modifier);
	}
	
	public void removeMultiplier(double multiplier) {
		this.multipliers.remove(multiplier);
	}
	
}
