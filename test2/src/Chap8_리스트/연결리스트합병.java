package Chap8_List;

import Chap3_검색.ArrayList;
import Chap3_검색.Fruit;
import Chap3_검색.Iterator;

public class 연결리스트합병 {
    ArrayList<Fruit> lst3 = new ArrayList<Fruit>();

	Iterator<Fruit> iter1 = lst1.iterator();
	Iterator<Fruit> iter2 = lst2.iterator();
	Fruit data1 = iter1.next();
	Fruit data2 = iter2.next();
    while (iter1.hasNext() && iter2.hasNext()) {
    	if ((data1.compareTo(data2))< 0) {lst3.add(data1);data1 = iter1.next();}
    	else if ((data1.compareTo(data2)) > 0) {lst3.add(data2);data2 = iter2.next();}
    	else {lst3.add(data1);data1 = iter1.next();data2 = iter2.next();}

    }
    while (iter1.hasNext()) {
    	lst3.add(data1);data1 = iter1.next();
    }
    while (iter2.hasNext()) {
    	lst3.add(data2);data2 = iter2.next();
    }
}
