import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodPlaceholder {

    public static void searchAndReplaceDiamonds(String text, String placeholder) {
        Pattern p = Pattern.compile("(<([\\w\\s]+)>)");
        Matcher m = p.matcher(text);
        StringBuffer sb = new StringBuffer();
        while (m.find())
            m.appendReplacement(sb, placeholder);
        m.appendTail(sb);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        searchAndReplaceDiamonds("abc!<cat bear 128>? Toy <dog>!", "Is`it");
    }
}
