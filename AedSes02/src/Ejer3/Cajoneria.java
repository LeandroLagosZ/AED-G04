package Ejer3;

import java.util.ArrayList;
import java.util.Iterator;

public class Cajoneria implements Iterable <Caja<?>>{
	private ArrayList<Caja<?>> lista=new ArrayList<>();
	private int tope;

	public Cajoneria(int tope) {
		super();
		this.tope=tope;
	}

	public void add(Caja<?> caja) {
		if (lista.size()<tope) {
			lista.add(caja);
		}else {
			throw new RuntimeException("no caben más");
		}
	}

	public Iterator<Caja<?>> iterator(){
		return lista.iterator();
	}
	
	public String search(Object ele) {
		for(Caja<?> i:lista) {
			if(i.getObjeto()!= null && i.getObjeto().equals(ele)) {
				int pos=lista.indexOf(i);
				return "Posición: "+pos+"  Color: "+i.getColor();
			}
		}
		return "Elemento no encontrado";
	}
	
	public int contar(Object ele) {
		int cuenta=0;
		for(Caja<?> i:lista) {
			if(i.getObjeto()!= null && i.getObjeto().equals(ele)) {
				cuenta +=1;				
			}
		}
		return cuenta;
	}
	
	public Object delete(Object ele) {
		for(Caja<?> i:lista) {
			if(i.getObjeto()!= null && i.getObjeto().equals(ele)) {
				Object eli=i.getObjeto();
				i.setObjeto(null);
				return eli;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		String cadena="Posición       Color       Objeto \n";
		for (Caja<?> i:lista) {
			int pos=lista.indexOf(i);
			cadena=cadena + pos+".             "+i.getColor()+"      "+i.getObjeto()+"\n";
		}
		return cadena;
	}
}
