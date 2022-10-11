package api;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

public class ChannelLink {

    String token;
    HeaderDetails header;

    public ChannelLink(String token){
        this.token = token;
    }

    public String channelLink() throws IOException {

        URL url = new URL("http://tv.tvzon.tv/stalker_portal/server/load.php?type=itv&action=create_link&cmd=ffrt%20http%3A%2F%2Flocalhost%2Fch%2F7650&JsHttpRequest=1-xml");
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

        header = new HeaderDetails(token);
        header.setHeader(httpConn);

        InputStream responseStream = httpConn.getResponseCode()  == 200
                ? httpConn.getInputStream()
                : httpConn.getErrorStream();

        if ("gzip".equals(httpConn.getContentEncoding())) {
            responseStream = new GZIPInputStream(responseStream);
        }

        Scanner s2 = new Scanner(responseStream).useDelimiter("\\A");
        String response = s2.hasNext() ? s2.next() : "";
        System.out.println(response);
        JSONObject obj=new JSONObject(response);
        JSONObject temp= (JSONObject) obj.get("js");
        String videoURL =(String) temp.get("cmd");

        return videoURL;

    }
}
