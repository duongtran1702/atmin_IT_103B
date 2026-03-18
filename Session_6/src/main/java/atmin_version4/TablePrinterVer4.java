package atmin_version4;

public class TablePrinterVer4 {

    public static synchronized void printRow(String input, String output) {
        System.out.printf("| %-25s | %-50s |\n", input, output);
    }

    public static void printHeader() {
        atmin.TablePrinter.printHeader();
    }

    public static void printFooter() {
        System.out.println("+---------------------------+----------------------------------------------------+");
    }
}