package atmin;

interface AdminActions {
    default void logActivity(String activity) {
        System.out.println("Admin log: " + activity);
    }
}
