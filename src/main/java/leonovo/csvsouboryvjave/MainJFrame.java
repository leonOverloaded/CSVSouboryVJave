/**
 * uci se:
 * Leon Belligerrator
 */
package leonovo.csvsouboryvjave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * vyukove pasmo IT Network
 * @author itnetwork.cz
 */
public class MainJFrame extends JFrame{
    private Databaze databaze;
    
    public MainJFrame(){
        //initComponents();
        Path path = Path.of(System.getProperty("user.home"), "itnetwork", "uzivatele.csv");
        try{
            Files.createDirectories(path.getParent());
            databaze = new Databaze(path);
        }
        catch(IOException ex){
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        JButton tlacitko = new JButton("Ulozit");
        this.add(tlacitko);
        EventUloz uloz = new EventUloz();
        tlacitko.addActionListener(uloz);
        this.pack();
    }
    class EventUloz implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            try{
                databaze.pridejUzivatele("Pavel Slavik", 22, LocalDate.of(2000, 3, 21));
                databaze.pridejUzivatele("Jan Novak", 31, LocalDate.of(2012, 10, 30));
                databaze.uloz();
            }
            catch(IOException ex){
                JOptionPane.showMessageDialog(null, "Databazi se nepodarilo ulozit,"
                        + "zkontrolujte pristupova prava k souboru.");
            }
        }
    }

}

