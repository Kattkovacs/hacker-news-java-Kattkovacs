package com.codecool.hackernews;

import java.util.List;

public class StaticHtmlParts {

    public static String getHead(String title, List<String> args) {
        String head = "";
        head +=
                "<head>" +
                "  <title>" + title + "</title>";
        if (args.contains("bootstrap")) head += " <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js%22%3E</script>" +
                "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>" +
                "  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">" +
                "  <link rel=\"canonical\" href=\"https://getbootstrap.com/docs/4.0/examples/sticky-footer/\">";
        head += "  <link rel=\"stylesheet\" type=\"text/css\" href='/static/css/site.css' />" +
                "</head>\n";
        return head;
    }


    public static String getMenubar() {
        return "<nav class=\"navbar sticky-top navbar-expand-lg navbar-dark bg-dark\">\n" +
                "  <a class=\"navbar-brand\" href=\"\\\">Hackson news</a>\n" +
                "  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNavAltMarkup\" aria-controls=\"navbarNavAltMarkup\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
                "    <span class=\"navbar-toggler-icon\"></span>\n" +
                "  </button>\n" +
                "  <div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">\n" +
                "    <div class=\"navbar-nav\">\n" +
                "      <a class=\"nav-item nav-link\" href=\"#\">Top News</a>\n" +
                "      <a class=\"nav-item nav-link\" href=\"#\">Newest</a>\n" +
                "      <a class=\"nav-item nav-link\" href=\"#\">Jobs</a>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</nav>";
    }

    public static String getFooter() {
        return "    <footer class=\"footer\">\n" +
                "      <div class=\"container\">\n" +
                "        <span class=\"text-muted\">Katt - kattkovacs@codecool.com</span>\n" +
                "      </div>\n" +
                "    </footer>";
    }
}
