package net;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by yuandl on 2016-10-18.
 * HttpURLConnection测试
 */
public class URLConnectionTest {
    public static void main(String[] args) {
//        String url = "http://10.58.178.72/intco/mobi/member/login";
//        HashMap<String, String> params = new HashMap<>();
//        params.put("username", "13468857714");
//        params.put("pwd", MD5.md5("123456").toLowerCase());
//        requestPost(url, params);

        String url ="http://10.58.178.120:8080/intco/mobi/member/uploadImage";
        Map<String, Object> params = new HashMap<>();
        params.put("mId", "1");
        params.put("imgFile", new File("E:\\kejiang\\projects\\盈科\\UE和UI\\英科UI切图7月20日\\png整图\\p6登陆页面.png"));
        requestPost2(url,params);
    }

    /**
     * Post请求
     *
     * @param httpUrl
     * @param paramsMap
     */
    private static void requestPost(String httpUrl, Map<String,String> paramsMap) {
        try {
            String baseUrl = httpUrl;
            //合成参数
            StringBuilder tempParams = new StringBuilder();
            int pos = 0;
            for (String key : paramsMap.keySet()) {
                if (pos > 0) {
                    tempParams.append("&");
                }
                tempParams.append(String.format("%s=%s", key, URLEncoder.encode((String) paramsMap.get(key), "utf-8")));
                pos++;
            }
            String params = tempParams.toString();
            System.out.println("Post方式请求地址httpUrl--->" + params);
            System.out.println("Post方式请求参数params--->" + params);
            // 请求的参数转换为byte数组
            byte[] postData = params.getBytes();
            // 新建一个URL对象
            URL url = new URL(baseUrl);
            // 打开一个HttpURLConnection连接
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            // 设置连接超时时间
            urlConn.setConnectTimeout(5 * 1000);
            //设置从主机读取数据超时
            urlConn.setReadTimeout(5 * 1000);
            // Post请求必须设置允许输出 默认false
            urlConn.setDoOutput(true);
            //设置请求允许输入 默认是true
            urlConn.setDoInput(true);
            // Post请求不能使用缓存
            urlConn.setUseCaches(false);
            // 设置为Post请求
            urlConn.setRequestMethod("POST");
            //设置本次连接是否自动处理重定向
            urlConn.setInstanceFollowRedirects(true);
            // 配置请求Content-Type
            urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            // 开始连接
            urlConn.connect();
            // 发送请求参数
            DataOutputStream dos = new DataOutputStream(urlConn.getOutputStream());
            dos.write(postData);
            dos.flush();
            dos.close();
            // 判断请求是否成功
            if (urlConn.getResponseCode() == 200) {
                // 获取返回的数据
                String result = streamToString(urlConn.getInputStream());
                System.out.println("Post方式请求成功，result--->" + result);
            } else {
                System.out.println("Post方式请求失败");
            }
            // 关闭连接
            urlConn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 将输入流转换成字符串
     *
     * @param is 从网络获取的输入流
     * @return
     */
    public static String streamToString(InputStream is) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            baos.close();
            is.close();
            byte[] byteArray = baos.toByteArray();
            return new String(byteArray);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Post请求
     *
     * @param httpUrl
     * @param paramsMap
     */
    private static void requestPost2(String httpUrl, Map<String, Object> paramsMap) {
        String boundary = "--------httppost123";
        try {
            String baseUrl = httpUrl;
//            //合成参数
//            StringBuilder tempParams = new StringBuilder();
//            int pos = 0;
//            for (String key : paramsMap.keySet()) {
//                if (pos > 0) {
//                    tempParams.append("&");
//                }
//                tempParams.append(String.format("%s=%s", key, URLEncoder.encode(paramsMap.get(key), "utf-8")));
//                pos++;
//            }
//            String params = tempParams.toString();
//            System.out.println("Post方式请求地址httpUrl--->" + params);
//            System.out.println("Post方式请求参数params--->" + params);
            // 请求的参数转换为byte数组
//            byte[] postData = params.getBytes();
            // 新建一个URL对象
            URL url = new URL(baseUrl);
            // 打开一个HttpURLConnection连接
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            // 设置连接超时时间
            urlConn.setConnectTimeout(5 * 1000);
            //设置从主机读取数据超时
            urlConn.setReadTimeout(5 * 1000);
            // Post请求必须设置允许输出 默认false
            urlConn.setDoOutput(true);
            //设置请求允许输入 默认是true
            urlConn.setDoInput(true);
            // Post请求不能使用缓存
            urlConn.setUseCaches(false);
            // 设置为Post请求
            urlConn.setRequestMethod("POST");
            //设置本次连接是否自动处理重定向
            urlConn.setInstanceFollowRedirects(true);
            //设置维持长连接
            urlConn.setRequestProperty("connection", "Keep-Alive");
            //设置文件字符集
            urlConn.setRequestProperty("Accept-Charset", "UTF-8");
            //设置文件类型
            urlConn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + "*****");
           // 开始连接
            urlConn.connect();

            DataOutputStream out = new DataOutputStream(urlConn.getOutputStream());
            // text


//            if (textMap != null) {
//                StringBuffer strBuf = new StringBuffer();
//                Iterator<Map.Entry<String, String>> iter = textMap.entrySet().iterator();
//                while (iter.hasNext()) {
//                    Map.Entry<String, String> entry = iter.next();
//                    String inputName = (String) entry.getKey();
//                    String inputValue = (String) entry.getValue();
//                    if (inputValue == null) {
//                        continue;
//                    }
//                    strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
//                    strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"\r\n\r\n");
//                    strBuf.append(inputValue);
//                }
//                out.write(strBuf.toString().getBytes());
//            }

            if (paramsMap != null) {
                StringBuffer strBuf = new StringBuffer();
                Iterator<Map.Entry<String,Object>> iter = paramsMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, Object> entry = iter.next();
                    String inputName =entry.getKey();
                    Object inputValue=entry.getValue();

                    if (inputValue == null) {
                        continue;
                    }
                    if(inputValue instanceof String){
                        String stringValue = (String) entry.getValue();
//                        strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                        strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"\r\n\r\n");
                        strBuf.append(stringValue);
                    }else if(inputValue instanceof File){
                        File file = (File) inputValue;
                        out.writeBytes("--" + boundary + "\r\n");
                        out.writeBytes("Content-Disposition: form-data; name=\"" + inputName
                                + "\"; filename=\"" + encode(file.getName()) + "\"\r\n");
                        out.writeBytes("Content-Type: " + getContentType(file) + "\r\n");
                        out.writeBytes("\r\n");
                        out.write(getBytes(file));
                        out.writeBytes("\r\n");
                    }

                }
                out.write(strBuf.toString().getBytes());
            }

//            // file
//            if (fileMap != null) {
//                Iterator<Map.Entry<String, String>> iter = fileMap.entrySet().iterator();
//                while (iter.hasNext()) {
//                    Map.Entry<String, String> entry = iter.next();
//                    String inputName = (String) entry.getKey();
//                    String inputValue = (String) entry.getValue();
//
//                }
//            }

            // 判断请求是否成功
            if (urlConn.getResponseCode() == 200) {
                // 获取返回的数据
                String result = streamToString(urlConn.getInputStream());
                System.out.println("Post方式请求成功，result--->" + result);
            } else {

                System.out.println("Post方式请求失败--->"+"getResponseCode()="+urlConn.getResponseCode()+"getResponseMessage()="+urlConn.getResponseMessage());
            }
            // 关闭连接
            urlConn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取文件的上传类型，图片格式为image/png,image/jpg等。非图片为application/octet-stream
    private static String getContentType(File f) throws Exception {

//      return "application/octet-stream";  // 此行不再细分是否为图片，全部作为application/octet-stream 类型
        ImageInputStream imagein = ImageIO.createImageInputStream(f);
        if (imagein == null) {
            return "application/octet-stream";
        }
        Iterator<ImageReader> it = ImageIO.getImageReaders(imagein);
        if (!it.hasNext()) {
            imagein.close();
            return "application/octet-stream";
        }
        imagein.close();
        return "image/" + it.next().getFormatName().toLowerCase();//将FormatName返回的值转换成小写，默认为大写

    }
    //把文件转换成字节数组
    private static byte[] getBytes(File f) throws Exception {
        FileInputStream in = new FileInputStream(f);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int n;
        while ((n = in.read(b)) != -1) {
            out.write(b, 0, n);
        }
        in.close();
        return out.toByteArray();
    }
    // 对包含中文的字符串进行转码，此为UTF-8。服务器那边要进行一次解码
    private static String encode(String value) throws Exception{
        return URLEncoder.encode(value, "UTF-8");
    }

}
