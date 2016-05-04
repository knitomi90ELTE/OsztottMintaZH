package osztottmintazhposta;

import java.rmi.Naming;

public class Felado {

    private int id;

    public Felado(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        int id = 1;//Integer.parseInt(args[0]);
        Felado f = new Felado(id);
        f.postaraJar();
    }

    private void postaraJar() {
        try {
            PostaI posta = (PostaI) Naming.lookup("rmi://localhost:9000/posta");
            for (int i = 1; i <= 9; i++) {
                Level level = new Level("cimzett" + id, "cim" + id,  i * 1000 + id, (id+i) % 2 == 0);
                int ar = posta.felad(level);
                System.out.println("A feladott level: " + level + ", ar: " + ar);
                Thread.sleep(2000);
            }
        } catch (Exception e) { }
    }

}
