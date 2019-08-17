package view;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class ConsoleWorkTest {
    private ConsoleWork consoleWork;

    @Before
    public void setUp() throws Exception {
        consoleWork = new ConsoleWork();
    }

    @Test
    public void enterIpForConsole() {
        InputStream in1 = new ByteArrayInputStream("1.1.1.0\n1.1.1.1".getBytes());
        System.setIn(in1);
        boolean enterMessage= consoleWork.enterIpForConsole();
        assertTrue(enterMessage);
    }

    @Test
    public void checkForIp() {
        String expected = "192.168.1.1";
        boolean actual = consoleWork.checkForIp(expected);
        assertTrue(actual);
    }
}