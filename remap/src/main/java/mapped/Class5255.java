// 
// Decompiled by Procyon v0.6.0
// 

package mapped;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Class5255
{
    private static final String field22284 = "_placeholder";
    private static final String field22285 = "num";
    private static final Logger field22286;
    
    public static Class7845 method16358(final Class9041 field32127) {
        final ArrayList list = new ArrayList();
        field32127.field38266 = (T)method16359(field32127.field38266, list);
        field32127.field38267 = list.size();
        final Class7845 class7845 = new Class7845();
        class7845.field32127 = field32127;
        class7845.field32128 = (byte[][])list.toArray(new byte[list.size()][]);
        return class7845;
    }
    
    private static Object method16359(final Object o, final List<byte[]> list) {
        if (o == null) {
            return null;
        }
        if (o instanceof byte[]) {
            final JSONObject JSONObject = new JSONObject();
            try {
                JSONObject.method13295("_placeholder", true);
                JSONObject.method13298("num", list.size());
            }
            catch (final JSONException thrown) {
                Class5255.field22286.log(Level.WARNING, "An error occured while putting data to JSONObject", thrown);
                return null;
            }
            list.add((byte[])o);
            return JSONObject;
        }
        if (o instanceof Class88) {
            final Class88 class4406 = new Class88();
            final Class88 class4407 = (Class88)o;
            for (int method462 = class4407.method462(), i = 0; i < method462; ++i) {
                try {
                    class4406.method493(i, method16359(class4407.method449(i), list));
                }
                catch (final JSONException thrown2) {
                    Class5255.field22286.log(Level.WARNING, "An error occured while putting packet data to JSONObject", thrown2);
                    return null;
                }
            }
            return class4406;
        }
        if (o instanceof JSONObject) {
            final JSONObject class4408 = new JSONObject();
            final JSONObject class4409 = (JSONObject)o;
            final Iterator<String> method463 = class4409.method13272();
            while (method463.hasNext()) {
                final String s = method463.next();
                try {
                    class4408.method13301(s, method16359(class4409.get(s), list));
                }
                catch (final JSONException thrown3) {
                    Class5255.field22286.log(Level.WARNING, "An error occured while putting data to JSONObject", thrown3);
                    return null;
                }
            }
            return class4408;
        }
        return o;
    }
    
    public static Class9041 method16360(final Class9041 class9041, final byte[][] array) {
        class9041.field38266 = (T)method16361(class9041.field38266, array);
        class9041.field38267 = -1;
        return class9041;
    }
    
    private static Object method16361(final Object o, final byte[][] array) {
        if (o instanceof Class88) {
            final Class88 class88 = (Class88)o;
            for (int method462 = class88.method462(), i = 0; i < method462; ++i) {
                try {
                    class88.method493(i, method16361(class88.method449(i), array));
                }
                catch (final JSONException thrown) {
                    Class5255.field22286.log(Level.WARNING, "An error occured while putting packet data to JSONObject", thrown);
                    return null;
                }
            }
            return class88;
        }
        if (!(o instanceof JSONObject)) {
            return o;
        }
        final JSONObject class89 = (JSONObject)o;
        if (class89.method13280("_placeholder")) {
            final int method463 = class89.method13287("num", -1);
            return (method463 >= 0 && method463 < array.length) ? array[method463] : null;
        }
        final Iterator<String> method464 = class89.method13272();
        while (method464.hasNext()) {
            final String s = method464.next();
            try {
                class89.method13301(s, method16361(class89.get(s), array));
            }
            catch (final JSONException thrown2) {
                Class5255.field22286.log(Level.WARNING, "An error occured while putting data to JSONObject", thrown2);
                return null;
            }
        }
        return class89;
    }
    
    static {
        field22286 = Logger.getLogger(Class5255.class.getName());
    }
}
