package fr.exercice.exoproduit.servlet;

import fr.exercice.exoproduit.models.Produit;
import fr.exercice.exoproduit.service.ProduitService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "produits", value="/produits")
public class ProduitServlet extends HttpServlet {

    private List<Produit> produits;

    private ProduitService prodServ;


    @Override
    public void init() throws ServletException {
        prodServ = new ProduitService();
        produits = prodServ.getAll();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String marque = req.getParameter("marque");
        String reference = req.getParameter("reference");
        Double prix = Double.valueOf(req.getParameter("prix"));
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        Integer stock = Integer.parseInt(req.getParameter("stock"));

        prodServ.create(marque,reference,date,prix,stock);

        produits = prodServ.getAll();

        req.setAttribute("produits",produits);
        req.getRequestDispatcher("produits.jsp").forward(req,resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("produits",produits);
        req.getRequestDispatcher("produits.jsp").forward(req,resp);

    }


}
