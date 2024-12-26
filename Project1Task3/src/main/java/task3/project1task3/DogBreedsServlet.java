package task3.project1task3;

import com.google.gson.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Random;

@WebServlet("/DogBreedsServlet")
public class DogBreedsServlet extends HttpServlet {

    // Handle GET requests to fetch dog breed information
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Construct the API URL based on the user-provided breed
        String parentUrl = "https://dog.ceo/api/breed/";
        String breed = request.getParameter("breed");
        request.setAttribute("breed", breed); // Set the breed as an attribute for use in JSP

        // Fetch random image from Dog CEO API for the given breed
        String dogBreedURL = parentUrl + breed + "/images";
        HttpURLConnection connection = (HttpURLConnection) new URL(dogBreedURL).openConnection();
        connection.setRequestMethod("GET");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(bufferedReader, JsonObject.class);
        JsonArray imagesArray = jsonObject.getAsJsonArray("message");
        bufferedReader.close();
        connection.disconnect();

        // Select a random image and set it as an attribute
        Random random = new Random();
        int totalImages = imagesArray.size();
        int imageNumber = random.nextInt(totalImages);
        String imageUrl = imagesArray.get(imageNumber).getAsString();
        request.setAttribute("image_url", imageUrl);
        request.setAttribute("image_number", imageNumber + 1);
        request.setAttribute("total_images", totalImages);

        // Scrape an additional image from AKC website
        String urlAnotherDogImage = "https://www.akc.org/dog-breeds/" + breed;
        try {
            Document document = Jsoup.connect(urlAnotherDogImage).get();
            Element imageMetaTag = document.select("meta[property=og:image]").first();
            String anotherDogImage = imageMetaTag != null ? imageMetaTag.attr("content") : "Image not found";
            request.setAttribute("another_dog_image", anotherDogImage);
        } catch (IOException e) {
            System.out.println("Error fetching the webpage: " + e.getMessage());
        }

        // Scrape breed facts (origin, lifespan, training, health) from DogTime
        String urlDogBreedFacts = "https://dogtime.com/dog-breeds/" + breed;
        try {
            Document document = Jsoup.connect(urlDogBreedFacts).get();
            Element quickFactsSection = document.select("h2.wp-block-heading:contains(Quick Facts) + ul").first();
            if (quickFactsSection != null) {
                Iterator<Element> iterator = quickFactsSection.select("li").iterator();
                String origin = null, lifespan = null, training = null, health = null;
                while (iterator.hasNext()) {
                    Element li = iterator.next();
                    if (li.text().contains("Origin")) origin = li.text();
                    else if (li.text().contains("Lifespan")) lifespan = li.text();
                    else if (li.text().contains("Training")) training = li.text();
                    else if (li.text().contains("Health")) health = li.text();
                }
                request.setAttribute("Origin", origin);
                request.setAttribute("Lifespan", lifespan);
                request.setAttribute("Training", training);
                request.setAttribute("Health", health);
            }
        } catch (IOException e) {
            System.out.println("Error fetching the webpage: " + e.getMessage());
        }

        // Forward the request to the appropriate JSP based on pageType
        String pageType = request.getParameter("pageType");
        if ("page1".equals(pageType)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("results.jsp");
            dispatcher.forward(request, response);
        } else if ("page2".equals(pageType)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("traits.jsp");
            dispatcher.forward(request, response);
        } else {
            response.getWriter().println("Invalid page type. Please specify page1 or page2.");
        }
    }
}
