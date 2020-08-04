package com.codecool.hackernews;

import com.codecool.hackernews.modal.NewsModal;
import com.codecool.hackernews.modal.PageModal;
import com.codecool.hackernews.modal.ResponseNewsModal;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
import java.util.ArrayList;
import java.util.Scanner;

@WebServlet(name = "apiTopServlet", urlPatterns = {"/api/top"}, loadOnStartup = 4)
public class ApiTopServlet extends javax.servlet.http.HttpServlet {
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");
        if (page == null || "0".equals(page)) page = "1";

        URL url = new URL("https://api.hnpwa.com/v0/news/" + page + ".json");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();

        Scanner sc = new Scanner(url.openStream());
        StringBuilder content = new StringBuilder();
        while (sc.hasNext()) {
            content.append(sc.nextLine());
        }
        System.out.println(content);
        sc.close();
        con.disconnect();

        JsonParser parse = new JsonParser();
        JsonArray jsonArray = (JsonArray) parse.parse(content.toString());
        PageModal pageModal = new PageModal();
        for (var object : jsonArray) {
            pageModal.addNews(new NewsModal(
                    ((JsonObject) object).get("id"),
                    ((JsonObject) object).get("points"),
                    ((JsonObject) object).get("title"),
                    ((JsonObject) object).get("time_ago"),
                    ((JsonObject) object).get("author"),
                    ((JsonObject) object).get("url"),
                    ((JsonObject) object).get("type"),
                    ((JsonObject) object).get("domain")));
        }
        ResponseNewsModal[] responseNewsModals = new ResponseNewsModal[pageModal.getNews().size()];
        for (int i = 0; i < responseNewsModals.length ; i++) {
            responseNewsModals[i] = new ResponseNewsModal(pageModal.getNews().get(i));
        }
        String response = gson.toJson(responseNewsModals);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(response);
        out.flush();
    }
}

