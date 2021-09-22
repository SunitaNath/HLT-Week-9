import java.sql.DriverManager;// * -> all
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Week9_JDBC {
    public static void main(String[] args) {
        String driveName = "com.mysql.cj.jdbc.Driver";//mysql database
        String url = "jdbc:mysql://localhost:3306/hltjavasql";//database location
        String user = "root";//database user name
        String password = "sunnyis100%Fancy";//database password
        //exception handling -> try-catch
        try
        {
            //Load driver
            Class.forName(driveName);
            //get db connection from driver manager
            Connection con = DriverManager.getConnection(url , user , password);//return Connection
            //create statement
            Statement stmt = con.createStatement();//return Statement
            //execute SQL query
            //1. select 2.insert 3.delete 4.update
            //1. select -> display all data
            ResultSet rs = stmt.executeQuery("select * from employee");
            while(rs.next()) {

                //read each record by column name
                System.out.println("eid :"+rs.getInt(1));//
                System.out.println("ename:"+rs.getString(2));//
                System.out.println("email :"+rs.getString(3));//
                System.out.println("mobile :"+rs.getString(4));//
                System.out.println("designation :"+rs.getString(5));//
                System.out.println("salary :"+rs.getDouble(6));//

                System.out.println("==========================");
            }//while ends
            //3. delete
            //int remove_count = stmt.executeUpdate("delete from employee where eid = 6");
            //System.out.println("remove row :"+remove_count);

            //4. update
            int update_count = stmt.executeUpdate("update employee set designation = 'Janitor' where eid = 5");
            System.out.println("row update :"+update_count);

        }//try ends
        catch(Exception ex)
        {
            //handling exceptions and error
            System.out.println("DB error :"+ex);
        }//catch ends
    }//main ends
}//class ends