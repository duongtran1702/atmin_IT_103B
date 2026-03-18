package atmin_version3;

public class TablePrinterVer3 {

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