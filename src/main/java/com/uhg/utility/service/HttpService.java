package com.uhg.utility.service;

import com.uhg.utility.utilities.FileHelper;
import com.uhg.utility.utilities.LogHelper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HttpService implements Runnable{
    HttpClient client = HttpClientBuilder.create().build();
    LogHelper logHelper = LogHelper.getLogger();
    int idx;
    String value;

    public HttpService(int idx, String value) {
        this.idx = idx;
        this.value = value;
    }

    @Override
    public void run() {
        Logger logger = LoggerFactory.getLogger(HttpService.class);
        HttpGet req = new HttpGet("https://postman-echo.com/get");
        URI uri = null;
        try {
            uri = new URIBuilder(req.getURI()).addParameter("dec",
                    value).build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        logger.info("Executing {}", idx);
        ((HttpRequestBase) req).setURI(uri);
        HttpResponse res = null;
        try {
            res = client.execute(req);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String response = null;
        try {
            response = EntityUtils.toString(res.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(response.contains("TEST") || response.contains("abc") || response.contains("demo")){
            try {
                FileHelper.writeToFileForExecution(String.valueOf(idx));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
