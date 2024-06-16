/////////////////////////////////////////////////////////////////////////////////////////////
// Copyright 2024 Garmin International, Inc.
// Licensed under the Flexible and Interoperable Data Transfer (FIT) Protocol License; you
// may not use this file except in compliance with the Flexible and Interoperable Data
// Transfer (FIT) Protocol License.
/////////////////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 21.141.0Release
// Tag = production/release/21.141.0-0-g2aa27e1
/////////////////////////////////////////////////////////////////////////////////////////////


package com.yuanyeex.herofitness.com.garmin.fit.repair;

import com.yuanyeex.herofitness.com.garmin.fit.Decode;
import com.yuanyeex.herofitness.com.garmin.fit.FileEncoder;
import com.yuanyeex.herofitness.com.garmin.fit.Fit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ActivityRepairTool {
    private final String inputFilePath;
    private final String outputFilePath;
    private FileEncoder fileEncoder = new FileEncoder();
    private FileInputStream inputFileStream = null;

    private ActivityRepairTool() {
        inputFilePath = null;
        outputFilePath = null;
    }

    public ActivityRepairTool(String inputFilePath) {
        this.inputFilePath = inputFilePath;
        outputFilePath = createOutputFilePath();
    }

    public static void main(String args[]) throws IOException {
        if (!validateCommandlineArgs(args)) {
            printUsage();
            return;
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("Input file does not exist: " + args[0]);
            return;
        }
        if (!file.getName().toLowerCase().endsWith(".fit")) {
            System.out.println("Input file is not a .fit file: " + args[0]);
            return;
        }

        ActivityRepairTool activityRepairTool = new ActivityRepairTool(args[0]);
        activityRepairTool.repair();
    }

    private static boolean validateCommandlineArgs(String[] args) {
        return args.length == 1;
    }

    private static void printUsage() {
        System.out.println("Usage: java -jar ActivityRepairTool.jar <filename>");
    }

    /**
     * @return the path to the output file
     */
    public String getOutputFilePath() {
        return outputFilePath;
    }

    /**
     * Repairs a corrupt or invalid FIT Activity file if possible
     */
    public void repair() {

        ActivityRepairFilter activityRepairFilter = new ActivityRepairFilter();

        try {
            inputFileStream = new FileInputStream(inputFilePath);

            Decode decoder = new Decode();
            decoder.addListener(activityRepairFilter);
            decoder.read(inputFileStream);
        }
        catch (Exception e) {
            System.out.println("Error while decoding file. Attempting to repair file...");
        }
        finally {
            closeInputStream();
        }

        if (!activityRepairFilter.canRepairFile()) {
            System.out.println("File can not be repaired.");
            return;
        }

        try {
            File outputFile = new File(outputFilePath);
            outputFile.delete();

            fileEncoder = new FileEncoder(outputFile, Fit.ProtocolVersion.V2_0);

            activityRepairFilter.addListener(fileEncoder);

            activityRepairFilter.flushMesgs();

        }
        catch (Exception e) {
            System.out.println("Error in repair.\n");
        }
        finally {
            closeFileEncoder();

            System.out.println("Repair complete. Repaired .fit file can be found at: " + outputFilePath);
        }
    }

    private String createOutputFilePath() {
        return inputFilePath.substring(0, (inputFilePath.length() - 4))
                + "_repaired.fit";
    }

    private void closeInputStream() {
        try {
            inputFileStream.close();
        }
        catch (IOException e) {
            System.err.println("Error closing Input File Stream.");
        }
    }

    private void closeFileEncoder() {
        try {
            if (fileEncoder != null) {
                fileEncoder.close();
            }
        }
        catch (Exception e) {
            System.err.println("Error closing File Encoder.");
        }
    }
}