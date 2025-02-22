package com.sample.ecomm.ssl;

import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;

public class RSADecryptor {

    // Load private key from PFX file
    public static PrivateKey loadPrivateKey(String pfxPath, String pfxPassword) throws Exception {
        KeyStore keystore = KeyStore.getInstance("PKCS12");
        try (FileInputStream fis = new FileInputStream(pfxPath)) {
            keystore.load(fis, pfxPassword.toCharArray());
        }

        // Get the first alias in the keystore
        String alias = keystore.aliases().nextElement();

        // Extract private key
        PrivateKey privateKey = (PrivateKey) keystore.getKey(alias, pfxPassword.toCharArray());
        if (privateKey == null) {
            throw new Exception("Private key not found in PFX file.");
        }

        return privateKey;
    }

    public static String decryptWithPrivateKey(String encryptedBase64, PrivateKey privateKey) throws Exception {
        // Convert Base64 string back to byte array
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedBase64);

        // Initialize Cipher for decryption
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        // Decrypt the bytes
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        // Convert decrypted bytes to string
        return new String(decryptedBytes);
    }

    public static void main(String[] args) {
        try {
            // Path to your PFX file and password
            String pfxPath = "keystore.pfx";
            String pfxPassword = "yourPfxPassword";

            // Load private key
            PrivateKey privateKey = RSADecryptor.loadPrivateKey(pfxPath, pfxPassword);

            // Example of an encrypted message (Base64 encoded)
            String encryptedMessage = "Z29vZCBtb3JuaW5n";  // Replace with actual encrypted data

            // Decrypt message
            String decryptedText = RSADecryptor.decryptWithPrivateKey(encryptedMessage, privateKey);
            System.out.println("Decrypted Text: " + decryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
