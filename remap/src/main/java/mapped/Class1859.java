// 
// Decompiled by Procyon v0.6.0
// 

package mapped;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public enum Class1859 implements IBlockReader
{
    field10138;
    
    @Nullable
    @Override
    public TileEntity getTileEntity(final BlockPos class354) {
        return null;
    }
    
    @Override
    public BlockState getBlockState(final BlockPos class354) {
        return Blocks.AIR.getDefaultState();
    }
    
    @Override
    public IFluidState getFluidState(final BlockPos class354) {
        return Class7558.field29974.getDefaultState();
    }
}
