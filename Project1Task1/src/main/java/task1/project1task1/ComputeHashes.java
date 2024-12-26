package task1.project1task1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import jakarta.xml.bind.DatatypeConverter;

@WebServlet("/computeHashes")
public class ComputeHashes extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve input text and selected hash function from the form
        String inputText = request.getParameter("text");
        String hashFunction = request.getParameter("hashFunction");

        // Set the response type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Create a MessageDigest instance for the selected hash algorithm
            MessageDigest messageDigest = MessageDigest.getInstance(hashFunction);

            // Compute the hash as a byte array
            byte[] hashBytes = messageDigest.digest(inputText.getBytes());

            // Convert the byte array to hexadecimal and base64 formats
            String hexHash = DatatypeConverter.printHexBinary(hashBytes);
            String base64Hash = DatatypeConverter.printBase64Binary(hashBytes);

            out.println("<html><body>");
            out.println("<h2>Hash Calculation Result</h2>");
            out.println("<p>Original Text: " + inputText + "</p>");
            out.println("<p>Hash Function: " + hashFunction + "</p>");
            out.println("<p>Hexadecimal Hash: " + hexHash + "</p>");
            out.println("<p>Base64 Hash: " + base64Hash + "</p>");
            out.println("</body></html>");

        } catch (NoSuchAlgorithmException e) {
            // Handle the case where the selected algorithm is not available
            out.println("<html><body><p>Error: Hash algorithm not available.</p></body></html>");
        } finally {
            out.close();
        }
    }
}
