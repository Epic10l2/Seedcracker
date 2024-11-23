import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
public class Seedcracker {

    private JComboBox<String> versionComboBox;

    public static List<Long> structureSeeds = new ArrayList<>();
    public static List<Long> partialSeeds = new ArrayList<>();
    public static AtomicInteger amountofpartialseeds = new AtomicInteger(0);
    public static AtomicInteger partialprogress = new AtomicInteger(0);
    public static AtomicInteger lastprogress = new AtomicInteger(0);
    public static boolean lightmode = true;
    private JComboBox<String> input1ComboBox, input2ComboBox, input3ComboBox, input4ComboBox, input5ComboBox, input6ComboBox, input7ComboBox, input8ComboBox, input9ComboBox, input10ComboBox;
    private JTextField input1XInput, input1ZInput, input2XInput, input2ZInput, input3XInput, input3ZInput, input4XInput, input4ZInput, input5XInput, input5ZInput, input6XInput, input6ZInput, input7XInput, input7ZInput, input8XInput, input8ZInput, input9XInput, input9ZInput, input10XInput, input10ZInput,pillarseedinput,gatewayinput;
    private JCheckBox pillarseedbox = new JCheckBox("Pillarseed"), gatewaybox = new JCheckBox("Gateway");
    public static JProgressBar partialbar = new JProgressBar(0,1048576),fullbar = new JProgressBar(0,268435456);
    public static JLabel partiallabel = new JLabel("Partial bruteforce: "+ partialSeeds),fulllabel = new JLabel("Complete bruteforce: "+ structureSeeds);
    public void GUI() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        partiallabel.setBounds(350, 180, 500, 20);
        frame.add(partiallabel);
        fulllabel.setBounds(350, 230, 500, 20);
        frame.add(fulllabel);
        partialbar.setValue(0);
        partialbar.setStringPainted(true);
        partialbar.setBounds(350, 200, 150, 20);
        frame.add(partialbar);
        fullbar.setValue(0);
        fullbar.setStringPainted(true);
        fullbar.setBounds(350, 250, 150, 20);
        frame.add(fullbar);
        versionComboBox = new JComboBox<>(new String[]{"Java", "Bedrock"});
        versionComboBox.setBounds(50, 10, 100, 30);
        panel.add(versionComboBox);
        pillarseedbox.setBounds(350, 50, 100, 30);
        pillarseedinput = createInputField(panel, 300, 80);
        pillarseedinput.setBounds(350, 80, 100, 30);
        pillarseedinput.setVisible(false);
        gatewaybox.setBounds(450, 50, 100, 30);
        gatewayinput = createInputField(panel, 400, 80);
        gatewayinput.setBounds(450, 80, 100, 30);
        gatewayinput.setVisible(false);

        pillarseedbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pillarseedinput.setVisible(pillarseedbox.isSelected());
                frame.revalidate();
                frame.repaint();
            }
        });
        gatewaybox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gatewayinput.setVisible(gatewaybox.isSelected());
                frame.revalidate();
                frame.repaint();
            }
        });

        frame.add(pillarseedbox);
        frame.add(gatewaybox);

        input1ComboBox = createRow(panel, 50, 50, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Desertemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input1ComboBox.setBounds(50, 50, 150, 30);
        input1XInput = createInputField(panel, 210, 50);
        input1ZInput = createInputField(panel, 270, 50);

        input2ComboBox = createRow(panel, 50, 90, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input2ComboBox.setBounds(50, 90, 150, 30);
        input2XInput = createInputField(panel, 210, 90);
        input2ZInput = createInputField(panel, 270, 90);

        input3ComboBox = createRow(panel, 50, 130, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input3ComboBox.setBounds(50, 130, 150, 30);
        input3XInput = createInputField(panel, 210, 130);
        input3ZInput = createInputField(panel, 270, 130);

        input4ComboBox = createRow(panel, 50, 170, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input4ComboBox.setBounds(50, 170, 150, 30);
        input4XInput = createInputField(panel, 210, 170);
        input4ZInput = createInputField(panel, 270, 170);

        input5ComboBox = createRow(panel, 50, 210, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input5ComboBox.setBounds(50, 210, 150, 30);
        input5XInput = createInputField(panel, 210, 210);
        input5ZInput = createInputField(panel, 270, 210);

        input6ComboBox = createRow(panel, 50, 250, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input6ComboBox.setBounds(50, 250, 150, 30);
        input6XInput = createInputField(panel, 210, 250);
        input6ZInput = createInputField(panel, 270, 250);

        input7ComboBox = createRow(panel, 50, 290, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input7ComboBox.setBounds(50, 290, 150, 30);
        input7XInput = createInputField(panel, 210, 290);
        input7ZInput = createInputField(panel, 270, 290);

        input8ComboBox = createRow(panel, 50, 330, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input8ComboBox.setBounds(50, 330, 150, 30);
        input8XInput = createInputField(panel, 210, 330);
        input8ZInput = createInputField(panel, 270, 330);

        input9ComboBox = createRow(panel, 50, 370, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input9ComboBox.setBounds(50, 370, 150, 30);
        input9XInput = createInputField(panel, 210, 370);
        input9ZInput = createInputField(panel, 270, 370);

        input10ComboBox = createRow(panel, 50, 410, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input10ComboBox.setBounds(50, 410, 150, 30);
        input10XInput = createInputField(panel, 210, 410);
        input10ZInput = createInputField(panel, 270, 410);

        JButton crackButton = new JButton("Crack");
        crackButton.setBounds(350, 300, 100, 30);
        panel.add(crackButton);
        crackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String edition = (String) versionComboBox.getSelectedItem();
                int editionwarning = 0;
                if (edition == "Bedrock") {
                    editionwarning = JOptionPane.showConfirmDialog(panel, "Bedrock Edition support is not yet fully implemented.", "Bedrock Edition not Supported", JOptionPane.CLOSED_OPTION);

                } else {
                    long liftablebits = 0;
                    StructureChecker desertTempleChecker = new StructureChecker(14357617L);
                    StructureChecker jungleTempleChecker = new StructureChecker(14357619L);
                    StructureChecker iglooChecker = new StructureChecker(14357618L);
                    StructureChecker swampHutChecker = new StructureChecker(14357620L);
                    StructureChecker outpostChecker = new StructureChecker(165745296);
                    StructureChecker shipwreckChecker = new StructureChecker(165745295);
                    StructureChecker ruinedPortalChecker = new StructureChecker(34222645);
                    StructureChecker ancientCityChecker = new StructureChecker(20083232);
                    StructureChecker mansionChecker = new StructureChecker(10387319);
                    StructureChecker chamberChecker = new StructureChecker(94251327);
                    StructureChecker villageChecker = new StructureChecker(10387312);
                    StructureChecker oceanruinChecker = new StructureChecker(14357621);
                    StructureChecker buriedChecker = new StructureChecker(10387320);
                    StructureChecker monumentChecker = new StructureChecker(10387313);
                    StructureChecker trailruinChecker = new StructureChecker(83469867);
                    StructureChecker structurefeatures1_12Checker = new StructureChecker(14357617);
                    StructureChecker village1_17Checker = new StructureChecker(10387312);
                    StructureChecker Netherstructurechecker = new StructureChecker(30084232);
                    StructureChecker bedrock_genericchecker = new StructureChecker(14357617);
                    StructureChecker bedrock_outpostChecker = new StructureChecker(165745296);
                    StructureChecker bedrock_shipwreckChecker = new StructureChecker(165745295);
                    StructureChecker bedrock_shipwreck1_17checker = new StructureChecker(165745295);
                    StructureChecker bedrock_villageChecker = new StructureChecker(10387312);
                    StructureChecker bedrock_village1_17Checker = new StructureChecker(10387312);
                    StructureChecker bedrock_portalChecker = new StructureChecker(40552231);
                    StructureChecker bedrock_treasureChecker = new StructureChecker(16842397);
                    StructureChecker bedrock_mansionChecker = new StructureChecker(10387319);
                    StructureChecker bedrock_monumentChecker = new StructureChecker(10387319);
                    StructureChecker mineshaftChecker = new StructureChecker(0);
                    StructureChecker slimechunkChecker = new StructureChecker(0);

                    String input1Selection = (String) input1ComboBox.getSelectedItem();
                    if (input1Selection != "None") {
                        if (input1Selection == "Deserttemple" || input1Selection == "Jungletemple" || input1Selection == "Igloo" || input1Selection == "Swamphut" || input1Selection == "Outpost" || input1Selection == "Deserttemple 1.12-" || input1Selection == "Jungletemple 1.12-" || input1Selection == "Igloo 1.12-" || input1Selection == "Swamphut 1.12-" || input1Selection == "Village 1.17-") {
                            int input1X = Integer.parseInt(input1XInput.getText());
                            int input1Z = Integer.parseInt(input1ZInput.getText());
                            MainSeedcracker.structureadder(input1Selection, input1X, input1Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input1Selection == "Ship" || input1Selection == "Oceanruin") {
                            int input1X = Integer.parseInt(input1XInput.getText());
                            int input1Z = Integer.parseInt(input1ZInput.getText());
                            MainSeedcracker.structureadder(input1Selection, input1X, input1Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input1Selection == "Slimechunk") {
                            int input1X = Integer.parseInt(input1XInput.getText());
                            int input1Z = Integer.parseInt(input1ZInput.getText());
                            MainSeedcracker.structureadder(input1Selection, input1X, input1Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input1Selection == "Mansion" || input1Selection == "Village" || input1Selection == "Trialchamber" || input1Selection == "Trailruin") {
                            int input1X = Integer.parseInt(input1XInput.getText());
                            int input1Z = Integer.parseInt(input1ZInput.getText());
                            MainSeedcracker.structureadder(input1Selection, input1X, input1Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input1X = Integer.parseInt(input1XInput.getText());
                            int input1Z = Integer.parseInt(input1ZInput.getText());
                            MainSeedcracker.structureadder(input1Selection, input1X, input1Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }

                    String input2Selection = (String) input2ComboBox.getSelectedItem();
                    if (input2Selection != "None") {
                        if (input2Selection == "Deserttemple" || input2Selection == "Jungletemple" || input2Selection == "Igloo" || input2Selection == "Swamphut" || input2Selection == "Outpost" || input2Selection == "Deserttemple 1.12-" || input2Selection == "Jungletemple 1.12-" || input2Selection == "Igloo 1.12-" || input2Selection == "Swamphut 1.12-" || input2Selection == "Village 1.17-") {
                            int input2X = Integer.parseInt(input2XInput.getText());
                            int input2Z = Integer.parseInt(input2ZInput.getText());
                            MainSeedcracker.structureadder(input2Selection, input2X, input2Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input2Selection == "Ship" || input2Selection == "Oceanruin") {
                            int input2X = Integer.parseInt(input2XInput.getText());
                            int input2Z = Integer.parseInt(input2ZInput.getText());
                            MainSeedcracker.structureadder(input2Selection, input2X, input2Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input2Selection == "Slimechunk") {
                            int input2X = Integer.parseInt(input2XInput.getText());
                            int input2Z = Integer.parseInt(input2ZInput.getText());
                            MainSeedcracker.structureadder(input2Selection, input2X, input2Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input2Selection == "Mansion" || input2Selection == "Village" || input2Selection == "Trialchamber" || input2Selection == "Trailruin") {
                            int input2X = Integer.parseInt(input2XInput.getText());
                            int input2Z = Integer.parseInt(input2ZInput.getText());
                            MainSeedcracker.structureadder(input2Selection, input2X, input2Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input2X = Integer.parseInt(input2XInput.getText());
                            int input2Z = Integer.parseInt(input2ZInput.getText());
                            MainSeedcracker.structureadder(input2Selection, input2X, input2Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }
                    String input3Selection = (String) input3ComboBox.getSelectedItem();
                    if (input3Selection != "None") {
                        if (input3Selection == "Deserttemple" || input3Selection == "Jungletemple" || input3Selection == "Igloo" || input3Selection == "Swamphut" || input3Selection == "Outpost" || input3Selection == "Deserttemple 1.12-" || input3Selection == "Jungletemple 1.12-" || input3Selection == "Igloo 1.12-" || input3Selection == "Swamphut 1.12-" || input3Selection == "Village 1.17-") {
                            int input3X = Integer.parseInt(input3XInput.getText());
                            int input3Z = Integer.parseInt(input3ZInput.getText());
                            MainSeedcracker.structureadder(input3Selection, input3X, input3Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input3Selection == "Ship" || input3Selection == "Oceanruin") {
                            int input3X = Integer.parseInt(input3XInput.getText());
                            int input3Z = Integer.parseInt(input3ZInput.getText());
                            MainSeedcracker.structureadder(input3Selection, input3X, input3Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input3Selection == "Slimechunk") {
                            int input3X = Integer.parseInt(input3XInput.getText());
                            int input3Z = Integer.parseInt(input3ZInput.getText());
                            MainSeedcracker.structureadder(input3Selection, input3X, input3Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input3Selection == "Mansion" || input3Selection == "Village" || input3Selection == "Trialchamber" || input3Selection == "Trailruin" ) {
                            int input3X = Integer.parseInt(input3XInput.getText());
                            int input3Z = Integer.parseInt(input3ZInput.getText());
                            MainSeedcracker.structureadder(input3Selection, input3X, input3Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input3X = Integer.parseInt(input3XInput.getText());
                            int input3Z = Integer.parseInt(input3ZInput.getText());
                            MainSeedcracker.structureadder(input3Selection, input3X, input3Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }
                    String input4Selection = (String) input4ComboBox.getSelectedItem();
                    if (input4Selection != "None") {
                        if (input4Selection == "Deserttemple" || input4Selection == "Jungletemple" || input4Selection == "Igloo" || input4Selection == "Swamphut" || input4Selection == "Outpost" || input4Selection == "Deserttemple 1.12-" || input4Selection == "Jungletemple 1.12-" || input4Selection == "Igloo 1.12-" || input4Selection == "Swamphut 1.12-" || input4Selection == "Village 1.17-") {
                            int input4X = Integer.parseInt(input4XInput.getText());
                            int input4Z = Integer.parseInt(input4ZInput.getText());
                            MainSeedcracker.structureadder(input4Selection, input4X, input4Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input4Selection == "Ship" || input4Selection == "Oceanruin") {
                            int input4X = Integer.parseInt(input4XInput.getText());
                            int input4Z = Integer.parseInt(input4ZInput.getText());
                            MainSeedcracker.structureadder(input4Selection, input4X, input4Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input4Selection == "Slimechunk") {
                            int input4X = Integer.parseInt(input4XInput.getText());
                            int input4Z = Integer.parseInt(input4ZInput.getText());
                            MainSeedcracker.structureadder(input4Selection, input4X, input4Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input4Selection == "Mansion" || input4Selection == "Village" || input4Selection == "Trialchamber" || input4Selection == "Trailruin") {
                            int input4X = Integer.parseInt(input4XInput.getText());
                            int input4Z = Integer.parseInt(input4ZInput.getText());
                            MainSeedcracker.structureadder(input4Selection, input4X, input4Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input4X = Integer.parseInt(input4XInput.getText());
                            int input4Z = Integer.parseInt(input4ZInput.getText());
                            MainSeedcracker.structureadder(input4Selection, input4X, input4Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }


                    String input5Selection = (String) input5ComboBox.getSelectedItem();
                    if (input5Selection != "None") {
                        if (input5Selection == "Deserttemple" || input5Selection == "Jungletemple" || input5Selection == "Igloo" || input5Selection == "Swamphut" || input5Selection == "Outpost" || input5Selection == "Deserttemple 1.12-" || input5Selection == "Jungletemple 1.12-" || input5Selection == "Igloo 1.12-" || input5Selection == "Swamphut 1.12-" || input5Selection == "Village 1.17-") {
                            int input5X = Integer.parseInt(input5XInput.getText());
                            int input5Z = Integer.parseInt(input5ZInput.getText());
                            MainSeedcracker.structureadder(input5Selection, input5X, input5Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input5Selection == "Ship" || input5Selection == "Oceanruin") {
                            int input5X = Integer.parseInt(input5XInput.getText());
                            int input5Z = Integer.parseInt(input5ZInput.getText());
                            MainSeedcracker.structureadder(input5Selection, input5X, input5Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input5Selection == "Slimechunk") {
                            int input5X = Integer.parseInt(input5XInput.getText());
                            int input5Z = Integer.parseInt(input5ZInput.getText());
                            MainSeedcracker.structureadder(input5Selection, input5X, input5Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input5Selection == "Mansion" || input5Selection == "Village" || input5Selection == "Trialchamber" || input5Selection == "Trailruin") {
                            int input5X = Integer.parseInt(input5XInput.getText());
                            int input5Z = Integer.parseInt(input5ZInput.getText());
                            MainSeedcracker.structureadder(input5Selection, input5X, input5Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input5X = Integer.parseInt(input5XInput.getText());
                            int input5Z = Integer.parseInt(input5ZInput.getText());
                            MainSeedcracker.structureadder(input5Selection, input5X, input5Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }

                    String input6Selection = (String) input6ComboBox.getSelectedItem();
                    if (input6Selection != "None") {
                        if (input6Selection == "Deserttemple" || input6Selection == "Jungletemple" || input6Selection == "Igloo" || input6Selection == "Swamphut" || input6Selection == "Outpost" || input6Selection == "Deserttemple 1.12-" || input6Selection == "Jungletemple 1.12-" || input6Selection == "Igloo 1.12-" || input6Selection == "Swamphut 1.12-" || input6Selection == "Village 1.17-") {
                            int input6X = Integer.parseInt(input6XInput.getText());
                            int input6Z = Integer.parseInt(input6ZInput.getText());
                            MainSeedcracker.structureadder(input6Selection, input6X, input6Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input6Selection == "Ship" || input6Selection == "Oceanruin") {
                            int input6X = Integer.parseInt(input6XInput.getText());
                            int input6Z = Integer.parseInt(input6ZInput.getText());
                            MainSeedcracker.structureadder(input6Selection, input6X, input6Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input6Selection == "Slimechunk") {
                            int input6X = Integer.parseInt(input6XInput.getText());
                            int input6Z = Integer.parseInt(input6ZInput.getText());
                            MainSeedcracker.structureadder(input6Selection, input6X, input6Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input6Selection == "Mansion" || input6Selection == "Village" || input6Selection == "Trialchamber" || input6Selection == "Trailruin") {
                            int input6X = Integer.parseInt(input6XInput.getText());
                            int input6Z = Integer.parseInt(input6ZInput.getText());
                            MainSeedcracker.structureadder(input6Selection, input6X, input6Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input6X = Integer.parseInt(input6XInput.getText());
                            int input6Z = Integer.parseInt(input6ZInput.getText());
                            MainSeedcracker.structureadder(input6Selection, input6X, input6Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }
                    String input7Selection = (String) input7ComboBox.getSelectedItem();
                    if (input7Selection != "None") {
                        if (input7Selection == "Deserttemple" || input7Selection == "Jungletemple" || input7Selection == "Igloo" || input7Selection == "Swamphut" || input7Selection == "Outpost" || input7Selection == "Deserttemple 1.12-" || input7Selection == "Jungletemple 1.12-" || input7Selection == "Igloo 1.12-" || input7Selection == "Swamphut 1.12-" || input7Selection == "Village 1.17-") {
                            int input7X = Integer.parseInt(input7XInput.getText());
                            int input7Z = Integer.parseInt(input7ZInput.getText());
                            MainSeedcracker.structureadder(input7Selection, input7X, input7Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input7Selection == "Ship" || input7Selection == "Oceanruin") {
                            int input7X = Integer.parseInt(input7XInput.getText());
                            int input7Z = Integer.parseInt(input7ZInput.getText());
                            MainSeedcracker.structureadder(input7Selection, input7X, input7Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input7Selection == "Slimechunk") {
                            int input7X = Integer.parseInt(input7XInput.getText());
                            int input7Z = Integer.parseInt(input7ZInput.getText());
                            MainSeedcracker.structureadder(input7Selection, input7X, input7Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input7Selection == "Mansion" || input7Selection == "Village" || input7Selection == "Trialchamber" || input7Selection == "Trailruin") {
                            int input7X = Integer.parseInt(input7XInput.getText());
                            int input7Z = Integer.parseInt(input7ZInput.getText());
                            MainSeedcracker.structureadder(input7Selection, input7X, input7Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input7X = Integer.parseInt(input7XInput.getText());
                            int input7Z = Integer.parseInt(input7ZInput.getText());
                            MainSeedcracker.structureadder(input7Selection, input7X, input7Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }

                    String input8Selection = (String) input8ComboBox.getSelectedItem();
                    if (input8Selection != "None") {
                        if (input8Selection == "Deserttemple" || input8Selection == "Jungletemple" || input8Selection == "Igloo" || input8Selection == "Swamphut" || input8Selection == "Outpost" || input8Selection == "Deserttemple 1.12-" || input8Selection == "Jungletemple 1.12-" || input8Selection == "Igloo 1.12-" || input8Selection == "Swamphut 1.12-" || input8Selection == "Village 1.17-") {
                            int input8X = Integer.parseInt(input8XInput.getText());
                            int input8Z = Integer.parseInt(input8ZInput.getText());
                            MainSeedcracker.structureadder(input8Selection, input8X, input8Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input8Selection == "Ship" || input8Selection == "Oceanruin") {
                            int input8X = Integer.parseInt(input8XInput.getText());
                            int input8Z = Integer.parseInt(input8ZInput.getText());
                            MainSeedcracker.structureadder(input8Selection, input8X, input8Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input8Selection == "Slimechunk") {
                            int input8X = Integer.parseInt(input8XInput.getText());
                            int input8Z = Integer.parseInt(input8ZInput.getText());
                            MainSeedcracker.structureadder(input8Selection, input8X, input8Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input8Selection == "Mansion" || input8Selection == "Village" || input8Selection == "Trialchamber" || input8Selection == "Trailruin") {
                            int input8X = Integer.parseInt(input8XInput.getText());
                            int input8Z = Integer.parseInt(input8ZInput.getText());
                            MainSeedcracker.structureadder(input8Selection, input8X, input8Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input8X = Integer.parseInt(input8XInput.getText());
                            int input8Z = Integer.parseInt(input8ZInput.getText());
                            MainSeedcracker.structureadder(input8Selection, input8X, input8Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }

                    String input9Selection = (String) input9ComboBox.getSelectedItem();
                    if (input9Selection != "None") {
                        if (input9Selection == "Deserttemple" || input9Selection == "Jungletemple" || input9Selection == "Igloo" || input9Selection == "Swamphut" || input9Selection == "Outpost" || input9Selection == "Deserttemple 1.12-" || input9Selection == "Jungletemple 1.12-" || input9Selection == "Igloo 1.12-" || input9Selection == "Swamphut 1.12-" || input9Selection == "Village 1.17-") {
                            int input9X = Integer.parseInt(input9XInput.getText());
                            int input9Z = Integer.parseInt(input9ZInput.getText());
                            MainSeedcracker.structureadder(input9Selection, input9X, input9Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input9Selection == "Ship" || input9Selection == "Oceanruin") {
                            int input9X = Integer.parseInt(input9XInput.getText());
                            int input9Z = Integer.parseInt(input9ZInput.getText());
                            MainSeedcracker.structureadder(input9Selection, input9X, input9Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input9Selection == "Slimechunk") {
                            int input9X = Integer.parseInt(input9XInput.getText());
                            int input9Z = Integer.parseInt(input9ZInput.getText());
                            MainSeedcracker.structureadder(input9Selection, input9X, input9Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input9Selection == "Mansion" || input9Selection == "Village" || input9Selection == "Trialchamber" || input9Selection == "Trailruin") {
                            int input9X = Integer.parseInt(input9XInput.getText());
                            int input9Z = Integer.parseInt(input9ZInput.getText());
                            MainSeedcracker.structureadder(input9Selection, input9X, input9Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input9X = Integer.parseInt(input9XInput.getText());
                            int input9Z = Integer.parseInt(input9ZInput.getText());
                            MainSeedcracker.structureadder(input9Selection, input9X, input9Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }

                    String input10Selection = (String) input10ComboBox.getSelectedItem();
                    if (input10Selection != "None") {
                        if (input10Selection == "Deserttemple" || input10Selection == "Jungletemple" || input10Selection == "Igloo" || input10Selection == "Swamphut" || input10Selection == "Outpost" || input1Selection == "Deserttemple 1.12-" || input10Selection == "Jungletemple 1.12-" || input10Selection == "Igloo 1.12-" || input10Selection == "Swamphut 1.12-" || input10Selection == "Village 1.17-") {
                            int input10X = Integer.parseInt(input10XInput.getText());
                            int input10Z = Integer.parseInt(input10ZInput.getText());
                            MainSeedcracker.structureadder(input10Selection, input10X, input10Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input10Selection == "Ship" || input10Selection == "Oceanruin") {
                            int input10X = Integer.parseInt(input10XInput.getText());
                            int input10Z = Integer.parseInt(input10ZInput.getText());
                            MainSeedcracker.structureadder(input10Selection, input10X, input10Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input10Selection == "Slimechunk") {
                            int input10X = Integer.parseInt(input10XInput.getText());
                            int input10Z = Integer.parseInt(input10ZInput.getText());
                            MainSeedcracker.structureadder(input10Selection, input10X, input10Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input10Selection == "Mansion" || input10Selection == "Village" || input10Selection == "Trialchamber" || input10Selection == "Trailruin") {
                            int input10X = Integer.parseInt(input10XInput.getText());
                            int input10Z = Integer.parseInt(input10ZInput.getText());
                            MainSeedcracker.structureadder(input10Selection, input10X, input10Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input10X = Integer.parseInt(input10XInput.getText());
                            int input10Z = Integer.parseInt(input10ZInput.getText());
                            MainSeedcracker.structureadder(input10Selection, input10X, input10Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }
                    if (gatewaybox.isSelected()) {
                        liftablebits += 2;
                    }
                    if (liftablebits >= 20 || pillarseedbox.isSelected() && liftablebits >= 16) {
                        long pillarSeed = -1;
                        if (pillarseedbox.isSelected()) {
                            pillarSeed = Integer.parseInt(pillarseedinput.getText());
                        }
                        int gateWay = -1;
                        if (gatewaybox.isSelected()) {
                            gateWay = Integer.parseInt(gatewayinput.getText());
                        }
                        boolean findStructureSeed = true;
                        amountofpartialseeds.set(0);
                        partialprogress.set(0);
                        lastprogress.set(0);
                        partialbar.setValue(0);
                        fullbar.setValue(0);
                        partialSeeds.clear();
                        partiallabel.setText("Partial bruteforce: " + partialSeeds);
                        structureSeeds.clear();
                        fulllabel.setText("Complete bruteforce: " + structureSeeds);
                        if (pillarSeed == -1) {
                            partialbar.setMaximum(1048576);
                            fullbar.setMaximum(268435456);
                            crackSeedsWithoutPillars(desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker, gateWay, findStructureSeed, structureSeeds);
                        } else {
                            partialbar.setMaximum(65536);
                            fullbar.setMaximum(65536);
                            crackSeeds(pillarSeed, gateWay, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, Netherstructurechecker, slimechunkChecker, findStructureSeed, structureSeeds);
                        }
                    } else {
                        int result = 0;
                        if (pillarseedbox.isSelected()) {
                            result = JOptionPane.showConfirmDialog(panel, "You only have " + liftablebits + "/16 liftable bits, do you want to continue anyways?", "Not enough Bits.", JOptionPane.YES_NO_OPTION);
                        } else {
                            result = JOptionPane.showConfirmDialog(panel, "You only have " + liftablebits + "/20 liftable bits, do you want to continue anyways?", "Not enough Bits.", JOptionPane.YES_NO_OPTION);
                        }
                        if (result == JOptionPane.YES_OPTION) {
                            List<Long> structureSeeds = new ArrayList<>();
                            long pillarSeed = -1;
                            if (pillarseedbox.isSelected()) {
                                pillarSeed = Integer.parseInt(pillarseedinput.getText());
                            }
                            int gateWay = -1;
                            if (gatewaybox.isSelected()) {
                                gateWay = Integer.parseInt(gatewayinput.getText());
                            }
                            boolean findStructureSeed = true;
                            amountofpartialseeds.set(0);
                            partialprogress.set(0);
                            lastprogress.set(0);
                            partialbar.setValue(0);
                            fullbar.setValue(0);
                            partialSeeds.clear();
                            partiallabel.setText("Partial bruteforce: " + partialSeeds);
                            structureSeeds.clear();
                            fulllabel.setText("Complete bruteforce: " + structureSeeds);

                            if (pillarSeed == -1) {

                                partialbar.setMaximum(1048576);
                                fullbar.setMaximum(268435456);
                                crackSeedsWithoutPillars(desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker, gateWay, findStructureSeed, structureSeeds);
                            } else {
                                partialbar.setMaximum(65536);
                                fullbar.setMaximum(65536);
                                crackSeeds(pillarSeed, gateWay, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, Netherstructurechecker, slimechunkChecker, findStructureSeed, structureSeeds);
                            }
                        }
                    }
                }


            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Seedcracker");
        frame.setSize(700, 600);
        frame.setVisible(true);
    }


    private JComboBox<String> createRow(JPanel panel, int x, int y, String... options) {
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(x, y, 100, 30);
        panel.add(comboBox);
        return comboBox;
    }


    private JTextField createInputField(JPanel panel, int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 50, 30);
        panel.add(textField);
        return textField;
    }

    public static void main(String[] args) {
        Seedcracker main = new Seedcracker();
        main.GUI();
    }

    private static void crackSeeds(long pillarSeed, long gateWay, StructureChecker desertTempleChecker, StructureChecker jungleTempleChecker, StructureChecker iglooChecker, StructureChecker swampHutChecker, StructureChecker outpostChecker, StructureChecker shipwreckChecker, StructureChecker ruinedPortalChecker, StructureChecker ancientCityChecker, StructureChecker mansionChecker, StructureChecker chamberChecker, StructureChecker villageChecker, StructureChecker oceanruinChecker, StructureChecker buriedChecker, StructureChecker monumentChecker, StructureChecker trailruinChecker, StructureChecker structurefeatures1_12Checker, StructureChecker village1_17Checker, StructureChecker mineshaftChecker, StructureChecker Netherstructurechecker, StructureChecker slimechunkChecker, boolean findStructureSeed, List<Long> structureSeeds) {
        int availableCores = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(availableCores);
        executorService.submit(() -> {
            new MainSeedcracker.SeedCrackerTask(pillarSeed, gateWay, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, Netherstructurechecker, slimechunkChecker, findStructureSeed, structureSeeds, 0, 65536).invoke();
        });

        executorService.shutdown();
    }

    private static void crackSeedsWithoutPillars(StructureChecker desertTempleChecker, StructureChecker jungleTempleChecker, StructureChecker iglooChecker, StructureChecker swampHutChecker, StructureChecker outpostChecker, StructureChecker shipwreckChecker, StructureChecker ruinedPortalChecker, StructureChecker ancientCityChecker, StructureChecker mansionChecker, StructureChecker chamberChecker, StructureChecker villageChecker, StructureChecker oceanruinChecker, StructureChecker buriedChecker , StructureChecker monumentChecker, StructureChecker trailruinChecker, StructureChecker structurefeatures1_12Checker, StructureChecker village1_17Checker, StructureChecker mineshaftChecker, StructureChecker bedrock_genericChecker,StructureChecker bedrock_mansionChecker, StructureChecker bedrock_monumentChecker, StructureChecker bedrock_outpostChecker, StructureChecker bedrock_portalChecker, StructureChecker bedrock_shipwreck1_17Checker, StructureChecker bedrock_shipwreckChecker,StructureChecker bedrock_treasureChecker, StructureChecker bedrock_village1_17Checker, StructureChecker bedrock_villageChecker,StructureChecker Netherstructurechecker, StructureChecker slimechunkChecker, long gateWay, boolean findStructureSeed, List<Long> structureSeeds) {
        int availablecores = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(availablecores);
        if (MainSeedcracker.edition) {
            executorService.submit(() -> {
                new MainSeedcracker.SeedCrackerTaskNoPillars(
                        desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker,
                        outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker,
                        mansionChecker, chamberChecker, villageChecker, oceanruinChecker,
                        buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker,
                        village1_17Checker, mineshaftChecker, bedrock_genericChecker, bedrock_mansionChecker,
                        bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker,
                        bedrock_shipwreck1_17Checker, bedrock_shipwreckChecker, bedrock_treasureChecker,
                        bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker,
                        slimechunkChecker, gateWay, findStructureSeed, structureSeeds, 0, 4294967295L
                ).invoke();
            });
        } else {
            executorService.submit(() -> {
                new MainSeedcracker.SeedCrackerTaskNoPillars(
                        desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker,
                        outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker,
                        mansionChecker, chamberChecker, villageChecker, oceanruinChecker,
                        buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker,
                        village1_17Checker, mineshaftChecker, bedrock_genericChecker, bedrock_mansionChecker,
                        bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker,
                        bedrock_shipwreck1_17Checker, bedrock_shipwreckChecker, bedrock_treasureChecker,
                        bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker,
                        slimechunkChecker, gateWay, findStructureSeed, structureSeeds, 0, 1048575
                ).invoke();
            });
        }
        executorService.shutdown();
    }



class StructureChecker {
    private List<int[]> coordinates;
    private long salt;

    public StructureChecker(long salt) {
        this.coordinates = new ArrayList<>();
        this.salt = salt;
    }

    public void addCoordinates(int chunkX, int chunkZ) {
        coordinates.add(new int[]{chunkX, chunkZ});
    }

    public boolean canGenerateBuriedTreasure(long fullSeed) {
        for (int[] coord : coordinates) {
            if (!buriedTreasureChecker(fullSeed, coord[0], coord[1])) {
                return false;
            }
        }
        return true;
    }


    public boolean buriedTreasureChecker(long fullseed, long chunkX, long chunkZ) {
        long newFullSeed = ((fullseed + chunkX * 341873128712L + chunkZ * 132897987541L + salt) ^ 25214903917L) & ((1L << 48) - 1);
        newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
        long next24 = newFullSeed >> 24;
        if (next24 < 167772.16) {
            return true;
        }
        return false;
    }
    public boolean canGenerateMineshaft(long fullSeed){
        for (int[] coord : coordinates) {
            if (!mineshaftChecker(fullSeed, coord[0], coord[1])) {
                return false;
            }
        }
        return true;

    }
    public boolean mineshaftChecker(long fullseed, int chunkX, int chunkZ){
        long newSeed = fullseed ^25214903917l;
        long randomInternalState = (newSeed * 25214903917l + 11) & ((1l<<48)-1);
        long firstThingie = randomInternalState >>16;
        randomInternalState = (randomInternalState * 25214903917l + 11) & ((1l<<48)-1);
        long secondThingie = randomInternalState >>16;
        long firstoutputthingie = ((firstThingie<<32) + (int)secondThingie);
        randomInternalState = (randomInternalState * 25214903917l + 11) & ((1l<<48)-1);
        firstThingie = randomInternalState >>16;
        randomInternalState = (randomInternalState * 25214903917l + 11) & ((1l<<48)-1);
        secondThingie = randomInternalState >>16;
        long secondoutputthingie = ((firstThingie<<32) + (int)secondThingie);
        long finaloutputthingie = (long) chunkX * firstoutputthingie ^ (long) chunkZ * secondoutputthingie ^ fullseed;
        newSeed = finaloutputthingie ^ 25214903917l;
        long newSeed1 = (newSeed * 25214903917l +11) & ((1l<<48)-1);
        long firstval = newSeed1 >> 22;
        long newSeed2 = (newSeed1 * 25214903917l +11) & ((1l<<48)-1);
        long secondval = newSeed2 >> 21;
        double finallyimdonewiththisbruh = (((long)firstval << 27) + secondval) /  (double)(1l << 53);
        if(finallyimdonewiththisbruh < 0.004d){
            return true;
        }
        return false;
    }
    public boolean canGenerateSlimechunk(long fullSeed, boolean lifting){

        for (int[] coord : coordinates) {
            if (!slimechunkChecker(fullSeed, coord[0], coord[1],lifting)) {
                return false;
            }
        }
        return true;
    }
    public boolean slimechunkChecker(long fullseed, int chunkX, int chunkZ, boolean lifting){
        long newSeed =
                (fullseed+
                (chunkX * chunkX * 4987142) +
                        (chunkX * 5947611) +
                        (chunkZ * chunkZ) * 4392871 +
                        (chunkZ * 389711) ^ 987234911l)^25214903917L;;
        newSeed = (newSeed * 25214903917l + 11) & ((1l<<48)-1);
        if(lifting){
            return(((newSeed>>17)&1)==0);
        }
        else{
            return(((((newSeed>>17)%10)+10)%10)==0);
        }
    }

    public boolean canGenerateAtAll(long halfSeed, boolean isShip, boolean isMansion, boolean isChamber, boolean isOceanruin) {
        for (int[] coord : coordinates) {
            if (!canGenerateInTheFirstPlace(halfSeed, coord[0], coord[1], isShip, isMansion, isChamber, isOceanruin)) {
                return false;
            }
        }
        return true;
    }

    public boolean canActuallyGenerate(long fullSeed, boolean isShip, boolean isRuinedPortal, boolean isAncient, boolean isMansion, boolean isChamber, boolean isVillage, boolean isOceanruin, boolean isMonument, boolean isNetherstructure) {
        for (int[] coord : coordinates) {
            if (!canActuallyGenerate(fullSeed, coord[0], coord[1], isShip, isRuinedPortal, isAncient, isMansion, isChamber, isVillage, isOceanruin, isMonument, isNetherstructure)) {
                return false;
            }
        }
        return true;
    }

    private boolean canGenerateInTheFirstPlace(long halfSeed, int chunkX, int chunkZ, boolean isShip, boolean isMansion, boolean isChamber, boolean isOceanruin) {
        int regX = isShip ? Math.floorDiv(chunkX, 24) : isMansion ? Math.floorDiv(chunkX, 80) : isChamber ? Math.floorDiv(chunkX, 34) : isOceanruin ? Math.floorDiv(chunkX, 20) : chunkX >> 5;
        int regZ = isShip ? Math.floorDiv(chunkZ, 24) : isMansion ? Math.floorDiv(chunkZ, 80) : isChamber ? Math.floorDiv(chunkZ, 34) : isOceanruin ? Math.floorDiv(chunkZ, 20) : chunkZ >> 5;
        long mask = isShip ? 3 : isMansion ? 3 : isChamber ? 1 : isOceanruin ? 3 : 7;

        long newHalfSeed = ((halfSeed + regX * 341873128712L + regZ * 132897987541L + salt) ^ 25214903917L) & ((1L << 32) - 1);
        newHalfSeed = (newHalfSeed * 25214903917L + 11) & ((1L << 32) - 1);
        if (isMansion) {
            long x1 = (newHalfSeed >> 17) & mask;
            newHalfSeed = (newHalfSeed * 25214903917L + 11) & ((1L << 32) - 1);
            long x2 = (newHalfSeed >> 17) & mask;
            long x3 = 0;
            while (x3 < 59) {
                long x4 = 0;
                while (x4 < 59) {
                    if (((int)(x3 + x4) / 2) == (((chunkX%80)+80)%80)) {
                        if (x1 == (x3 & mask) && x2 == (x4 & mask)) {
                            newHalfSeed = (newHalfSeed * 25214903917L + 11) & ((1L << 32) - 1);
                            long z1 = (newHalfSeed >> 17) & mask;
                            newHalfSeed = (newHalfSeed * 25214903917L + 11) & ((1L << 32) - 1);
                            long z2 = (newHalfSeed >> 17) & mask;
                            long z3 = 0;
                            while (z3 < 59) {
                                long z4 = 0;
                                while (z4 < 59) {
                                    if (((int)(z3 + z4) / 2) == (((chunkZ)%80)+80)%80) {
                                        if (z1 == (z3 & mask) && z2 == (z4 & mask)) {
                                            return true;
                                        }
                                    }
                                    z4++;
                                }
                                z3++;
                            }
                            break;
                        }
                    }
                    x4++;
                }
                x3++;
            }
        }

        if (((newHalfSeed >> 17) & mask) == (chunkX & mask)) {
            newHalfSeed = (newHalfSeed * 25214903917L + 11) & ((1L << 32) - 1);
            return ((newHalfSeed >> 17) & mask) == (chunkZ & mask);
        }
        return false;
    }

    private boolean canActuallyGenerate(long fullSeed, int chunkX, int chunkZ, boolean isShip, boolean isRuinedPortal, boolean isAncient, boolean isMansion, boolean isChamber, boolean isVillage, boolean isOceanruin, boolean isMonument, boolean isNetherstructure) {
        int regX = (isRuinedPortal ? Math.floorDiv(chunkX, 40) : isShip ? Math.floorDiv(chunkX, 24) : isAncient ? Math.floorDiv(chunkX, 24) : isMansion ? Math.floorDiv(chunkX, 80) : isChamber ? Math.floorDiv(chunkX, 34) : isVillage ? Math.floorDiv(chunkX, 34) : isOceanruin ? Math.floorDiv(chunkX, 20) : isMonument ? Math.floorDiv(chunkX, 32) : isNetherstructure ? Math.floorDiv(chunkX, 23) : chunkX >> 5);
        int regZ = (isRuinedPortal ? Math.floorDiv(chunkZ, 40) : isShip ? Math.floorDiv(chunkZ, 24) : isAncient ? Math.floorDiv(chunkZ, 24) : isMansion ? Math.floorDiv(chunkZ, 80) : isChamber ? Math.floorDiv(chunkZ, 34) : isVillage ? Math.floorDiv(chunkZ, 34) : isOceanruin ? Math.floorDiv(chunkZ, 20) : isMonument ? Math.floorDiv(chunkZ, 32) : isNetherstructure ? Math.floorDiv(chunkZ, 23) : chunkZ >> 5);
        long mask = isRuinedPortal ? 25 : isShip ? 20 : isChamber ? 22 : isVillage ? 26 : isOceanruin ? 12 : isNetherstructure ? 23 : 24;
        long coordMask = isRuinedPortal ? 40 : isShip ? 24 : isChamber ? 34 : isVillage ? 34 : isOceanruin ? 20 : isNetherstructure ? 27 : 32;
        long newFullSeed = ((fullSeed + regX * 341873128712L + regZ * 132897987541L + salt) ^ 25214903917L) & ((1L << 48) - 1);
        if (isMansion) {
            newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
            long x1 = (newFullSeed >> 17) % 60;
            newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
            long x2 = (newFullSeed >> 17) % 60;
            long x = (x1 + x2) / 2;
            if (x == (((chunkX % 80) + 80) % 80)) {
                newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
                long z1 = (newFullSeed >> 17) % 60;
                newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
                long z2 = (newFullSeed >> 17) % 60;
                long z = (z1 + z2) / 2;
                return (z == (((chunkZ % 80) + 80) % 80));
            }
        }
        if (isMonument) {
            newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
            long x1 = (newFullSeed >> 17) % 27;
            newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
            long x2 = (newFullSeed >> 17) % 27;
            long x = (x1 + x2) / 2;
            if (x == (((chunkX % 32) + 32) % 32)) {
                newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
                long z1 = (newFullSeed >> 17) % 27;
                newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
                long z2 = (newFullSeed >> 17) % 27;
                long z = (z1 + z2) / 2;
                return (z == (((chunkZ % 32) + 32) % 32));
            }
        }
        if (isAncient) {
            newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
            if ((newFullSeed >> 44) == (((chunkX % 24) + 24) % 24)) {
                newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
                if ((newFullSeed >> 44) == (((chunkZ % 24) + 24) % 24)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        newFullSeed = (newFullSeed * 25214903917L + 11) & ((1L << 48) - 1);
        if (((newFullSeed >> 17) % mask) == (((chunkX % coordMask) + coordMask) % coordMask)) {
            newFullSeed = (newFullSeed * 25214903917L + 11) & ((1L << 48) - 1);
            return ((((newFullSeed >> 17) % mask) + mask) % mask) == (((chunkZ % coordMask) + coordMask) % coordMask);
        }
        return false;
    }
    public boolean bedrock_canGenerate(long seed , boolean isTriangular,boolean isMansions, boolean isMonument, boolean isOutpost,boolean isPortal, boolean isShipwreck, boolean isShipwreck1_17, boolean isTreasure,boolean isVillage, boolean isVillage1_17){
        if(!isTriangular){
            for (int[] coord : coordinates) {
                if(!bedrock_isValidSeed(seed,coord[0],coord[1],false,false)){
                    return false;
                }
            }
            return true;
        }
        else{
            return false;
        }


    }
    private boolean bedrock_isValidSeed(long seed, int chunkX, int chunkZ,boolean isPortal,boolean isShipwreck){
        long regX = isPortal ? Math.floorDiv(chunkX,40) : isShipwreck ? Math.floorDiv(chunkX,24) : chunkX >> 5;
        long regZ = isPortal ? Math.floorDiv(chunkZ,40) : isShipwreck ? Math.floorDiv(chunkZ,24) : chunkZ >> 5;
        long mask = isPortal ? 40 : isShipwreck ? 24 : 32;
        long bound = isPortal ? 25 : isShipwreck ? 20 : 24;
        long regionSeed = regX * 341873128712L + regZ * 132897987541L + seed + salt;
        int[] mt = new int[629];
        int mti = 0;
        mt[0] = (int) regionSeed;
        for (mti = 1; mti < 622; mti += 8) {
            mt[mti] = 1812433253 * (mt[mti - 1] ^ (mt[mti - 1] >>> 30)) + mti;
            mt[mti + 1] = 1812433253 * (mt[mti] ^ (mt[mti] >>> 30)) + (mti + 1);
            mt[mti + 2] = 1812433253 * (mt[mti + 1] ^ (mt[mti + 1] >>> 30)) + (mti + 2);
            mt[mti + 3] = 1812433253 * (mt[mti + 2] ^ (mt[mti + 2] >>> 30)) + (mti + 3);
            mt[mti + 4] = 1812433253 * (mt[mti + 3] ^ (mt[mti + 3] >>> 30)) + (mti + 4);
            mt[mti + 5] = 1812433253 * (mt[mti + 4] ^ (mt[mti + 4] >>> 30)) + (mti + 5);
            mt[mti + 6] = 1812433253 * (mt[mti + 5] ^ (mt[mti + 5] >>> 30)) + (mti + 6);
            mt[mti + 7] = 1812433253 * (mt[mti + 6] ^ (mt[mti + 6] >>> 30)) + (mti + 7);
        }





        if (mti >= 624) {
            for (int k = 0; k < 227; k++) {
                int y = (mt[k] & 0x80000000) | (mt[k + 1] & 0x7fffffff);
                mt[k] = mt[k + 397] ^ (y >>> 1) ^ ((y & 1) * 0x9908b0df);
            }

            for (int k = 624-397; k < 624 - 1; k++) {
                int y = (mt[k] & 0x80000000) | (mt[k + 1] & 0x7fffffff);
                mt[k] = mt[k + (397 - 624)] ^ (y >>> 1) ^ ((y & 1) * 0x9908b0df);
            }
            int y = (mt[624 - 1] & 0x80000000) | (mt[0] & 0x7fffffff);
            mt[624 - 1] = mt[397 - 1] ^ (y >>> 1) ^ ((y & 1) * 0x9908b0df);
            mti = 0;
        }

        int y = mt[mti++];
        y ^= (y >>> 11);
        y ^= (y << 7) & 0x9d2c5680;
        y ^= (y << 15) & 0xefc60000;
        y ^= (y >>> 18);

        long randomValue = y & 0xFFFFFFFFL;
        int x = (int) (randomValue % bound);
        return(x == (((chunkX%mask)+mask)%mask));



    }
    private boolean bedrock_isValidSeedTriangular(){
        return false;
    }

}






class MainSeedcracker {
    public static boolean printToFile = false;
    public static boolean edition = false;


    public static void structureadder(String structureType, int chunkX, int chunkZ, StructureChecker desertTempleChecker, StructureChecker jungleTempleChecker, StructureChecker iglooChecker, StructureChecker swampHutChecker, StructureChecker outpostChecker, StructureChecker shipwreckChecker, StructureChecker ruinedPortalChecker, StructureChecker ancientCityChecker, StructureChecker mansionChecker, StructureChecker chamberChecker, StructureChecker villageChecker, StructureChecker oceanruinChecker, StructureChecker buriedChecker, StructureChecker monumentChecker, StructureChecker trailruinChecker, StructureChecker structurefeatures1_12Checker, StructureChecker village1_17Checker, StructureChecker mineshaftChecker, StructureChecker bedrock_genericchecker, StructureChecker bedrock_mansionChecker, StructureChecker bedrock_monumentChecker, StructureChecker bedrock_outpostChecker, StructureChecker bedrock_portalChecker, StructureChecker bedrock_shipwreck1_17checker, StructureChecker bedrock_shipwreckChecker, StructureChecker bedrock_treasureChecker, StructureChecker bedrock_village1_17Checker, StructureChecker bedrock_villageChecker, StructureChecker Netherstructurechecker, StructureChecker slimechunkChecker) {
        float startTime = System.nanoTime();

        List<Long> structureSeeds = new ArrayList<>();



        switch (structureType) {
            case "Deserttemple":
                if (edition) {
                    bedrock_genericchecker.addCoordinates(chunkX, chunkZ);
                } else {
                    desertTempleChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Jungletemple":
                if (edition) {
                    bedrock_genericchecker.addCoordinates(chunkX, chunkZ);
                } else {
                    jungleTempleChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Igloo":
                if (edition) {
                    bedrock_genericchecker.addCoordinates(chunkX, chunkZ);
                } else {
                    iglooChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Swamphut":
                if (edition) {
                    bedrock_genericchecker.addCoordinates(chunkX, chunkZ);
                } else {
                    swampHutChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Outpost":
                if (edition) {
                    bedrock_outpostChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    outpostChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Ship":
                if (edition) {
                    bedrock_shipwreckChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    shipwreckChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Portal":
                if (edition) {
                    bedrock_portalChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    ruinedPortalChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Ancientcity":
                if (edition) {
                    ancientCityChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    ancientCityChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Mansion":
                if (edition) {
                    bedrock_mansionChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    mansionChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Trialchamber":
                if (edition) {
                    chamberChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    chamberChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Village":
                if (edition) {
                    bedrock_village1_17Checker.addCoordinates(chunkX, chunkZ);
                } else {
                    villageChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Oceanruin":
                if (edition) {
                    oceanruinChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    oceanruinChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Treasure":
                if (edition) {
                    bedrock_treasureChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    buriedChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Monument":
                if (edition) {
                    bedrock_monumentChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    monumentChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Trailruin":
                if (edition) {
                    trailruinChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    trailruinChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Deserttemple 1.12-":
                structurefeatures1_12Checker.addCoordinates(chunkX, chunkZ);
                break;
            case "Jungletemple 1.12-":
                structurefeatures1_12Checker.addCoordinates(chunkX, chunkZ);
                break;
            case  "Igloo 1.12-":
                structurefeatures1_12Checker.addCoordinates(chunkX, chunkZ);
                break;
            case "Swamphut 1.12-":
                structurefeatures1_12Checker.addCoordinates(chunkX,chunkZ);
            case "Village 1.17-":
                if (edition) {
                    bedrock_village1_17Checker.addCoordinates(chunkX, chunkZ);
                } else {
                    village1_17Checker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Bastion":
                Netherstructurechecker.addCoordinates(chunkX, chunkZ);
                break;
            case "Fortress":
                Netherstructurechecker.addCoordinates(chunkX, chunkZ);
                break;
            case "Mineshaft":
                mineshaftChecker.addCoordinates(chunkX,chunkZ);
                break;
            case "Slimechunk":
                slimechunkChecker.addCoordinates(chunkX, chunkZ);
                break;
            default:
                System.out.println("Unknown structure type: " + structureType);
        }


    }


    public static class SeedCrackerTask extends RecursiveTask<Void> {
        private static final int THRESHOLD = 1024;
        private long pillarSeed;
        private long gateWay;
        private StructureChecker desertTempleChecker;
        private StructureChecker jungleTempleChecker;
        private StructureChecker iglooChecker;
        private StructureChecker swampHutChecker;
        private StructureChecker outpostChecker;
        private StructureChecker shipwreckChecker;
        private StructureChecker ruinedPortalChecker;
        private StructureChecker ancientCityChecker;

        private StructureChecker mansionChecker;

        private StructureChecker chamberChecker;

        private StructureChecker villageChecker;

        private StructureChecker oceanruinChecker;

        private StructureChecker buriedChecker;

        private StructureChecker monumentChecker;

        private StructureChecker trailruinChecker;

        private StructureChecker structurefeatures1_12checker;

        private StructureChecker village1_17Checker;
        private StructureChecker mineshaftChecker;

        private StructureChecker Netherstructurechecker;
        private StructureChecker slimechunkChecker;

        private boolean findStructureSeed;
        private List<Long> structureSeeds;
        private long start;
        private long end;

        public SeedCrackerTask(long pillarSeed, long gateWay, StructureChecker desertTempleChecker, StructureChecker jungleTempleChecker, StructureChecker iglooChecker, StructureChecker swampHutChecker, StructureChecker outpostChecker, StructureChecker shipwreckChecker, StructureChecker ruinedPortalChecker, StructureChecker ancientCityChecker, StructureChecker mansionChecker, StructureChecker chamberChecker, StructureChecker villageChecker, StructureChecker oceanruinChecker, StructureChecker buriedChecker, StructureChecker monumentChecker, StructureChecker trailruinChecker, StructureChecker structurefeatures1_12checker, StructureChecker village1_17Checker,StructureChecker mineshaftChecker, StructureChecker Netherstructurechecker, StructureChecker slimechunkChecker, boolean findStructureSeed, List<Long> structureSeeds, long start, long end) {
            this.pillarSeed = pillarSeed;
            this.gateWay = gateWay;
            this.desertTempleChecker = desertTempleChecker;
            this.jungleTempleChecker = jungleTempleChecker;
            this.iglooChecker = iglooChecker;
            this.swampHutChecker = swampHutChecker;
            this.outpostChecker = outpostChecker;
            this.shipwreckChecker = shipwreckChecker;
            this.ruinedPortalChecker = ruinedPortalChecker;
            this.ancientCityChecker = ancientCityChecker;
            this.mansionChecker = mansionChecker;
            this.chamberChecker = chamberChecker;
            this.villageChecker = villageChecker;
            this.oceanruinChecker = oceanruinChecker;
            this.buriedChecker = buriedChecker;
            this.monumentChecker = monumentChecker;
            this.trailruinChecker = trailruinChecker;
            this.structurefeatures1_12checker = structurefeatures1_12checker;
            this.village1_17Checker = village1_17Checker;
            this.mineshaftChecker = mineshaftChecker;
            this.Netherstructurechecker = Netherstructurechecker;
            this.slimechunkChecker = slimechunkChecker;
            this.findStructureSeed = findStructureSeed;
            this.structureSeeds = structureSeeds;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Void compute() {
            if (end - start <= THRESHOLD) {
                for (long lowerBits = start; lowerBits < end; lowerBits++) {
                    long partialRandomInternalState = (pillarSeed << 16) + lowerBits;
                    long halfSeed = ((1540035429L * (1540035429L * partialRandomInternalState + 239479465L) + 239479465L) ^ 25214903917L) & 4294967295L;
                    if (canGenerateAtAll(halfSeed)) {
                        if (gateWay != -1) {
                            long nextSeed = halfSeed ^ 25214903917L;
                            nextSeed = (nextSeed * 25214903917L + 11) & ((1L << 32) - 1);
                            if (((nextSeed >> 17) & 3) == (gateWay & 3)) {
                                int amountofpartialseed = amountofpartialseeds.incrementAndGet();
                                partialSeeds.add(halfSeed);
                                SwingUtilities.invokeLater(()-> Seedcracker.partiallabel.setText("Partial bruteforce: Halfseed/s: " + partialSeeds));
                                processHalfSeed(halfSeed);
                            }
                        } else {
                            int amountofpartialseed = amountofpartialseeds.incrementAndGet();
                            partialSeeds.add(halfSeed);
                            SwingUtilities.invokeLater(()-> Seedcracker.partiallabel.setText("Partial bruteforce: Halfseed/s: " + partialSeeds));
                            processHalfSeed(halfSeed);
                        }
                    }
                    int currentprogress = partialprogress.incrementAndGet();
                    if((currentprogress % 65536)==0){
                        SwingUtilities.invokeLater(() -> Seedcracker.partialbar.setValue(currentprogress));
                    }
                }
                return null;
            } else {
                long mid = (start + end) >>> 1;
                SeedCrackerTask left = new SeedCrackerTask(pillarSeed, gateWay, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12checker, village1_17Checker, mineshaftChecker, Netherstructurechecker, slimechunkChecker ,findStructureSeed, structureSeeds, start, mid);
                SeedCrackerTask right = new SeedCrackerTask(pillarSeed, gateWay, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12checker, village1_17Checker, mineshaftChecker, Netherstructurechecker, slimechunkChecker ,findStructureSeed, structureSeeds, mid, end);
                invokeAll(left, right);
                return null;
            }
        }

        private void processHalfSeed(long halfSeed) {
            if (findStructureSeed) {
                crackStructureSeed(halfSeed);
            }
        }

        private boolean canGenerateAtAll(long halfSeed) {
            return desertTempleChecker.canGenerateAtAll(halfSeed, false, false, false, false) &&
                    jungleTempleChecker.canGenerateAtAll(halfSeed, false, false, false, false) &&
                    iglooChecker.canGenerateAtAll(halfSeed, false, false, false, false) &&
                    swampHutChecker.canGenerateAtAll(halfSeed, false, false, false, false) &&
                    outpostChecker.canGenerateAtAll(halfSeed, false, false, false, false) &&
                    village1_17Checker.canGenerateAtAll(halfSeed, false, false, false, false) &&
                    structurefeatures1_12checker.canGenerateAtAll(halfSeed, false, false, false, false) &&
                    oceanruinChecker.canGenerateAtAll(halfSeed, false, false, false, true) &&
                    shipwreckChecker.canGenerateAtAll(halfSeed, true, false, false, false) &&
                    trailruinChecker.canGenerateAtAll(halfSeed, false, false, true, false) &&//method to bitlift chambers can be applied to trailruins without any changes
                    chamberChecker.canGenerateAtAll(halfSeed, false, false, true, false) &&
                    villageChecker.canGenerateAtAll(halfSeed, false, false, true, false) &&//method to bitlift chambers can be applied to villages without any changes
                    slimechunkChecker.canGenerateSlimechunk(halfSeed, true)&&
                    mansionChecker.canGenerateAtAll(halfSeed, false, true, false, false);
        }

        private void crackStructureSeed(long halfSeed) {
            for (long structureSeed = halfSeed; structureSeed < (1L << 48); structureSeed += (1L << 32)) {
                if (canActuallyGenerate(structureSeed)) {
                    long nextSeed = structureSeed ^ 25214903917L;
                    nextSeed = (nextSeed * 25214903917L + 11) & ((1L << 48) - 1);
                    if (((nextSeed >> 17) % 20) == gateWay || gateWay == -1) {
                        structureSeeds.add(structureSeed);
                        SwingUtilities.invokeLater(()-> Seedcracker.fulllabel.setText("Complete bruteforce: Structureseed/s: " + structureSeeds));
                    }
                }
                int currentprogress = lastprogress.incrementAndGet();
                int amountofpartialseed = amountofpartialseeds.get();
                if((currentprogress % 6553)==0){
                    SwingUtilities.invokeLater(() -> Seedcracker.fullbar.setValue(currentprogress));
                }
            }

        }

        private boolean canActuallyGenerate(long structureSeed) {
            return mansionChecker.canActuallyGenerate(structureSeed, false, false, false, true, false, false, false, false, false) &&
                    buriedChecker.canGenerateBuriedTreasure(structureSeed) &&
                    monumentChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, true, false) &&
                    villageChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, true, false, false, false) &&
                    trailruinChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, true, false, false, false) &&
                    ruinedPortalChecker.canActuallyGenerate(structureSeed, false, true, false, false, false, false, false, false, false) &&
                    desertTempleChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    jungleTempleChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    iglooChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    swampHutChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    outpostChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    village1_17Checker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    Netherstructurechecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, true) &&
                    chamberChecker.canActuallyGenerate(structureSeed, false, false, false, false, true, false, false, false, false) &&
                    shipwreckChecker.canActuallyGenerate(structureSeed, true, false, false, false, false, false, false, false, false) &&
                    structurefeatures1_12checker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    ancientCityChecker.canActuallyGenerate(structureSeed, false, false, true, false, false, false, false, false, false) &&
                    oceanruinChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, true, false, false)&&
                    mineshaftChecker.canGenerateMineshaft(structureSeed)&&
                    slimechunkChecker.canGenerateSlimechunk(structureSeed, false);

        }
    }

    public static class SeedCrackerTaskNoPillars extends RecursiveTask<Void> {
        private static final long THRESHOLD = 1024L;
        private StructureChecker desertTempleChecker;
        private StructureChecker jungleTempleChecker;
        private StructureChecker iglooChecker;
        private StructureChecker swampHutChecker;
        private StructureChecker outpostChecker;
        private StructureChecker shipwreckChecker;
        private StructureChecker ruinedPortalChecker;

        private StructureChecker ancientCityChecker;

        private StructureChecker mansionChecker;
        private StructureChecker chamberChecker;

        private StructureChecker villageChecker;

        private StructureChecker oceanruinChecker;

        private StructureChecker buriedChecker;

        private StructureChecker monumentChecker;

        private StructureChecker trailruinChecker;

        private StructureChecker structurefeatures1_12Checker;

        private StructureChecker village1_17Checker;
        private StructureChecker mineshaftChecker;

        private StructureChecker bedrock_genericChecker;

        private StructureChecker bedrock_mansionChecker;

        private StructureChecker bedrock_monumentChecker;

        private StructureChecker bedrock_outpostChecker;

        private StructureChecker bedrock_portalChecker;

        private StructureChecker bedrock_shipwreck1_17Checker;

        private StructureChecker bedrock_shipwreckChecker;

        private StructureChecker bedrock_treasureChecker;

        private StructureChecker bedrock_village1_17Checker;

        private StructureChecker bedrock_villageChecker;

        private StructureChecker Netherstructurechecker;
        private StructureChecker slimechunkChecker;

        private long gateWay;
        private boolean findStructureSeed;
        private List<Long> structureSeeds;
        private long start;
        private long end;

        public SeedCrackerTaskNoPillars(StructureChecker desertTempleChecker, StructureChecker jungleTempleChecker, StructureChecker iglooChecker, StructureChecker swampHutChecker, StructureChecker outpostChecker, StructureChecker shipwreckChecker, StructureChecker ruinedPortalChecker, StructureChecker ancientCityChecker, StructureChecker mansionChecker, StructureChecker chamberChecker, StructureChecker villageChecker, StructureChecker oceanruinChecker, StructureChecker buriedChecker, StructureChecker monumentChecker, StructureChecker trailruinChecker, StructureChecker structurefeatures1_12Checker, StructureChecker village1_17Checker,StructureChecker mineshaftChecker, StructureChecker bedrock_genericChecker, StructureChecker bedrock_mansionChecker, StructureChecker bedrock_monumentChecker, StructureChecker bedrock_outpostChecker, StructureChecker bedrock_portalChecker, StructureChecker bedrock_shipwreck1_17Checker, StructureChecker bedrock_shipwreckChecker, StructureChecker bedrock_treasureChecker, StructureChecker bedrock_village1_17Checker, StructureChecker bedrock_villageChecker, StructureChecker Netherstructurechecker, StructureChecker slimechunkChecker, long gateWay, boolean findStructureSeed, List<Long> structureSeeds, long start, long end) {
            this.desertTempleChecker = desertTempleChecker;
            this.jungleTempleChecker = jungleTempleChecker;
            this.iglooChecker = iglooChecker;
            this.swampHutChecker = swampHutChecker;
            this.outpostChecker = outpostChecker;
            this.shipwreckChecker = shipwreckChecker;
            this.ruinedPortalChecker = ruinedPortalChecker;
            this.ancientCityChecker = ancientCityChecker;
            this.mansionChecker = mansionChecker;
            this.chamberChecker = chamberChecker;
            this.villageChecker = villageChecker;
            this.oceanruinChecker = oceanruinChecker;
            this.buriedChecker = buriedChecker;
            this.monumentChecker = monumentChecker;
            this.trailruinChecker = trailruinChecker;
            this.structurefeatures1_12Checker = structurefeatures1_12Checker;
            this.village1_17Checker = village1_17Checker;
            this.mineshaftChecker = mineshaftChecker;
            this.bedrock_genericChecker = bedrock_genericChecker;
            this.bedrock_mansionChecker = bedrock_mansionChecker;
            this.bedrock_monumentChecker = bedrock_monumentChecker;
            this.bedrock_outpostChecker = bedrock_outpostChecker;
            this.bedrock_portalChecker = bedrock_portalChecker;
            this.bedrock_shipwreck1_17Checker = bedrock_shipwreck1_17Checker;
            this.bedrock_shipwreckChecker = bedrock_shipwreckChecker;
            this.bedrock_treasureChecker = bedrock_treasureChecker;
            this.bedrock_village1_17Checker = bedrock_village1_17Checker;
            this.bedrock_villageChecker = bedrock_villageChecker;
            this.Netherstructurechecker = Netherstructurechecker;
            this.slimechunkChecker = slimechunkChecker;
            this.gateWay = gateWay;
            this.findStructureSeed = findStructureSeed;
            this.structureSeeds = structureSeeds;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Void compute() {
            List<Long> validSeeds = new ArrayList<>();
            if (edition) {
                float startTime = System.nanoTime();
                for (long halfseed = 3271699702L; halfseed < end; halfseed++) {
                    if (halfseed == 10000000) {
                        float stopTime = System.nanoTime() - startTime;
                        System.out.println("10 mil" + (stopTime / 1_000_000_000));
                    }
                    if (bedrock_canGenerate(halfseed)) {
                        System.out.println("Bedrock Halfseed:" + halfseed);
                    }
                }
                return null;

            } else if (end - start <= THRESHOLD) {
                for (long lower20bits = start; lower20bits < end; lower20bits++) {
                    if (canGenerateAtAll(lower20bits)) {
                        long nextSeed = lower20bits ^ 25214903917L;
                        nextSeed = (nextSeed * 25214903917L + 11) & ((1L << 32) - 1);
                        if (((nextSeed >> 17) & 3) == (gateWay & 3) || gateWay == -1) {
                            validSeeds.add(lower20bits);
                            int amount = amountofpartialseeds.incrementAndGet();
                        }
                    }
                    int currentprogress = Seedcracker.partialprogress.incrementAndGet();
                    SwingUtilities.invokeLater(() -> Seedcracker.partialbar.setValue(currentprogress));
                }

                if (!validSeeds.isEmpty()) {
                    crackStructureSeeds(validSeeds);
                }
                return null;

            } else {
                long mid = (start + end) >>> 1;
                SeedCrackerTaskNoPillars left = new SeedCrackerTaskNoPillars(desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericChecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17Checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker, gateWay, findStructureSeed, structureSeeds, start, mid);
                SeedCrackerTaskNoPillars right = new SeedCrackerTaskNoPillars(desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericChecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17Checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker, gateWay, findStructureSeed, structureSeeds, mid, end);
                invokeAll(left, right);
                return null;
            }
        }

        private void processHalfSeed(long lower20bits) {
            partialSeeds.add(lower20bits);
            SwingUtilities.invokeLater(()-> Seedcracker.partiallabel.setText("Partial bruteforce: Liftseed/s: " + partialSeeds));
            if (findStructureSeed) {
                crackStructureSeed(lower20bits);
            }
        }

        private void crackStructureSeeds(List<Long> validSeeds) {

            ExecutorService executorService = Executors.newFixedThreadPool(4);
            List<Future<?>> futures = new ArrayList<>();
            for (Long seed : validSeeds) {
                executorService.submit(() -> {
                    processHalfSeed(seed);
                });
            }


            for (Future<?> future : futures) {
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            executorService.shutdown();
        }

        private boolean canGenerateAtAll(long lower20bits) {
            return desertTempleChecker.canGenerateAtAll(lower20bits, false, false, false, false) &&
                    jungleTempleChecker.canGenerateAtAll(lower20bits, false, false, false, false) &&
                    iglooChecker.canGenerateAtAll(lower20bits, false, false, false, false) &&
                    swampHutChecker.canGenerateAtAll(lower20bits, false, false, false, false) &&
                    outpostChecker.canGenerateAtAll(lower20bits, false, false, false, false) &&
                    village1_17Checker.canGenerateAtAll(lower20bits, false, false, false, false) &&
                    structurefeatures1_12Checker.canGenerateAtAll(lower20bits, false, false, false, false) &&
                    oceanruinChecker.canGenerateAtAll(lower20bits, false, false, false, true) &&
                    shipwreckChecker.canGenerateAtAll(lower20bits, true, false, false, false) &&
                    trailruinChecker.canGenerateAtAll(lower20bits, false, false, true, false) &&//method to bitlift chambers can be applied to trailruins without any changes
                    chamberChecker.canGenerateAtAll(lower20bits, false, false, true, false) &&
                    villageChecker.canGenerateAtAll(lower20bits, false, false, true, false) &&//method to bitlift chambers can be applied to villages without any changes
                    slimechunkChecker.canGenerateSlimechunk(lower20bits, true)&&
                    mansionChecker.canGenerateAtAll(lower20bits, false, true, false, false);
        }

        private void crackStructureSeed(long lower20bits) {
            for (long structureSeed = lower20bits; structureSeed < (1L << 48); structureSeed += (1L << 20)) {
                if (canActuallyGenerate(structureSeed)) {
                    long nextSeed = structureSeed ^ 25214903917L;
                    nextSeed = (nextSeed * 25214903917L + 11) & ((1L << 48) - 1);
                    if (((nextSeed >> 17) % 20) == gateWay || gateWay == -1) {
                        structureSeeds.add(structureSeed);
                        SwingUtilities.invokeLater(()-> Seedcracker.fulllabel.setText("Complete bruteforce: Structureseed/s: "+structureSeeds));
                    }
                }
                int currentprogress = lastprogress.incrementAndGet();
                if((currentprogress%2684354)==0) {
                    int amountofpartialseed = amountofpartialseeds.get();
                    SwingUtilities.invokeLater(() -> Seedcracker.fullbar.setValue(currentprogress/amountofpartialseeds.get()));
                }
            }
        }

        private boolean canActuallyGenerate(long structureSeed) {
            return mansionChecker.canActuallyGenerate(structureSeed, false, false, false, true, false, false, false, false, false) &&
                    buriedChecker.canGenerateBuriedTreasure(structureSeed) &&
                    monumentChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, true, false) &&
                    villageChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, true, false, false, false) &&
                    trailruinChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, true, false, false, false) &&
                    ruinedPortalChecker.canActuallyGenerate(structureSeed, false, true, false, false, false, false, false, false, false) &&
                    desertTempleChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    jungleTempleChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    iglooChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    swampHutChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    outpostChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    village1_17Checker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    Netherstructurechecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, true) &&
                    chamberChecker.canActuallyGenerate(structureSeed, false, false, false, false, true, false, false, false, false) &&
                    shipwreckChecker.canActuallyGenerate(structureSeed, true, false, false, false, false, false, false, false, false) &&
                    structurefeatures1_12Checker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    ancientCityChecker.canActuallyGenerate(structureSeed, false, false, true, false, false, false, false, false, false) &&
                    oceanruinChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, true, false, false)&&
                    mineshaftChecker.canGenerateMineshaft(structureSeed)&&
                    slimechunkChecker.canGenerateSlimechunk(structureSeed, false);
        }

        private boolean bedrock_canGenerate(long halfSeed) {
            return bedrock_genericChecker.bedrock_canGenerate(halfSeed, false, false, false, false, false, false, false, false, false, false);
        }
    }

    }
}

