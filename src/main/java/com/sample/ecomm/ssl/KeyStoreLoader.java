package com.sample.ecomm.ssl;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public class KeyStoreLoader {

    public static KeyStore loadKeyStore(String keystorePath, String keystorePassword) throws Exception {
        KeyStore keystore = KeyStore.getInstance("PKCS12"); // Use "JKS" for Java KeyStore
        try (FileInputStream fis = new FileInputStream(keystorePath)) {
            keystore.load(fis, keystorePassword.toCharArray());
        }
        return keystore;
    }

    public static PrivateKey getPrivateKey(KeyStore keystore, String alias, String keyPassword) throws Exception {
        return (PrivateKey) keystore.getKey(alias, keyPassword.toCharArray());
    }

    public static X509Certificate getCertificate(KeyStore keystore, String alias) throws Exception {
        return (X509Certificate) keystore.getCertificate(alias);
    }
}

