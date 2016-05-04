package osztottmintazhposta;

import java.io.Serializable;

//serializeable
public class Level implements Serializable {

    public final String name;
    public final String cim;
    public final int iranyitoszam;
    public final boolean elsobbsegi;

    public Level(String name, String cim, int iranyitoszam) {
        this(name, cim, iranyitoszam, false);
    }

    public Level(String name, String cim, int iranyitoszam, boolean elsobbsegi) {
        this.name = name;
        this.cim = cim;
        this.iranyitoszam = iranyitoszam;
        this.elsobbsegi = elsobbsegi;
    }

    @Override
    public String toString() {
        return "Level{" + "name=" + name + ", cim=" + cim + ", iranyitoszam=" + iranyitoszam + ", elsobbsegi=" + elsobbsegi + '}';
    }

}
