import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "Qazwsx150508";
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(" SELECT course_name AS Name, Count(subscription_date) AS CountPurchase, MAX(MONTH(subscription_date)) AS LastMonthSales FROM PurchaseList GROUP BY course_name;");
            System.out.println(" Название курса - Среднее покупок в месяц : ");
            while (resultSet.next()){
                String courseName = resultSet.getString("Name");
                double countPurchase = Double.parseDouble(resultSet.getString("CountPurchase"));
                double lastMonthSales = Double.parseDouble(resultSet.getString("LastMonthSales"));
                double value = countPurchase/lastMonthSales;
                System.out.printf(courseName + " - %.2f \n" , value);
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
