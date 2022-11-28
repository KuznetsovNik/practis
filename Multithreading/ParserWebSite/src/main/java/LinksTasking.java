import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class LinksTasking extends RecursiveTask<List<String>> {
    private String url;

    public LinksTasking(String url) {
        this.url = url;
    }

    @Override
    protected List<String> compute() {
        List<String> result = new ArrayList<>();
        List<LinksTasking> linksTasking = new ArrayList<>();
        List<String> linksList = new ArrayList<>();
        try {
            result.add(url);
            linksList.addAll(ParserUtils.parserUtils(url));
            for (String thisUrl : linksList){
                linksTasking.add(new LinksTasking(thisUrl));
            }
            for (LinksTasking linksTasker : linksTasking){
                linksTasker.fork();
            }
            for (LinksTasking linksTasker : linksTasking) {
                result.addAll(linksTasker.join());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
