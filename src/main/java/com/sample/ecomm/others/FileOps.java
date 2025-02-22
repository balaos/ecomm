package com.sample.ecomm.others;

import java.io.*;

public class FileOps {
    public static void main(String[] args) throws IOException {
        System.out.println(findStringInFile("/home/balamurugan.v@zucisystems.com/workspace/sample/ecomm/src/main/resources/Sample.txt", "abcd"));
    }

    public static boolean findStringInFile(String filePath, String str) throws IOException {
        File file = new File(filePath);

        BufferedReader reader = new BufferedReader(new FileReader(file));

        // read the file line by linex
        String line = null;
        while ((line = reader.readLine()) != null) {
            if (line.contains(str)) {
                return true;
            }
        }

        return false;
    }
}
