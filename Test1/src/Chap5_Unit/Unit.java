package Chap5_Unit;

public class Unit {
	private String name;
	private int hp;
	private int atk;
	
	public Unit() {
		// TODO Auto-generated constructor stub
	}
	public Unit(String name, int hp, int atk) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getHp() {
		return hp;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getAtk() {
		return atk;
	}
	public String unitStatus() {
		return getName() + "/" + "hp:" + getHp() + "/" + "공격력:" + getAtk();
	}
	public void attacked(Unit unit) {
		this.setHp(this.hp-unit.getAtk());
	}
	public void attack(Unit unit) {
		System.out.println("공격합니다.");
		unit.attacked(this);
	}
}