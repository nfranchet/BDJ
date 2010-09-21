package com.aeonconsulting.bdj.model;

public enum Categorie2DParaBD implements CategorieParaBD {

	DIVERS(0),
	EXLIBRIS(1),
	VALUE2(2),
	VALUE3(3),
	VALUE4(4),
	VALUE5(5),
	VALUE6(6),
	CARTE(7),
	VALUE8(8),
	MARQUEPAGE(9),
	COFFRET(10),
	VALUE11(11),
	VALUE12(12),
	VALUE13(13),
	VALUE14(14),
	VALUE15(15),
	VALUE16(16)
	;
	
	private int value;
	
	private Categorie2DParaBD(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
