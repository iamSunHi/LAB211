/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textNormalizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nhật Huy
 */
public class TextNormalizer {

    private List<String> result;
    private String inputFile;
    private String outputFile;

    public TextNormalizer(String inputFile, String outputFile) {
        this.result = new ArrayList<>();
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public void displayNormalizedText() {
        for (String line : result) {
            System.out.println(line);
        }
    }

    public void normalizeText() {
        try {
            List<String> lines = readFromFile();

            normalize(lines);

            writeToFile();

            System.out.println("Text normalization completed successfully. The normalized text display below:\n");

            displayNormalizedText();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred during text normalization: " + e.getMessage());
        }
    }

    private List<String> readFromFile() throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(new File(inputFile));
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();
        return lines;
    }

    private void normalize(List<String> lines) {
        for (String line : lines) {
            String normalizedLine = normalizeLine(line);
            result.add(normalizedLine);
        }
    }

    private String normalizeLine(String line) {
        line = line.trim();
        while (line.contains("  ")) {
            line = line.replaceAll("  ", " ");
        }

        while (line.contains(",  ")) {
            line = line.replaceAll(",  ", ", ");
        }
        while (line.contains(".  ")) {
            line = line.replaceAll(".  ", ". ");
        }
        while (line.contains(":  ")) {
            line = line.replaceAll(":  ", ": ");
        }

        line = line.substring(0, 1).toUpperCase() + line.substring(1);

        if (line.startsWith("\"")) {
            int closingQuoteIndex = line.indexOf("\"", 1);
            if (closingQuoteIndex != -1) {
                String quotedPhrase = line.substring(1, closingQuoteIndex).trim();
                line = "\"" + quotedPhrase + "\"" + line.substring(closingQuoteIndex + 1);
            }
        }

        if (!line.endsWith(".")) {
            line += ".";
        }

        return line;
    }

    private void writeToFile() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File(outputFile));
        for (String line : result) {
            writer.println(line);
        }
        writer.close();
    }

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }
}
