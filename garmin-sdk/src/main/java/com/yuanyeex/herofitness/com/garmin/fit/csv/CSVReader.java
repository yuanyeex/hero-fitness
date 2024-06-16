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


package com.yuanyeex.herofitness.com.garmin.fit.csv;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

import com.garmin.fit.*;
import com.yuanyeex.herofitness.com.garmin.fit.*;
import com.yuanyeex.herofitness.com.garmin.fit.util.DateTimeConverter;
import com.yuanyeex.herofitness.com.garmin.fit.util.SemicirclesConverter;

public class CSVReader {
    private static final Pattern csvPattern = Pattern.compile("\"([^\"]+?)\",?|([^,]+),?|,");

    private static final Pattern doublePattern = Pattern.compile("^([0-9]+)?\\.[0-9]+$");

    private static final Pattern hexPattern = Pattern.compile("^(0[xX]){1}[a-fA-F0-9]{2}$");

    private final Fit.ProtocolVersion protocolVersion;

    private int unknownMesgCount = 0;
    private int unknownFieldCount = 0;

    private int typeCol = -1;
    private int localNumCol = -1;
    private int mesgCol = -1;
    private int fieldCol = -1;
    private int lineNum = 1;

    private LinkedList<FieldDescriptionMesg> fieldDescriptionMesgs = new LinkedList<FieldDescriptionMesg>();
    private HashMap<Short, DeveloperDataIdMesg> developerDataIdMesgs = new HashMap<Short, DeveloperDataIdMesg>();

    static public boolean read(final InputStream in, final MesgListener mesgListener, final MesgDefinitionListener mesgDefinitionListener) {
        return CSVReader.read(in, mesgListener, mesgDefinitionListener, Fit.ProtocolVersion.V1_0);
    }

    static public boolean read(final InputStream in, final MesgListener mesgListener, final MesgDefinitionListener mesgDefinitionListener, final Fit.ProtocolVersion protocolVersion) {
        CSVReader csvReader = new CSVReader(protocolVersion);
        return csvReader.readCSV(in, mesgListener, mesgDefinitionListener);
    }

    CSVReader() {
        this(Fit.ProtocolVersion.V1_0);
    }

    CSVReader(Fit.ProtocolVersion protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public boolean readCSV(final InputStream in, final MesgListener mesgListener, final MesgDefinitionListener mesgDefinitionListener) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            ArrayList<String> cells;
            String line;

            line = reader.readLine();
            // Strips the UTF-8 BOM if it exists
            line = stripUTF8Bom(line);
            cells = readCells(line);

            for (int col = 0; col < cells.size(); col++) {
                if (cells.get(col).equals("Type")) {
                    typeCol = col;
                }
                else if (cells.get(col).equals("Local Number")) {
                    localNumCol = col;
                }
                else if (cells.get(col).equals("Message")) {
                    mesgCol = col;
                }
                else if (cells.get(col).equals("Field 1")) {
                    fieldCol = col;
                    break;
                }
            }

            while ((line = reader.readLine()) != null) {
                cells = readCells(line);
                lineNum++;

                if ((cells.size() <= typeCol) || (cells.size() <= localNumCol) || (cells.size() <= mesgCol)) {
                    continue; // Ignore empty lines.
                }

                if (cells.get(mesgCol).equalsIgnoreCase("unknown")) {
                    unknownMesgCount++;
                    continue;
                }

                if (cells.get(typeCol).equalsIgnoreCase("Definition")) {
                    if (!readMessageDefinition(cells, mesgDefinitionListener)) {
                        return false;
                    }
                }
                else if (cells.get(typeCol).equalsIgnoreCase("Data")) {
                    if (!readMessage(cells, mesgListener)) {
                        return false;
                    }
                }
            }
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }

        if (unknownMesgCount > 0 || unknownFieldCount > 0) {
            System.out.printf("Ignored %d unknown field(s) and %d unknown message(s) during encoding.\n",
                    unknownFieldCount, unknownMesgCount);
        }

