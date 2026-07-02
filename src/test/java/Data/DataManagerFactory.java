package Data;

public class DataManagerFactory {

    public enum Source {
        EXCEL, CSV
    }

    private static final String EXCEL_PATH = "src/test/resources/Data.xlsx";
    private static final String CSV_PATH = "src/test/resources/Data.csv";

    private static DataFileManager instance;

    private DataManagerFactory() {
    }

    /** Reads the -DdataSource=EXCEL|CSV flag, defaults to EXCEL if not set. */
    public static synchronized DataFileManager getDataManager() {
        if (instance == null) {
            String property = System.getProperty("dataSource", "EXCEL").trim().toUpperCase();
            Source source;
            try {
                source = Source.valueOf(property);
            } catch (IllegalArgumentException e) {
                System.err.println("Unknown dataSource '" + property + "', falling back to EXCEL");
                source = Source.EXCEL;
            }
            instance = getDataManager(source);
        }
        return instance;
    }

    public static DataFileManager getDataManager(Source source) {
        switch (source) {
            case CSV:
                return new CSVFileManager(CSV_PATH);
            case EXCEL:
            default:
                return new ExcelFileManager(EXCEL_PATH);
        }
    }
}
