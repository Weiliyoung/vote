package com.weiyang.vote.controller;

import com.alibaba.fastjson.JSONObject;
import com.weiyang.vote.utils.ApiResponseUtils;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private static final Logger logger = Logger.getLogger(OptionController.class);

    @RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String CreateSessionByAuthCode(@RequestBody JSONObject requestBody) {
        String appId = requestBody.getString("appid");
        String appSecret = requestBody.getString("secret");
        String code = requestBody.getString("code");
        String reqUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + appSecret + "&js_code=" + code + "&grant_type=authorization_code";
        HttpClient httpClient = new HttpClient();
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
        GetMethod getMethod = new GetMethod(reqUrl);
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        String response = "";
        int statusCode;
        try {
            statusCode = httpClient.executeMethod(getMethod);
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("请求出错：" + getMethod.getStatusLine());
            }
            Header[] headers = getMethod.getResponseHeaders();
            for (Header h : headers) {
                System.out.println(h.getName() + "---------------" + h.getValue());
            }
            byte[] responseBody = getMethod.getResponseBody();
            response = new String(responseBody, StandardCharsets.UTF_8);
            System.out.println("-----------response:" + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.parseObject(response);
        return ApiResponseUtils.success(jsonObject);
    }

}
