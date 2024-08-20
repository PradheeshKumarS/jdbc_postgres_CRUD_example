import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresqlCRUD {
	
	public static void main(String[] args) {
		
		// Step 1 : create connection to the database by giving dbname , userid and password;
		Connection conobj = connectDb("mydb", "user" , "password");
		
		// Step 2 : C in CRUD (Create a table)
		createTable(conobj, "Student");
		
		// Step 3 : Insert some rows
		insertRows(conobj , "Student" , "kumar" , 1 , "AIDS");
		insertRows(conobj , "Student" , "karna" , 2 , "CIVIL");
		insertRows(conobj , "Student" , "sakthi" , 3 , "CSE");
		insertRows(conobj , "Student" , "gopal" , 4 , "IT");
		insertRows(conobj , "Student" , "sanjay" , 5 , "MECH");
		
		// Step 4 : U in CRUD (update rows in a table)
		updateRows(conobj,"Student" , "Annan" , 3);
		
		// Step 5 : D in CRUD (delete rows in a table)
		deleteRows(conobj , "Student", 3);
		
		// Step 6 : R in CRUD (read data from table)
		readtable(conobj, "Student");
		
		
	}
	
	// First a connection has to be created via driver manager
	
	public static Connection connectDb(String dbname , String user , String password) {
		
		Connection con = null;
		String url = "jdbc:postgresql://localhost:5432/";
		
		try {
			
			con = DriverManager.getConnection(url + dbname , user , password);
			if(con != null) {
				System.out.println("Connected to database !!");
			}else {
				System.out.println("Oops !! Connection failed");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	// Create a Table in the database
	
	public static void createTable(Connection con , String tablename) {
		Statement st = null;
		try {
			String query = "create table " + tablename + " (name varchar(20) , rollno int , department varchar(20));";
			st = con.createStatement();
			st.executeUpdate(query);
			System.out.println("Table created successfully....");
		}
		catch (SQLException e) {
			System.out.println("Problem in creating table !!!");
			System.out.println(e.getMessage());
		}
	}
	
	// Insert values in the table
	
	public static void insertRows(Connection con , String tname , String name , int rno , String dept) {
		Statement stmt;
		 
        try
        {
            String query=String.format("insert into %s(name,rollno,department) values('%s','%s','%s');",tname,name,rno,dept);
            stmt=con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Inserted successfully !");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
	}
	
	// Read from the table
	
	public static void readtable(Connection c , String tname) {
		Statement st;
		ResultSet rs;
		
		try {
			
			st = c.createStatement();
			rs = st.executeQuery("select * from " + tname + ";");
			
			System.out.println("Name\t\tRollno\t\tDept");
            System.out.println("-----------------------------------------------");
            
            while(rs.next()) {
            	System.out.print(rs.getString("name")+"\t\t");
                System.out.print(rs.getString("rollno")+"\t\t");
                System.out.println(rs.getString("department"));
            }

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Update records from table
	
	public static void updateRows(Connection con , String tname , String newname , int rno) {
		Statement stmt;
		 
        try
        {
            String query=String.format("update %s set name = '%s' where rollno = '%d';", tname,newname, rno);
            stmt=con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Updated successfully !");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
	}
	
	// Delete records from table
	
	public static void deleteRows(Connection con , String tname , int rno) {
		Statement stmt;
		 
        try
        {
            String query=String.format("delete from %s where rollno = %d;", tname, rno);
            stmt=con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Deleted successfully....");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
	}
	
	
}
