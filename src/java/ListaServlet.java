package br.ufjf.dcc192;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaPessoasServlet", urlPatterns = {"/index.html"})
public class ListaServlet extends HttpServlet {

    private List<String> frutas;
    private List<String> frutas1;

    public ListaServlet() {
        frutas = new ArrayList<String>();
        frutas.add("Maçã");
        frutas.add("Banana");
        frutas.add("Acerola");
        frutas.add("Jabuticaba");
        frutas.add("Melancia");
        frutas.add("Romã");
    }

    public void preencheArray() {
        frutas.add("Maçã");
        frutas.add("Banana");
        frutas.add("Acerola");
        frutas.add("Jabuticaba");
        frutas.add("Melancia");
        frutas.add("Romã");
    }

    ;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comando = request.getParameter("comando");
        if ("ord".equals(comando)) {
            Collections.sort(frutas);
        } else if ("random".equals(comando)) {
            // Collections.shuffle(frutas);
            frutas.clear();
            preencheArray();

        } else if ("cresc".equals(comando)) {
            frutas1 = new ArrayList<String>();
            frutas1 = frutas;
            for (int i = 0; i <= frutas.size(); i++) {
                frutas.get(i).length();
            }
        }
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html;charset=UTF-8");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Frutas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Frutas</h1>");
            out.println("<ul>");
            for (String fruta : frutas) {
                out.println("       <li>"
                        + fruta + "</li>");
            }

            out.println("   </ul>");
            out.println("<p><a href ='?comando=ord'>Ordem Alfabetica</a></p>");
            out.println("<p><a href ='?comando=random'>Ordem Aleatoria</a></p>");
            out.println("<p><a href ='?comando=cresc'>Ordem Crescente</a></p>");
            out.println("   </body>");
            out.println("</html>");
        }

    }

}
