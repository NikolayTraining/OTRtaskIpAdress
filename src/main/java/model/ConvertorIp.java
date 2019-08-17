package model;

public class ConvertorIp implements ConvertorIpImpl{

    @Override
    public long ipToLong(String ip) {
        String[] ipSplit = ip.split("\\.");
        long longIp = 0;
        for (int i = 0; i < ipSplit.length; i++) {
            longIp += Integer.parseInt(ipSplit[i]) * Math.pow(256, 3 - i);
        }
        return longIp;
    }

    @Override
    public String longToIp(long longIp) {
        return ((longIp >> 24) & 0xFF) + "." +

                ((longIp >> 16) & 0xFF) + "." +

                ((longIp >> 8) & 0xFF) + "." +

                (longIp & 0xFF);
    }
}
