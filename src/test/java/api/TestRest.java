package api;

import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.simple.JSONObject;

public class TestRest{

    static Integer i,y;

    public Long getMaxUserId() throws Exception{
        Long userId = null;
        URL url=new URL("https://jsonplaceholder.typicode.com/posts/");
        HttpURLConnection connection=(HttpURLConnection)url.openConnection();

        String line;
        Integer table[];



        try{
            connection.setRequestMethod("GET");
            InputStream content=(InputStream)connection.getInputStream();
            BufferedReader in=new BufferedReader(new InputStreamReader(content));
            StringBuilder lines=new StringBuilder();
            while((line=in.readLine())!=null){
                lines.append(line);
            }
            in.close();

            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            JsonArray jsonArray = new JsonParser().parse(lines.toString()).getAsJsonArray();
            JsonElement wholeUser;

            for(int i=0;i<jsonArray.size();i++){
                wholeUser = jsonArray.get(i);
                JsonObject rootObject = wholeUser.getAsJsonObject();
                arrayList.add(rootObject.get("userId").getAsInt());

            }
            //for removing
            System.out.println(arrayList);
            i = Collections.max(arrayList);
            System.out.println("value for max user id: "+i);   //for remove


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return userId;

    }



    public void getMaxId() throws Exception{
        Long userId = null;
        StringBuilder stringBuilder = new StringBuilder("https://jsonplaceholder.typicode.com/posts");
        stringBuilder.append("?userId=");
        stringBuilder.append(URLEncoder.encode(i.toString(), "UTF-8"));
        URL url=new URL(stringBuilder.toString());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept-Charset", "UTF-8");
        String line;
        try{

            int responseCode=con.getResponseCode();
            InputStream content = (InputStream)con.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(content));
            StringBuilder lines = new StringBuilder();

            while((line=in.readLine())!=null){
                lines.append(line);
            }
            in.close();

            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            JsonArray jsonArray = new JsonParser().parse(lines.toString()).getAsJsonArray();
            JsonElement wholeUser;

            for(int i=0;i<jsonArray.size();i++){
                wholeUser = jsonArray.get(i);
                JsonObject rootObject = wholeUser.getAsJsonObject();
                arrayList.add(rootObject.get("id").getAsInt());

            }
            //for removing
            System.out.println(arrayList);
            y = Collections.max(arrayList);
            System.out.println("value id for previous max userId: "+y);   //for remove

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }


    public void setPostforID() throws Exception{
        Long userId = null;
        URL url=new URL("https://jsonplaceholder.typicode.com/comments");
        HttpURLConnection connection=(HttpURLConnection)url.openConnection();
        DataOutputStream wr;
        String line;
        JSONObject oppjson = new JSONObject();
        try{
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            wr =new DataOutputStream(connection.getOutputStream());
            oppjson.put("title","titleeee");
            oppjson.put("body","booooddyy");
            oppjson.put("postId",y);
            wr.writeBytes(oppjson.toString());
            wr.flush();
            wr.close();
            int responseCode=connection.getResponseCode();
            InputStream content=(InputStream)connection.getInputStream();
            BufferedReader in=new BufferedReader(new InputStreamReader(content));
            StringBuilder lines=new StringBuilder();
            while((line=in.readLine())!=null){
                lines.append(line);
            }
            in.close();
            System.out.println("Status code for creating new comment: "+responseCode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

}