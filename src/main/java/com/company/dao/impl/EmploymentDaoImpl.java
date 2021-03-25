/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.EmploymentDaoInter;
import com.company.entity.EmploymentHistory;
import com.company.dao.inter.AbstractDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class EmploymentDaoImpl extends AbstractDao  implements EmploymentDaoInter{
     
    private EmploymentHistory getEmploymentHistory(ResultSet rs) throws Exception {
        int userId = rs.getInt("user_id");
        String header = rs.getString("header");
        Date beginDate = rs.getDate("begin_date");
        Date endDate = rs.getDate("end_date");
        String jobDescription = rs.getString("jobDesription");

//        EmploymentHistory emp = new EmploymentHistory(null, header, beginDate, endDate, jobDescription, new User(userId));
        return null;
    }

    public List<EmploymentHistory> getEmploymentHistoryByUser(int userid) {
        List<EmploymentHistory> result = new ArrayList<EmploymentHistory>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from employment_history where u.userid=?");
            stmt.setInt(1, userid);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                EmploymentHistory u = getEmploymentHistory(rs);
                result.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }
    
}
