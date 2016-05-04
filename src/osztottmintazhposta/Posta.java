package osztottmintazhposta;

//ez az rmi
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Posta extends UnicastRemoteObject implements PostaI {

    private int ar;
    private int felar;
    private List<Level> levelek = new LinkedList<>();
    private List<Level> elsobbsegi = new LinkedList<>();

    public Posta() throws RemoteException {
        super();
    }

    public Posta(int ar, int felar) throws RemoteException {
        super();
        this.ar = ar;
        this.felar = felar;
    }

    @Override
    public int felad(Level l) throws RemoteException {
        if (l.elsobbsegi) {
            elsobbsegi.add(l);
            return ar + felar;
        } else {
            levelek.add(l);
            return ar;
        }
    }

    private boolean joLevel(Level level, byte szj) {
        String ir = String.valueOf(level.iranyitoszam);
        return ir.startsWith(String.valueOf(szj));
    }

    @Override
    public List<Level> elszallit(byte irSzamKezdet, int taskameret) throws RemoteException {
        List<Level> szallitando = new ArrayList<>();

        for (Level level : elsobbsegi) {
            if (taskameret <= 0) {
                break;
            }
            if (joLevel(level, irSzamKezdet)) {
                szallitando.add(level);
                taskameret--;
            }
        }

        for (Level level : levelek) {
            if (taskameret <= 0) {
                break;
            }
            if (joLevel(level, irSzamKezdet)) {
                szallitando.add(level);
                taskameret--;
            }
        }

        for (Level level : szallitando) {
            elsobbsegi.remove(level);
            levelek.remove(level);
        }

        return szallitando;
    }

    public static void main(String[] args) throws RemoteException {
        //Posta p = new Posta(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        Posta p = new Posta(100, 50);
        Registry reg = LocateRegistry.createRegistry(9000);
        reg.rebind("posta", p);
        System.out.println("A posta elindult");
    }

}
