import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.Arrays;

@WebServlet("/text")
public class text extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String tekst = request.getParameter("text");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println(tekst);
        writer.println("<h2>Ilość słow: " + iloscSlow(tekst) + "</h2>");
        writer.println("<h2>Ilosc znaków: " + tekst.length() + "</h2>");
        writer.println("<h2>Ilość znaków (bez spacji): " + znaki(tekst) + "</h2>");
        writer.println("<h2>Polindrom: " + czyPolindrom(tekst) + "</h2>");

    }

    private int iloscSlow(String tekst){
        String[] split = tekst.split("\\s+");
        int ilosc = split.length;
       return ilosc;
    }

    private int znaki(String tekst){
        String napis = tekst.replaceAll("\\s+","");
        int znaki = napis.length();
        return znaki;
    }

    private boolean czyPolindrom(String tekst){
        char[] napis =tekst.toCharArray();
        for(int i=0 ; i<napis.length; i++)
            if (napis[i] == napis[napis.length - 1 - i]) {

            }else return false;
    return true;
    }
}
