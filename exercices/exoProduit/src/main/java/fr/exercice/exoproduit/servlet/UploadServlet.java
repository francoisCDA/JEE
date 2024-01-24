package fr.exercice.exoproduit.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "upload", value = "/upload" )
@MultipartConfig(maxFileSize = 10 * 1024 * 1024)
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uploadPath = getServletContext().getRealPath("/") + "images";

        File file = new File(uploadPath);

        if (!file.exists()) {
            file.mkdir();
        }

        Part image = req.getPart("image");

        String fileName = image.getSubmittedFileName();

        String pathimg = uploadPath + File.separator + fileName;

        image.write(pathimg);

        String idUpdt = req.getParameter("idUpdt");

        req.setAttribute("idPrdct", idUpdt );
        req.setAttribute("pathimg",fileName);
        req.getRequestDispatcher("produits").forward(req,resp);

    }


}
