package com.songbo.server.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.songbo.server.bean.RPCResponse;
import com.songbo.server.bean.RPCResponseForS;
import com.songbo.server.bean.sendTransaction.RPCResponseForT;
import com.songbo.server.bean.token.TokenCreateResult;
import com.songbo.server.bean.token.TokenListResult;
import com.songbo.server.service.RPCRequestService;
import com.songbo.server.utils.RPCRequestParams;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RPCRequestServiceImpl
 * @Description TODO
 * @Author songbo
 * @Date 19-9-21 下午1:59
 **/
@Slf4j
@Service
public class RPCRequestServiceImpl implements RPCRequestService {
    @Override
    public String rpcGetRequest(String urls) {
        //String url = "https://explorer.indexchain.io/insight-api-komodo/addr/RGd77ChrgHVNgYU4ptXaofCCBYnkho1xJr/balance";
        String url = RPCRequestParams.EXPLORER_URL1+urls;

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newBuilder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .readTimeout(1,TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        log.warn("get url: "+request.url().toString());
        Call call = okHttpClient.newCall(request);

        try {
            Response response = call.execute();
            String string = response.body().string();
            //System.out.println(string);
            log.warn("GET", request.url().toString(), string);
            return string;
        }catch (SocketTimeoutException e){
            log.error("浏览器1挂了: "+request.url().toString(), e);
            return rpcGetRequestRest(RPCRequestParams.EXPLORER_URL2+urls);
        } catch (IOException e) {
            e.printStackTrace();
            log.warn("GET_fail "+e);
            return "fail";
        }


    }

    @Override
    public String rpcGetRequestRest(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newBuilder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .readTimeout(1,TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        log.warn("get url: "+request.url().toString());
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            String string = response.body().string();
            //System.out.println(string);
            log.warn("GET", request.url().toString(), string);
            return string;
        }catch (SocketTimeoutException e){
            log.error("浏览器2挂了: "+request.url().toString(), e);
            return "fail";
        } catch (IOException e) {
            e.printStackTrace();
            log.warn("GET_fail "+e);
            return "fail";
        }
    }

    @Override
    public RPCResponse transactionRequest(JSONObject params) {
        final String credentials = Credentials.basic(RPCRequestParams.NODE_LOGIN,RPCRequestParams.NODE_PASS);
        OkHttpClient okHttpClient = new OkHttpClient();
        MediaType json = MediaType.parse("Content-type; application/json");
        RequestBody requestBody = RequestBody.create(json,params.toJSONString());

        Request request = new Request.Builder()
                .url(RPCRequestParams.NODE_ADDRESS)
                .post(requestBody)
                .addHeader("Content-type", "application/json")
                .addHeader("Authorization", credentials)
                .build();
        Call call = okHttpClient.newCall(request);
        log.warn("request.body: "+request.toString(),request);
        try {
            Response response = call.execute();
            //response.body().string()只能调用一次
            log.warn("response.body: "+response.body().toString(),response);
            JSONObject jsonObject = (JSONObject) JSONObject.parse(response.body().string());
            return jsonObject.toJavaObject(RPCResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            log.warn("GET_fail "+e);
            return null;
        }
    }

    @Override
    public RPCResponseForS StringTransactionRequest(JSONObject params) {
        log.warn("sign or send transaction: "+params,params);
        final String credentials = Credentials.basic(RPCRequestParams.NODE_LOGIN,RPCRequestParams.NODE_PASS);
        OkHttpClient okHttpClient = new OkHttpClient();
        MediaType json = MediaType.parse("Content-type; application/json");
        RequestBody requestBody = RequestBody.create(json,params.toJSONString());

        Request request = new Request.Builder()
                .url(RPCRequestParams.NODE_ADDRESS)
                .post(requestBody)
                .addHeader("Content-type", "application/json")
                .addHeader("Authorization", credentials)
                .build();
        Call call = okHttpClient.newCall(request);
        log.warn("request.body: "+request.toString(),request);
        try {
            Response response = call.execute();
            //response.body().string()只能调用一次
            log.warn("response.body: "+response.body().toString(),response);
            JSONObject jsonObject = (JSONObject) JSONObject.parse(response.body().string());
            return jsonObject.toJavaObject(RPCResponseForS.class);
        } catch (IOException e) {
            e.printStackTrace();
            log.warn("GET_fail "+e);
            return null;
        }
    }

    @Override
    public TokenListResult rpcTokenListRequest(JSONObject params) {
        log.warn("rpcTokenListRequest: "+params,params);
        final String credentials = Credentials.basic(RPCRequestParams.NODE_LOGIN,RPCRequestParams.NODE_PASS);
        OkHttpClient okHttpClient = new OkHttpClient();
        MediaType json = MediaType.parse("Content-type; application/json");
        RequestBody requestBody = RequestBody.create(json,params.toJSONString());

        Request request = new Request.Builder()
                .url(RPCRequestParams.NODE_ADDRESS)
                .post(requestBody)
                .addHeader("Content-type", "application/json")
                .addHeader("Authorization", credentials)
                .build();
        Call call = okHttpClient.newCall(request);
        log.warn("request.body: "+request.toString(),request);
        try {
            Response response = call.execute();
            //response.body().string()只能调用一次
            log.warn("response.body: "+response.body().toString(),response);
            JSONObject jsonObject = (JSONObject) JSONObject.parse(response.body().string());
            return jsonObject.toJavaObject(TokenListResult.class);
        } catch (IOException e) {
            e.printStackTrace();
            log.warn("GET_fail "+e);
            return null;
        }
    }

    @Override
    public TokenCreateResult rpcTokenCreateRequest(JSONObject params) {
        return null;
    }

    @Override
    public <T> T rpcRequest(JSONObject params, Class<T> tClass) {
        log.warn("rpcRequest: "+params,params);
        final String credentials = Credentials.basic(RPCRequestParams.NODE_LOGIN,RPCRequestParams.NODE_PASS);
        OkHttpClient okHttpClient = new OkHttpClient();
        MediaType json = MediaType.parse("Content-type; application/json");
        RequestBody requestBody = RequestBody.create(json,params.toJSONString());

        Request request = new Request.Builder()
                .url(RPCRequestParams.NODE_ADDRESS)
                .post(requestBody)
                .addHeader("Content-type", "application/json")
                .addHeader("Authorization", credentials)
                .build();
        Call call = okHttpClient.newCall(request);
        log.warn("request.body: "+request.toString(),request);
        try {
            Response response = call.execute();
            //response.body().string()只能调用一次
            String res = response.body().string();
            log.warn("response.body: "+res,response);
            JSONObject jsonObject = (JSONObject) JSONObject.parse(res);
            return jsonObject.toJavaObject(tClass);
        } catch (IOException e) {
            e.printStackTrace();
            log.warn("GET_fail "+e);
            return null;
        }
    }

    @Override
    public <T, V> RPCResponseForT<T, V> rpcRequestForRPCResponseForT(JSONObject params, Class<T> tClass, Class<V> vClass) {
        log.warn("rpcRequest: "+params,params);
        final String credentials = Credentials.basic(RPCRequestParams.NODE_LOGIN,RPCRequestParams.NODE_PASS);
        OkHttpClient okHttpClient = new OkHttpClient();
        MediaType json = MediaType.parse("Content-type; application/json");
        RequestBody requestBody = RequestBody.create(json,params.toJSONString());

        Request request = new Request.Builder()
                .url(RPCRequestParams.NODE_ADDRESS)
                .post(requestBody)
                .addHeader("Content-type", "application/json")
                .addHeader("Authorization", credentials)
                .build();
        Call call = okHttpClient.newCall(request);
        log.warn("request.body: "+request.toString(),request);
        try {
            Response response = call.execute();
            //response.body().string()只能调用一次
            String res = response.body().string();
            log.warn("response.body: "+res,response);
            /*Type type = new TypeReference<RPCResponseForT<T, V>>(){}.getType(); // 构造TypeReference的匿名内部类对象，直接获取Type对象
            RPCResponseForT<T, V> parsed = JSON.parseObject(res, type);*/
            JSONObject jsonObject = (JSONObject) JSONObject.parse(res);
            T t;
            if (jsonObject.getJSONObject("result")==null){
                t = null;
            }else {
                t = jsonObject.getJSONObject("result").toJavaObject(tClass);
            }
            V v;
            if (jsonObject.getJSONObject("error")==null){
                v = null;
            }else {
                v = jsonObject.getJSONObject("error").toJavaObject(vClass);
            }
            String id = jsonObject.getString("id");
            RPCResponseForT<T, V> responseForT = new RPCResponseForT<>(t, v, id);
            return responseForT;

        } catch (IOException e) {
            e.printStackTrace();
            log.warn("GET_fail "+e);
            return null;
        }
    }
}
