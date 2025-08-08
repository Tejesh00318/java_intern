public class StrengthChecker {

    public String evaluate(String password) {
        int score = 0;

        if (password.length() >= 12) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*\\d.*")) score++;
        if (password.matches(".*[!@#$%^&*()].*")) score++;

        if (score <= 2) return "Weak";
        else if (score <= 4) return "Medium";
        else return "Strong";
    }
}
