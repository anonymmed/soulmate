/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysoulmates.controllers;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
/**
 *
 * @author Mohamed
 */
public class FtpUpload {
    
public void connectFTP()
{
    FTPClient client = new FTPClient();
FileInputStream fis = null;

try {
    client.connect("localhost", 21);
    client.login("Mohamed", "V4Vendetta");

    //
    // Create an InputStream of the file to be uploaded
    //
    String filename = "med.png";
    fis = new FileInputStream(new File(System.getProperty("user.dir")+"/src/mysoulmates/images/med.jpg"));

    //
    // Store file to server
    //
    client.storeFile(filename, fis);
    client.logout();
} catch (IOException e) {
    e.printStackTrace();
} finally {
    try {
        if (fis != null) {
            fis.close();
        }
        client.disconnect();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}

}

