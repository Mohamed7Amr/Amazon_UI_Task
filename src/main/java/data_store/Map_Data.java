package data_store;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Map_Data {

    /***************************************DECLARATIONS/INSTANTIATIONS***************************************/
    public static Map<String, LinkedList<Double>> flow_Data = new HashMap<>();
    public static LinkedList<Double> key_Values = new LinkedList<>();

    /**********************************************METHODS**************************************************/
    public static void add_Map_Key_Data(String key,double item_Value)
    {
        key_Values.add(item_Value);
        flow_Data.put(key,key_Values);
    }
    public static Double get_Map_Key_Data(String key, int index_Item_In_LinkedList)
    {
        return flow_Data.get(key).get(index_Item_In_LinkedList);
    }
}
