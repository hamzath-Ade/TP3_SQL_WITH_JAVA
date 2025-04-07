package com.isep.dao.model;

import com.isep.dao.DAO;
import com.isep.dao.model.Dept;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DeptDAO extends DAO<Dept> {
    public DeptDAO(Connection connect) {
        super(connect);
    }
    
    @Override
    public Dept find(int id) {
        Dept dept = null;
        try {
            PreparedStatement ps = this.connect.prepareStatement("SELECT deptno, dname, loc FROM dept WHERE deptno = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dept = new Dept();
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                dept.setLoc(rs.getString("loc"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
    }
    
    // Implémente create, update, delete si besoin...
}
