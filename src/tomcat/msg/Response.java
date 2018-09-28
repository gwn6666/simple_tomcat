package tomcat.msg;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

public class Response {

    public static final String ENTER = "\r\n";
    public static final String SPACE = " ";
    private StringBuilder response;
    private Integer contextLength;
    private OutputStream outputStream;

    public Response() {
        response = new StringBuilder();
        contextLength = 0;
    }

    public Response(OutputStream outputStream) {
        this();
        this.outputStream = outputStream;
    }

    public void createResponse(int code, String content) throws IOException {
        response.append("HTTP/1.1").append(ENTER);
        switch (code) {
            case 200:
                response.append("OK").append(ENTER);
                break;
            case 404:
                response.append("NOT FOUND").append(ENTER);
                break;
            case 500:
                response.append("SERVER ERROR").append(ENTER);
                break;
            default:
                break;
        }
        response.append("Server: myServer" + SPACE).append("0.0.1.v").append(ENTER)
                .append("Date:" + SPACE).append(new Date()).append(ENTER)
                .append("Context-Type:text/html;charset=UTF-8").append(ENTER)
                .append("<html><body>")
                .append(content)
                .append("</body></html>")
                .append("Context-Length:" + contextLength).append(ENTER);

        outputStream.write(response.toString().getBytes());
        outputStream.close();
    }

}
