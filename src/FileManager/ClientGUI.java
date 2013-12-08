package FileManager;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JOptionPane;
import java.io.File;
import java.util.ArrayList;

public class ClientGUI extends javax.swing.JFrame {

    private Client client;
    private String username, response;
    private boolean isConnected;
    private boolean isLoggedIn;

    public ClientGUI() {
        initComponents();
        client = new Client();
        isConnected = true;
        isLoggedIn = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        btnRegister = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        btnUploadFile = new javax.swing.JButton();
        btnGetFileList = new javax.swing.JButton();
        btnDownloadFile = new javax.swing.JButton();
        textfieldRegister = new javax.swing.JTextField();
        textfieldLogin = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textareaMainDialog = new javax.swing.JTextArea();
        btnDeleteFile = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (isConnected) {
                    forcedLogOut();
                } else {
                    System.exit(0);
                }
            }
        });

        btnRegister.setText("Register");
        btnRegister.setToolTipText("Register new account");
        btnRegister.setName("btnRegister"); // NOI18N
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.setToolTipText("Client login");
        btnLogin.setName("btnLogin"); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnUploadFile.setText("Upload File");
        btnUploadFile.setToolTipText("Upload a client file to the server");
        btnUploadFile.setEnabled(false);
        btnUploadFile.setName("btnUploadFile"); // NOI18N
        btnUploadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadFileActionPerformed(evt);
            }
        });

        btnGetFileList.setText("Get File List");
        btnGetFileList.setToolTipText("Retrieve list of client's file on server");
        btnGetFileList.setEnabled(false);
        btnGetFileList.setName("btnGetList"); // NOI18N
        btnGetFileList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetFileListActionPerformed(evt);
            }
        });

        btnDownloadFile.setText("Download File");
        btnDownloadFile.setToolTipText("Download file from server");
        btnDownloadFile.setEnabled(false);
        btnDownloadFile.setName("btnDownloadFile"); // NOI18N
        btnDownloadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadFileActionPerformed(evt);
            }
        });

        textfieldRegister.setName("txtboxRegister"); // NOI18N

        textfieldLogin.setName("txtboxLogin"); // NOI18N

        textareaMainDialog.setColumns(20);
        textareaMainDialog.setRows(5);
        textareaMainDialog.setEnabled(false);
        textareaMainDialog.setName("txtareaMainDialog"); // NOI18N
        jScrollPane1.setViewportView(textareaMainDialog);

        btnDeleteFile.setText("Delete File");
        btnDeleteFile.setToolTipText("Delete client file on server");
        btnDeleteFile.setEnabled(false);
        btnDeleteFile.setName("btnDeleteFile"); // NOI18N
        btnDeleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteFileActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        title.setText("Client - Server Interface");
        title.setToolTipText("");

        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addComponent(btnUploadFile, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addComponent(btnGetFileList, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addComponent(btnDownloadFile, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addComponent(btnDeleteFile, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(textfieldRegister)
                .addComponent(textfieldLogin)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))))
                .addGap(41, 41, 41)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnRegister)
                .addComponent(textfieldRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnLogin)
                .addComponent(textfieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addComponent(btnUploadFile)
                .addGap(35, 35, 35)
                .addComponent(btnGetFileList)
                .addGap(18, 18, 18)
                .addComponent(btnDownloadFile)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteFile)
                .addGap(18, 18, 18)
                .addComponent(btnLogOut))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {
        if (textfieldRegister.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "You must enter a name in the field opposite");
            textfieldRegister.setBackground(new java.awt.Color(204, 255, 204));
            textfieldRegister.requestFocus();
        } else {
            username = textfieldRegister.getText();
            try {
                response = client.clientRegister(username);

                if (response.substring(0, 7).equals("Welcome")) {
                    welcomeMessage(response);
                    isLoggedIn = true;
                    isConnected = true;
                    unlockUI();
                } else {
                    textareaMainDialog.append("\n~" + response);
                    textfieldRegister.setText("");
                }
            } catch (Exception ex) {
                //ex.printStackTrace();
                System.out.println("Exception in Client: " + ex);
            }
        }
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        if (textfieldLogin.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "You must enter your username in the field opposite");
            textfieldLogin.setBackground(new java.awt.Color(204, 255, 204));
            textfieldLogin.requestFocus();
        } else {
            username = textfieldLogin.getText();
            try {
                response = client.clientLogin(username);

                //int messageCode = Integer.parseInt(response.substring(0, 3));

                if (response.substring(0, 7).equals("Welcome")) {
                    welcomeMessage(response);
                    isLoggedIn = true;
                    isConnected = true;
                    unlockUI();
                } else {
                    textareaMainDialog.append("\n~" + response);
                    textfieldLogin.setText("");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void btnUploadFileActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JFileChooser fileChooser = new JFileChooser("test files");
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String uploadResponse = client.clientUpload(file);
                textareaMainDialog.append("\n~ " + uploadResponse);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void btnGetFileListActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            ArrayList<String> filenamelist = client.clientGetList();
            //int messageCode = Integer.parseInt(response.substring(0, 3));
            textareaMainDialog.append("\n~ File List:\n");

            for (String filename : filenamelist) {
                textareaMainDialog.append(filename + "\n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void btnDownloadFileActionPerformed(java.awt.event.ActionEvent evt) {

        if (textareaMainDialog.getSelectedText() == null) {
            JOptionPane.showMessageDialog(this, "Please get a list of files and then select a file to download");
        } else {
            try {
                String fileName = textareaMainDialog.getSelectedText();
                File file = new File(fileName);
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Specify a file to save");
                fileChooser.setSelectedFile(file);
                int userSelection = fileChooser.showSaveDialog(this);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    response = client.clientDownload(fileName, fileChooser.getSelectedFile().toString());
                }
                
            } catch (Exception ex) {
                ex.printStackTrace();
                response = "Exception - Download Unsuccessful!";
            }
            finally
            {
                textareaMainDialog.append("\n~ " + response);
            }
        }
    }

    private void btnDeleteFileActionPerformed(java.awt.event.ActionEvent evt) {

        if (textareaMainDialog.getSelectedText() == null) {
            JOptionPane.showMessageDialog(this, "Please get a list of files and then highlight 1");
        } else {
            try {
                //response = client.clientDeleteFile(textareaMainDialog.getSelectedText());
                textareaMainDialog.append("\n~ " + response.substring(4, response.length()));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {

        logoutSub();
    }

    private void forcedLogOut() {

        JOptionPane.showMessageDialog(null, "The system is going to force a disconnection!");

        logoutSub();
    }

    private void logoutSub() {

        try {
            response = client.logOut();

            if (response.substring(0, 11).equals("Logged Out!")) {
                isLoggedIn = false;
                isConnected = false;

                Thread.sleep(3000); //just for effect
                System.exit(0);

            } else {
                textareaMainDialog.append("\n~" + response);
                textfieldLogin.setText("");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void welcomeMessage(String name) {
        textareaMainDialog.setText("");
        textareaMainDialog.append("**************************************\n"
                + "         " + name
                + "\n**************************************\n");
    }

    private void unlockUI() {
        if (isLoggedIn) {
            btnUploadFile.setEnabled(true);
            btnGetFileList.setEnabled(true);
            btnDownloadFile.setEnabled(true);
            textareaMainDialog.setEnabled(true);
            btnDeleteFile.setEnabled(true);
            btnRegister.setEnabled(false);
            btnLogin.setEnabled(false);
            textfieldLogin.setEnabled(false);
            textfieldRegister.setEnabled(false);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JButton btnDeleteFile;
    private javax.swing.JButton btnDownloadFile;
    private javax.swing.JButton btnGetFileList;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnUploadFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textareaMainDialog;
    private javax.swing.JTextField textfieldLogin;
    private javax.swing.JTextField textfieldRegister;
    private javax.swing.JLabel title;
    // End of variables declaration
}
