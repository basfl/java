package com.example.model;

import java.io.Serializable;

public class Record implements Serializable {
	boolean maleFlag;
	boolean femaleFlag;
	boolean kgFlag;
	double bmi;

	public boolean isKgFlag() {
		return kgFlag;
	}

	public void setKgFlag(boolean kgFlag) {
		this.kgFlag = kgFlag;
	}

	double weight;

	public boolean isMaleFlag() {
		return maleFlag;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setMaleFlag(boolean maleFlag) {
		this.maleFlag = maleFlag;
	}

	public boolean isFemaleFlag() {
		return femaleFlag;
	}

	public void setFemaleFlag(boolean femaleFlag) {
		this.femaleFlag = femaleFlag;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

}
