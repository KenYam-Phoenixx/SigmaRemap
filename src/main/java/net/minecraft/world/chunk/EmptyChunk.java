package net.minecraft.world.chunk;

import mapped.Chunk;
import mapped.ChunkHolderLocationType;
import mapped.Class2206;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Util;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeContainer;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraft.world.lighting.WorldLightManager;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class EmptyChunk extends Chunk {
   private static final Biome[] field9135 = Util.<Biome[]>make(
      new Biome[BiomeContainer.field9154], var0 -> Arrays.fill(var0, BiomeRegistry.PLAINS)
   );

   public EmptyChunk(World var1, ChunkPos var2) {
      super(var1, var2, new BiomeContainer(var1.func_241828_r().<Biome>getRegistry(Registry.BIOME_KEY), field9135));
   }

   @Override
   public BlockState getBlockState(BlockPos var1) {
      return Blocks.VOID_AIR.getDefaultState();
   }

   @Nullable
   @Override
   public BlockState setBlockState(BlockPos var1, BlockState var2, boolean var3) {
      return null;
   }

   @Override
   public FluidState getFluidState(BlockPos var1) {
      return Fluids.EMPTY.method25049();
   }

   @Nullable
   @Override
   public WorldLightManager method7131() {
      return null;
   }

   @Override
   public int getLightValue(BlockPos var1) {
      return 0;
   }

   @Override
   public void addEntity(Entity var1) {
   }

   @Override
   public void removeEntity(Entity var1) {
   }

   @Override
   public void removeEntityAtIndex(Entity var1, int var2) {
   }

   @Nullable
   @Override
   public TileEntity method7029(BlockPos var1, Class2206 var2) {
      return null;
   }

   @Override
   public void method7135(TileEntity var1) {
   }

   @Override
   public void addTileEntity(BlockPos var1, TileEntity var2) {
   }

   @Override
   public void removeTileEntity(BlockPos var1) {
   }

   @Override
   public void method7137() {
   }

   @Override
   public void method7138(Entity var1, AxisAlignedBB var2, List<Entity> var3, Predicate<? super Entity> var4) {
   }

   @Override
   public <T extends Entity> void method7140(Class<? extends T> var1, AxisAlignedBB var2, List<T> var3, Predicate<? super T> var4) {
   }

   @Override
   public boolean isEmpty() {
      return true;
   }

   @Override
   public boolean isEmptyBetween(int var1, int var2) {
      return true;
   }

   @Override
   public ChunkHolderLocationType getLocationType() {
      return ChunkHolderLocationType.field167;
   }
}
