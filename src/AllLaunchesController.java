import java.io.IOException;

public class AllLaunchesController {
    AllLaunchesModel allLaunchesModel;

    public AllLaunchesController() throws IOException {
        allLaunchesModel = new AllLaunchesModel();
        AllLaunchesView allLaunchesView = new AllLaunchesView(this, allLaunchesModel);

    }
    public void onClick(int index) throws IOException {

        LaunchDetailsController launchDetailsController = new LaunchDetailsController(allLaunchesModel.launchesArray[index]);
    }
}
