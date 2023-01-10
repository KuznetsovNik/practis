import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class MainForm {
    private JPanel mainPanel;
    private JTextField textSurname;
    private JTextField textPatronymic;
    private JTextField textName;

    private JButton collapseButton;
    private JLabel surnameLabel;
    private JLabel nameLabel;
    private JLabel patronemicLabel;
    private JTextField textFIO;
    private JLabel fIOLebel;

    public MainForm(){
        collapseButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (Objects.equals(collapseButton.getText(), "Collapse")){
                    String name = textName.getText();
                    String surname = textSurname.getText();
                    String patronymic = textPatronymic.getText();
                    if (name.isEmpty() || surname.isEmpty()){
                        JOptionPane.showMessageDialog(
                                mainPanel,
                                " Поле Фамилия/Имя пустое, введите данные ",
                                "Ошибка",
                                JOptionPane.PLAIN_MESSAGE);
                    }else {
                        textFIO.setText(textSurname.getText().trim() + " " + textName.getText().trim() + " " + textPatronymic.getText().trim());
                        textFIO.setVisible(true);
                        fIOLebel.setVisible(true);

                        textSurname.setText("");
                        textSurname.setVisible(false);
                        surnameLabel.setVisible(false);

                        textName.setText("");
                        textName.setVisible(false);
                        nameLabel.setVisible(false);

                        textPatronymic.setText("");
                        patronemicLabel.setVisible(false);
                        textPatronymic.setVisible(false);
                        collapseButton.setText("Expand");
                    }
                }else {
                    collapseButton.setText("Collapse");
                    String fio = textFIO.getText();
                    String[] words = fio.split("\\s");
                    for (String word : words){
                        System.out.println(word);
                    }
                    textFIO.setVisible(false);
                    fIOLebel.setVisible(false);

                    textSurname.setText(words[0]);
                    textSurname.setVisible(true);
                    surnameLabel.setVisible(true);

                    textName.setText(words[1]);
                    textName.setVisible(true);
                    nameLabel.setVisible(true);

                    if (words.length == 3) {
                        textPatronymic.setText(words[2]);
                    }
                    patronemicLabel.setVisible(true);
                    textPatronymic.setVisible(true);
                }
            }
        });
    }
    public JPanel getMainPanel(){
        return mainPanel;
    }
}
