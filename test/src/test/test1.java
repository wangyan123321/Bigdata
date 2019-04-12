package test;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class test1 {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		List<Transaction> transactions = Arrays.asList(
		new Transaction(brian, 2011, 300),
		new Transaction(raoul, 2012, 1000),
		new Transaction(raoul, 2011, 400),
		new Transaction(mario, 2012, 710),
		new Transaction(mario, 2012, 700),
		new Transaction(alan, 2012, 950)
		);
		
		System.err.println(transactions.stream()
				.filter(b->b.getYear()==2011)
				.sorted(Comparator.comparing(Transaction::getValue).reversed())
				.collect(toList()));
		System.err.println(transactions.stream()
				.map(b->b.getTrader().getCity())
				.distinct()
				.collect(toList()));
		System.err.println(transactions.stream()
				.map(b->b.getTrader())
				.distinct()
				.filter(b->b.getCity() == "Cambridge")
				.sorted(Comparator.comparing(Trader::getName))
				.collect(toList()));
		System.err.println(transactions.stream()
				.map(b->b.getTrader().getName())
				.distinct()
				.sorted()
				.collect(toList()));
		System.err.println(transactions.stream()
				.anyMatch(a->a.getTrader().getCity()=="Milan"));
		transactions.stream()
				.filter(b->b.getTrader().getCity()=="Cambridge")
				.map(b->b.getValue())
				.reduce(Integer::sum)
				.ifPresent(b->System.err.println(b));
		transactions.stream()
				.map(b->b.getValue())
				.reduce(Integer::max)
				.ifPresent(b->System.err.println(b));
		transactions.stream()
		.map(b->b.getValue())
		.reduce(Integer::min)
		.ifPresent(b->System.err.println(b));
		
		IntStream.rangeClosed(1, 50)
				.boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 50)
						.filter(b -> Math.sqrt(a*a+b*b)%1==0)
						.mapToObj(b->new int[] {a,b,(int)Math.sqrt(a*a+b*b)})
				).forEach(a->System.err.println(a[0]+" "+a[1]+" "+a[2]));;

	}
}
