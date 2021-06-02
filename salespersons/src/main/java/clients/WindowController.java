package clients;

import domain.Salesperson;
import services.IServices;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public abstract class WindowController extends UnicastRemoteObject implements Serializable {
    protected IServices services = null;
    protected Salesperson signedSalesperson = null;

    protected WindowController() throws RemoteException {
    }

    public void init(IServices services, Salesperson signedSalesperson) {
        this.services = services;
        this.signedSalesperson = signedSalesperson;
    }
}
