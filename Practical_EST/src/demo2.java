import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


class demo2 extends GenericServlet{
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String username = servletRequest.getParameter("uname");
        String password = servletRequest.getParameter("upass");

        if(username.equals("hello") && password.equals("hello@123")){
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/valid");
            requestDispatcher.forward(servletRequest,servletResponse);
        }else{
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/error");
            requestDispatcher.include(servletRequest,servletResponse);
        }
    }
}