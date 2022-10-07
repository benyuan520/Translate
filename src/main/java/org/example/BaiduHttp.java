package org.example;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;

import java.io.File;

public class BaiduHttp {

    public String pictrans(File file) {
        // 请求url
        String url = "https://aip.baidubce.com/file/2.0/mt/pictrans/v1";
        try {
//            String param = "{\"id\": \"kR7z8nOMLV7prmE194Po\"}";
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.2e4f13528dfe06ae1c52be6945c91cf5.2592000.1667394948.282335-27740771";
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.post("https://aip.baidubce.com/file/2.0/mt/pictrans/v1?access_token=" + accessToken)
                    .field("image",file)
                    .field("from", "en")
                    .field("to", "zh")
                    .field("v", "3")
                    .field("paste", "1")
                    .asString();
            String result = response.getBody();
            JSONObject Photojson=new JSONObject(result);
            System.out.println(Photojson);
            JSONObject data =Photojson.getJSONObject("data");
            System.out.println(file.getName());
//            System.out.println(data.getString("pasteImg"));
            return data.getString("pasteImg");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
