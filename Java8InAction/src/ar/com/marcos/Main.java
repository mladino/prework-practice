package ar.com.marcos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) {
	
		List<Apple> inventory = Arrays.asList(new Apple(80, "red"),
											new Apple(155, "green"),
											new Apple(120, "green"));
		inventory.forEach((Apple a) -> System.out.println(a.getWeight()));
		System.out.println("-------");
		inventory.sort(new Comparator<Apple>() {
			@Override
			public int compare(Apple o1, Apple o2) {
				return o2.getWeight().compareTo(o2.getWeight());
			}
		});
		inventory.forEach((Apple a) -> System.out.println(a.getWeight()));
		System.out.println("-------");
		inventory.sort((Apple a1, Apple a2)-> a1.getWeight().compareTo(a2.getWeight())) ;
		inventory.forEach((Apple a) -> System.out.println(a.getWeight()));
		System.out.println("-------");
		process(()->System.out.println("Corriendo un hilo con lambda"));
		forEach(Arrays.asList(1,2,3,4,5),(Integer p)->System.out.println(p));
		
	}
	
	public static void process(Runnable r){
		r.run();
	}
	
	public static <T> void forEach(List<T> list, Consumer<T> c){
		for(T i:list){
			c.accept(i);
		}
	}

}
