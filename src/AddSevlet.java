

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;
import com.factory.StudentSerivceFactory;
import com.service.StudentService;

/**
 * Servlet implementation class AddSevlet
 */
@WebServlet("/AddSevlet")
public class AddSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		String sid=request.getParameter("sid");
		String sname=request.getParameter("sname");
		String saddress=request.getParameter("saddress");
		
		Student std = new Student();
		std.setSid(sid);
		std.setSname(sname);
		std.setSaddress(saddress);
		StudentService stdService= StudentSerivceFactory.getStudentService();
		stdService.addStudent(std);
		
		List<Student> std_list=stdService.getAllStudents();
		out.println("<html>");
		out.println("<body><br><br>");
		out.println("<table border='i'>");
		out.println("<tr><th>SID</th><th>SNAME</th><th>SADDRESS</th></tr>");
		for(Student student:std_list) {
			out.println("<tr>");
			out.println("<td>"+student.getSid()+"</td>");
			out.println("<td>"+student.getSname()+"</td>");
			out.println("<td>"+student.getSaddress()+"</td>");
			out.println("</tr>");
		}
		
		out.println("</tabel>");
		out.println("</hr></body>");
		out.println("</html>");
		
		RequestDispatcher rd= request.getRequestDispatcher("/index.html");
		rd.include(request, response);
		
		
		
	}

}
