import java.io.IOException;

public class LaunchDetailsController {

    public LaunchDetailsController(Launch launch) throws IOException {
        LaunchDetailsModel launchDetailsModel = new LaunchDetailsModel(launch);
        LaunchDetailsView launchDetailsView = new LaunchDetailsView(this, launchDetailsModel);

        System.out.println("Started");
    }
}
