package projectStart;

import view.ConsoleWork;
import view.ConsoleWorkImpl;

public class StartProgram {

    public static void main(String[] args) {
        ConsoleWorkImpl consoleWork = new ConsoleWork();
        System.out.println("Hello!");
        if ( consoleWork.enterIpForConsole()== true){
            consoleWork.printRangeIp();}
        System.out.println("You exit program.");
    }
}
