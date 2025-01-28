package mapped;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.block.JigsawBlock;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.JigsawTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.jigsaw.JigsawOrientation;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Class7490 extends Class7487 {
   public static final Codec<Class7490> field32190 = RecordCodecBuilder.create(
      var0 -> var0.group(ConfiguredFeature.field33883.fieldOf("feature").forGetter(var0x -> var0x.field32191), method24379()).apply(var0, Class7490::new)
   );
   private final Supplier<ConfiguredFeature<?, ?>> field32191;
   private final CompoundNBT field32192;

   public Class7490(Supplier<ConfiguredFeature<?, ?>> var1, Class109 var2) {
      super(var2);
      this.field32191 = var1;
      this.field32192 = this.method24414();
   }

   private CompoundNBT method24414() {
      CompoundNBT var3 = new CompoundNBT();
      var3.putString("name", "minecraft:bottom");
      var3.putString("final_state", "minecraft:air");
      var3.putString("pool", "minecraft:empty");
      var3.putString("target", "minecraft:empty");
      var3.putString("joint", JigsawTileEntity.OrientationType.ROLLABLE.getString());
      return var3;
   }

   public BlockPos method24415(TemplateManager var1, Rotation var2) {
      return BlockPos.ZERO;
   }

   @Override
   public List<Class8266> method24374(TemplateManager var1, BlockPos var2, Rotation var3, Random var4) {
      ArrayList var7 = Lists.newArrayList();
      var7.add(
         new Class8266(
            var2,
            Blocks.JIGSAW.getDefaultState().with(JigsawBlock.field18712, JigsawOrientation.method526(Direction.DOWN, Direction.SOUTH)),
            this.field32192
         )
      );
      return var7;
   }

   @Override
   public MutableBoundingBox method24375(TemplateManager var1, BlockPos var2, Rotation var3) {
      BlockPos var6 = this.method24415(var1, var3);
      return new MutableBoundingBox(
         var2.getX(),
         var2.getY(),
         var2.getZ(),
         var2.getX() + var6.getX(),
         var2.getY() + var6.getY(),
         var2.getZ() + var6.getZ()
      );
   }

   @Override
   public boolean method24376(
           TemplateManager var1, ISeedReader var2, StructureManager var3, ChunkGenerator var4, BlockPos var5, BlockPos var6, Rotation var7, MutableBoundingBox var8, Random var9, boolean var10
   ) {
      return this.field32191.get().func_242765_a(var2, var4, var9, var5);
   }

   @Override
   public Class8325<?> method24377() {
      return Class8325.field35772;
   }

   @Override
   public String toString() {
      return "Feature[" + Registry.FEATURE.getKey(this.field32191.get().method26518()) + "]";
   }
}
