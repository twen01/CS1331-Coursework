public class StringOperations {
    public static void main(String[] args) {
        String str = "Thomas";
        System.out.println(str);
        str.replace('T','A');
        str.replace('s','Z');
        System.out.println(str);
        String url = "www.google.com";
        System.out.println(url);
        String newUrl = url.substring(4,10).concat("1331");
        System.out.println(newUrl);
    }
}
