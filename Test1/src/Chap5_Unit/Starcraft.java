package Chap5_Unit;

public class Starcraft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marine marine = new Marine();
		Firebat firebat = new Firebat();
		Unit tank = new Unit("Tank", 150, 30);
		System.out.println(marine.unitStatus());
		System.out.println(firebat.unitStatus());
		System.out.println(tank.unitStatus());
		marine.attack(tank);
		System.out.println(tank.unitStatus());
		marine.attack(tank);
		marine.attack(tank);
		marine.attack(tank);
		marine.attack(tank);
		marine.attack(tank);
		marine.attack(tank);
		marine.attack(tank);
		marine.attack(tank);
		marine.attack(tank);
		marine.attack(tank);
		System.out.println(tank.unitStatus());
	}

}