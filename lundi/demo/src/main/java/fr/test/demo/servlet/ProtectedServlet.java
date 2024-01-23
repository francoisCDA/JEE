package fr.test.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="protected", value="/protect")
public class ProtectedServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




        //       resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//
        //out.println("<html><body>");

        // ****************** les coockies **********************

//        boolean logged = false;
//
//        Cookie[] cookies = req.getCookies();
//
//        for (Cookie c: cookies) {
//            if(c.getName().equals("isLogged") && c.getValue().equals("true") ) {
//                out.println("<div>Connecté</div>");
//                logged= true;
//                break;
//            }
//        }
//
//        if(!logged) {
//            out.println("<div>pas connecté</div>");
//        }
//

        // *****************  les sessions ***********************

        HttpSession session = req.getSession();


        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
//
        out.println("<html><body>");



        boolean logged = (session.getAttribute("isLogged")!=null) ? (boolean) session.getAttribute("isLogged") : false ;

        if(logged) {
            out.println("<div>Connecté</div>");
        } else {
            out.println("<div>pas connecté</div>");
        }



        out.println("</html></body>");






    }
}
