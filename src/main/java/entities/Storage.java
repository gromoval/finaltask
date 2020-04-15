package entities;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static List<Object> data = new ArrayList<>();

    public Storage()
    {
        data.clear();
    }

    public Storage(Object data)
    {
        this.data.add(data);
    }

    public void setStorageData(Object data)
    {
        this.data.add(data);
    }

    public Object getStorageData(Object data)
    {
        for (Object dataf:this.data) {
            if (dataf.equals(data)) {
                return dataf;
            }
        }
        return null;
    }

    public Object removeStorageData(Object data)
    {
        return this.data.remove(data);
    }
}
