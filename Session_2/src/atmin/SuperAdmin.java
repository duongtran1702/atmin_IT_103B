package atmin;

class SuperAdmin implements UserActions, AdminActions {

    @Override
    public void logActivity(String activity) {
//        UserActions.super.logActivity(activity);
        AdminActions.super.logActivity(activity);
    }

    public static void main(String[] args) {
        SuperAdmin superadmin = new SuperAdmin();
        superadmin.logActivity("Delete user");
    }
}
