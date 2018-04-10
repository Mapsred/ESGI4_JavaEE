package servlet;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

@WebServlet("/json_example")
public class JsonServlet extends HttpServlet {
    /**
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws IOException exception
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder().add("index", "Hello World !");

        JsonObject jsonObject = objectBuilder.build();

        String jsonString;
        try (Writer writer = new StringWriter()) {
            Json.createWriter(writer).write(jsonObject);
            jsonString = writer.toString();
        }

        response.getWriter().write(jsonString);
    }
}
