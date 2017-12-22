package ie.gmit.sw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import java.util.concurrent.locks.Lock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ie.gmit.sw.utils.InQueueList;
import ie.gmit.sw.utils.Query;

/**
 * Servlet implementation class LookUpServlet
 */
@WebServlet("/LookUpServlet")
public class LookUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// private
	/**
	 * Default constructor.
	 */
	public LookUpServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String str = request.getParameter("lookupstr");
		System.out.println(str);
		String job_num = UUID.randomUUID().toString().replace("-", "");
		Query que = new Query();
		que.setJob_num(job_num);
		que.setStr(str);
		InitListener.INLIST.insertLast(que);
		synchronized (Lock.class) {
			Lock.class.notify();
		}
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println(job_num);
		out.print(job_num);
		out.flush();
		out.close();
	}

}
