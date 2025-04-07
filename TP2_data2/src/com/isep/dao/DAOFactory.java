package com.isep.dao;

import com.isep.dao.model.Dept;
import com.isep.dao.model.DeptDAO;
import com.isep.dao.model.Emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {
    private Connection connect;
    
    public DAOFactory(String url, String user, String pass) throws SQLException {
        connect = DriverManager.getConnection(url, user, pass);
    }
    
    public DeptDAO getDeptDAO() {
        return new DeptDAO(connect) {
            @Override
            public boolean create(Dept obj) {
                return false;
            }

            @Override
            public boolean update(Dept obj) {
                return false;
            }

            @Override
            public boolean delete(Dept obj) {
                return false;
            }
        };
    }
    
    public EmpDAO getEmpDAO() {
        return new EmpDAO(connect) {
            @Override
            public boolean create(Emp obj) {
                return false;
            }

            @Override
            public boolean update(Emp obj) {
                return false;
            }

            @Override
            public boolean delete(Emp obj) {
                return false;
            }
        };
    }
    
    // Ajoute d'autres DAO si besoin...
    
    public void close() throws SQLException {
        if(connect != null) {
            connect.close();
        }
    }
}
