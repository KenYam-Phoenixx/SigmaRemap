// 
// Decompiled by Procyon v0.6.0
// 

package mapped;

import java.io.IOException;

public class Class4389 implements IPacket<Class5813>
{
    private static String[] field19664;
    private int field19665;
    
    public Class4389() {
    }
    
    public Class4389(final int field19665) {
        this.field19665 = field19665;
    }
    
    public void method12756(final Class5813 class5813) {
        class5813.method17425(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer class8654) throws IOException {
        this.field19665 = class8654.readByte();
    }
    
    @Override
    public void writePacketData(final PacketBuffer class8654) throws IOException {
        class8654.writeByte(this.field19665);
    }
}
