package Chap5_Unit;

public class Marine extends Unit {
	public Marine() {
		// TODO Auto-generated constructor stub
		this.setName("Marine");
		this.setAtk(6);
		this.setHp(40);
	}
	public void steampack() {
		System.out.println("marine:기분 죽이는데?");
		this.setAtk(this.getAtk()*2);
		this.setHp(getHp()-10);
	}
}
