package test;

/**
 * 
 * @author wy
 *
 */
public class ExceptionHandlerTest {

	static public void exceptionHandlerDo() {
		int i =0;
		int k = 0;
		
		try {
			System.out.println("try block");
			//int m = i/k;
		}catch (Throwable e) {
			// TODO: handle exception
			System.out.println("exception block");
		} 
		finally {
			// TODO: handle finally clause
			
			System.out.println("finally block");
		}
		
		System.out.println("finally next block!");
	}
	
	public static Integer finalReturnTest() {
		try {
			int k = 0/0;
		} catch (Exception e) {
			// TODO: handle exception
			return 1;
		}finally {
			return 2;
		}
	}
	public static void main(String[] args) {
		int i = finalReturnTest();
		System.err.println(i);
	}
}
