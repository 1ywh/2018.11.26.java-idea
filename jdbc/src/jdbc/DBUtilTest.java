package jdbc;

import java.sql.*;

/**
 * @author ywh
 * @date 2019/11/2 19:21
 * @description   PrepareStatement 创建对象
 */
public class DBUtilTest {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //创建连接
            connection = DBUtil.getConnection();
            //1 PreparedStatement 执行命令
            String sql = "select *from table where qq_mail" + "like ? and class_id= ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 3);//第一个参数值
            preparedStatement.setString(2, "%孙");//第二个参数值
            resultSet = preparedStatement.executeQuery();
            //插入

//            //2  Statement 注入，漏洞
//            String sql1 = "select *from table where id=3";
//            Statement statement = connection.createStatement();
//            ResultSet resultSet1 = statement.executeQuery(sql1);
            while (resultSet.next()) {
                Integer id = resultSet.getInt(2);
                Integer name = resultSet.getInt("j");
                System.out.println(String.format("%d,%d", id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


