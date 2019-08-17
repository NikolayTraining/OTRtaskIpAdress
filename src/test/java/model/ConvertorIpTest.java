package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class ConvertorIpTest {
    private ConvertorIp convertorIp;

    @Before
    public void setUp() throws Exception {
        convertorIp = new ConvertorIp();
    }

    @Test
    public void ipToLong() {
        long expected = 3232235521L;
        String expected1 = "192.168.0.1";
        long actual = convertorIp.ipToLong(expected1);
        assertEquals(expected,actual);
    }

    @Test
    public void longToIp() {
        String expected = "192.168.0.1";
        long expected1 = 3232235521L;
        String actual = convertorIp.longToIp(expected1);
        assertEquals("Unexpected string value",expected,actual);
    }
}