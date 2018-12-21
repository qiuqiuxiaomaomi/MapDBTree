import org.eclipse.collections.api.factory.map.strategy.MutableHashingStrategyMapFactory;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import java.io.File;
import java.util.concurrent.ConcurrentMap;

public class MapDBApplication {

    public static void main(String[] args){
        DB db = DBMaker.fileDB(new File("Bonaparte3.db")).closeOnJvmShutdown().make();
        try {
            ConcurrentMap<String, String> hashMap = db.hashMap("map12")
                    .keySerializer(Serializer.STRING)
                    .valueSerializer(Serializer.STRING)
                    .layout(64, 64, 4)
                    .createOrOpen();
            hashMap.put("123", "567");
            db.commit();
            String value = hashMap.get("123");
            System.out.println("value:" + value);
            hashMap.put("235", "abc");
            db.rollback();
            value = hashMap.get("235");
            System.out.println("value2:" + value);
            db.close();
        }catch (Exception e){

        }finally{

        }
    }
}
