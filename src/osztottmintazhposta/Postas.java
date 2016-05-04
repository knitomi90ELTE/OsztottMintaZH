package osztottmintazhposta;

import java.rmi.Naming;
import java.util.List;
import java.util.Random;

/*
Az első parancssori argumentuma egy számjegy, ami azt jelzi, hogy milyen számjeggyel kezdődő leveleket fog ő szállítani; 
második argumentum pedig egy egész szám, ami a postás táskamérete (maximum mennyi levelet tud elszállítani).

A postás 1 és 5 közötti random másodpercenként keresse fel a postát, és kérje el az ő paramétereinek megfelelő elszállítandó leveleket. 
A standard outputra írja ki minden alkalommal, hogy éppen mely leveleket kapta meg a postáról.
 */
public class Postas {

    private byte szj;
    private int meret;
    private Random r = new Random();

    public Postas(byte szj, int meret) {
        this.szj = szj;
        this.meret = meret;
    }

    public void szallit() {
        try {
            PostaI posta = (PostaI) Naming.lookup("rmi://localhost:9000/posta");
            while(true) {
                List<Level> l = posta.elszallit(szj, meret);
                for (Level level : l) {
                    System.out.println(level);
                }
                Thread.sleep(r.nextInt((5 - 1) + 1) + 1);
            }
            
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        
    }

}
