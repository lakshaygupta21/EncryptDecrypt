import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnDecrypt extends JFrame {

    JLabel message;
    JButton encrypt;
    JButton decrypt;
    JTextArea input;
    JPanel panel;
    JLabel output;
    JPanel outputPanel;

    EnDecrypt(){

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

message.setBounds(20,60,500,20);
input.setBounds(40,100,400,200);
outputPanel.setBounds(20,320,440,100);
outputPanel.setBackground(Color.YELLOW);
outputPanel.add(output);
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
                 String s = new String(encryptT(input.getText().toString(),4)); //key =4
                 output.setText(s);
            }
        } );
        decrypt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = new String(decryptT(input.getText().toString(),4));
                output.setText(s);
            }
        } );
show();

    }

    public static StringBuffer encryptT(String text, int s)
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
public static String decryptT(String message, int key){
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
