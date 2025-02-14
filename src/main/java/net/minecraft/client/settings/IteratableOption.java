package net.minecraft.client.settings;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import net.minecraft.client.AbstractOption;
import net.minecraft.client.GameSettings;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.OptionButton;
import net.minecraft.util.text.ITextComponent;

public class IteratableOption extends AbstractOption {
   public BiConsumer<GameSettings, Integer> field25313;
   public BiFunction<GameSettings, IteratableOption, ITextComponent> field25314;

   public IteratableOption(String var1, BiConsumer<GameSettings, Integer> var2, BiFunction<GameSettings, IteratableOption, ITextComponent> var3) {
      super(var1);
      this.field25313 = var2;
      this.field25314 = var3;
   }

   public void method17945(GameSettings var1, int var2) {
      this.field25313.accept(var1, var2);
      var1.saveOptions();
   }

   @Override
   public Widget createWidget(GameSettings var1, int var2, int var3, int var4) {
      return new OptionButton(var2, var3, var4, 20, this, this.method17947(var1), var2x -> {
         this.method17945(var1, 1);
         var2x.setMessage(this.method17947(var1));
      });
   }

   public ITextComponent method17947(GameSettings var1) {
      return this.field25314.apply(var1, this);
   }
}
