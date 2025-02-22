package com.sample.ecomm.ssl;

import javax.xml.crypto.KeySelector;
import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Collections;

public class XMLSigner {

    public static String signXML(String xmlInput, String keystorePath, String keystorePassword, String alias, String keyPassword) throws Exception {
        // Load KeyStore
        KeyStore keystore = KeyStoreLoader.loadKeyStore(keystorePath, keystorePassword);
        PrivateKey privateKey = KeyStoreLoader.getPrivateKey(keystore, alias, keyPassword);
        X509Certificate certificate = KeyStoreLoader.getCertificate(keystore, alias);

        // Initialize XML Document
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new ByteArrayInputStream(xmlInput.getBytes()));

        // Create XMLSignatureFactory
        XMLSignatureFactory xmlSigFactory = XMLSignatureFactory.getInstance("DOM");

        // Create Reference
        Reference reference = xmlSigFactory.newReference(
                "", // Empty string means the whole document is signed
                xmlSigFactory.newDigestMethod(DigestMethod.SHA256, null),
                Collections.singletonList(xmlSigFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null)),
                null,
                null
        );

        // Create SignedInfo
        SignedInfo signedInfo = xmlSigFactory.newSignedInfo(
                xmlSigFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null),
                xmlSigFactory.newSignatureMethod(SignatureMethod.RSA_SHA256, null),
                Collections.singletonList(reference)
        );

        // Create KeyInfo (includes X.509 Certificate)
        KeyInfoFactory keyInfoFactory = xmlSigFactory.getKeyInfoFactory();
        X509Data x509Data = keyInfoFactory.newX509Data(Collections.singletonList(certificate));
        KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(x509Data));

        // Create XML Signature
        XMLSignature xmlSignature = xmlSigFactory.newXMLSignature(signedInfo, keyInfo);

        // Attach Signature to Document
        DOMSignContext domSignContext = new DOMSignContext(privateKey, document.getDocumentElement());
        xmlSignature.sign(domSignContext);

        // Convert Document to String
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(document), new StreamResult(writer));

        return writer.toString();
    }
}

