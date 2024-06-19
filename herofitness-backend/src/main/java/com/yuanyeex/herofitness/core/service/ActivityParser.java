package com.yuanyeex.herofitness.core.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public interface ActivityParser {

    /**
     * Parse activity from local file
     *
     */
    default void parse(String localFilePath) {
        try {
            parse(new FileInputStream(localFilePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Parse activity from stream
     */
    void parse(InputStream inputStream);
}
