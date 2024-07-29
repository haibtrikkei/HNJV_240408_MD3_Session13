package ra.demo_call_procedure.controller;

import ra.demo_call_procedure.model.dto.EmployeeDTO;
import ra.demo_call_procedure.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "loadEmployees", value = "/loadEmployees")
public class LoadEmployees extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        List<EmployeeDTO> list = new EmployeeServiceImpl().findAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("listEmployees.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        doGet(request,response);
    }

    public void destroy() {
    }
}