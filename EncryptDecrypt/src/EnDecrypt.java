import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnDecrypt extends JFrame {
    String s ;
    JLabel message;
    JButton encrypt;
    JButton decrypt;
    JTextArea input;
    JPanel panel;
    JLabel output;
    JPanel outputPanel;
    JRadioButton caesar;
    JRadioButton hill;
    ButtonGroup G;
    EnDecrypt(){
caesar =    new JRadioButton();
hill = new JRadioButton();
G = new ButtonGroup();
input= new JTextArea();
encrypt = new JButton("ENCRYPT");
decrypt = new JButton("DECRYPT");
output = new JLabel("Your result will be displayed here: ");
outputPanel = new JPanel();
message = new JLabel("Enter message below to encrypt/decrypt: ");
panel= new JPanel();
panel.setLayout(null);
encrypt.setBounds(20,20,150,30);
decrypt.setBounds(310,20,150,30);
message.setFont(new Font("Serif", Font.PLAIN, 16));
input.setFont(new Font("Helvetica",Font.PLAIN,20));
output.setFont(new Font("Serif", Font.PLAIN, 16));
caesar.setFont(new Font("Serif",Font.PLAIN,14));
hill.setFont(new Font("Serif",Font.PLAIN,14));
caesar.setText("Caesar Cipher,3");
hill.setText("Caesar Cipher,4");
caesar.setSelected(true);
caesar.setBounds(180,10,120,30);
hill.setBounds(180,35,120,30);
message.setBounds(20,60,500,20);
input.setBounds(40,100,400,200);
outputPanel.setBounds(20,320,440,100);
outputPanel.setBackground(Color.YELLOW);
outputPanel.add(output);
G.add(caesar);
G.add(hill);
panel.add(caesar);
panel.add(hill);
panel.add(encrypt);
panel.add(decrypt);
panel.add(message);
panel.add(input);
input.setVisible(true);
panel.add(input);
panel.add(outputPanel);
add(panel);
setSize(500,500);
        encrypt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(caesar.isSelected()) {
                    s = new String(caesarCipherEncrypt(input.getText().toString(), 3)); //key =3
                }else if(hill.isSelected()){
                    s = new String(caesarCipherEncrypt(input.getText().toString(), 4)); //key =4
                }else{
                    s = new String("Enter Text");
                }
                output.setText(s);

            }
        } );
        decrypt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(caesar.isSelected()) {
                    s = new String(caesarCipherDecrypt(input.getText().toString(), 3)); //key =3
                }else if(hill.isSelected()){
                    s = new String(caesarCipherDecrypt(input.getText().toString(), 4)); //key =4
                }else{
                    s = new String("Enter Text");

                }
                output.setText(s);
            }
        } );
show();

    }

    public static StringBuffer caesarCipherEncrypt(String text, int s)
    {
        StringBuffer result= new StringBuffer();

        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) +
                        s - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)text.charAt(i) +
                        s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }
public static String caesarCipherDecrypt(String message, int key){
    String decryptedMessage = "";
    char ch;
    for(int i = 0; i < message.length(); ++i){
            ch = message.charAt(i);
            
            if(ch >= 'a' && ch <= 'z'){
                ch = (char)(ch - key);
                
                if(ch < 'a'){
                    ch = (char)(ch + 'z' - 'a' + 1);
                }
                
                decryptedMessage += ch;
            }
            else if(ch >= 'A' && ch <= 'Z'){
                ch = (char)(ch - key);
                
                if(ch < 'A'){
                    ch = (char)(ch + 'Z' - 'A' + 1);
                }
                
                decryptedMessage += ch;
            }
            else {
                decryptedMessage += ch;
            }
        }
        return decryptedMessage;

}

    public static void main(String [] args){
        new EnDecrypt();
    }

}
