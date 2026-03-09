package atmin;

interface UserActions {
    default void logActivity(String activity) {
        System.out.println("User log: " + activity);
    }
}
