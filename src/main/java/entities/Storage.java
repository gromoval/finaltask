package entities;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Storage {
    final String FILE_NAME = "hashmap.txt";
    private Map<String, Object> data = new HashMap<>();

    public Storage() {}

    public void putStorageData(String str, Object data)
    {
        this.data.put(str, data);
    }

//serialize
// надо проверить чтобы не достать то чего там нет
//    public Object getStorageData(String str)
//    {
//        if (data.get(str)) {
//
//        }
//        return data.get(str);
//        return null;
//    }

    public void removeStorageData(String str) {
        data.remove(str);
    }

    public void saveHashMapToFile() throws IOException {
        Files.write(Paths.get(FILE_NAME),
                data.entrySet().stream().map(k->k.getKey()+"\r\n"+k.getValue()).collect(Collectors.toList()),
                StandardCharsets.UTF_8);
    }

// а тут бахнуть через entryset. так вот не пашет
//    public void readHashMapFromFile() throws IOException {
//        Files.lines(Paths.get(FILE_NAME), StandardCharsets.UTF_8).forEach((k, v) -> {data.put(k, (Object) v);});
//    }
}