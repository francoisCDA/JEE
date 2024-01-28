package fr.exercice.hopital.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;


@WebServlet("/photo")
public class PhotoServlet extends HttpServlet {

    //solution qui permet d'économiser seconde requète sql pour récupérer le fichier photo
    // dans un autre contexte il faudrait enregistrer le fichier dans une autre table pour optimiser le transfert d'info.
 private static Long id ;

 private static byte[] photo;


    private static void setId(Long id) {
        PhotoServlet.id = id;
    }



    private static void setPhoto(byte[] photo) {
        PhotoServlet.photo = photo;
    }

    public static void set(Long id, byte[] photo){
        setId(id);
        setPhoto(photo);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("image/jpg");
        OutputStream out = resp.getOutputStream();
        out.write(photo);
        out.close();

    }


}
