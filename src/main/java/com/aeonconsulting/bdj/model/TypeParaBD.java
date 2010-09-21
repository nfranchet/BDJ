package com.aeonconsulting.bdj.model;

public enum TypeParaBD {

	VALUEO(0),
	TYPE_2D(1),
	TYPE_3D(2),
	MULTIMEDIA(3),
	VALUE4(4);
	
	private int value;
	
	private TypeParaBD(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
