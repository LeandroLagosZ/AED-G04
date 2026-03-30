public class ZonaMinera {
	private String mineral;
	private double cantidad;
	private double pureza;

	public ZonaMinera(String mineral, double cantidad, double pureza) {
		this.mineral = mineral;
		this.cantidad = cantidad;
		this.pureza = pureza;
	}

	public String getMineral() {
		return mineral;
	}

	public double getCantidad() {
		return cantidad;
	}

	public double getPureza() {
		return pureza;
	}

	public double calcularValorEconomico() {
		return cantidad * pureza;
	}

	@Override
	public String toString() {
		return "[ " + mineral + ", cantidad: " + cantidad + ", pureza: " + pureza + " ]";
	}
}