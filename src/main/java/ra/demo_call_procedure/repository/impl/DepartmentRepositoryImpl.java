package ra.demo_call_procedure.repository.impl;

import ra.demo_call_procedure.db.DBUtility;
import ra.demo_call_procedure.model.dto.EmployeeDTO;
import ra.demo_call_procedure.model.entity.Department;
import ra.demo_call_procedure.repository.DepartmentRepository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepositoryImpl implements DepartmentRepository {
    @Override
    public List<Department> findAll() {
        List<Department> list = new ArrayList<>();

        Connection con;
        CallableStatement cstmt;
        ResultSet rs;

        con = DBUtility.getConnection();
        try {
            cstmt = con.prepareCall("{call get_all_department()}");
            rs = cstmt.executeQuery();
            while(rs.next()){
                Department d = new Department();
                d.setDepId(rs.getString("depId"));
                d.setDepName(rs.getString("depName"));
                d.setStatus(rs.getBoolean("status"));
                list.add(d);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtility.closeConnection(con);
        }

        return list;
    }
}
