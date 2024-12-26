# Dogs-breed-web-application
Overview: This web application displays information about different dog breeds, including images and facts, by utilizing web scraping and APIs. The user interacts with a dropdown menu to select a dog breed, after which the app provides information such as a randomly chosen image from the Dog CEO API, three facts about the breed from web-scraped data, and another dynamically generated image related to dogs. The app is built in Java, JSP, and follows the MVC (Model-View-Controller) architecture pattern for separation of concerns.

Features: Dog Breed Selection: The app presents a dropdown menu with a list of specific dog breeds. Users can select a breed and submit their choice. Random Image of Dog Breed: After submitting a breed, the app fetches a random image of the selected breed from the Dog CEO API, indicating how many images were available and which one was selected. Breed Facts: The app scrapes at least three facts about the selected dog breed from different web sources. These facts are presented to the user along with citations. Additional Dynamic Dog Image: An additional image of a dog (not from Dog CEO) is displayed. This image changes dynamically upon each execution. Error Handling: The app handles errors such as network issues or unavailable data in a user-friendly manner, displaying appropriate error messages.

Technologies Used: Java & JSP: The application is primarily developed in Java and JSP, following the MVC design pattern. Dog CEO API: This API is used to fetch images of dog breeds in JSON format. Gson Library: Used to parse JSON data returned by the Dog CEO API. Web Scraping: Data about dog breeds is scraped from web sources using libraries like jsoup, allowing the application to extract HTML elements from websites. HTML: The frontend is built using HTML, including dropdown menus and checkboxes for user interaction.

Installation: Clone the Repository: Clone the project to your local machine. Set Up Maven Dependencies: Ensure that all Maven dependencies, including gson and jsoup, are set up correctly in your pom.xml file. If necessary, reload Maven projects to apply the changes.

API Access: The Dog CEO API is used to fetch images. No API key is required, but you will need internet access for the app to connect to the API.

Run the Application: Run the application using a local server like Apache Tomcat or another Java web server. Ensure that the server is properly configured with SSL certificates to avoid SSL handshake issues.

Usage Welcome Page: The user starts on the welcome page where they see a dropdown menu of dog breeds. The breeds are limited to a predefined list. Selecting a Breed: The user selects a breed from the dropdown and presses the "Submit" button. Displaying Information: After submission: A random image of the selected breed is fetched from the Dog CEO API and displayed, along with the total number of images and the selected image index. The app displays three facts about the selected breed, scraped from web sources. Citations for these facts are shown. Another dynamically fetched dog-related image is displayed. Error Handling: If there are issues fetching images or facts, error messages guide the user.

MVC Structure Model: Responsible for handling API requests (Dog CEO API) and web scraping for breed facts. View: Contains JSP pages to render the input and output, including the welcome page, dog images, and breed facts. Controller: Handles the user input (breed selection) and manages the flow between the Model and View.

Web Scraping Notes The app scrapes data from reliable web sources that provide factual information about dog breeds. It uses the jsoup library to parse and extract this data. Ensure that you do not scrape from restricted websites or use copyrighted images.

Error Handling The app catches exceptions such as IOException, SSLHandshakeException, and invalid data formats gracefully. Error messages are shown to the user in case of issues with data fetching.

API Citation The random dog image is fetched from Dog CEO API, and the image source is credited appropriately.

Acknowledgements Dog CEO API: For providing random dog breed images. jsoup: For simplifying the web scraping process. Gson Library: For parsing JSON data efficiently.
