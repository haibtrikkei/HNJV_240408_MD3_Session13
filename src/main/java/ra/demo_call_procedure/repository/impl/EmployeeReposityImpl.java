package ra.demo_call_procedure.repository.impl;

import ra.demo_call_procedure.db.DBUtility;
import ra.demo_call_procedure.model.dto.EmployeeDTO;
import ra.demo_call_procedure.model.entity.Employee;
import ra.demo_call_procedure.repository.EmployeeReposity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeReposityImpl implements EmployeeReposity {
    @Override
    public List<EmployeeDTO> findAll() {
        List<EmployeeDTO> list = new ArrayList<>();

        Connection con;
        CallableStatement cstmt;
        ResultSet rs;

        con = DBUtility.getConnection();
        try {
            cstmt = con.prepareCall("{call get_all_employee()}");
            rs = cstmt.executeQuery();
            while(rs.next()){
                EmployeeDTO e = new EmployeeDTO();
                e.setEmpId(rs.getInt("empId"));
                e.setFullName(rs.getString("fullName"));
                e.setGender(rs.getBoolean("gender"));
                e.setBirthday(rs.getDate("birthday"));
                e.setAddress(rs.getString("address"));
                e.setDepId(rs.getString("depId"));
                e.setDepName(rs.getString("depName"));
                list.add(e);
                con.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtility.closeConnection(con);
        }

        return list;
    }

    @Override
    public EmployeeDTO findById(Integer empId) {
        EmployeeDTO e = null;

        Connection con;
        CallableStatement cstmt;
        ResultSet rs;

        con = DBUtility.getConnection();
        try {
            cstmt = con.prepareCall("{call get_employee_by_id(?)}");
            cstmt.setInt(1, empId);
            rs = cstmt.executeQuery();
            if(rs.next()){
                e = new EmployeeDTO();
                e.setEmpId(rs.getInt("empId"));
                e.setFullName(rs.getString("fullName"));
                e.setGender(rs.getBoolean("gender"));
                e.setBirthday(rs.getDate("birthday"));
                e.setAddress(rs.getString("address"));
                e.setDepId(rs.getString("depId"));
                e.setDepName(rs.getString("depName"));
            }
        } catch (SQLException e1) {
            throw new RuntimeException(e1);
        }finally {
            DBUtility.closeConnection(con);
        }

        return e;
    }

    @Override
    public boolean save(Employee emp) {
        boolean bl = false;

        Connection con;
        CallableStatement cstmt;

        con = DBUtility.getConnection();
        try {
            cstmt = con.prepareCall("{call insert_employee(?,?,?,?,?)}");
            cstmt.setString(1, emp.getFullName());
            cstmt.setBoolean(2, emp.getGender());
            cstmt.setDate(3, new Date(emp.getBirthday().getTime()));
            cstmt.setString(4, emp.getAddress());
            cstmt.setString(5, emp.getDepId());
            int i = cstmt.executeUpdate();
            if(i>0)
                 bl = true;
        } catch (SQLException e1) {
            throw new RuntimeException(e1);
        }finally {
            DBUtility.closeConnection(con);
        }

        return bl;
    }

    @Override
    public boolean update(Employee emp) {
        boolean bl = false;

        Connection con;
        CallableStatement cstmt;

        con = DBUtility.getConnection();
        try {
            cstmt = con.prepareCall("{call update_employee(?,?,?,?,?,?)}");
            cstmt.setString(1, emp.getFullName());
            cstmt.setBoolean(2, emp.getGender());
            cstmt.setDate(3, new Date(emp.getBirthday().getTime()));
            cstmt.setString(4, emp.getAddress());
            cstmt.setString(5, emp.getDepId());
            cstmt.setInt(6, emp.getEmpId());
            int i = cstmt.executeUpdate();
            if(i>0)
                bl = true;
        } catch (SQLException e1) {
            throw new RuntimeException(e1);
        }finally {
            DBUtility.closeConnection(con);
        }

        return bl;
    }

    @Override
    public boolean delete(Integer empId) {
        boolean bl = false;

        Connection con;
        CallableStatement cstmt;

        con = DBUtility.getConnection();
        try {
            cstmt = con.prepareCall("{call delete_employee(?)}");
           cstmt.setInt(1, empId);
            int i = cstmt.executeUpdate();
            if(i>0)
                bl = true;
        } catch (SQLException e1) {
            throw new RuntimeException(e1);
        }finally {
            DBUtility.closeConnection(con);
        }

        return bl;
    }

    @Override
    public List<EmployeeDTO> findByName(String empName) {
        List<EmployeeDTO> list = new ArrayList<>();

        Connection con;
        CallableStatement cstmt;
        ResultSet rs;

        con = DBUtility.getConnection();
        try {
            cstmt = con.prepareCall("{call get_employee_by_name(?)}");
            if(empName.equals("null"))
                empName = "";
            cstmt.setString(1, empName);
            rs = cstmt.executeQuery();
            while(rs.next()){
                EmployeeDTO e = new EmployeeDTO();
                e.setEmpId(rs.getInt("empId"));
                e.setFullName(rs.getString("fullName"));
                e.setGender(rs.getBoolean("gender"));
                e.setBirthday(rs.getDate("birthday"));
                e.setAddress(rs.getString("address"));
                e.setDepId(rs.getString("depId"));
                e.setDepName(rs.getString("depName"));
                list.add(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtility.closeConnection(con);
        }

        return list;
    }
}
