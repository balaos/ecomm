package com.sample.ecomm.ssl;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class PfxLoader {

    public static void loadPfx(String pfxPath, String pfxPassword) throws Exception {
        // Load the PFX file into a KeyStore
        KeyStore keystore = KeyStore.getInstance("PKCS12");
        try (FileInputStream fis = new FileInputStream(pfxPath)) {
            keystore.load(fis, pfxPassword.toCharArray());
        }

        // Get the first alias (there's usually only one in a PFX file)
        Enumeration<String> aliases = keystore.aliases();
        String alias = "";
        if (aliases.hasMoreElements()) {
            alias = aliases.nextElement();
        } else {
            throw new Exception("No aliases found in the PFX file.");
        }

        System.out.println("Using alias: " + alias);

        // Retrieve the private key
        PrivateKey privateKey = (PrivateKey) keystore.getKey(alias, pfxPassword.toCharArray());
        if (privateKey == null) {
            throw new Exception("Private key not found in PFX file.");
        }

        // Retrieve the certificate
        X509Certificate certificate = (X509Certificate) keystore.getCertificate(alias);
        if (certificate == null) {
            throw new Exception("Certificate not found in PFX file.");
        }

        // Print certificate details
        System.out.println("Certificate Subject: " + certificate.getSubjectDN());
        System.out.println("Certificate Issuer: " + certificate.getIssuerDN());
    }

    public static void main(String[] args) {
        try {
            loadPfx("keystore.pfx", "yourPfxPassword");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
