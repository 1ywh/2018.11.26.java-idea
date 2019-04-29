package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * Author:ywh
 * Date:2019/03/24
 */
public class JDBC {

    public static void main(String[] args) {
        //1.加载程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //2.获取连接
        //第一种 ：DriverManager
        //url规范  jdbc:<数据库的名字>：//host:port/<database name>
        //第二种 ；DataSource数据源

        String url = "jdbc:mysql://127.0.0.1:3306/java7";
        //都是接口
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url, "root", "199938");
            //3.创建命令
            statement = connection.createStatement();

            //4.准备SQL语句,执行
            String sql = "select id,name,balance from account";
            resultSet = statement.executeQuery(sql);



            //5.返回结果,处理结果
            while (resultSet.next()) {
                //一般不用下标 ,用列名
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int balance = resultSet.getInt("balance");
                System.out.println(String.format("id:%d   name:%s    balance:%s", id, name, balance));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            //谁先创建谁后关闭,先关结果，命令，连接
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

