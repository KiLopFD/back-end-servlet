package core.backend.backend;

import java.io.*;

import Models.UsersEntity;
import Utils.Serializers.UserSerializer;
import com.google.gson.Gson;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        // Hello
        PrintWriter out = response.getWriter();
        UsersEntity usersEntity = new UsersEntity();
        UserSerializer userSerializer = new UserSerializer(usersEntity);
        out.println(userSerializer.getName(1));
    }

    public void destroy() {
    }
}