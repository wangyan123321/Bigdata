package test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;

public class test {
	
	public static boolean isZhiShu(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static Map<Boolean, List<Integer>> getdata(Integer n) {
		return IntStream.rangeClosed(2, n).boxed().collect(Collectors.partitioningBy(d->isZhiShu(d)));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH) );
		List<Dish> names = menu.stream().filter(d->{
			return d.getCalories()>300;
		}).distinct()
		.limit(3)
		.collect(toList());
		System.err.println(names);
		
		menu.stream().forEach(System.err::println);
		
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		
		System.err.println(numbers.stream().filter(d->d%3==1).distinct().skip(1).collect(toList()));
		String str = new String();
		List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
		System.err.println(words.stream().map(d->d.length()).collect(toList()));
		
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		numbers1.stream().flatMap(d->numbers2.stream().map(b->new int[]{d,b}))
		.filter(d->(d[0]+d[1])%3==0).forEach(d->System.err.println(d[0]+" "+d[1]));
		numbers1.stream().flatMap(d->numbers2.stream().filter(b -> (b+d)%3==0).map(b->new int[]{d,b})).forEach(d->System.err.println(d[0]+" "+d[1]));

		if (numbers1.stream().anyMatch(d->d>3)) {
			System.err.println("111");
		}
		if (numbers.stream().noneMatch(d->d<0)) {
			System.err.println("0000");
		}
		numbers1.stream().filter(d->d>2).findAny().ifPresent(d->System.err.println(d));
		
		numbers1.stream().reduce((a,b)->a>b? a:b ).ifPresent(a->System.err.println(a));
		
		numbers1.stream().reduce(Integer::max ).ifPresent(a->System.err.println(a));
		
		menu.stream().map(b->b.getName()).map(b->1).reduce(Integer::sum).ifPresent(d->System.err.println(d));
	
		long sum = menu.stream().collect(Collectors.counting());
		System.err.println(sum);
		System.err.println(menu.stream().count());
		
		//构建一个接口
		Comparator< Dish> comDish = Comparator.comparingInt(Dish::getCalories);
		System.err.println(menu.stream().collect(Collectors.maxBy(comDish)));
		
		IntSummaryStatistics su = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
		System.err.println(su);
		
		System.err.println(menu.stream().collect(Collectors.groupingBy(Dish::getType)));
	
		System.err.println(getdata(50));
	}

}
