package leetcode;

import com.sun.org.apache.bcel.internal.classfile.Code;

import java.util.HashMap;
import java.util.Random;

public class TinyUrlCodec {
    public static void main(String[] args) {
        String testUrl = "https://domain.com/my/awesome-url2";
        Codec codec = new Codec();
        String tinyUrl = codec.encode(testUrl);
        System.out.println(tinyUrl);
        String longUrl = codec.decode(tinyUrl);
        System.out.println(longUrl);
    }

    static class Codec {


        //base 62
        final static char[] ALPHABET = "abcdefghijklmnopqrtstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        final static Integer TINY_URL_SIZE = 9;
        final static Integer BASE = ALPHABET.length;
        final static String BASE_URL = "https://tinyurl.com/";
        static HashMap<String, String> urlCache = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            StringBuilder stringBuilder = new StringBuilder();



            String tinyUrl = stringBuilder.toString();
            urlCache.put(tinyUrl, longUrl);
            return BASE_URL + stringBuilder.toString();
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return urlCache.getOrDefault(shortUrl.substring(BASE_URL.length()), null);
        }
    }

}
