package io.arkitekt.appManager.operationAPI;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;


public class HttpSession {
    MediaType mediaType = MediaType.parse("multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW");
    RequestBody body = RequestBody.create(mediaType, "------WebKitFormBoundary7MA4YWxkTrZu0gW" +
            "\r\nContent-Disposition: form-data; name=\"_method\"" +
            "\r\n\r\nPUT\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW" +
            "\r\nContent-Disposition: form-data; name=\"banner_tmp_image_file\"; filename=\"C:\\Users\\Andrew\\Desktop\\2.png\"" +
            "\r\nContent-Type: image/png" +
            "\r\n\r\n\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW--");
    private CloseableHttpClient httpClient;
    private ApiManager api;

    public HttpSession(ApiManager api) {
        this.api = api;
        httpClient = HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()).build();
    }

    public String loginGET() throws IOException {
        String response = Request.Get("http://preproduction-my.arkitekt.io/users/sign_in").
                execute().returnContent().asString();
        Document doc = Jsoup.parse(response);
        String token = doc.select("input[name='authenticity_token']").attr("value");
        return token;
    }

    public void loginPost() throws IOException {
        String token = loginGET();
        HttpResponse response = Request.Post("http://preproduction-my.arkitekt.io/users/sign_in").
                addHeader("Content-Type", "application/x-www-form-urlencoded").
                bodyForm(Form.form().
                        add("user[email]", "api1234@gmail.com").
                        add("user[password]", "1111111111").
                        add("authenticity_token", token).
                        add("commit", "Sign in").build()).
                execute().returnResponse();
        System.out.println(response);
    }

    public void uploadFileBanner() throws IOException {
        File file = new File("src/test/resources/carBanner.jpg");

        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM).
                addFormDataPart("_method", "PUT").
                addFormDataPart("banner_tmp_image_file", file.getName(),
                        RequestBody.create(MediaType.parse("image/jpg"),file)).
                build();
        /*HttpResponse response = Request.Post("http://preproduction-my.arkitekt.io/users/sign_in").
                addHeader("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW").
                bodyFile(Form.form().build();*/

    }

    public String executValue(String locator, String attr) throws IOException {
        Document doc = Jsoup.parse(loginGET());
        String token = doc.select(locator).attr(attr);
        return token;
    }


    private String geTextFrom(CloseableHttpResponse response) throws IOException {
        try {
            return EntityUtils.toString(response.getEntity());
        } finally {
            response.close();
        }
    }
}
