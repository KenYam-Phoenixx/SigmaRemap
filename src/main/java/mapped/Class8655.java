package mapped;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.ClickEvent$Action;
import net.minecraft.util.text.event.HoverEvent;

public class Class8655 extends DamageSource {
   public Class8655() {
      super("badRespawnPoint");
      this.method31143();
      this.method31132();
   }

   @Override
   public ITextComponent method31110(LivingEntity var1) {
      IFormattableTextComponent var4 = TextComponentUtils.wrapWithSquareBrackets(new TranslationTextComponent("death.attack.badRespawnPoint.link"))
         .modifyStyle(
            var0 -> var0.setClickEvent(new ClickEvent(ClickEvent$Action.OPEN_URL, "https://bugs.mojang.com/browse/MCPE-28723"))
                  .setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent("MCPE-28723")))
         );
      return new TranslationTextComponent("death.attack.badRespawnPoint.message", var1.getDisplayName(), var4);
   }
}
