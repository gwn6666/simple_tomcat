package tomcat.servlet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoweinan
 * @date 2018/9/28
 */
public class ServletMappingConfig {
    public static List<ServletMapping> servletMappingList = new ArrayList<>();

    static {
        servletMappingList.add(new ServletMapping("helloWorldServlet","/hello","tomcat.servlet.HelloWorldServlet"));
    }
}
