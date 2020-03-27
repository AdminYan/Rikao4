package com.bw.rikao3_27.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//工具类
public class NetUtil {

    //单例模式
    public NetUtil(){

    }

    private static final NetUtil NET_UTIL = new NetUtil();

    public static NetUtil getInstance() {
        return NET_UTIL;
    }

    public boolean hasNet(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if(activeNetworkInfo != null && activeNetworkInfo.isAvailable()){
            return true;
        }else {
            return false;
        }
    }

    public String ioToString(InputStream inputStream) throws IOException {

        byte[] bytes = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int len = -1;

        while((len = inputStream.read(bytes)) != -1){
            byteArrayOutputStream.write(bytes,0,len);
        }

        byte[] bytes1 = byteArrayOutputStream.toByteArray();
        String json =new String(bytes1);

        return json;
    }

    public Bitmap ioToBitmap(InputStream inputStream){
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        return bitmap;
    }

    public String  doget(String httpurl){
        InputStream inputStream=null;
        try {
            URL url = new URL(httpurl);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.connect();

            if(httpURLConnection.getResponseCode() == 200){
                inputStream = httpURLConnection.getInputStream();
                String string = ioToString(inputStream);
                return string;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Bitmap  dogetphoto(String photourl){
        InputStream inputStream=null;
        try {
            URL url = new URL(photourl);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.connect();

            if(httpURLConnection.getResponseCode() == 200){
                inputStream = httpURLConnection.getInputStream();
                Bitmap bitmap = ioToBitmap(inputStream);

                return bitmap;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
