/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlets;

import Models.Pokemon;
import com.google.gson.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.net.URI;
import java.net.http.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="SvApi", urlPatterns={"/SvApi"})
public class SvApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpClient client = HttpClient.newHttpClient();
          
            HttpRequest apiRequest = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("https://pokeapi.co/api/v2/pokemon?limit=24"))
                    .build();

            HttpResponse<String> apiResponse = client.send(apiRequest, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonObject = JsonParser.parseString(apiResponse.body()).getAsJsonObject();
            JsonArray results = jsonObject.getAsJsonArray("results");

            List<Pokemon> listaPokemon = new ArrayList<>();

            for (JsonElement element : results) {
                JsonObject pokeObj = element.getAsJsonObject();
                String name = pokeObj.get("name").getAsString();
                String url = pokeObj.get("url").getAsString();

                HttpRequest detailRequest = HttpRequest.newBuilder()
                        .GET()
                        .uri(URI.create(url))
                        .build();

                HttpResponse<String> detailResponse = client.send(detailRequest, HttpResponse.BodyHandlers.ofString());
                JsonObject detailJson = JsonParser.parseString(detailResponse.body()).getAsJsonObject();
                String image = detailJson.getAsJsonObject("sprites").get("front_default").getAsString();
                int id = detailJson.get("id").getAsInt();

                Pokemon p = new Pokemon();
                p.setName(name);
                p.setImage(image);
                p.setId(id);

                listaPokemon.add(p);
            }

            request.setAttribute("listaPokemon", listaPokemon);

        } catch (Exception e) {
            request.setAttribute("errorApi", e.getMessage());
        }

        request.getRequestDispatcher("/secure/home.jsp").forward(request, response);
    }
}
