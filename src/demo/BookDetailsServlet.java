package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 144320d on 10/29/2015.
 */
@WebServlet(name = "BookDetailsServlet", urlPatterns = "/bookdetails")
public class BookDetailsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Duke's Bookstore</title></head><body bgcolor=\"#ffffff\"><center><hr> <br> &nbsp;<h1><font size=\"+3\" color=\"#CC0066\">Duke's </font> <img src=\"./duke.books.gif\" alt=\"Duke holding books\"\"><font size=\"+3\"color=\"black\">Bookstore</font></h1></center><br><hr> <br>");

        String bookId = request.getParameter("bookId");
        if (bookId != null) {
            BookDBAO db = new BookDBAO();
            BookDetails bd = db.getBookDetails(bookId);

            //Print out the information obtained
            out.println("<h2>Web components for developers</h2>&nbsp; by<em>Java Expert</em> &nbsp; &nbsp; (2015)<br> &nbsp; <br><h4>Here's what the critcs say: </h4><blockquote>Web components for developers talks about how web components can transfor the way you develop application for the web</blockquote><h4>Our Price: 5.9</h4><p><strong><a href=\"/bookcatalog?bookId=203\">Add to Cart</a>&nbsp;&nbsp;&nbsp;<a href=\"/bookcatalog\">Continue Shopping</a></p></strong>");
        }
        out.println("</body></html>");
    }
}