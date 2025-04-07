package com.isep.dao;

import com.isep.dao.model.Emp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class EmpDAO extends DAO<Emp> {
    public EmpDAO(Connection connect) {
        super(connect);
    }
    
    @Override
    public Emp find(int id) {
        Emp emp = null;
        try {
            PreparedStatement ps = this.connect.prepareStatement(
                "SELECT empno, ename, efirst, job, mgr, sal FROM emp WHERE empno = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                emp = new Emp();
                emp.setEmpno(rs.getInt("empno"));
                emp.setEname(rs.getString("ename"));
                emp.setEfirst(rs.getString("efirst"));
                emp.setJob(rs.getString("job"));
                emp.setSal(rs.getInt("sal"));
                int mgrId = rs.getInt("mgr");
                if (!rs.wasNull()) {
                    // Appel récursif pour récupérer le manager
                    emp.setMgr(find(mgrId));
                }
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }
    
    // Implémente create, update, delete...
}
