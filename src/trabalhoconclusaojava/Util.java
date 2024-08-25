package trabalhoconclusaojava;

import java.awt.Component;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Util {

    private static Component parent;

    public static void grava(ArrayList array) {
        
        String patharq;  

        JFileChooser escolhe = new JFileChooser();
        int returnVal = escolhe.showOpenDialog(parent);
        patharq = escolhe.getSelectedFile().getAbsolutePath();

        if (returnVal == 0) {

            try {
                FileOutputStream arquivo = new FileOutputStream(patharq);
                ObjectOutputStream fluxo = new ObjectOutputStream(arquivo);
                fluxo.writeObject(array);
                fluxo.flush();
                JOptionPane.showMessageDialog(null, "Dados gravados com sucesso no arquivo dados.dat");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Falha na gravação do arquivo" + (e));

            }

        }

    }

    public static ArrayList le() {

        String patharq;

        JFileChooser escolhe = new JFileChooser();
        int returnVal = escolhe.showOpenDialog(parent);
        patharq = escolhe.getSelectedFile().getAbsolutePath();

        ArrayList array = new ArrayList();

        if (returnVal == 0) {

            try {
                FileInputStream arquivo = new FileInputStream(patharq);
                ObjectInputStream fluxo = new ObjectInputStream(arquivo);
                array = (ArrayList) fluxo.readObject();
                JOptionPane.showMessageDialog(null, "Dados lidos com sucesso no arquivo dados.dat");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Falha na leitura do arquivo" + (e));
            }
        }
        return array;
    }
}