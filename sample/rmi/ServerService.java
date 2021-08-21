package sample.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerService extends Remote {
    public String sayHello() throws RemoteException;

    public int sum(int x, int y) throws RemoteException;
}
