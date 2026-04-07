package emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.DTO.EmpDTO;
import emp.service.EmpService;


@WebServlet("/emp")
public class EmpController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. 서비스 호출
        EmpService service = new EmpService();
        List<EmpDTO> empList = service.getEmpList();

        // 2. request에 담기
        request.setAttribute("empList", empList);

        // 3. JSP로 forward
        RequestDispatcher rd = request.getRequestDispatcher("/empList.jsp");
        rd.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
