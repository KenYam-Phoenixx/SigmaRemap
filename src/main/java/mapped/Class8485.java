package mapped;

import totalcross.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Class8485 {
   private static final int field36377 = 15000;
   private static final int field36378 = 80;
   public static final String field36379 = "8744d8c7bb5e811a40b6119d63811040";
   public static final String field36380 = "http://ws.audioscrobbler.com/2.0/";
   private static final int field36381 = 30;
   public static final String field36382 = "http://musicbrainz.org/ws/2/";
   private static final int field36383 = 15000;
   private static final String field36384 = Class8485.class.getName();

   public static JSONObject method30008(String var0, String var1) throws IOException {
      URL var4 = new URL(var0);
      HttpURLConnection var5 = (HttpURLConnection)var4.openConnection();
      String var6 = "Set-Cookie";
      var5.setRequestMethod("GET");
      var5.setRequestProperty(
         "ChatCommandExecutor-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/604.4.7 (KHTML, like Gecko) Version/11.0.2 Safari/604.4.7"
      );
      var5.setRequestProperty("Accept-Language", "en-us");
      var5.setRequestProperty("Accept", "application/json");
      var5.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      var5.setRequestProperty("Connexion", "keep-alive");
      var5.setRequestProperty("DNT", "1");
      var5.setRequestProperty("Upgrade-Insecure-Requests", "1");
      var5.setDoOutput(true);
      DataOutputStream var7 = new DataOutputStream(var5.getOutputStream());
      var7.writeBytes(var1);
      var7.flush();
      var7.close();
      int var8 = var5.getResponseCode();
      BufferedReader var9 = new BufferedReader(new InputStreamReader(var5.getInputStream()));
      StringBuffer var10 = new StringBuffer();

      String var11;
      while ((var11 = var9.readLine()) != null) {
         var10.append(var11);
      }

      var9.close();
      return Class9275.method34958(var10.toString());
   }
}
