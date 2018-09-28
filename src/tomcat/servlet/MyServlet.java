package tomcat.servlet;

import tomcat.msg.Request;
import tomcat.msg.Response;

/**
 * @author gaoweinan
 * @date 2018/9/28
 */
public abstract class MyServlet {

    public abstract void doGet(Request request, Response response);

    public abstract void doPost(Request request, Response response);

    public void service(Request request, Response response) {
        if (request.getMethod().equalsIgnoreCase("POST")) {
            doPost(request, response);
        } else if (request.getMethod().equalsIgnoreCase("GET")) {
            doGet(request, response);
        }

    }
}