        return true;
    }

    private ArrayList<String> readCells(String line) {
        ArrayList<String> list = new ArrayList<String>();
        Matcher m;

        if (line == null) {
            return null;
        }

        m = csvPattern.matcher(line);

        while (m.find()) {
            String match = m.group();

            if (match == null) {
                break;
            }

            if (match.endsWith(",")) { // trim trailing ,
                match = match.substring(0, match.length() - 1);
            }

            if (match.startsWith("\"")) { // assume also ends with
                match = match.substring(1, match.length() - 1);
            }

            if (match.length() == 0) {
                match = null;
            }

            list.add(match);
        }

        return list;
    }

    private ArrayList<String> readValues(String cell) {
        ArrayList<String> list = new ArrayList<String>();
        String value;
        int i = 0;

        if (cell == null) {
            return null;
        }

        value = "";
        while (i < cell.length()) {
            if (cell.charAt(i) == '|') {
                list.add(value);
                value = "";
            }
            else {
                value += cell.charAt(i);
            }
            i++;
        }

        if (value.length() > 0) {
            list.add(value);
        }

        return list;
    }

    private String stripUTF8Bom(String input) {

        byte[] beforeStrip = input.getBytes(Charset.forName("UTF-8"));
        if (beforeStrip[0] == Fit.UTF8_BOM_BYTE_1 && beforeStrip[1] == Fit.UTF8_BOM_BYTE_2 && beforeStrip[2] == Fit.UTF8_BOM_BYTE_3) {
            byte[] afterStrip = new byte[beforeStrip.length - Fit.UTF8_NUM_BOM_BYTES];
            System.arraycopy(beforeStrip, Fit.UTF8_NUM_BOM_BYTES, afterStrip, 0, afterStrip.length);

            try {
                input = new String(afterStrip, "UTF-8");
            } catch (UnsupportedEncodingException e) {
            }
        }

        return input;
    }

    Boolean isDoubleValue(String value) {
        Matcher m = doublePattern.matcher(value);
        return m.find();
    }

    Boolean isHexValue(String value) {
        Matcher m = hexPattern.matcher(value);
        return m.find();
    }

    private boolean readMessage(ArrayList<String> cells, MesgListener mesgListener) {
        Mesg mesg;

        int cellIndex;

        mesg = Factory.createMesg(cells.get(mesgCol));

        if (mesg.getNum() == MesgNum.INVALID) {
            System.err.printf("CSVReader.read(): Error on line %d - Unknown message \"%s\".\n", lineNum, mesg.getName());
            return false;
        }

        if (localNumCol >= 0) {
            mesg.setLocalNum(Integer.valueOf(cells.get(localNumCol)));
        }

        cellIndex = fieldCol;

        while ((cellIndex + 2) <= cells.size()) {
            String fieldOrSubFieldName = cells.get(cellIndex++);
            ArrayList<String> values = readValues(cells.get(cellIndex++));
            FieldBase field = null;

            cellIndex++; // ignore units

            if (fieldOrSubFieldName == null) {
                break; // Blank cell.
            }

            if (fieldOrSubFieldName.equalsIgnoreCase("unknown")) {
                unknownFieldCount++;
                continue;
            }

            // See if there is an available native field for this field that we are searching for
            Field nativeField = Factory.createField(mesg.getName(), fieldOrSubFieldName);

            if (values == null) {
                continue; // Blank cell. Continue as other cells may be valid.
            }

            if (nativeField.getNum() == Fit.FIELD_NUM_INVALID) {
                // Check for Developer Field
                for (FieldDescriptionMesg descriptionMesg : fieldDescriptionMesgs) {
                    if (descriptionMesg.getFieldName(0).equals(fieldOrSubFieldName)) {

                        if (protocolVersion == Fit.ProtocolVersion.V1_0) {
                            throw new RuntimeException("FIT Protocol Error. A developer field was found while using Protocol Version 1.0. " +
                                    "To use developer data, specify the -p2 command line option to enable FIT Protocol 2.0.");
                        }

                        DeveloperDataIdMesg devId = developerDataIdMesgs.get(descriptionMesg.getDeveloperDataIndex());
                        field = new DeveloperField(descriptionMesg, devId);
                        break;
                    }
                }
            }
            else {
                field = nativeField;
            }

            if (field == null) {
                // The field is not native or a defined developer data field
                System.err.printf("CSVReader.read(): Error on line %d - Unknown field \"%s\" in message \"%s\".\n", lineNum, fieldOrSubFieldName, mesg.getName());
                return false;
            }

            for (String value : values) {
                int numValues = field.getNumValues();

                if (field.getType() == Fit.BASE_TYPE_STRING) {
                    // Pass the read in string through
                    field.setValue(numValues, value, fieldOrSubFieldName);
                }
                else {
                    // Parse the numeric values of the string
                    try {
                        boolean setRawValue = false;

                        switch (field.getType()) {
                            case Fit.BASE_TYPE_ENUM:
                                if (Short.valueOf(value).equals(Fit.ENUM_INVALID)) {
                                    setRawValue = true;
                                }
                                break;
                            case Fit.BASE_TYPE_SINT8:
                                if (Byte.valueOf(value).equals(Fit.SINT8_INVALID)) {
                                    setRawValue = true;
                                }
                                break;
                            case Fit.BASE_TYPE_UINT8:
                                if (Short.valueOf(value).equals(Fit.UINT8_INVALID)) {
                                    setRawValue = true;
                                }
                                break;
                            case Fit.BASE_TYPE_UINT8Z:
                                if (Short.valueOf(value).equals(Fit.UINT8Z_INVALID)) {
                                    setRawValue = true;
                                }
                                break;
                            case Fit.BASE_TYPE_SINT16:
                                if (Short.valueOf(value).equals(Fit.SINT16_INVALID)) {
                                    setRawValue = true;
                                }
                                break;
                            case Fit.BASE_TYPE_UINT16:
                                if (Integer.valueOf(value).equals(Fit.UINT16_INVALID)) {
                                    setRawValue = true;
                                }
                                break;
                            case Fit.BASE_TYPE_UINT16Z:
                                if (Integer.valueOf(value).equals(Fit.UINT16Z_INVALID)) {
                                    setRawValue = true;
                                }
                                break;
                            case Fit.BASE_TYPE_SINT32:
                                if (nativeField.getUnits().equals("semicircles") && isDoubleValue(value)) {
                                    int semicircles = SemicirclesConverter.degreesToSemicircles(Double.parseDouble(value));

                                    value = Integer.toString(semicircles);
                                }

                                if (Integer.valueOf(value).equals(Fit.SINT32_INVALID)) {
                                    setRawValue = true;
                                }
                                break;
                            case Fit.BASE_TYPE_UINT32:
                                if (nativeField.getProfileType().name().equalsIgnoreCase("DATE_TIME")) {
                                    value = DateTimeConverter.parseDateTime(value);
                                }

                                if (Long.valueOf(value).equals(Fit.UINT32_INVALID)) {
                                    setRawValue = true;
                                }
                                break;
                            case Fit.BASE_TYPE_UINT32Z:
                                if (Long.valueOf(value).equals(Fit.UINT32Z_INVALID)) {
                                    setRawValue = true;
                                }
                                break;
                            case Fit.BASE_TYPE_FLOAT32:
                                if (Float.valueOf(value).equals(Fit.FLOAT32_INVALID)) {
                                    setRawValue = true;
                                }
                                break;
                            case Fit.BASE_TYPE_FLOAT64:
                                if (Double.valueOf(value).equals(Fit.FLOAT64_INVALID)) {
                                    setRawValue = true;
                                }
                                break;
                            case Fit.BASE_TYPE_BYTE:
                                if (isHexValue(value)) {
                                    value = Integer.decode(value).toString();
                                }

                                if (Short.valueOf(value).equals(Fit.BYTE_INVALID)) {
                                    setRawValue = true;
                                }
                                break;
                            default:
                                break;
                        }

                        Double doubleValue = Double.valueOf(value);

                        if (setRawValue) {
                            field.setRawValue(numValues, doubleValue);
                        }
                        else {
                            field.setValue(numValues, doubleValue, fieldOrSubFieldName);
                        }

                    } catch (java.lang.NumberFormatException e) {
                        field.setValue(numValues, Double.valueOf(value), fieldOrSubFieldName);
                    }
                }
            }

            if (field instanceof Field) {
                mesg.addField((Field) field);
            }
            else {
                mesg.addDeveloperField((DeveloperField) field);
            }
        }

        if (mesg.getNum() == MesgNum.FIELD_DESCRIPTION) {
            fieldDescriptionMesgs.add(new FieldDescriptionMesg(mesg));
        }
        else if (mesg.getNum() == MesgNum.DEVELOPER_DATA_ID) {
            DeveloperDataIdMesg devId = new DeveloperDataIdMesg(mesg);
            short developerIndex = devId.getDeveloperDataIndex();

            // Save the Developer Data Id Message
            developerDataIdMesgs.put(developerIndex, devId);

            Iterator<FieldDescriptionMesg> it = fieldDescriptionMesgs.iterator();

            // Remove fields associated with the old developer assigned to the index of the new dev
            while (it.hasNext()) {
                FieldDescriptionMesg next = it.next();

                if (next.getDeveloperDataIndex() == developerIndex) {
                    it.remove();
                }
            }
        }

        if (mesgListener != null) {
            mesgListener.onMesg(mesg);
        }

        return true;
    }

    private boolean readMessageDefinition(ArrayList<String> cells, MesgDefinitionListener mesgDefinitionListener) {
        MesgDefinition mesgDef;
        Mesg mesg;

        int cellIndex = fieldCol;

        mesg = Factory.createMesg(cells.get(mesgCol));

        if (mesg.getNum() == MesgNum.INVALID) {
            System.err.printf("CSVReader.read(): Error on line %d - Unknown message \"%s\".\n", lineNum, mesg.getName());
            return false;
        }

        if (localNumCol >= 0) {
            mesg.setLocalNum(Integer.valueOf(cells.get(localNumCol)));
        }

        mesgDef = new MesgDefinition(mesg);

        while ((cellIndex + 2) <= cells.size()) {
            String fieldOrSubFieldName = cells.get(cellIndex++);
            ArrayList<String> values = readValues(cells.get(cellIndex++));
            FieldBase field = null;
            FieldDefinitionBase fieldDef = null;

            cellIndex++; // ignore units

            if (fieldOrSubFieldName == null) {
                break; // Blank cell.
            }

            if (fieldOrSubFieldName.equalsIgnoreCase("unknown")) {
                unknownFieldCount++;
                continue;
            }

            // See if there is an available native field for this field that we are searching for
            Field nativeField = Factory.createField(mesg.getName(), fieldOrSubFieldName);

            if (values == null) {
                continue; // Blank cell. Continue as other cells may be valid.
            }

            if (nativeField.getNum() == Fit.FIELD_NUM_INVALID) {
                // Check for Developer Field
                for (FieldDescriptionMesg descriptionMesg : fieldDescriptionMesgs) {
                    if (descriptionMesg.getFieldName(0).equals(fieldOrSubFieldName)) {

                        if (protocolVersion == Fit.ProtocolVersion.V1_0) {
                            throw new RuntimeException("FIT Protocol Error. A developer field was found while using Protocol Version 1.0. " +
                                    "To use developer data, specify the -p2 command line option to enable FIT Protocol 2.0.");
                        }

                        DeveloperDataIdMesg devId = developerDataIdMesgs.get(descriptionMesg.getDeveloperDataIndex());
                        field = new DeveloperField(descriptionMesg, devId);
                        fieldDef = new DeveloperFieldDefinition(descriptionMesg, devId);
                        break;
                    }
                }
            }
            else {
                field = nativeField;

                fieldDef = new FieldDefinition((Field) field);
            }

            if (field == null) {
                // The field is not native or a defined developer data field
                System.err.printf("CSVReader.read(): Error on line %d - Unknown field \"%s\" in message \"%s\".\n", lineNum, fieldOrSubFieldName, mesg.getName());
                return false;
            }

            for (String value : values) {
                // The 'value' for a field definition in the CSV is number of base type elements that the
                // field contains. The size of the field in bytes is this number multiplied by the base type
                // size.
                fieldDef.setSize(Integer.valueOf(value) * Fit.baseTypeSizes[field.getType() & Fit.BASE_TYPE_NUM_MASK]);
            }

            if (field instanceof Field) {
                mesgDef.addField((FieldDefinition) fieldDef);
            }
            else {
                mesgDef.addDeveloperField((DeveloperFieldDefinition) fieldDef);
            }
        }

        if (mesgDefinitionListener != null) {
            mesgDefinitionListener.onMesgDefinition(mesgDef);
        }

        return true;
    }
}
