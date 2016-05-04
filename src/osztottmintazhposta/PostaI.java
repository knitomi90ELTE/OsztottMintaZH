/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osztottmintazhposta;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author knitomi90
 */
public interface PostaI extends Remote {
    
    public int felad(Level l) throws RemoteException;
    
    public List<Level> elszallit(byte irSzamKezdet, int taskameret) throws RemoteException;
    
}
