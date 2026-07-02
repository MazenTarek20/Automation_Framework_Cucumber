package Data;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;


public class ExcelFileManager implements DataFileManager {

    private static final LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

    public ExcelFileManager(String path) {
        this(path, "Sheet1");
    }

    public ExcelFileManager(String path, String sheetName) {
        try (FileInputStream fis = new FileInputStream(path);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                sheet = workbook.getSheetAt(0);
            }

            DataFormatter formatter = new DataFormatter();
            boolean firstRow = true;

            for (Row row : sheet) {
                if (firstRow) {
                    firstRow = false; // skip header row
                    continue;
                }

                Cell keyCell = row.getCell(0);
                if (keyCell == null) continue;

                String key = formatter.formatCellValue(keyCell).trim();
                if (key.isEmpty()) continue;

                Cell valueCell = row.getCell(1);
                String value = valueCell == null ? "" : formatter.formatCellValue(valueCell).trim();

                dataMap.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
