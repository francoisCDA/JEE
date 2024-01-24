package fr.exercice.exoproduit.servlet;

import fr.exercice.exoproduit.models.Produit;
import fr.exercice.exoproduit.service.ProduitService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "rmproduit", value="/rmproduit")
public class RmProduitServlet extends HttpServlet {
    private ProduitService prodServ;

    @Override
    public void init() throws ServletException {
        prodServ = new ProduitService();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String connection = (String) session.getAttribute("estConnu");

        if (connection.equals("in connexion we trust")) {


            Long id = Long.parseLong(req.getParameter("id"));
            String action = req.getParameter("action");

            if ((action.equals("delete"))) {
                prodServ.del(id);
                resp.sendRedirect("produits");
                //req.getRequestDispatcher("/produits").forward(req,resp);
            }

            if ((action.equals("detail"))) {
                Produit prod = prodServ.get(id);
                req.setAttribute("prod", prod);
                req.getRequestDispatcher("details.jsp").forward(req, resp);
            }

            if ((action.equals("edit"))) {
                Produit prod = prodServ.get(id);
                req.setAttribute("prod", prod);
                req.getRequestDispatcher("new-produits.jsp").forward(req, resp);
            }
        } else {
            resp.sendRedirect("identification-error.jsp");
        }

    }
}
