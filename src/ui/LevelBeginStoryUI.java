package ui;

import model.levelStuff.NewLevel;
import model.levelStuff.NewRoom;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class LevelBeginStoryUI {
    private JPanel begPanel;
    private JLabel begStoryLabel;
    private JButton beginButton;

    public LevelBeginStoryUI(NewLevel l, NewRoom r) {
        begStoryLabel.setText(l.getIntroLabelText());
        begPanel.setBackground(l.getColor());
        JFrame frame = new JFrame();
        frame.setContentPane(begPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        beginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewRoomUI(l, r, 0, 0);
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        begPanel = new JPanel();
        begPanel.setLayout(new GridBagLayout());
        begStoryLabel = new JLabel();
        Font begStoryLabelFont = this.$$$getFont$$$("Courier New", -1, -1, begStoryLabel.getFont());
        if (begStoryLabelFont != null) begStoryLabel.setFont(begStoryLabelFont);
        begStoryLabel.setText("Label");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        begPanel.add(begStoryLabel, gbc);
        beginButton = new JButton();
        Font beginButtonFont = this.$$$getFont$$$("Courier New", -1, -1, beginButton.getFont());
        if (beginButtonFont != null) beginButton.setFont(beginButtonFont);
        beginButton.setText("Begin");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        begPanel.add(beginButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return begPanel;
    }
}
