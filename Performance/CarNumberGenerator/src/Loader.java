import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Loader {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        List<Thread> threadsList = new ArrayList<>();
        for (int i = 1; i < 6;i++) {
            RunnerThread runnerThread = new RunnerThread("res/numbers%.txt".replaceFirst("\\%", String.valueOf(i)));
            threadsList.add(runnerThread);
        }
        threadsList.forEach(Thread::run);

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static StringBuilder padNumber(int number, int numberLength) {
        StringBuilder numberBuilder = new StringBuilder().append(number);
        int padSize = numberLength - number;
        for (int i = 0; i < padSize; i++) {
            numberBuilder.insert(0,'0');
        }
        return numberBuilder;
    }

    static class RunnerThread extends Thread{
        String path;
        RunnerThread(String path){
            this.path = path;
        }
        public void run(){
            try {
                PrintWriter writer = new PrintWriter(path);
                char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

                for (int regionCode = 1; regionCode < 100; regionCode++) {
                    StringBuilder builder = new StringBuilder();
                    for (int number = 1; number < 1000; number++) {
                        for (char firstLetter : letters) {
                            for (char secondLetter : letters) {
                                for (char thirdLetter : letters) {
                                    builder.append(firstLetter);
                                    builder.append(padNumber(number, 3));
                                    builder.append(secondLetter);
                                    builder.append(thirdLetter);
                                    builder.append(padNumber(regionCode, 2));
                                    builder.append("\n");

                                }
                            }
                        }
                    }
                    writer.write(builder.toString());
                }
                writer.flush();
                writer.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}
