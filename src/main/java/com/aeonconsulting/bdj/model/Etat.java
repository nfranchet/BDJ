package com.aeonconsulting.bdj.model;

public enum Etat {

	NEUF(0),
	TRES_BON(1),
	BON(2),
	MOYEN(3),
	MAUVAIS(4);
	
	private int value;
	
	private Etat(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	
}
