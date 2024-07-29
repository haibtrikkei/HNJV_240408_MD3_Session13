package ra.demo_call_procedure.controller;

import ra.demo_call_procedure.model.entity.Department;
import ra.demo_call_procedure.model.entity.Employee;
import ra.demo_call_procedure.service.impl.DepartmentServiceImpl;
import ra.demo_call_procedure.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "insertEmployee", value = "/insertEmployee")
public class InsertEmployee extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String fullName = request.getParameter("fullName");
        Boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday;
        try {
            birthday = sf.parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String address = request.getParameter("address");
        String depId = request.getParameter("depId");
        Employee e = new Employee();
        e.setFullName(fullName);
        e.setGender(gender);
        e.setBirthday(birthday);
        e.setAddress(address);
        e.setDepId(depId);

        boolean blInsert = new EmployeeServiceImpl().save(e);
        if(blInsert){
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else{
            request.setAttribute("error","Insert failed!");
            List<Department> list = new DepartmentServiceImpl().findAll();
            request.setAttribute("listDepart",list);
            request.getRequestDispatcher("insertEmployee.jsp").forward(request,response);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        doGet(request,response);
    }

    public void destroy() {
    }
}