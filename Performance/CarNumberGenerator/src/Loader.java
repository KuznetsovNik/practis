import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.*;

public class Loader {
    public static final int REGIONCOUNT = 100;

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        int valueDividedBy10 = REGIONCOUNT / 10;
        for (int i = 0; i < 10; i++) {
            int from = valueDividedBy10 * i + 1;
            int to = valueDividedBy10 * (i + 1);
            executorService.execute(new NumberWriter(from, to));
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        System.out.println((System.currentTimeMillis() - start) + " ms");
    }
}
/*
// В run SBuilder,в padNumber:
    //SBuilder(SBuilder возвр знач) 20c 19c 19c cp-19 ; (String возвр знач) 24c 36c 36c cp-32
    //String(String возвр знач) 19c 19c 22c cp-20
    //SBuffer(SBuffer возвр знач) 21c 20c 20c cp-20 ; (String возвр знач) 26c 25c 24c cp-25
// В run SBuffer,в padNumber:
    //SBuilder(SBuilder возвр знач) 22c 20c 22c cp-21 ; (String возвр знач) 26c 24c 27c cp-25
    //String(String возвр знач) 21c 29c 29c cp-26
    //SBuffer(SBuffer возвр знач) 23c 23c 23c cp-23c ; (String возвр знач) 27c 25c 25c cp-26
 */

class NumberWriter implements Runnable{
    private int from;
    private int to;

    private static String path = "res/numbers1.txt";
    public NumberWriter(int from, int to){
        this.from = from;
        this.to = to;
    }

    @Override
    public void run () {
        try {
            FileOutputStream writer = new FileOutputStream(path,true);
            char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
            StringBuilder builder = new StringBuilder();
            for (int localRegionCode = from; localRegionCode < to; localRegionCode++) {
                for (int number = 1; number < 1000; number++) {
                    for (char firstLetter : letters) {
                        for (char secondLetter : letters) {
                            for (char thirdLetter : letters) {
                                builder.append(firstLetter);
                                builder.append(padNumber(number, 3));
                                builder.append(secondLetter);
                                builder.append(thirdLetter);
                                builder.append(padNumber(localRegionCode, 2));
                                builder.append("\n");
                                if (builder.length() > 1024) {
                                    writer.write(builder.toString().getBytes());
                                    builder = new StringBuilder();
                                }
                            }
                        }
                    }
                }
            }
            writer.flush();
            writer.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private static StringBuilder padNumber(int number, int numberLength) {
        StringBuilder numberBuilder = new StringBuilder().append(number);
        int padSize = numberLength - numberBuilder.length();

        for (int i = 0; i < padSize; i++) {
            numberBuilder.insert(0,'0');
        }

        return numberBuilder;
    }
}

