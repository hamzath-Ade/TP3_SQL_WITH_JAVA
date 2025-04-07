import com.isep.dao.DAOFactory;
import com.isep.dao.model.Dept;
import com.isep.dao.model.DeptDAO;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:postgresql://localhost:5432/";
        String user = "postgres";
        String pass = "2411Mathusha";

        Connection connexion = null;

        try {
            DAOFactory daoFactory = new DAOFactory("jdbc:postgresql://localhost:5432/", "postgres", "2411Mathusha");
            DeptDAO deptDAO = daoFactory.getDeptDAO();
            Dept dept20 = deptDAO.find(20);
            System.out.println(dept20);
            daoFactory.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connexion = DriverManager.getConnection(url, user, pass);
            System.out.println("BDD Connected");


            /*displayDepartment(connexion);//EXO1


            moveDepartment(connexion,7369,30);//EXO2
            displayTable(connexion, "EMP");*/
            //displayTable_1(connexion, "EMP");

            moveDepartmentPS(connexion, 7369,10);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connexion != null)
                try {
                    connexion.close();
                } catch (SQLException ignore) {
                    ignore.printStackTrace();
                }
        }
    }

//PART 1
    //Exercice 1
    public static void displayDepartment(Connection connexion) throws SQLException {
        Statement statement = connexion.createStatement();

        String sql = "SELECT deptno, dname, loc FROM dept";
        ResultSet resultat = statement.executeQuery(sql);
        while (resultat.next()) {
            int deptno = resultat.getInt("deptno");
            String dname = resultat.getString("dname");
            String loc = resultat.getString("loc");
            System.out.println("Department " + deptno + " is " + dname + " and located in " + loc);
        }
        resultat.close();
        statement.close();
    }

    //Exercice 2
    public static void moveDepartment(Connection connexion, int empno, int newDeptno) throws SQLException {
        Statement statement = connexion.createStatement();
        String sql = "UPDATE emp SET deptno = " + newDeptno + " WHERE empno = " + empno;
        int rowsAffected = statement.executeUpdate(sql);
        System.out.println("Rows affected: " + rowsAffected);
        statement.close();
    }

    //Exercice 3

    public static void displayTable(Connection connexion, String tableName) throws SQLException {
        String sql = "SELECT * FROM " + tableName;
        Statement statement = connexion.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();


        for (int i = 1; i <= columnCount; i++) {
            System.out.print(rsmd.getColumnName(i) + "\t");
        }
        System.out.println();


        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
        rs.close();
        statement.close();
    }

    //Exercice 5

    public static void moveDepartmentPS(Connection connexion, int empno, int newDeptno) throws SQLException {
        /* PreparedStatement preparedStatement = connexion.prepareStatement(
                "SELECT * FROM emp WHERE efirst = ? AND ename = ?" );
        Scanner sc = new Scanner(System.in);
        String firstName = sc.next();
        preparedStatement.setString( 1, firstName );
        String lastName = sc.next();
        preparedStatement.setString( 2, lastName );
        ResultSet results = preparedStatement.executeQuery();*/
        String sql = "UPDATE emp SET deptno = ? WHERE empno = ?";
        PreparedStatement ps = connexion.prepareStatement(sql);
        ps.setInt(1, newDeptno);
        ps.setInt(2, empno);
        int rowsAffected = ps.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);
        ps.close();
    }

    //Exercice 6

    public static void displayTable_1(Connection connexion, String tableName) throws SQLException {
        String sql = "SELECT * FROM ?";
        PreparedStatement ps = connexion.prepareStatement(sql);
        ps.setString(1, tableName);

        ResultSet rs = ps.executeQuery();

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();


        for (int i = 1; i <= columnCount; i++) {
            System.out.print(rsmd.getColumnName(i) + "\t");
        }
        System.out.println();


        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }

        rs.close();
        ps.close();
    }

//PART 2



}
