import java.sql.DriverManager;// * -> all
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Java_test_1 {
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
            ResultSet rs = stmt.executeQuery("select * from student");//return all records
            while(rs.next()) {

                //read each record by column name
                System.out.println("SID :"+rs.getInt(1));//sid-1
                System.out.println("FIRST NAME :"+rs.getString(2));//firstName-2
                System.out.println("LAST NAME :"+rs.getString(3));//lastName-3
                System.out.println("SCORE :"+rs.getInt(4));//score-4

                System.out.println("==========================");
            }//while ends

            //2. Insert record
            //int row_count = stmt.executeUpdate("insert into student(sid,firstName,lastName,score) values(1001,'Shikha','P',92)");
            //System.out.println("Row insert :"+row_count);//1-success

            //3. delete
            //int remove_count = stmt.executeUpdate("delete from student where SID = 1001");
            //System.out.println("remove row :"+remove_count);

            //4. update
            int update_count = stmt.executeUpdate("update student set score = 100 where SID = 7");
            System.out.println("row update :"+update_count);

        }//try ends
        catch(Exception ex)
        {
            //handling exceptions and error
            System.out.println("DB error :"+ex);
        }//catch ends
    }//main ends
}//class ends