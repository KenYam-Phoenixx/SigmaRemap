package mapped;

import com.mojang.datafixers.DSL;
import com.mojang.datafixers.DataFix;
import com.mojang.datafixers.TypeRewriteRule;
import com.mojang.datafixers.schemas.Schema;
import net.minecraft.util.datafix.TypeReferences;

public class Class9412 extends DataFix {
   public Class9412(Schema var1, boolean var2) {
      super(var1, var2);
   }

   public TypeRewriteRule makeRule() {
      return this.fixTypeEverywhereTyped(
         "OptionsForceVBOFix",
         this.getInputSchema().getType(TypeReferences.OPTIONS),
         var0 -> var0.update(DSL.remainderFinder(), var0x -> var0x.set("useVbo", var0x.createString("true")))
      );
   }
}
