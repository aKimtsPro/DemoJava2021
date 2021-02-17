package POO.demo.services;

import POO.demo.services.models.Adresse;
import POO.demo.services.models.Personne;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataGeneratorService {

    private static final String csvPathFile = ".\\data\\stock_data.csv";
    private static BufferedReader br = null;
    private static String line = "";
    private static String csvSplitCharacter = ",";

    private static DataGeneratorService instance;

    private DataGeneratorService() {

    }

    public static DataGeneratorService getInstance() {
        if (instance == null) {
            instance = new DataGeneratorService();
        }

        return instance;
    }

    public List<Personne> getDataFromCSV() {
        List<Personne> output = new ArrayList<>();
        int count = 0;

        try {
            br = new BufferedReader(new FileReader(csvPathFile));
            while ((line = br.readLine()) != null) {
                if (count != 0) {
                    String[] data = line.split(csvSplitCharacter);
                    data = checkQuotes(data);
                    Personne p;
                    if (data.length == 12) {
                        p = new Personne(data[0], data[1], data[2],
                                new Adresse(data[3], data[4], data[5], data[6], Integer.parseInt(data[7])),
                                new String[]{data[8], data[9]}, data[10], data[11]
                        );
                    } else {
                        p = new Personne(data[0], data[1], data[2] + " " + data[3],
                                new Adresse(data[4], data[5], data[6], data[7], Integer.parseInt(data[8])),
                                new String[]{data[9], data[10]}, data[11], data[12]);
                    }
                    output.add(p);
                }
                count++;
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return output;
    }

    private static String[] checkQuotes(String[] data) {
        // TODO Auto-generated method stub
        for (int i = 0; i < data.length; i++) {
            if (data[i].contains("\"")) {
                data[i] = data[i].replace('"', ' ').trim();

            }
        }


        return data;
    }
}
