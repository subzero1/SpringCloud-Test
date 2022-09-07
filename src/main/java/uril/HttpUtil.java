package uril;

import javax.servlet.ServletException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpUtil {

	/**
	 * @param strURL 请求URL
	 * @param method 请求方法 默认是POST
	 * @param params 参数
	 * @return 返回值
	 * @throws ServletException
	 * @throws IOException
	 */
	public static String request(String strURL,String method, String params) {
		StringBuffer sb = new StringBuffer("");
		try {
            URL url = new URL(strURL);// 创建连接  
            HttpURLConnection connection = (HttpURLConnection) url  
                    .openConnection();  
            connection.setDoOutput(true);  
            connection.setDoInput(true);  
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestMethod(method); // 设置请求方式
//			connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
			connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
			connection.connect();
			OutputStreamWriter out = new OutputStreamWriter(
					connection.getOutputStream(), "UTF-8"); // utf-8编码
			if (params != null && !params.equals("")) {
				out.append(params);
			}
			out.flush();
			out.close();

			// 读取响应
			// 读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader( 
                    connection.getInputStream())); 
            String lines; 
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8"); 
                sb.append(lines); 
            } 
            reader.close(); 
            // 断开连接 
            connection.disconnect(); 
            return sb.toString();

        } catch (Exception e) {
			sb.append(e.getMessage());
//            e.printStackTrace();
        }
        return sb.toString(); // 自定义错误信息
	}
	
	public static Object doPost(String strURL, String params) throws Exception{
		return request( strURL, "POST",  params);
	}
	public static Object doPost(String strURL) throws Exception{
		return request( strURL, "POST",  null);
	}
	
	public static Object doGet(String strURL, String params) throws Exception{
		return request( strURL, "GET",  params);
	}
	
}
