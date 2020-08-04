package com.codecool.hackernews;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

@WebServlet(name = "hackerNewsServlet", urlPatterns = {"/"}, loadOnStartup = 1)
public class HackerNewServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String title = "Michael Hackson news";

        String navBar = "<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n" +
                "  <a class=\"navbar-brand\" href=\"\\\">Hackson news</a>\n" +
                "  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNavAltMarkup\" aria-controls=\"navbarNavAltMarkup\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
                "    <span class=\"navbar-toggler-icon\"></span>\n" +
                "  </button>\n" +
                "  <div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">\n" +
                "    <div class=\"navbar-nav\">\n" +
                "      <a class=\"nav-item nav-link active\" href=\"#\">Top news <span class=\"sr-only\">(current)</span></a>\n" +
                "      <a class=\"nav-item nav-link\" href=\"#\">Newest</a>\n" +
                "      <a class=\"nav-item nav-link\" href=\"#\">Jobs</a>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</nav>";

        String footer = "<!-- Footer -->\n" +
                "<footer class=\"page-footer font-small blue\">\n" +
                "\n" +
                "  <div class=\"footer-copyright text-center py-3\">© 2020 Copyright: Panka\n" +
                "    <a href=\"https://mdbootstrap.com/\"> mervay.panka@gmail.com</a>\n" +
                "  </div>\n" +
                "\n" +
                "</footer>\n";

        out.println(
                "<html>\n" +
                        "<head>" +
                        "  <title>" + title + "</title>" +
                        "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>" +
                        "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">" +
                        "  <link rel=\"stylesheet\" type=\"text/css\" href='/static/css/site.css' />" +
                        "  <script type=\"module\" src=\"/static/js/main.js\" defer> </script>" +
                        "</head>\n" +
                        "<body>\n" +
                        navBar +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        "<ul>\n" +
                        "<li><b>First Name</b>: " + request.getParameter("first_name") + "\n" +
                        "<li><b>Last Name</b>: " + request.getParameter("last_name") + "\n" +
                        "</ul>\n" +
                        "<div class='visit'>You can serve any static content from <span class='folder'>webapp/static</span> folder, like a css file.</div>" +
                        "<div>Visit another servlet: <a href=\"/another\">Visit the other servlet</a></div>" +
                        "<div>You can provide a json file as well: <a href=\"/json\">Visit Hacker News json data example</a></div>" +
                        "</body> " +
                         footer +
                        "</html>"
        );
    }
}
