package com.epam.repair.utils;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TestUtils {
    public static String loadTestFile(String loadFile) throws IOException {
        return FileUtils.readFileToString(
                FileUtils.toFile(TestUtils.class.getClassLoader().getResource(loadFile)), StandardCharsets.UTF_8);
    }
}