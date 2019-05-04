import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AllLaunchesView {

    private final Map<String, ImageIcon> imageMap;

    public AllLaunchesView(AllLaunchesController allLaunchesController, AllLaunchesModel allLaunchesModel) {

        JFrame frame = new JFrame("Launches");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        imageMap = createImageMap(allLaunchesModel.launchesArray);
        JList list = new JList(getNamesOnly(allLaunchesModel.launchesArray));
        list.setCellRenderer(new ListRenderer());
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList list = (JList)e.getSource();
                if (e.getClickCount() == 2){
                    int index = list.locationToIndex(e.getPoint());
                    try {
                        allLaunchesController.onClick(index);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JScrollPane scroll = new JScrollPane(list);
        frame.add(scroll);
        frame.pack();
        frame.setSize(1024,768);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    public String[] getNamesOnly(Launch[] list){
        String[] temp = new String[list.length];
        for (int i=0; i < list.length; i++) {
            temp[i] = list[i].getMission_name();
        }
        return temp;
    }

    public class ListRenderer extends DefaultListCellRenderer {

        Font font = new Font("helvitica", Font.BOLD, 24);


        @Override
        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
            label.setIcon(imageMap.get(value));
            label.setHorizontalTextPosition(JLabel.RIGHT);
            label.setFont(font);
            return label;
        }
    }

    private Map<String, ImageIcon> createImageMap(Launch[] list) {
        Map<String, ImageIcon> map = new HashMap<>();
        try {
            for (int i=0; i < list.length; i++) {
                String temp = list[i].getLinks().getMission_patch_small();

                if (temp != null) {
                    Image image = ImageIO.read(new URL(temp)).getScaledInstance(64,64,Image.SCALE_SMOOTH);
                    map.put(list[i].getMission_name(), new ImageIcon(image));
                }
                else{
                    Image image = ImageIO.read(new URL("https://via.placeholder.com/256x256")).getScaledInstance(64,64,Image.SCALE_SMOOTH);
                    map.put(list[i].getMission_name(),new ImageIcon(image));


                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return map;
    }


}
