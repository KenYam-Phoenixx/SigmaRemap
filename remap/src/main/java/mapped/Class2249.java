// 
// Decompiled by Procyon v0.6.0
// 

package mapped;

import java.util.Iterator;
import javax.annotation.Nullable;

public class Class2249 implements Iterable<BlockState>
{
    private static String[] field13787;
    public static final BlockState field13788;
    private final Class94<BlockState> field13789;
    private int field13790;
    
    private Class2249() {
        this.field13789 = new Class94<BlockState>(16);
    }
    
    public int method8452(final BlockState class7096) {
        int method563 = this.field13789.method563(class7096);
        if (method563 == -1) {
            method563 = this.field13790++;
            this.field13789.method561(class7096, method563);
        }
        return method563;
    }
    
    @Nullable
    public BlockState method8453(final int n) {
        final BlockState class7096 = this.field13789.method499(n);
        return (class7096 != null) ? class7096 : Class2249.field13788;
    }
    
    @Override
    public Iterator<BlockState> iterator() {
        return this.field13789.iterator();
    }
    
    public void method8454(final BlockState class7096, final int n) {
        this.field13789.method561(class7096, n);
    }
    
    static {
        field13788 = Blocks.AIR.getDefaultState();
    }
}
