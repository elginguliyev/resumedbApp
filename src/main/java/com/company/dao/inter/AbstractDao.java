package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDao {
    public   Connection connect() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost/resume?useUnicode=" +
                "true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Baku";
        String username="root";
        String password="16792115";
        Connection c= DriverManager.getConnection(url, username,  password);
        return c;
    }
}
