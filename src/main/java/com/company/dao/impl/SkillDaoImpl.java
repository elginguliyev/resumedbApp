/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.SkillDaoInter;
import com.company.entity.UserSkill;
import com.company.dao.inter.AbstractDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class SkillDaoImpl extends AbstractDao implements SkillDaoInter{
      public UserSkill getUserSkill(ResultSet rs) throws Exception {
        int userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");

        int power = rs.getInt("power");
        String skillName = rs.getString("skill_name");

//        return new UserSkill(null, new User(userId), new Skill(skillId, skillName), power);
        return null;
    }

    @Override
    public List<UserSkill> getAllSkillByUser(int userid) {
        List<UserSkill> result = new ArrayList<UserSkill>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("SELECT"
                    + "\tu.*,"
                    + "\tus.skill_id,"
                    + "\ts.NAME AS skill_name,"
                    + "\tus.power "
                    + "FROM"
                    + "\tuser_skill us"
                    + "\tLEFT JOIN USER u ON us.user_id = u.id"
                    + "\tLEFT JOIN skill s ON us.skill_id = s.id"
                    + "\twhere us.user_id=?");
            stmt.setInt(1, userid);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                UserSkill u = getUserSkill(rs);
                result.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

   
    
}
