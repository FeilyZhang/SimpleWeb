package tech.feily.simpleweb.util;

import java.io.IOException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

import tech.feily.simpleweb.main.RootBean;

public class ReadConfigFile {

	static String fileContent;

	public static RootBean getConfig(String filePath) throws IOException {
	    
        new OperateFile();
        fileContent= OperateFile.read(filePath);
        JSONObject inJSONObject, jsonObject = new JSONObject(fileContent);
        JSONArray mappingDetail = (JSONArray) new JSONObject(fileContent).get("MappingDetail");
        int arraySize = mappingDetail.length();
        int index = 0;
        RootBean rootBean = new RootBean();
        String servletName, servletClass;
        String[] cls = new String[arraySize];
        String[] urlPath = new String[arraySize];
        String[] className = new String[arraySize];
        String[] simpleIntro = new String[arraySize];
        String[] handleMethod = new String[arraySize];
        String[] requestMethod = new String[arraySize];
        Iterator<Object> it = mappingDetail.iterator();
        
        servletName = jsonObject.getString("ServletName");
        servletClass = jsonObject.getString("ServletClass");
        
        while(it.hasNext()) {
            inJSONObject = (JSONObject) it.next();
            cls[index] = inJSONObject.getString("cls");
            urlPath[index] = inJSONObject.getString("UrlPath");
            className[index] = inJSONObject.getString("ClassName");
            simpleIntro[index] = inJSONObject.getString("SimpleIntro");
            handleMethod[index] = inJSONObject.getString("HandleMethod");
            requestMethod[index] = inJSONObject.getString("RequestMethod");
            ++index;
        }
        rootBean.setServletName(servletName);
        rootBean.setServletClass(servletClass);
        rootBean.setCls(cls);
        rootBean.setUrlPath(urlPath);
        rootBean.setClassName(className);
        rootBean.setSimpleIntro(simpleIntro);
        rootBean.setHandleMethod(handleMethod);
        rootBean.setRequestMethod(requestMethod);
        
        return rootBean;
        
	}
	/*
	public static void main(String[] args) throws IOException {
	    String string = new OperateFile().read("/home/fei/workspace/SimpleWeb/WebContent/WEB-INF/config.json");
	    System.out.println(new JSONObject(string).get("version"));
	    JSONArray mappingDetail = (JSONArray) new JSONObject(string).get("MappingDetail");
	    JSONObject jsonObject = (JSONObject) mappingDetail.get(1);
	    System.out.println(jsonObject.get("ClassName"));
	}
*/
}
