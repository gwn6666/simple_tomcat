package tomcat.msg;

import tomcat.servlet.MyServlet;
import tomcat.servlet.ServletMappingConfig;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gaoweinan
 * @date 2018/9/28
 */
public class Tomcat {

    private int port;

    private Map<String, String> urlServletMap = new HashMap<>();

    public Tomcat(int port) {
        this.port = port;
    }

    public void start() {
        initServletMapping();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Tomcat starting ...");

            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                Request request = new Request(inputStream);
                Response response = new Response(outputStream);

                dispatch(request, response);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initServletMapping() {
        ServletMappingConfig.servletMappingList.forEach(temp -> urlServletMap.put(temp.getUrl(), temp.getCalzz()));

    }

    private void dispatch(Request request, Response response) {
        String clazz = urlServletMap.get(request.getUrl());
        try {
            Class<MyServlet> myServletClass = (Class<MyServlet>) Class.forName(clazz);
            MyServlet myServlet = myServletClass.newInstance();

            myServlet.service(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Tomcat(8080).start();
    }

}
