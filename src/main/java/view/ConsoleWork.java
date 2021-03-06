package view;

import model.ConvertorIp;
import model.ConvertorIpImpl;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleWork implements ConsoleWorkImpl {
    private String messageConsole = null;
    private String oneIp = null;
    private String twoIp = null;
    private String messageExit = "exit";
    private long oneIpValue = 0;
    private long twoIpValue = 0;
    private ConvertorIpImpl convertorIp = new ConvertorIp();

        @Override
    public boolean enterIpForConsole() {
        messageConsole = null;
        try (Scanner scanner = new Scanner(System.in)) {
            while (!messageExit.equalsIgnoreCase(messageConsole)) {
                System.out.println("If you want to exit, enter: 'exit' ");
                if (oneIp != null) {
                    System.out.println("IP " + oneIp + " ~ Enter range IP address: ");
                    messageConsole = scanner.nextLine();
                } else {
                    System.out.println("Enter range IP address: ");
                    messageConsole = scanner.nextLine();
                }
                if (messageExit.equalsIgnoreCase(messageConsole)){
                    return false;
                }
                if (checkForIp(messageConsole) == true) {
                    if (oneIp != null) {
                        twoIp = messageConsole;
                        return true;
                    } else {
                        oneIp = messageConsole;
                    }
                    System.out.println("Ip address: " + messageConsole);
                } else {
                    System.out.println("Ip address is not correct!!!");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public void printRangeIp() {
        if (!oneIp.equals(null) && !twoIp.equals(null)) {
            oneIpValue = convertorIp.ipToLong(oneIp);
            twoIpValue = convertorIp.ipToLong(twoIp);
            if (oneIpValue - twoIpValue > 0) {
                System.out.println("oneIpValue - twoIpValue = " + (oneIpValue - twoIpValue));
                System.out.println("IP: " + twoIp + " ~ " + oneIp);
                for (int ii = 0; ii < (oneIpValue - twoIpValue) - 1; ii++) {
                    System.out.println(convertorIp.longToIp(twoIpValue + ii + 1));
                }
            } else {
                System.out.println(" Amount = " + (twoIpValue - oneIpValue));
                System.out.println("IP: " + oneIp + " ~ " + twoIp);
                for (int ii = 0; ii < (twoIpValue - oneIpValue) - 1; ii++) {
                    System.out.println(convertorIp.longToIp(oneIpValue + ii + 1));
                }
            }
            if (Math.abs(twoIpValue - oneIpValue) < 2) {
                System.out.println("No valid addresses!!!");
            }
        }

    }

    public boolean checkForIp(String s) {
        Pattern delimiterPattern = Pattern.compile("^(([1-9]?\\d|1\\d\\d|2[0-5][0-5]|2[0-4]\\d)\\.)" +
                "{3}([1-9]?\\d|1\\d\\d|2[0-5][0-5]|2[0-4]\\d)$");
        Matcher matcher = delimiterPattern.matcher(s);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

}
