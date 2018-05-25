package UseCase1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import UseCase1.Book;

public class BookManager {
	Scanner sc = new Scanner(System.in);

	public void menu(){
		int num;
		startMenu();
		System.out.print("请选择：");
		num = sc.nextInt();
		switch(num){
		case 0:
			countMenu();
			break;
		case 1:
			addMenu();
			break;
		case 2:	
			searchMenu();
			break;
		case 3:
			deleteMenu();
			break;
		case 4:
			borrowMenu();
			break;
		case 5:
			returnMenu();
			break;
		case 6:
			exitMenu();
			break;
		default :
			break;
		}
	}
	public void	startMenu(){
		System.out.println("欢迎使用迷你图书管理器");
		System.out.println("------------------------------");
		System.out.println("0.借出排行版");
		System.out.println("1.新增图书");
		System.out.println("2.查看图书");
		System.out.println("3.删除图书");
		System.out.println("4.借出图书");
		System.out.println("5.归还图书");
		System.out.println("6.退出");
		System.out.println("------------------------------");
	}
	public void countMenu() {
		System.out.println("--->排行版");
		System.out.println();
		System.out.println("************************");
		count();
		System.out.println("************************");
		returnMain();
	}
	public void addMenu() {
		System.out.println("此处实现新增图书");
		System.out.println("************************");
		add();
		System.out.println("************************");
		returnMain();
	}
	public void searchMenu() {
		System.out.println("--->查看图书");
		System.out.println();
		search();
		returnMain();
	}
	public void deleteMenu() {
		System.out.println("--->删除图书");
		System.out.println();
		delete();
		returnMain();
	}
	public void borrowMenu() {
		System.out.println("--->借出图书");
		System.out.println();
		borrow();
		returnMain();
	}
	public void returnMenu() {
		System.out.println("--->归还图书");
		System.out.println();
		returnBook();
		returnMain();
	}
	public void exitMenu() {
		System.out.println("欢迎下次使用！");
	}
	public void returnMain() {
		System.out.print("输入0返回：");
		int num = sc.nextInt();
		switch(num){
			case 0:
				menu();
				break;
			default:
				System.out.print("输入错误，请重新输入：");
				int a = sc.nextInt();
				switch(a){
					case 0:
						menu();
						break;
					default:
						break;
					}
		}
	}
	List<Book> books = new ArrayList<Book>();
	public  void initial(){
		Book a = new Book();
		a.setName("罗马假日");
		a.setState(0);
		a.setDate("2010-7-1");
		a.setCount(15);
		books.add(a);
		Book b = new Book();
		b.setName("风声鹤唳");
		b.setState(1);
		b.setCount(15);
		books.add(b);
		Book c = new Book();
		c.setName("浪漫满屋");
		c.setState(1);
		c.setCount(15);
		books.add(c);
	}
	public void count(){
		System.out.println("次数\t名称");
		Collections.sort(books,new Comparator<Book>(){
			public int compare(Book obj1,Book obj2){
				Book b1 = (Book)obj1;
				Book b2 = (Book)obj2;
				if(b1.getCount() < b2.getCount()){
					return 1;
				}else if(b1.getCount() > b2.getCount()){
					return -1;
				}else{
					return 0;
				}
			}
		});
		for(int i = 0; i < books.size(); i++){
			Book book = new Book();
			book = (Book)books.get(i);
			if(book.getName() != null){
				System.out.println(book.getCount() + "\t《" + book.getName() + "》");
			}
		}
	}
	public void add(){
		System.out.print("请输入图书名称：");
		String name = sc.next();
		Book book = new Book();
		book.setName(name);
		book.setState(1);
		books.add(book);
		System.out.println("新增《" + name + "》成功！");
	}
	public void search(){
		System.out.println("序号\t状态\t名称\t\t借出日期");
		for(int i = 0; i < books.size(); i++){
			Book book = (Book)books.get(i);	
			if(book.getName() == null){
				break;
			}else if(book.getName() != null){
				String s;
				if(book.getState() == 1)s = "可借";
				else s = "已借出";
				System.out.print((i + 1) + "\t");
				System.out.print(s+"\t《");
				System.out.print(book.getName() + "》\t");
				if(book.getDate() == null)s = "";
				else s = book.getDate();
				System.out.println("\t"+s);
			}
		}
	}
	public void delete(){
		System.out.print("请输入图书名称：");
		String name = sc.next();
		for(int i = 0; i < books.size(); i++){
			Book book = (Book)books.get(i);
			if(book.getName() != null && book.getName().equals(name) && book.getState() == 1){
				books.remove(book);
				System.out.println("删除《" + name + "》成功！");
				break;
			}
			else if(book.getName() != null && book.getName().equals(name) && book.getState() == 0){
				System.out.println("《" + name + "》为借出状态，不能删除！");
				break;
			}else if(i == books.size() - 1){
				System.out.println("没有找到匹配信息！");
				break;
			} 				
		}
	}
	public void borrow(){
		System.out.print("请输入图书名称：");
		String name = sc.next();
		System.out.print("请输入借出日期（年-月-日）：");
		String date = sc.next();
		for(int i = 0; i < books.size(); i++){
			Book book = (Book)books.get(i);
			if(book.getName().equals(name) && book.getState() == 1){
				book.setState(0);
				book.setDate(date);
				int count  = book.getCount()+1;
				book.setCount(count);
				System.out.println("借出《" + name + "》成功！");
			}else if(book.getName().equals(name) && book.getState() == 0){
				System.out.println("《" + name + "》已被借出！");
			}else if(i == books.size()-1){
				System.out.println("没有找到匹配信息！");
			}
		}
	}
	public void returnBook() {
		System.out.print("请输入图书名称：");
		String name = sc.next();
		System.out.print("请输入归还日期（年-月-日）：");
		String date1 = sc.next();
		for(int i = 0; i < books.size(); i++){
			Book book = (Book)books.get(i);
			if(book.getName().equals(name) && book.getState() == 0){
				book.setState(1);
				SimpleDateFormat sd = new SimpleDateFormat("yyy-MM-dd");
				Date d1 = null, d2 = null;
				try{
					d1 = sd.parse(date1);
					d2 = sd.parse(book.getDate());
				}catch(ParseException e){
					e.printStackTrace();
				}
				long charge;
				charge = (d1.getTime() - d2.getTime())/(24*60*60*1000);
				System.out.println("\n归还《" + name + "》成功！");
				System.out.println("借出日期为：" + book.getDate());
				System.out.println("归还日期为：" + date1);
				System.out.println("应付租金（元）：" + charge);
				book.setDate(null);
			}
		}
	}
}
