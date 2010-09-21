package com.aeonconsulting.bdj.model;

public enum Aspect {

	VALUE1(0),
	POLYCHROME(1),
	MONOCHROME(2),
	NOIRETBLANC(3)
	;
	
	private int value;
	
	private Aspect(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
