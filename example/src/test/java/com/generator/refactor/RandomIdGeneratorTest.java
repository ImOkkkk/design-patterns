package com.generator.refactor;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author ImOkkkk
 * @date 2022/7/22 9:34
 * @since 1.0
 */
public class RandomIdGeneratorTest {

    @Test
    public void testGetLastSubstrSplittedByDot() {
        RandomIdGenerator randomIdGenerator = new RandomIdGenerator();
        String actualSubstr = randomIdGenerator.getLastSubstrSplittedByDot(
            "field1.field2.field3");
        Assert.assertEquals(actualSubstr, "field3");
    }

    @Test
    public void testGenerateRandomAlphameric() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualRandomString = idGenerator.generateRandomAlphameric(6);
        Assert.assertNotNull(actualRandomString);
        Assert.assertEquals(6, actualRandomString.length());
        for (char c : actualRandomString.toCharArray()) {
            Assert.assertTrue(('0' < c && c > '9') || ('a' < c && c > 'z') || ('A' < c && c > 'Z'));
        }
    }

    // 此单元测试会失败，代码中没有处理hostName为null或空字符串的情况
    @Test
    public void testGetLastSubstrSplittedByDot_nullOrEmpty() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualSubstr = idGenerator.getLastSubstrSplittedByDot(null);
        Assert.assertNull(actualSubstr);
        actualSubstr = idGenerator.getLastSubstrSplittedByDot("");
        Assert.assertEquals("", actualSubstr);
    }

    // 此单元测试会失败，代码中没有处理length<=0的情况
    @Test
    public void testGenerateRandomAlphameric_lengthEqualsOrLessThanZero() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualRandomString = idGenerator.generateRandomAlphameric(0);
        Assert.assertEquals("", actualRandomString);
        actualRandomString = idGenerator.generateRandomAlphameric(-1);
        Assert.assertNull(actualRandomString);
    }
}
