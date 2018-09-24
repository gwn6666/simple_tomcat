package tomcat.msg;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;

public class Response {

    public static final String ENTER = "\r\n";
    public static final String SPACE = " ";
    private StringBuilder header;
    private StringBuilder textContext;
    private Integer contextLength;
    private BufferedWriter bufferedWriter;

    public Response(){
        header = new StringBuilder();
        textContext = new StringBuilder();
        contextLength = 0;
    }

    public Response(OutputStream outputStream) {
        this();
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    public void createHeader(int code){
        header.append("HTTP/1.1").append(ENTER);
        switch (code) {
            case 200:
                header.append("OK").append(ENTER);
                break;
            case 404:
                header.append("NOT FOUND").append(ENTER);
                break;
            case 500:
                header.append("SERVER ERROR").append(ENTER);
                break;
            default:
                break;
        }
        header.append("Server: myServer"+SPACE).append("0.0.1.v").append(ENTER);
        header.append("Date:"+SPACE).append(new Date()).append(ENTER);
        header.append("Context-Type:text/html;charset=UTF-8").append(ENTER);
        header.append("Context-Length:"+contextLength).append(ENTER);
    }

    public Response htmlContext(String content){
        textContext.append(content).append(ENTER);
        contextLength += (content+ENTER).toString().getBytes().length;
        return this;
    }
}
