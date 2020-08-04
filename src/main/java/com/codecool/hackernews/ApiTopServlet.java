package com.codecool.hackernews;

import com.codecool.hackernews.models.NewsModel;
import com.codecool.hackernews.models.ResponseNewsModel;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet(name = "apiTopServlet", urlPatterns = {"/api/top"}, loadOnStartup = 4)
public class ApiTopServlet extends javax.servlet.http.HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = getPageContent(req.getParameter("page"));
        NewsModel[] newsModels = new Gson().fromJson(content, NewsModel[].class);
        ResponseNewsModel[] responseNewsModels = extractNewsModel(newsModels);
        String responseString = new Gson().toJson(responseNewsModels);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(responseString);
        out.flush();
    }

    private ResponseNewsModel[] extractNewsModel(NewsModel[] newsModels) {
        ResponseNewsModel[] responseNewsModels = new ResponseNewsModel[newsModels.length];
        for (int i = 0; i < newsModels.length; i++) {
            responseNewsModels[i] = new ResponseNewsModel(newsModels[i]);
        }
        return responseNewsModels;
    }

    private String getPageContent(String page) throws IOException {
        if (page == null || "0".equals(page)) page = "1";

        URL url = new URL("https://api.hnpwa.com/v0/news/" + page + ".json");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        return content.toString();
    }
}
