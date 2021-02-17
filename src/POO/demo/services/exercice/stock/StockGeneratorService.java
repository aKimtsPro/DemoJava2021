package POO.demo.services.exercice.stock;

import POO.demo.services.exercice.stock.models.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockGeneratorService {

    private static final String csvPathFile = ".\\data\\stock_data.csv";
    private static BufferedReader br = null;
    private static String line = "";
    private static final String csvSplitCharacter = ",";

    private static StockGeneratorService instance;

    private StockGeneratorService() {

    }

    public static StockGeneratorService getInstance() {
        if (instance == null) {
            instance = new StockGeneratorService();
        }

        return instance;
    }

    public List<Product> getDataFromCSV() {
        System.out.println("\n- chargement des données -");
        List<Product> output = new ArrayList<>();
        int count = 0;

        try {
            br = new BufferedReader(new FileReader(csvPathFile));
            while ((line = br.readLine()) != null) {
                if (count != 0) {

                    String[] data = line.split(csvSplitCharacter);
                    data = checkQuotes(data);
                    switch (data.length) {
                        case 6 :
                            output.add(new Product(
                                    Integer.parseInt(data[0]),
                                    data[1],
                                    Double.parseDouble(data[2]),
                                    Integer.parseInt(data[3]),
                                    data[4],
                                    data[5])
                            );
                            break;
                        case 7 :
                            output.add(new Product(
                                    Integer.parseInt(data[0]),
                                    data[1] + data[2],
                                    Double.parseDouble(data[3]),
                                    Integer.parseInt(data[4]),
                                    data[5],
                                    data[6])
                            );
                            break;
                        case 8 :
                            output.add(new Product(
                                    Integer.parseInt(data[0]),
                                    data[1] + data[2] + data[3],
                                    Double.parseDouble(data[4]),
                                    Integer.parseInt(data[5]),
                                    data[6],
                                    data[7])
                            );
                            break;
                    }

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

        System.out.println("\n- chargement terminé -");

        return output;
    }

    // Supprime les "
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
