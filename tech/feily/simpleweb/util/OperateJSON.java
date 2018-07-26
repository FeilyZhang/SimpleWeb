package tech.feily.simpleweb.util;

public class OperateJSON {
	
	String SPACE = "    ";
	
	public String getNormalizeJSON(String jsonContent) {
		for(int i = 0; i < jsonContent.length() - 1; i++) {
			while (true) {
				char c = jsonContent.charAt(i);
				if (c == '\r' || c == '\n' || c==' ') {
					jsonContent = jsonContent.substring(0, i) + jsonContent.substring(i + 1, jsonContent.length());
				} else {
					break;
				}
			}
		}
		return jsonContent;
	}
	
	public String formatJSON(String jsonContent) {
        StringBuffer result = new StringBuffer();
        int length = jsonContent.length();
        int number = 0;
        char key = 0;
        for (int i = 0; i < length; i++) {
            key = jsonContent.charAt(i);
            if(key == '[' || key == '{') {
                result.append(key);
                result.append("\r\n");
                number++;
                result.append(indent(number));
            } else if(key == ']' || key == '}') {
                result.append("\r\n");
                number--;
                result.append(indent(number));
                result.append(key);
            } else if (key == ',') {
                result.append(key);
                result.append("\r\n");
                result.append(indent(number));
            } else {
                result.append(key);
            }
        }
        return result.toString();
    }

    public String indent(int number) {
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < number; i++) {
            result.append(SPACE);
        }
        return result.toString();
    }
    /*
	public static void main(String[] args) throws IOException {
		System.out.println(new OperateJSON().getNormalizeJSON(new OperateFile().read("/home/fei/Downloads/format_data.json")));
		System.out.println(new OperateJSON().formatJSON(new OperateJSON().getNormalizeJSON(new OperateFile().read("/home/fei/Downloads/format_data.json"))));

	}*/
	
}
