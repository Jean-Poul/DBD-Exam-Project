package db.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class AddressFetcher {

    public static void add() throws IOException {
        /*
         Data in adr1.txt and adr2.txt comes from https://api.dataforsyningen.dk/adresser?struktur=mini&kommunekode=0159

         */
        String from1 = "sql/adr1.txt";
        String in1 = "sql/addresses1.sql";
        String from2 = "sql/adr2.txt";
        String in2 = "sql/addresses2.sql";
        JSONParser parser = new JSONParser();

        writeLines(from1, in1, parser);
        writeLines(from2, in2, parser);
    }

    public static void writeLines(String path_from, String path_in, JSONParser parser) {
        try {
            String data = new String(Files.readAllBytes(Paths.get(path_from)));
            Object object = parser.parse(data);
            JSONArray jsonArray = (JSONArray) object;

            FileWriter sqlWriter = new FileWriter(path_in);
            sqlWriter.write("INSERT INTO addresses(street, building_id, local_id, zipcode, x, y)\n");
            sqlWriter.write("VALUES\n");

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                String street = (String) jsonObject.get("vejnavn");
                String building_identifier = (String) jsonObject.get("husnr");
                String floor = (String) jsonObject.get("etage");
                String door = (String) jsonObject.get("dør");
                String local_identifier = "";
                if (floor != null) {
                    local_identifier = floor;
                }
                if (door != null) {
                    if (local_identifier.equals("")) {
                        local_identifier = door;
                    } else {
                        local_identifier += "." + door;
                    }
                }
                int zipcode = Integer.parseInt((String) jsonObject.get("postnr"));
                DecimalFormat df = new DecimalFormat("#.###############");
                double x = (double) jsonObject.get("x");
                String x_str = df.format(x).replace(',', '.');
                double y = (double) jsonObject.get("y");
                String y_str = df.format(y).replace(',', '.');

                char delimiter = ',';
                if (i == jsonArray.size() - 1) {
                    delimiter = ';';
                }

                String values = String.format("('%s', '%s', '%s', %d, %s, %s)%c\n", street, building_identifier, local_identifier, zipcode, x_str, y_str, delimiter);
                sqlWriter.write(values);
            }
            sqlWriter.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }


}
