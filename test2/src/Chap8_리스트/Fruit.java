package Chap8_리스트;

import java.util.Comparator;


class Fruit {
	String name;
	int price;
	String expire;

	public Fruit(String name, int price, String expire) {
		this.name = name;
		this.price = price;
		this.expire = expire;
	}
    @Override
    public String toString() {
        return "<" + name + ", " + price + ", " + expire+ ">";
    }

	public int getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
}
class FruitNameComparator implements Comparator<Fruit>{
	public int compare(Fruit f1, Fruit f2) {
		//구현
		return f1.name.compareTo(f2.name);
	}
}
