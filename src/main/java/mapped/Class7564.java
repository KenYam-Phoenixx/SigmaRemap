package mapped;

import com.google.common.collect.Streams;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateContainer;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Class7564 implements Class7562 {
   private static String[] field32492;
   private final Iterable<? extends Class7562> field32493;

   public Class7564(Iterable<? extends Class7562> var1) {
      this.field32493 = var1;
   }

   @Override
   public Predicate<BlockState> method24750(StateContainer<Block, BlockState> var1) {
      List<Predicate<BlockState>> var4 = Streams.stream(this.field32493).<Predicate<BlockState>>map(var1x -> var1x.method24750(var1)).collect(Collectors.toList());
      return var1x -> var4.stream().anyMatch(var1xx -> var1xx.test(var1x));
   }
}
