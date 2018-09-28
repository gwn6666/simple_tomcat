package tomcat.servlet;

import tomcat.msg.Request;
import tomcat.msg.Response;

import java.io.IOException;

/**
 * @author gaoweinan
 * @date 2018/9/28
 */
public class HelloWorldServlet extends MyServlet {


    @Override
    public void doGet(Request request, Response response) {
        try {
            response.createResponse(200, "content");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(Request request, Response response) {
        try {
            response.createResponse(200, "content");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
