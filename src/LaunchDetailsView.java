import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class LaunchDetailsView {

    public LaunchDetailsView(LaunchDetailsController launchDetailsController, LaunchDetailsModel launchDetailsModel) throws IOException {
        JFrame frame = new JFrame(launchDetailsModel.launch.getMission_name());
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(1024, 768);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.LINE_AXIS));
        String imageURLString = launchDetailsModel.launch.getLinks().getMission_patch();


        JLabel imageLabel;
        if (imageURLString == null) {
            Image image = ImageIO.read(new URL("https://via.placeholder.com/256x256"));
            imageLabel = new JLabel(new ImageIcon(image.getScaledInstance(256, 256, Image.SCALE_SMOOTH)));
        } else {
            Image image = ImageIO.read(new URL(imageURLString));
            imageLabel = new JLabel(new ImageIcon(image.getScaledInstance(256, 256, Image.SCALE_SMOOTH)));
        }

        jPanel.add(imageLabel);
        imageLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        JPanel header = new JPanel();
        header.setSize(frame.getWidth()/3, frame.getHeight());
        header.setAlignmentY(Component.TOP_ALIGNMENT);
        header.setLayout(new BoxLayout(header,BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("<html><h1>" + launchDetailsModel.launch.getMission_name()+ "</h1></html>" );
        JLabel details = new JLabel("<html><p>" + launchDetailsModel.launch.getDetails() + "</p></html>");

        header.add(title);
        header.add(details);


        jPanel.add(header);
        frame.add(jPanel);
        frame.repaint();
    }


}
