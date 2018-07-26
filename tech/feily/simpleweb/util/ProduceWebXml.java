package tech.feily.simpleweb.util;

import java.io.IOException;

public class ProduceWebXml {

    public ProduceWebXml(String filePath, String displayName, String servletName, String servletClass, String[] urlPath) throws IOException {
        OperateFile.write(filePath, Constant.preModule, true);
        OperateFile.write(filePath, displayName, true);
        OperateFile.write(filePath, Constant.dispalyName, true);
        OperateFile.write(filePath, Constant.welcomeFileList, true);
        OperateFile.write(filePath, Constant.preServletName + servletName + "</servlet-name>\n    " + "<servlet-class>" + servletClass + Constant.servletName, true);
        OperateFile.write(filePath, Constant.preServletMapping + servletName + "</servlet-name>\n", true);
        for (int i = 0; i < urlPath.length; i++){
            OperateFile.write(filePath, "    <url-pattern>" + urlPath[i] + "</url-pattern>\n", true);
        }
        OperateFile.write(filePath, Constant.end, true);
    }
}
