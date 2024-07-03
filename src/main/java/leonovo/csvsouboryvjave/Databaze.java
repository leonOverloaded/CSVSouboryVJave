/**
 * uci se:
 * Leon Belligerrator
 */
package leonovo.csvsouboryvjave;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 * vyukove pasmo IT Network
 * @author itnetwork.cz
 */
public class Databaze {
    private final DefaultListModel<Uzivatel> uzivatele;
    private final Path soubor;
    
    public Databaze(Path soubor){
        uzivatele = new DefaultListModel<>();
        this.soubor = soubor;
    }
    
    public void pridejUzivatele(String jmeno, int vek, LocalDate registrovan){
        uzivatele.addElement(new Uzivatel(jmeno, vek, registrovan));
    }
    public List<Uzivatel> vratVsechny(){
        return Collections.list(uzivatele.elements());
    }
    public ListModel<Uzivatel> getModel(){
        return uzivatele;
    }
    public void uloz() throws IOException {
        //nejpve soubor vytvorime, pokud jiz existuje, tak jej vyprazdnime
        Files.writeString(soubor, "", StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        //pak projedeme vsechny uzivatele
        //a pro kazdeho vytvorime radek s jeho vlastnostmi oddelenymi strednikem
        //radek pote zapiseme do souboru
        for(Uzivatel u : vratVsechny()){
            String radek = u.getJmeno() + ";" + u.getJmeno() + ";" + 
                    u.getRegistrovan().toString() + System.lineSeparator();
            Files.writeString(soubor, radek, StandardOpenOption.APPEND);
        }
    }
    public void nacti() throws IOException{
        
    }
}
