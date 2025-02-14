package mapped;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.util.Direction;

import java.util.List;
import java.util.Random;

public interface IBakedModel extends Class7205 {
   List<Class8557> method22619(BlockState var1, Direction var2, Random var3);

   boolean method22620();

   boolean method22621();

   boolean method22622();

   boolean method22623();

   TextureAtlasSprite getParticleTexture();

   default ItemCameraTransforms method22625() {
      return ItemCameraTransforms.DEFAULT;
   }

   Class6391 method22626();
}
