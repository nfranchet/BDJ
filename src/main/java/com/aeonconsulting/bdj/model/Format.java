package com.aeonconsulting.bdj.model;

public enum Format {
	// TODO : Mettre les bons numeros
	NORMAL(0),
	GRAND(1),
	ITALIEN(2),
	AUTRE(3),
	COMICS(4),
	MANGAS(5),
	POCHE(6);
	
	private int value;
	
	private Format(int value) {
		this.value=value;
	}

	public int getValue() {
		return value;
	}
	
}
