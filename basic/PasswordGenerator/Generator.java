import java.util.Scanner;

public class Generator {
    private final Scanner scanner;

    public Generator(Scanner scanner) {
        this.scanner = scanner;
    }

    public void mainLoop() {
        System.out.println("🔐 Welcome to the Ultimate Password Service");

        boolean running = true;
        while (running) {
            System.out.println("\n📋 Menu:");
            System.out.println("1.Password Generate");
            System.out.println("2.Password Strength Check");
            System.out.println("3. Useful Information");
            System.out.println("4. Quit");
            System.out.print("👉 Enter your choice: ");


            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    generatePasswordFlow();
                    break;
                case "2":
                    checkStrengthFlow();
                    break;
                case "3":
                    showUsefulInfo();
                    break;
                case "4":
                    System.out.println("👋 Exiting... Stay secure!");
                    running = false;
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }
    }

    private void generatePasswordFlow() {

        System.out.println("\t Answer the following questions by  'y' or 'N' ");
        System.out.println("✅ Choose character types to include:");
        System.out.print("Do you want  uppercase letters (A–Z)? (y/n): ");
        boolean useUpper = scanner.nextLine().trim().equalsIgnoreCase("y");

        System.out.print("Do you want lowercase letters (a–z)? (y/n): ");
        boolean useLower = scanner.nextLine().trim().equalsIgnoreCase("y");

        System.out.print("Do you want numbers (0–9)? (y/n): ");
        boolean useDigits = scanner.nextLine().trim().equalsIgnoreCase("y");

        System.out.print("Do you want special symbols (!@#$...)? (y/n): ");
        boolean useSymbols = scanner.nextLine().trim().equalsIgnoreCase("y");
        System.out.print("🔢 Enter desired password length (8–32): ");
        int length;

        try {
            length = Integer.parseInt(scanner.nextLine());
            if (length < 8 || length > 32) {
                System.out.println("⚠️ Length must be between 8 and 32.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid number format.");
            return;
        }

        if (!useUpper && !useLower && !useDigits && !useSymbols) {
            System.out.println("❌ You must select at least one character type to generate password.");
            return;
        }

        PasswordBuilder builder = new PasswordBuilder();
        String password = builder.generate(length, useUpper, useLower, useDigits, useSymbols);

        StrengthChecker checker = new StrengthChecker();
        String strength = checker.evaluate(password);

        System.out.println("\n🔑 Generated Password: " + password);
        System.out.println("💪 Strength: " + strengthBar(strength) + " (" + strength + ")");
    }

    private void checkStrengthFlow() {
        System.out.print("🔍 Enter a password to check its strength: ");
        String inputPassword = scanner.nextLine();

        StrengthChecker checker = new StrengthChecker();
        String strength = checker.evaluate(inputPassword);

        System.out.println("💪 Strength: " + strengthBar(strength) + " (" + strength + ")");
    }

    private void showUsefulInfo() {
        System.out.println();
        System.out.println("Use a minimum password length of 8 or more characters if permitted");
        System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
        System.out.println("Generate passwords randomly where feasible");
        System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
        System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences," +
                "\nusernames, relative or pet names, romantic links (current or past) " +
                "and biographical information (e.g., ID numbers, ancestors' names or dates).");
        System.out.println("Avoid using information that the user's colleagues and/or " +
                "acquaintances might know to be associated with the user");
        System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");
    }

    private String strengthBar(String strength) {
        switch (strength) {
            case "Weak": return "█░░";
            case "Medium": return "██░";
            case "Strong": return "███";
            default: return "░░░";
        }
    }
}
