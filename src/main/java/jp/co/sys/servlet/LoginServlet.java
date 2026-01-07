package jp.co.sys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 直接URLを叩かれた場合はログイン画面へ戻す
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // コンテキストパスを含めてリダイレクト
        response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
    }

    // JSPのフォームから送信された時の処理
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("user_id");
        String pass = request.getParameter("password");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h1>Java Servlet 受信成功</h1>");
        out.println("<p>取得したコンテキストパス: " + request.getContextPath() + "</p>");
        out.println("<p>入力ID: " + id + "</p>");
        out.println("<p>入力PW: " + pass + "</p>");
        out.println("<hr>");
        out.println("<a href='" + request.getContextPath() + "/jsp/login.jsp'>戻る</a>");
        out.println("</body></html>");
    }
}