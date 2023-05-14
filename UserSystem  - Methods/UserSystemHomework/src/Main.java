import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String[][] usersData = new String[4][2];

        // main loop
        while (!command.equals("end")) {
            String[] commandArgs = command.split(" ");
            switch (commandArgs[0]) {

                case "register":
                    caseRegister(usersData, commandArgs);
                    break;

                case "delete":
                    caseDelete(usersData, commandArgs);
            }

            // read next command
            command = scanner.nextLine();
        }
    }

    //METHOD FOR REGISTER CASE
    public static void caseRegister(String[][] usersData, String[] commandArgs) {
        // validate arguments
        if (commandArgs.length < 3) {
            System.out.println(textRed() + "Too few parameters." + textReset());
            return;
        }

        String username = commandArgs[1];
        String password = commandArgs[2];

        // validate username
        if (username.length() < 3) {
            System.out.println(textRed() + "Username must be at least 3 characters long." + textReset());
            return;
        }

        // validate password
        if (password.length() < 3) {
            System.out.println(textRed() + "Password must be at least 3 characters long." + textReset());
            return;
        }

        // check if username exists
        boolean usernameExists = false;
        for (int i = 0; i < usersData.length; i++) {
            if (username.equals(usersData[i][0])) {
                usernameExists = true;
            }
        }

        if (usernameExists) {
            System.out.println(textRed() + "Username already exists." + textReset());
            return;
        }

        // find free slot
        int freeSlotIndex = -1;
        for (int i = 0; i < usersData.length; i++) {
            if (usersData[i][0] == null) {
                freeSlotIndex = i;
            }
        }

        // no free slots
        if (freeSlotIndex == -1) {
            System.out.println(textRed() + "The system supports a maximum number of 4 users." + textReset());
            return;
        }

        // save user
        usersData[freeSlotIndex][0] = username;
        usersData[freeSlotIndex][1] = password;

        System.out.println(textGreen() + "Registered user." + textReset());

    }

    //METHOD FOR DELETE CASE
    public static void caseDelete(String[][] usersData, String[] commandArgs) {
        // validate arguments
        if (commandArgs.length < 3) {
            System.out.println(textRed() + "Too few parameters." + textReset());
            return;
        }

        String username = commandArgs[1];
        String password = commandArgs[2];

        // validate username
        if (username.length() < 3) {
            System.out.println(textRed() + "Username must be at least 3 characters long" + textReset());
            return;
        }

        // validate password
        if (password.length() < 3) {
            System.out.println(textRed() + "Password must be at least 3 characters long." + textReset());
            return;
        }

        // find account to delete
        int accountIndex = -1;
        for (int i = 0; i < usersData.length; i++) {
            if (username.equals(usersData[i][0]) && password.equals(usersData[i][1])) {
                accountIndex = i;
            }
        }

        if (accountIndex == -1) {
            System.out.println(textRed() + "Invalid account/password." + textReset());
            return;
        }

        usersData[accountIndex][0] = null;
        usersData[accountIndex][1] = null;

        System.out.println(textGreen() + "Deleted account." + textReset());

    }

    //METHODS FOR TEXT COLORS
    public static String textReset() {
        String ANSI_RESET = "\u001B[0m";
        return ANSI_RESET;
    }

    public static String textBlack() {
        String ANSI_BLACK = "\u001B[30m";
        return ANSI_BLACK;
    }

    public static String textRed() {
        String ANSI_RED = "\u001B[31m";
        return ANSI_RED;
    }

    public static String textGreen() {
        String ANSI_GREEN = "\u001B[32m";
        return ANSI_GREEN;
    }

}
