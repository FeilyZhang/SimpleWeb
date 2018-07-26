package tech.feily.simpleweb.main;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tech.feily.simpleweb.util.ProduceWebXml;
import tech.feily.simpleweb.util.ReadConfigFile;

public class RootClass extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    String servletPath, method;
    String servletName, servletClass;
    String[] cls, urlPath, className, simpleIntro, handleMethod, requestMethod;
    
    public RootClass(String configFilePath, String webxmlFilePath, String displayName) throws IOException {
        super();
        
        RootBean rootBean = ReadConfigFile.getConfig(configFilePath);
        
        servletName = rootBean.getServletName();
        servletClass = rootBean.getServletClass();
        
        cls = rootBean.getCls();
        urlPath = rootBean.getUrlPath();
        className = rootBean.getClassName();
        simpleIntro = rootBean.getSimpleIntro();
        handleMethod = rootBean.getHandleMethod();
        requestMethod = rootBean.getRequestMethod();
        
        if (!new File(webxmlFilePath).exists()) {
            new ProduceWebXml(webxmlFilePath, displayName, servletName, servletClass, urlPath);
        }
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        servletPath = request.getServletPath();
        method = request.getMethod();
        for (String methods : requestMethod) {
            if (method.equalsIgnoreCase(methods)) {
                doGet(request,response);
            } else if (method.equalsIgnoreCase(methods)) {
                doPost(request,response);
            }
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (int i = 0; i < urlPath.length; i++) {
            if (servletPath.equals(urlPath[i])) {
                try {
                    @SuppressWarnings("rawtypes")
                    Class[] paramType = {HttpServletRequest.class, HttpServletResponse.class};
                    Object[] param = {request, response};
                    Class<?> handle = Class.forName(className[i]);
                    Object object = handle.newInstance();
                    Method method = object.getClass().getDeclaredMethod(handleMethod[i], paramType);
                    method.invoke(object, param);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                //new RootServlet(request, response);
            }
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (int i = 0; i < urlPath.length; i++) {
            if (servletPath.equals(urlPath[i])) {
                try {
                    @SuppressWarnings("rawtypes")
                    Class[] paramType = {HttpServletRequest.class, HttpServletResponse.class};
                    Object[] param = {request, response};
                    Class<?> handle = Class.forName(className[i]);
                    Object object = handle.newInstance();
                    Method method = object.getClass().getDeclaredMethod(handleMethod[i], paramType);
                    method.invoke(object, param);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                //new RootServlet(request, response);
            }
        }
    }   
    

    public static void main(String[] args) throws IOException {
        String configFilePath, webxmlFilePath, displayName;
        configFilePath = "/home/fei/workspace/Marking/WebContent/WEB-INF/config.json";
        webxmlFilePath = "/home/fei/workspace/Marking/WebContent/WEB-INF/web.xml";
        displayName = "Marking";
        new RootClass(configFilePath, webxmlFilePath, displayName);
        //new RootClass("/home/fei/workspace/SimpleWeb/WebContent/WEB-INF/config.json");
    }
}
