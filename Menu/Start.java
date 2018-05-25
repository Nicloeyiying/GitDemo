package Menu;

import UseCase1.BookManager;
public class Start {
	public static void main(String[]args){
		BookManager m = new BookManager();
		m.initial();
		m.menu();
	}
}
