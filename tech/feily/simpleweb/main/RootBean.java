package tech.feily.simpleweb.main;

public class RootBean {
    
    String servletName;
    String servletClass;
    
    String[] cls;
    String[] urlPath;
    String[] className;
    String[] simpleIntro;
    String[] handleMethod;
    String[] requestMethod;
    
    public void setServletName(String servletName) {
        this.servletName = servletName;
    }
    
    public void setServletClass(String servletClass) {
        this.servletClass = servletClass;
    }
    
    public void setUrlPath(String[] urlPath) {
        this.urlPath = urlPath;
    }
    
    public void setClassName(String[] className) {
        this.className = className;
    }
    
    public void setSimpleIntro(String[] simpleIntro) {
        this.simpleIntro = simpleIntro;
    }
    
    public void setHandleMethod(String[] handleMethod) {
        this.handleMethod = handleMethod;
    }
    
    public void setRequestMethod(String[] requestMethod) {
        this.requestMethod = requestMethod;
    }
    
    public void setCls(String[] cls) {
        this.cls = cls;
    }
    
    public String getServletName() {
        return servletName;
    }

    public String getServletClass() {
        return servletClass;
    }
    
    public String[] getCls() {
        return cls;
    }
    public String[] getUrlPath() {
        return urlPath;
    }
    
    public String[] getClassName() {
        return className;
    }
    
    public String[] getSimpleIntro() {
        return simpleIntro;
    }

    public String[] getHandleMethod() {
        return handleMethod;
    }
    
    public String[] getRequestMethod() {
        return requestMethod;
    }
    
}
