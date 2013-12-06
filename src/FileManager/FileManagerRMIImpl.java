package FileManager;

import java.awt.List;
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
import java.util.ArrayList;

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
                this.client = username;
                gui.ServerTextArea.append("\n" + username + " has registered and is logged on.");
                gui.count = gui.count + 1;
                gui.countTextField.setText(Integer.toString(gui.count));
            } else {
                response = username + " already exists!";
            }
        } catch (Exception ex) {
            response = "There were problems registering!";
            System.out.println("Exception caught in thread: " + ex);
        } finally {
            return response;
        }

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
                this.client = username;
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
        } finally {
            return response;
        }

    }

    @Override
    public String uploadFile(byte[] buffer, String filename) throws java.rmi.RemoteException {

        try {
            //**********************************************************
            if (isLogin) {
                FileOutputStream newFile = new FileOutputStream("C:\\dataStore\\" + client + "\\" + filename);
                newFile.write(buffer);
                newFile.close();
                response = "Upload Successful";
            } else {
                response = "Your Not Logged In";
            }

        } catch (IOException ioex) {
            response = "There were IO problems logging in!";
            System.out.println("IOException : " + ioex);
        } catch (Exception ex) {
            response = "Exception - There were problems logging in!";
            System.out.println("Exception caught in thread: " + ex);
        } finally {
            return response;
        }

    }

    @Override
    public ArrayList<String> fileList(String username) throws java.rmi.RemoteException {

        ArrayList<String> filenameList = new ArrayList<String>();
        try {
            //fileListAsString = "";
            if (isLogin) {
                File folder = new File("C:\\dataStore\\" + username);
                File[] listOfFiles = folder.listFiles();
                for (File file : listOfFiles) {
                    filenameList.add(file.getName());
                }
                if (filenameList.size() == 0) {
                    filenameList.add("No Files Found!");
                }
            } else {
                filenameList.add("Your Not Logged In");
            }
        } catch (Exception ex) {
            filenameList.clear();
            filenameList.add("Exception - Unsuccessful Obtaining List!");
            System.out.println("Exception caught in thread: " + ex);
        } finally {
            return filenameList;
        }



    }

    @Override
    public byte[] downloadFile(String s) throws java.rmi.RemoteException {
        byte[] b = new byte[10];
        return b;
    }

    public String deleteFile(String s) throws java.rmi.RemoteException {
        return "";
    }

    public String logout(String username) throws java.rmi.RemoteException {
        isLogin = false;
        gui.ServerTextArea.append("\n" + username + " has logged off.");
        gui.count = gui.count - 1;
        gui.countTextField.setText(Integer.toString(gui.count));
        return "Logged Out!";
    }
}
