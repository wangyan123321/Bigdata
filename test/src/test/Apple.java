package test;

/**
 * 
 * @author wy
 *
 */
public class Apple implements Fruite {

	String color;
	Integer weight;
	String city;
	
	public Apple(){
		color = "red";
		weight = 10;
		city = "changchun";
	}
	
	public Apple(String color){
		this.color = color;
		weight = 10;
		city = "changchun";
	}
	
	public Apple(String color, Integer weight){
		this.color = color;
		this.weight = weight;
		city = "changchun";
	}
	
	public Apple(String color, Integer weight, String city){
		this.color = color;
		this.weight = weight;
		this.city = city;
	}
	
	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getWeight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + ", city=" + city + "]";
	}
	//2222
	//111111222
	
	//测试数据2
	//qianduan tianjia xinde shuju
	
	//测试数据3
	
	//ceshiSHUJU4
	
	
	//本地测试数据5
}
