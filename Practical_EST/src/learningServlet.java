import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
//life cycle of servlet
/* -> when servlet is created first container loads it
    then it called init method once after that each request trigger service method
    (it figures out request is post put or get)
    finally destroy methods is called to clean up resources
*/
//Three ways to create webpage implements Servlet , extends GenereicServlet and extends HttpServlet
//servlet collaboration->One servlet calling another servlet
//     (req)
//client->server->servlet Container->web.xml
//      <-
//     (res)

//Servlet Collaboration
//|(two interface)
//|___>RequestDispatcherServlet------->{forword(req,res},{include(req,res}
//---->HttpServletResponse------------->{sendRedirect()}

//@WebServelt-> annotation to remove complexity of registering the page again and again in web.xml



//diff between forward and include
//from validate page if correct username & pass then it will process the forward page and show  then show the result of forward page alone
//if include funnction it will combine the ouput of the validatepage and itself error page and show the result

//sendRedirect
//the sendRedirect first take the path to url and then it takes back to server

//HttpServletResponse --> used when we want to move to another page which is not in our servlet
//RequestDispatcherServlet--> used to shift on relative webpage




//MVC(model view controller) desgin pattern

// Model


//  |
//  |
//controller-->Dao-->database
//  |
//  |
// view
public class learningServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();

    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}
