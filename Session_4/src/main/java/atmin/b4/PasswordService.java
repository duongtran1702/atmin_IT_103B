package atmin.b4;

public class PasswordService {

    public String evaluatePasswordStrength(String password) {

        if (password.length() < 8) {
            return "Yếu";
        }

        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasLower = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[^A-Za-z0-9].*");

        int score = 0;

        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;

        if (score == 4) return "Mạnh";
        if (score > 2) return "Trung bình";

        return "Yếu";
    }
}