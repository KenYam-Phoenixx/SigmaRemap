// 
// Decompiled by Procyon v0.6.0
// 

package mapped;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import java.io.IOException;

public class Class4264 implements IPacket<IClientPlayNetHandler>
{
    private static String[] field19131;
    private int field19132;
    private byte field19133;
    
    public Class4264() {
    }
    
    public Class4264(final Entity class399, final byte field19133) {
        this.field19132 = class399.getEntityId();
        this.field19133 = field19133;
    }
    
    @Override
    public void readPacketData(final PacketBuffer class8654) throws IOException {
        this.field19132 = class8654.readInt();
        this.field19133 = class8654.readByte();
    }
    
    @Override
    public void writePacketData(final PacketBuffer class8654) throws IOException {
        class8654.writeInt(this.field19132);
        class8654.writeByte(this.field19133);
    }
    
    public void method12764(final IClientPlayNetHandler class5800) {
        class5800.method17302(this);
    }
    
    public Entity method12799(final World class1847) {
        return class1847.getEntityByID(this.field19132);
    }
    
    public byte method12800() {
        return this.field19133;
    }
}
