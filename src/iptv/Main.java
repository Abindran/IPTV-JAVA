package iptv;
import api.ChannelLink;
import api.TokenApi;
import api.UserDetails;
import videoplayer.Player;

import java.io.IOException;


public class Main {

    static String token;
    public static String videoURL;


    public String getVideUrl(){
        return videoURL;
    }

    public static  void main(String[]args) throws IOException {

        TokenApi tokenApi = new TokenApi();
        token = tokenApi.getToken();

        UserDetails userDetails = new UserDetails(token);
        userDetails.userDetails();

        ChannelLink channelLink = new ChannelLink(token);
        videoURL = channelLink.channelLink();

        Player.main();
    }

}
