package atmin;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class BTTH {
    public static String registerUser(String name, String ageInput, String email)
            throws InvalidAgeException, InvalidEmailException {

        int age;

        try {
            age = Integer.parseInt(ageInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Tuoi phai la mot con so!");
        }

        if (age < 18) {
            throw new InvalidAgeException("Loi nghiep vu: Tuoi khong du de dang ky he thong.",1000);
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new InvalidEmailException("Email khong hop le!",1001);
        }

        return name + " - " + age + " - " + email;
    }

    public static void saveUserToFile(String userData) throws FileNotFoundException {
        System.out.println("Dang luu user: " + userData);
        throw new FileNotFoundException("Khong tim thay file luu tru.");
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Nhap ten: ");
            String name = sc.nextLine();

            System.out.print("Nhap tuoi: ");
            String age = sc.nextLine();

            System.out.print("Nhap email: ");
            String email = sc.nextLine();

            String userData = registerUser(name, age, email);

            System.out.println("Dang ky thanh cong!");
            saveUserToFile(userData);

        } catch (InvalidAgeException e) {

            System.out.println(e.getMessage());
            System.out.println("Code Error: " + e.geteCode());

        } catch (InvalidEmailException e) {

            System.out.println(e.getMessage());
            System.out.println("Code Error: " + e.geteCode());

        } catch (NumberFormatException e) {

            System.out.println("Tuoi phai la mot con so!");

        } catch (FileNotFoundException e) {

            System.out.println("Loi he thong: " + e.getMessage());

        } finally {

            System.out.println("Hoan tat luong xu ly dang ky.");

        }
    }
}
