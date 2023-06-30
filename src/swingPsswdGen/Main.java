package swingPsswdGen;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

    private static final long serialVersionUID = 1L;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JPanel contentPane;
    private JTextField textField;
    private String alphabet = "qwertzuiopüasdfghjklöäyxcvbnmQWERTZUIOPÜASDFGHJKLÖÄYXCVBNM";
    private String numbers = "1234567890";
    private String specials = "<>,;.:-_#'+*!§$%&/()=?";
    private int randomLittleAlphabet, randomBigAlphabet, randomNumbers, randomSpecial;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Main() {
        setDefaultCloseOperation(3);
        setBounds(100, 100, 428, 269);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(this.contentPane);
        JRadioButton rdBtn8 = new JRadioButton("8");
        JRadioButton rdBtn16 = new JRadioButton("16");
        JRadioButton rdBtn24 = new JRadioButton("24");
        JRadioButton rdBtn32 = new JRadioButton("32");
        JLabel lblPasswordLength = new JLabel("Passwortlänge auswählen");
        this.buttonGroup.add(rdBtn8);
        this.buttonGroup.add(rdBtn16);
        this.buttonGroup.add(rdBtn24);
        this.buttonGroup.add(rdBtn32);
        this.textField = new JTextField();
        this.textField.setFont(new Font("Arial Black", 0, 16));
        this.textField.setHorizontalAlignment(0);
        this.textField.setEnabled(false);
        this.textField.setColumns(10);
        lblPasswordLength.setFont(new Font("Arial Black", 0, 12));
        JButton btnGenerate = new JButton("Generieren");
        btnGenerate.setEnabled(false);
        if (this.buttonGroup.getSelection() == null)
            btnGenerate.setEnabled(true);
        btnGenerate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String txtRdBtn = Main.this.textOfRadioButton();
                Main.this.textField.setEnabled(true);
                Main.this.textField.setText(Main.this.generatePassword(Integer.parseInt(txtRdBtn)));
            }
        });
        GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(5)
                                .addComponent(lblPasswordLength)
                                .addGap(36)
                                .addComponent(rdBtn8, -2, 45, -2)
                                .addGap(2)
                                .addComponent(rdBtn16, -2, 45, -2)
                                .addGap(2)
                                .addComponent(rdBtn24, -2, 45, -2)
                                .addGap(2)
                                .addComponent(rdBtn32, -2, 45, -2)
                                .addContainerGap(27, 32767))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(245)
                                .addComponent(btnGenerate, -2, 105, -2)
                                .addContainerGap(74, 32767))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(17)
                                .addComponent(this.textField, -2, 380, -2)));

        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(15)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(lblPasswordLength))
                                        .addComponent(rdBtn8)
                                        .addComponent(rdBtn16)
                                        .addComponent(rdBtn24)
                                        .addComponent(rdBtn32))
                                .addGap(13)
                                .addComponent(btnGenerate)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 78, 32767)
                                .addComponent(this.textField, -2, 53, -2)
                                .addGap(47)));
        this.contentPane.setLayout(gl_contentPane);
    }

    protected String generatePassword(int passwordLength) {
        char[] password = new char[passwordLength];
        int[] checkRandomNumber = new int[passwordLength];
        char temp;
        int i;

        switch (passwordLength) {
            case 8:
                for (i = 0; i < passwordLength; i++) {
                    this.randomLittleAlphabet = (int) (Math.random() * 28.0D);
                    this.randomBigAlphabet = (int) (Math.random() * 28.0D + 29.0D);
                    this.randomNumbers = (int) (Math.random() * 9.0D);
                    this.randomSpecial = (int) (Math.random() * 20.0D);
                    if (i == 4 || i == 5) {
                        password[i] = this.numbers.charAt(this.randomNumbers);
                    } else if (i == 6 || i == 7) {
                        password[i] = this.specials.charAt(this.randomSpecial);
                    } else if (i == 1 || i == 2) {
                        password[i] = this.alphabet.charAt(this.randomLittleAlphabet);
                    } else {
                        password[i] = this.alphabet.charAt(this.randomBigAlphabet);
                    }
                }
                for (i = 0; i < password.length; i++) {
                    this.randomLittleAlphabet = (int) (Math.random() * passwordLength);
                    if (!checkRandomNumber.equals(Integer.valueOf(this.randomLittleAlphabet))) {
                        temp = password[i];
                        password[i] = password[this.randomLittleAlphabet];
                        password[this.randomLittleAlphabet] = temp;
                        checkRandomNumber[i] = this.randomLittleAlphabet;
                    } else {
                        i--;
                    }
                }
                break;
            case 16:
                for (i = 0; i < passwordLength; i++) {
                    this.randomLittleAlphabet = (int) (Math.random() * 28.0D);
                    this.randomBigAlphabet = (int) (Math.random() * 28.0D + 29.0D);
                    this.randomNumbers = (int) (Math.random() * 9.0D);
                    this.randomSpecial = (int) (Math.random() * 20.0D);
                    if (i == 4 || i == 5 || i == 6) {
                        password[i] = this.numbers.charAt(this.randomNumbers);
                    } else if (i == 7 || i == 8 || i == 9) {
                        password[i] = this.specials.charAt(this.randomSpecial);
                    } else if (this.randomBigAlphabet % 2 == 0) {
                        password[i] = this.alphabet.charAt(this.randomBigAlphabet);
                    } else {
                        password[i] = this.alphabet.charAt(this.randomLittleAlphabet);
                    }
                }
                for (i = 0; i < password.length; i++) {
                    this.randomLittleAlphabet = (int) (Math.random() * passwordLength);
                    if (!checkRandomNumber.equals(Integer.valueOf(this.randomLittleAlphabet))) {
                        temp = password[i];
                        password[i] = password[this.randomLittleAlphabet];
                        password[this.randomLittleAlphabet] = temp;
                        checkRandomNumber[i] = this.randomLittleAlphabet;
                    } else {
                        i--;
                    }
                }
                break;
            case 24:
                for (i = 0; i < passwordLength; i++) {
                    this.randomLittleAlphabet = (int) (Math.random() * 28.0D);
                    this.randomBigAlphabet = (int) (Math.random() * 28.0D + 29.0D);
                    this.randomNumbers = (int) (Math.random() * 9.0D);
                    this.randomSpecial = (int) (Math.random() * 20.0D);
                    if (i == 4 || i == 5 || i == 6 || i == 7) {
                        password[i] = this.numbers.charAt(this.randomNumbers);

                    } else if (i == 8 || i == 9 || i == 10 || i == 11) {
                        password[i] = this.specials.charAt(this.randomSpecial);

                    } else if (this.randomBigAlphabet % 2 == 0) {
                        password[i] = this.alphabet.charAt(this.randomBigAlphabet);
                    } else {
                        password[i] = this.alphabet.charAt(this.randomLittleAlphabet);
                    }
                }
                for (i = 0; i < password.length; i++) {
                    this.randomLittleAlphabet = (int) (Math.random() * passwordLength);
                    if (!checkRandomNumber.equals(Integer.valueOf(this.randomLittleAlphabet))) {
                        temp = password[i];
                        password[i] = password[this.randomLittleAlphabet];
                        password[this.randomLittleAlphabet] = temp;
                        checkRandomNumber[i] = this.randomLittleAlphabet;
                    } else {
                        i--;
                    }
                }
                break;
            case 32:
                for (i = 0; i < passwordLength; i++) {
                    this.randomLittleAlphabet = (int) (Math.random() * 28.0D);
                    this.randomBigAlphabet = (int) (Math.random() * 28.0D + 29.0D);
                    this.randomNumbers = (int) (Math.random() * 9.0D);
                    this.randomSpecial = (int) (Math.random() * 20.0D);
                    if (i == 4 || i == 5 || i == 6 || i == 7 || i == 8) {
                        password[i] = this.numbers.charAt(this.randomNumbers);
                    } else if (i == 9 || i == 10 || i == 11 || i == 12) {
                        password[i] = this.specials.charAt(this.randomSpecial);
                    } else if (this.randomBigAlphabet % 2 == 0) {
                        password[i] = this.alphabet.charAt(this.randomBigAlphabet);
                    } else {
                        password[i] = this.alphabet.charAt(this.randomLittleAlphabet);
                    }
                }
                for (i = 0; i < password.length; i++) {
                    this.randomLittleAlphabet = (int) (Math.random() * passwordLength);
                    if (!checkRandomNumber.equals(Integer.valueOf(this.randomLittleAlphabet))) {
                        temp = password[i];
                        password[i] = password[this.randomLittleAlphabet];
                        password[this.randomLittleAlphabet] = temp;
                        checkRandomNumber[i] = this.randomLittleAlphabet;
                    } else {
                        i--;
                    }
                }
                break;
        }
        return String.valueOf(password);
    }

    protected String textOfRadioButton() {
        Enumeration<AbstractButton> buttons = this.buttonGroup.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected())
                return button.getText();
        }
        return null;
    }
}