package atmin;

import java.util.Scanner;

public class B2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap tong so nguoi dung: ");
        int n = sc.nextInt();
        System.out.println("Nhap so luong nhom: ");
        int m = sc.nextInt();

        if (m != 0) {
            int result = n / m;
            System.out.println(result);
        } else {
            System.out.println("Khong the chia cho 0");
        }
    }
}
