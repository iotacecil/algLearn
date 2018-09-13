package courseBook.dsLearn;

import java.util.ArrayList;
import java.util.List;

public class Codec {
    List<String> urls = new ArrayList<String>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urls.add(longUrl);
        return String.valueOf(urls.size()-1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = Integer.valueOf(shortUrl);
        return (index<urls.size())?urls.get(index):"";
    }
    public static void main(String[] args) {
        Codec sl = new Codec();
        System.out.println(sl.encode("https://main.java.leetcode.com/problems/design-tinyurl"));

    }
}
