package atmin;

public class TablePrinter {

    public static synchronized void printRow(String input, String output) {
        System.out.printf("| %-25s | %-50s |\n", input, output);
    }

    public static void printHeader() {
        System.out.println("+---------------------------+----------------------------------------------------+");
        System.out.printf("| %-25s | %-50s |\n", "Input", "Output");
        System.out.println("+---------------------------+----------------------------------------------------+");
    }

    public static void printFooter() {
        System.out.println("+---------------------------+----------------------------------------------------+");
    }
}