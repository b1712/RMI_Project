package FileManager;

import java.io.*;
import java.rmi.*;
import java.util.ArrayList;
//import javax.swing.JOptionPane;

/**
 *
 * @author t00154737
 */
public class Client {

    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);
    String hostname = "localhost";
    String portNum = "7";
    RMIFileManagerInterface interfaceObject;
    boolean done = false;
    String message, response;

    public Client() {
        try {
            //int RMIPort;         
            String hostName;
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            //System.out.println("Enter the RMIRegistry host namer:");
            //hostName = br.readLine();
            //System.out.println("Enter the RMIregistry port number:");
            //String portNum = br.readLine();
            hostName = "localhost";
            //RMIPort = Integer.parseInt(portNum);
            int portNum = 2500;
            String registryURL =
                    "rmi://" + hostName + ":" + portNum + "/FileManager";
            // find the remote object and cast it to an interface object
            interfaceObject = (RMIFileManagerInterface) Naming.lookup(registryURL);
            System.out.println("Lookup completed ");

        } // end try 
        catch (Exception e) {
            System.out.println("Exception in Client: " + e);
        }
    }

    public String clientRegister(String username) {
        try {
            response = interfaceObject.register(username);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return response;
    }

    public String clientLogin(String username) {
        try {
            response = interfaceObject.login(username);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return response;
    }

    public String clientUpload(File file) {
        String newResponse = "";
        
        try {
            byte buffer[] = new byte[(int) file.length()];
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            inputStream.read(buffer, 0, buffer.length);
            inputStream.close();

            newResponse = interfaceObject.uploadFile(buffer, file.getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return newResponse;
    }

    public ArrayList<String> clientGetList() {
        
        ArrayList<String> filenameList = null;
        try {
            filenameList  = interfaceObject.fileList();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return filenameList;
    }
//
//    public String clientDeleteFile(String fileName) {
//        try {
//            response = helper.deleteFile(fileName);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        return response;
//    }
//
//    public String clientDownload(String fileName, String path) {
//        try {
//            response = helper.downloadFile(fileName, path);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        return response;
//    }
//

    public String logOut() {
        try {
            response = interfaceObject.logout();

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return response;
    }
}
