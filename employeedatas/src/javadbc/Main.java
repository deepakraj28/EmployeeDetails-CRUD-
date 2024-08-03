package javadbc;
import java.util.*;
public class Main {
    public static void emp()
    {
    	Scanner sc = new Scanner(System.in);
			System.out.println("Select by process by entering no");
		
			System.out.println("1.create table");
			System.out.println("2.insert data");
			System.out.println("3.select or retrieve employee specific");
			System.out.println("4.select all employee deatails");
			System.out.println("5.update");
			System.out.println("6.delete");
			int n=sc.nextInt();
			EmployeeDao edao=new EmployeeDao();
			switch(n)
			{
			case 1:
				{
					edao.create();
					break;
				}
			case 2:
			{
				
				System.out.println("Enter the number of employee details you can add?");
				int k=sc.nextInt();
				System.out.println("id ename city dept designation doj dob salary");
				for(int i=0;i<k;i++)
				{
				edao.insert(sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble());
				}
				break;
			}
			case 3:{
				System.out.print("Enter your id: ");
				edao.select(sc.nextInt());
				break;
			}
			case 4:
			{
				edao.selectAll();
				break;
			}
			case 5:
			{
				System.out.println("Enter id and salary");	
				edao.update(sc.nextInt(),sc.nextDouble());
				break;
			}
			case 6:
			{
				System.out.println("Enter id which you want to delete");
				edao.delete(sc.nextInt());
				break;
			}
			
		}
    }
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in) ;
			System.out.println("To add the details please enter 'true' or'false'");
			while(sc.nextBoolean())
			{
			emp();
			System.out.println("To add the details please enter 'true' or'false'");
			}
		
	}
	

}
