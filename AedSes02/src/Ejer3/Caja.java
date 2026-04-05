package Ejer3;

import java.util.ArrayList;

public class Caja <T> {
	private String color;
	private T objeto;
	
	public Caja(String color) {
		this.color=color;
	}
	public Caja(String color, T ob) {
		this.color=color;
		objeto= ob;
	}
	
	public T getObjeto() {
		return objeto;
	}
	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
