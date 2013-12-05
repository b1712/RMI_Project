package FileManager;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;
import java.nio.file.Files;
import java.util.concurrent.CountDownLatch;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author t00154737
 */
public class FileManagerRMIImpl extends UnicastRemoteObject implements RMIFileManagerInterface {

    private boolean isLogin = false;
    private String response, client;
    private File clientFolder, clientFlie;
    ServerGUI gui;

    public FileManagerRMIImpl(ServerGUI gui) throws RemoteException {
        super();
        this.gui = gui;
    }

    @Override
    public String register(String username) throws java.rmi.RemoteException {

        try {
            //************************************************************************
            // File path
            //*************************************************************************
            File dir = new File("C:\\dataStore\\" + username);
            if (!dir.exists()) {
                dir.mkdir();
                response = "Welcome " + username;
                isLogin = true;
                client = username;
                gui.ServerTextArea.append("\n" + username + " has registered and is logged on.");
                gui.count = gui.count + 1;
                gui.countTextField.setText(Integer.toString(gui.count));
            } else {
                response = username + " already exists!";
            }
        } catch (Exception ex) {
            response = "There were problems registering!";
            System.out.println("Exception caught in thread: " + ex);
        }

        return response;
    }

    @Override
    public String login(String username) throws java.rmi.RemoteException {

        try {


            //************************************************************************
            // File path
            //*************************************************************************
            clientFolder = new File("C:\\dataStore\\" + username);
            if (clientFolder.isDirectory()) {
                isLogin = true;
                response = "Welcome back " + username;
                client = username;
                gui.ServerTextArea.append("\n" + username + " is logged on.");
                gui.count = gui.count + 1;
                gui.countTextField.setText(Integer.toString(gui.count));
            } else {
                isLogin = false;
                response = "Login Unsuccessful!";
            }
        } catch (Exception ex) {
            response = "There were problems logging in!";
            System.out.println("Exception caught in thread: " + ex);
        }

        return response;
    }

    @Override
    public String uploadFile(byte[] buffer, String filename) throws java.rmi.RemoteException {

        try {
            FileOutputStream newFile = new FileOutputStream("C:\\dataStore\\" + client + "\\" + filename);
            newFile.write(buffer);
            newFile.close();
        } //************************************************************************************
        catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException : " + ex);
        } catch (IOException ioe) {
            System.out.println("IOException : " + ioe);
        }
        return "File Saved!";
    }

    @Override
    public Byte[] downloadFile(String s) throws java.rmi.RemoteException {
        Byte[] b = new Byte[10];
        return b;
    }

    @Override
    public String fileList() throws java.rmi.RemoteException {
        return "";
    }

    public String deleteFile(String s) throws java.rmi.RemoteException {
        return "";
    }

    public String logout() throws java.rmi.RemoteException {
        isLogin = false;
        gui.ServerTextArea.append("\n" + client + " has logged off.");
        gui.count = gui.count - 1;
        gui.countTextField.setText(Integer.toString(gui.count));
        return "Logged Out!";
    }
}
