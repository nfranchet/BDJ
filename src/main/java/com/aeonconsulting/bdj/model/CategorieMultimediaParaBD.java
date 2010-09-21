package com.aeonconsulting.bdj.model;

public enum CategorieMultimediaParaBD implements CategorieParaBD {

	UNKNOWN0(0),
	CDROM(1),
	UNKNOWN2(2),
	UNKNOWN3(3),
	UNKNOWN4(4),
	UNKNOWN5(5),
	UNKNOWN6(6),
	UNKNOWN7(7),
	UNKNOWN8(8),
	UNKNOWN9(9),
	UNKNOWN10(10);
	
	private int value;
	
	private CategorieMultimediaParaBD(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
