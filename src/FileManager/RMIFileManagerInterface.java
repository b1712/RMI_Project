package FileManager;

import java.util.ArrayList;

/**
 *
 * @author t00154737
 */
public interface RMIFileManagerInterface extends java.rmi.Remote
{
    public String register(String s) throws java.rmi.RemoteException;
    public String login(String s) throws java.rmi.RemoteException;
    public String uploadFile(byte [] b, String s) throws java.rmi.RemoteException;
    public byte [] downloadFile(String s) throws java.rmi.RemoteException;
    public ArrayList<String> fileList() throws java.rmi.RemoteException;
    public String deleteFile(String s) throws java.rmi.RemoteException;
    public String logout() throws java.rmi.RemoteException;
}

