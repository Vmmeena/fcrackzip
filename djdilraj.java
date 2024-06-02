import java.util.*;

 // Compiler version JDK 11.0.2

 class Dcoder
 {
   public static void main(String args[])
   { 
    System.out.println("Hello, Dcoder!");
   }
 }
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.IOUtils;

import java.io.*;
import java.util.zip.ZipException;

public class ZipPasswordRecovery {
    public static void main(String[] args) {
        String zipFilePath = "path/to/zip/file.zip";
        String[] commonPasswords = {"password1", "password123", "123456", "qwerty"};

        for (String password : commonPasswords) {
            try {
                ZipFile zipFile = new ZipFile(new File(zipFilePath));
                if (isPasswordCorrect(zipFile, password)) {
                    System.out.println("Password found: " + password);
                    // Perform further actions here, like extracting the contents of the zip file
                    break;
                }
            } catch (ZipException e) {
                System.err.println("Invalid zip file or incorrect password: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("IO error: " + e.getMessage());
            }
        }
    }

    private static boolean isPasswordCorrect(ZipFile zipFile, String password) throws IOException {
        try {
            for (ZipArchiveEntry entry : zipFile.getEntries()) {
                InputStream stream = zipFile.getInputStream(entry);
                if (stream != null) {
                    stream.close();
                }
            }
            return true;
        } catch (ZipException e) {
            // Incorrect password
            return false;
        }
    }
}
