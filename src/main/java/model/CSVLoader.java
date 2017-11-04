package model;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;


public class CSVLoader {
    public void load() {
        Reader in = null;
        try {
            in = new FileReader("/home/vincent/workspace/cresiapp/src/main/resources/preguntas.csv");
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
            for (CSVRecord record : records) {
                System.out.println(record.get("Pregunta"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new CSVLoader().load();
    }
}



