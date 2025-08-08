import java.util.Random;

public class PasswordBuilder {
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+<>?";

    public String generate(int length, boolean useUpper, boolean useLower, boolean useDigits, boolean useSymbols) {
        StringBuilder charPool = new StringBuilder();

        if (useLower) charPool.append(LOWER);
        if (useUpper) charPool.append(UPPER);
        if (useDigits) charPool.append(DIGITS);
        if (useSymbols) charPool.append(SYMBOLS);

        if (charPool.length() == 0) return "";

        Random rand = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(charPool.charAt(rand.nextInt(charPool.length())));
        }

        return password.toString();
    }
}
