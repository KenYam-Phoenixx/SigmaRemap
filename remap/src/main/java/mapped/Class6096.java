// 
// Decompiled by Procyon v0.6.0
// 

package mapped;

import com.google.gson.JsonObject;

public interface Class6096<T extends Class3662<?>>
{
    public static final Class6096<Class3664> field24733 = method18182("crafting_shaped", new Class6097());
    public static final Class6096<Class3679> field24734 = method18182("crafting_shapeless", new Class6099());
    public static final Class6095<Class3670> field24735 = method18182("crafting_special_armordye", new Class6095<Class3670>(Class3670::new));
    public static final Class6095<Class3676> field24736 = method18182("crafting_special_bookcloning", new Class6095<Class3676>(Class3676::new));
    public static final Class6095<Class3669> field24737 = method18182("crafting_special_mapcloning", new Class6095<Class3669>(Class3669::new));
    public static final Class6095<Class3665> field24738 = method18182("crafting_special_mapextending", new Class6095<Class3665>(Class3665::new));
    public static final Class6095<Class3674> field24739 = method18182("crafting_special_firework_rocket", new Class6095<Class3674>(Class3674::new));
    public static final Class6095<Class3678> field24740 = method18182("crafting_special_firework_star", new Class6095<Class3678>(Class3678::new));
    public static final Class6095<Class3671> field24741 = method18182("crafting_special_firework_star_fade", new Class6095<Class3671>(Class3671::new));
    public static final Class6095<Class3677> field24742 = method18182("crafting_special_tippedarrow", new Class6095<Class3677>(Class3677::new));
    public static final Class6095<Class3672> field24743 = method18182("crafting_special_bannerduplicate", new Class6095<Class3672>(Class3672::new));
    public static final Class6095<Class3667> field24744 = method18182("crafting_special_shielddecoration", new Class6095<Class3667>(Class3667::new));
    public static final Class6095<Class3673> field24745 = method18182("crafting_special_shulkerboxcoloring", new Class6095<Class3673>(Class3673::new));
    public static final Class6095<Class3668> field24746 = method18182("crafting_special_suspiciousstew", new Class6095<Class3668>(Class3668::new));
    public static final Class6095<Class3675> field24747 = method18182("crafting_special_repairitem", new Class6095<Class3675>(Class3675::new));
    public static final Class6098<Class3684> field24748 = method18182("smelting", new Class6098<Class3684>(Class3684::new, 200));
    public static final Class6098<Class3681> field24749 = method18182("blasting", new Class6098<Class3681>(Class3681::new, 100));
    public static final Class6098<Class3683> field24750 = method18182("smoking", new Class6098<Class3683>(Class3683::new, 100));
    public static final Class6098<Class3682> field24751 = method18182("campfire_cooking", new Class6098<Class3682>(Class3682::new, 100));
    public static final Class6096<Class3686> field24752 = method18182("stonecutting", new Class6100(Class3686::new));
    
    T method18179(final Class1932 p0, final JsonObject p1);
    
    T method18180(final Class1932 p0, final PacketBuffer p1);
    
    void method18181(final PacketBuffer p0, final T p1);
    
    default <S extends Class6096<T>, T extends Class3662<?>> S method18182(final String s, final S n) {
        return Class90.method511(Class90.field237, s, n);
    }
}
