public class EnglishText {
    public static void main(String[] args) {
        String englishText = "About a thousand years ago, people known as the Vikings were known and feared throughout Europe. The Vikings were the people of the northern part of Europe, called Scandinavia, which includes the modern countries of Denmark, Norway, and Sweden. The Vikings made their living by farming and fishing. However, by about the year 700, they began making attacks, or raids, upon towns along the coasts of Europe in order to steal the wealth of those towns. The Vikings made their attacks very quickly and without any warning. They were very cruel to the people of the towns they attacked, and they sometimes destroyed the towns by burning down the buildings. In some parts of Europe, the local kings would often fight against the Vikings. Sometimes, however, the kings would pay the Vikings in order to persuade them not to attack. Although the Vikings were known as fierce warriors, they also built excellent ships. The wooden Viking ships, called longboats, were able to sail even in very bad weather. Many Viking longboats were about 20 metres long, but some were nearly 90 metres long. The Viking sailors used both sails and oars to move their ships.";
        String[] words = englishText.split("[^A-Za-z]");
        for (int i = 0; i < words.length; i++){
            if (!words[i].isEmpty()) {
                System.out.println(words[i]);
            }
        }
    }
}
