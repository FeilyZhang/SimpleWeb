/**
 * 
 */
/**
 * @author fei
 *
 */
package tech.feily.simpleweb.util;

class Constant {
    static String preModule = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<web-app xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://xmlns.jcp.org/xml/ns/javaee\" xsi:schemaLocation=\"http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd\" id=\"WebApp_ID\" version=\"3.1\">\n  <display-name>";
    static String dispalyName = "\n</display-name>";
    static String welcomeFileList = "  <welcome-file-list>\n    <welcome-file>index.html</welcome-file>\n    <welcome-file>index.htm</welcome-file>\n    <welcome-file>index.jsp</welcome-file>\n    <welcome-file>default.html</welcome-file>\n    <welcome-file>default.htm</welcome-file>\n    <welcome-file>default.jsp</welcome-file>\n  </welcome-file-list>";
    static String preServletName = "  <servlet>\n    <servlet-name>";
    static String servletName = "</servlet-class>\n  </servlet>";
    static String preServletMapping = "  <servlet-mapping>\n    <servlet-name>";
    static String end = "  </servlet-mapping>\n</web-app>";
}