package com.aeonconsulting.bdj.model;

public enum Origine {

	EUROPE(1),
	ASIE(2),
	USA(3),
	AUTRE(0);
	
	private int value;
	
	private Origine(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
