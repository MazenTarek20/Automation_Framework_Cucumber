package Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class CSVFileManager implements DataFileManager {

    private static final LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

    public CSVFileManager(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // skip header row
                    continue;
                }
                if (line.trim().isEmpty()) continue;

                String[] parts = splitKeyValue(line);
                String key = parts[0];
                if (key.isEmpty()) continue;

                dataMap.put(key, parts[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String[] splitKeyValue(String line) {
        int idx = line.indexOf(',');
        if (idx == -1) {
            return new String[]{stripQuotes(line), ""};
        }
        String key = stripQuotes(line.substring(0, idx));
        String value = stripQuotes(line.substring(idx + 1));
        return new String[]{key, value};
    }

    private String stripQuotes(String s) {
        s = s.trim();
        if (s.length() >= 2 && s.startsWith("\"") && s.endsWith("\"")) {
            s = s.substring(1, s.length() - 1);
        }
        return s;
    }

    @Override
    public static String getValue(String key) {
        return dataMap.get(key);
    }

    @Override
    public ArrayList<String> getArrayList(String key) {
        ArrayList<String> list = new ArrayList<>();
        String raw = dataMap.get(key);
        if (raw != null && !raw.isEmpty()) {
            for (String item : raw.split(";")) {
                list.add(item.trim());
            }
        }
        return list;
    }
}
