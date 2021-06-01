package clients;

import domain.User;
import services.IServices;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public abstract class WindowController extends UnicastRemoteObject implements Serializable {
    protected IServices services = null;
    protected User signedUser = null;

    protected WindowController() throws RemoteException {
    }

    public void init(IServices services, User signedUser) {
        this.services = services;
        this.signedUser = signedUser;
    }
}
