package clashRoyale.modelo;

public class Carta {
	private String nombre;
	private int coste;
	private int damange;
	private int hp;
	public Carta(String nombre, int coste, int damange, int hp) {
		this.nombre = nombre;
		this.coste = coste;
		this.damange = damange;
		this.hp = hp;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCoste() {
		return coste;
	}
	public void setCoste(int coste) {
		this.coste = coste;
	}
	public int getDamange() {
		return damange;
	}
	public void setDamange(int damange) {
		this.damange = damange;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	
}
