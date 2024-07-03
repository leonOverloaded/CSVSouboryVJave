/**
 * uci se:
 * Leon Belligerrator
 */
package leonovo.csvsouboryvjave;

import java.time.LocalDate;

/**
 * vyukove pasmo IT Network
 * @author itnetwork.cz
 */
public class Uzivatel {
    private final String jmeno;
    private final int vek;
    private final LocalDate registrovan;
    
    public Uzivatel(String jmeno, int vek, LocalDate registrovan){
        this.jmeno = jmeno;
        this.vek = vek;
        this.registrovan = registrovan;
    }
    public String getJmeno(){
        return jmeno;
    }
    public int getVek(){
        return vek;
    }
    public LocalDate getRegistrovan(){
        return registrovan;
    }
    
    @Override
    public String toString(){
        return jmeno;
    }
}
