package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        // 🔧 Increase timeouts to avoid timeout errors
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .callTimeout(30, TimeUnit.SECONDS)
                .build();

        String url = "https://jsonplaceholder.typicode.com/posts";

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.out.println("Something went wrong: " + response.code());
                return;
            }
            System.out.println(response.body().string());
        } catch (IOException ex) {
            System.out.println("Request failed: " + ex.getMessage());
        }
    }
}
