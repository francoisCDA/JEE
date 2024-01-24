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
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "produits", value="/produits")
public class ProduitServlet extends HttpServlet {

    private List<Produit> produits;

    private ProduitService prodServ;

    private HttpSession session;


    @Override
    public void init() throws ServletException {
        prodServ = new ProduitService();
        produits = prodServ.getAll();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();

        String connection = (String) session.getAttribute("estConnu");

        if (connection.equals("in connexion we trust")) {
            Long id = Long.valueOf(req.getParameter("idPrdct"));
            String marque = req.getParameter("marque");
            String reference = req.getParameter("reference");
            Double prix = Double.valueOf(req.getParameter("prix"));
            LocalDate date = LocalDate.parse(req.getParameter("date"));
            int stock = Integer.parseInt(req.getParameter("stock"));
            if (id == null) {
                prodServ.create(marque,reference,date,prix,stock);
            } else {
                Produit prodToUpdt = prodServ.get(id);
                prodToUpdt.setMarque(marque);
                prodToUpdt.setReference(reference);
                prodToUpdt.setPrix(prix);
                prodToUpdt.setStock(stock);
                prodToUpdt.setDateAchat(date);
                prodServ.update(prodToUpdt);
            }


            doGet(req,resp);
        } else {
            resp.sendRedirect("identification-error.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        produits = prodServ.getAll();
        req.setAttribute("produits",produits);
        req.getRequestDispatcher("produits.jsp").forward(req,resp);

    }



}
