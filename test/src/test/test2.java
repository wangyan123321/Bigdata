package test;

import java.util.function.Function;
import java.util.stream.LongStream;

import javax.swing.GroupLayout.ParallelGroup;


public class test2 {

	public static void addTimeTest(Function<Long, Long> addFunc, Long limit) {
		
		long fast = Long.MAX_VALUE;
		
		for (int i = 0; i < 10; i++) {
			Long start = System.nanoTime();
			Long sum = addFunc.apply(limit);
			Long timeUser = (System.nanoTime()-start)/1000000;
			
			fast = fast>timeUser?timeUser:fast;
		}
		
		System.err.println(fast);
	}
	
	public static Long paraleCaculate(Long n) {
		return LongStream.rangeClosed(1, n).parallel().reduce(0L,Long::sum);
		
	}
	
	public static void main(String[] args) {
		Long test1 = 100000000L;
		
		addTimeTest(test2::paraleCaculate, test1);
	}
}
