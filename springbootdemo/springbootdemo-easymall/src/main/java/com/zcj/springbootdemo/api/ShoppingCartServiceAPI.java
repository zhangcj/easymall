package com.zcj.springbootdemo.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zcj.springbootdemo.api.apimodel.BaseApiModel;
import com.zcj.springbootdemo.api.apimodel.ShoppingCart.ShoppingCartApiModel;
import com.zcj.springbootdemo.util.HttpRequestUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2017/4/6.
 */
@Service
public class ShoppingCartServiceAPI {

    private final String uri = "http://inner.clubapi.autohome.com.cn/api/MasterLog/GetTopicSetList?topicId=62023785&_appid=user";

    private RestTemplate template;
    public ShoppingCartServiceAPI() {
        template = new RestTemplate();
    }

    /**
     * 依据购物车id获取购物车信息
     * @param id 购物车id
     * @return
     */
    public void getShoppingCartById(Integer id) {
        try {
            MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
//            parts.add("_appid", "user");
//            parts.add("topicId", "62023785");

//            String response = template.getForObject(
//                    uri,
//                    String.class,
//                    parts);


            String response = HttpRequestUtils.httpGet(uri);

            ObjectMapper objectMapper = new ObjectMapper();
            BaseApiModel baseApiModel = objectMapper.readValue(response, BaseApiModel.class);
            if(baseApiModel!=null && baseApiModel.getResult().size()>0){
                ArrayList<ShoppingCartApiModel> apiModels = (ArrayList<ShoppingCartApiModel>)baseApiModel.getResult().get("topicSetList");
                System.out.println("size:"+apiModels.size());
            }

            System.out.println(response);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
