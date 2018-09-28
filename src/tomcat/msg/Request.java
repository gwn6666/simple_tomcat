package tomcat.msg;

import java.io.InputStream;

public class Request {
    private String url;
    private String method;

    public Request(InputStream inputStream) {
        String httpRequest = "";
        byte[] httpRequestBytes = new byte[1024];
        int length = 0;

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
