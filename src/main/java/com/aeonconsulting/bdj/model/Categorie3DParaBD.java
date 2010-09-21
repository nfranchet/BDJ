package com.aeonconsulting.bdj.model;

public enum Categorie3DParaBD implements CategorieParaBD {

	VALUE0(0),
	STATUETTE(1),
	VALUE2(2),
	VALUE3(3),
	VALUE4(4),
	VALUE5(5),
	VALUE6(6),
	VALUE7(7),
	VALUE8(8),
	VALUE9(9);
	
	private int value;
	
	private Categorie3DParaBD(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
