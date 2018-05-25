package UseCase1;

public class Book {
	private String name;
	private int state;
	private String date;
	private int count = 0;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getState(){
		return state;
	}
	public void setState(int state){
		this.state = state;
	}
	public String getDate(){
		return date;
	}
	public void setDate(String date){
		this.date = date;
	}
	public int getCount(){
		return count;
	}
	public void setCount(int count){
		this.count = count;
	}
	
}
