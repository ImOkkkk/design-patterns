package com.generator.refactor;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @author ImOkkkk
 * @date 2022/7/21 17:21
 * @since 1.0
 */
public class RandomIdGenerator implements LogTraceIdGenerator {
    private static final Logger logger = LoggerFactory.getLogger(RandomIdGenerator.class);

    @Override
    public String generate() throws IdGenerationFailureException {
        String id = "";
        String substrOfHostName = null;
        try {
            substrOfHostName = getLastFiledOfHostName();
        } catch (UnknownHostException e) {
            throw new IdGenerationFailureException("host name is empty.");
        }
        String randomString = generateRandomAlphameric(8);
        id = String.format("%s-%d-%s", substrOfHostName, System.currentTimeMillis(), randomString);
        return id;
    }

    /**
     * what：生成指定长度的随机字符串 why： how：
     *
     * @param length
     * @return
     */
    public String generateRandomAlphameric(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("...");
        }
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit || isUppercase || isLowercase) {
                randomChars[count] = (char) randomAscii;
                ++count;
            }
        }
        return new String(randomChars);
    }

    private String getLastFiledOfHostName() throws UnknownHostException {
        String substrOfHostName = null;
        String hostName = InetAddress.getLocalHost().getHostName();
        substrOfHostName = getLastSubstrSplittedByDot(hostName);
        return substrOfHostName;
    }

    public String getLastSubstrSplittedByDot(String hostName) {
        if (hostName == null || hostName.isEmpty()) {
            throw new IllegalArgumentException("..."); // 运行时异常
        }
        String[] tokens = hostName.split("\\.");
        String substrOfHostName = hostName;
        substrOfHostName = tokens[tokens.length - 1];
        return substrOfHostName;
    }
}
