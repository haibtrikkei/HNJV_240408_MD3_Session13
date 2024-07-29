package ra.demo_call_procedure.controller;

import ra.demo_call_procedure.model.dto.EmployeeDTO;
import ra.demo_call_procedure.model.entity.Department;
import ra.demo_call_procedure.service.impl.DepartmentServiceImpl;
import ra.demo_call_procedure.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "initInsertEmployee", value = "/initInsertEmployee")
public class InitInsertEmployee extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        List<Department> list = new DepartmentServiceImpl().findAll();
        request.setAttribute("listDepart",list);
        request.getRequestDispatcher("insertEmployee.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        doGet(request,response);
    }

    public void destroy() {
    }
}