import java.io.IOException;

public class AllLaunchesModel {
    private ApiParser apiParser;
    public Launch[] launchesArray;

    public AllLaunchesModel() throws IOException {
        apiParser = new ApiParser();
        launchesArray = apiParser.getAllLaunches();

    }
}
