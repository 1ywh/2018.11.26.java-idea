package com.ywh.core.dao;

import com.ywh.core.model.FileCondition;
import com.ywh.core.model.FileThing;
import com.ywh.core.model.FileType;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ywh
 * @date 2019/11/25 15:30
 * @description 没有限制的全查询，代码没有重构
 */

public class NoLimitDaoImpl implements FileDao {

    // 数据源
    private final DataSource dataSource;

    public  NoLimitDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override

    public void insert(FileThing fileThing) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //建立连接
            connection = dataSource.getConnection();
            //准备SQL语句
            String sql = "insert into file_thing(file_name, file_path, file_depth, file_type) values(?,?,?,?) ";

            //准备命令
            preparedStatement = connection.prepareStatement(sql);
            //设置参数
            preparedStatement.setString(1, fileThing.getFile_name());
            preparedStatement.setString(2, fileThing.getFile_path());
            preparedStatement.setInt(3, fileThing.getFile_depth());
            //返回枚举的名称，比如FileType.txt--->存txt
            preparedStatement.setString(4, fileThing.getFile_type().name());
            //执行命令
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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
    public void closeAll(ResultSet resultSet, PreparedStatement statement, Connection connection) {
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

    @Override
    public List<FileThing> search(FileCondition fileCondition) {
        List<FileThing> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //建立连接
            connection = dataSource.getConnection();
            //准备SQL语句
            String sql = "select file_name, file_path, file_depth, file_type from file_thing";
            //准备命令
            preparedStatement = connection.prepareStatement(sql);
            //查询
            resultSet = preparedStatement.executeQuery();
            //处理结果
            while (resultSet.next()) {
                //行记录变为对象fileThing
                FileThing fileThing = new FileThing();
                fileThing.setFile_depth(resultSet.getInt("file_depth"));
                fileThing.setFile_name(resultSet.getString("file_name"));
                fileThing.setFile_path(resultSet.getString("file_path"));

                String fileType = resultSet.getString("file_type");
                fileThing.setFile_type(FileType.lookupByName(fileType));
                list.add(fileThing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           closeAll(resultSet,preparedStatement,connection);
        }
        return list;
    }

    public static void main(String[] args) throws SQLException {
        FileDao fileIndexDao = new  NoLimitDaoImpl(DataBaseFactory.dataSource());
        FileThing fileThing = new FileThing();
        fileThing.setFile_name("简历.txt");
        fileThing.setFile_path("F:\\test\\a\\简历.txt");
        fileThing.setFile_depth(2);
        fileThing.setFile_type(FileType.DOC);

        fileIndexDao.insert(fileThing);
        List<FileThing> fileThings = fileIndexDao.search(new FileCondition());
        for (FileThing files : fileThings) {
            System.out.println(files);
        }
    }
}
