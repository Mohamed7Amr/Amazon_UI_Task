package dataWriter;

import lombok.SneakyThrows;

import java.io.FileWriter;
import java.util.Properties;

public class TestData_PropertiesFile_Writer {

    @SneakyThrows
    public static void write_Properties(String file_Path, String key, String value)
    {
        Properties pro = new Properties();
        pro.setProperty(key,value);
        pro.store(new FileWriter(file_Path),null);
    }
}
