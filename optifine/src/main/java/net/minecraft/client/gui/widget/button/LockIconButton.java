package net.minecraft.client.gui.widget.button;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

public class LockIconButton extends Button
{
    private boolean locked;

    public LockIconButton(int p_i392_1_, int p_i392_2_, Button.IPressable p_i392_3_)
    {
        super(p_i392_1_, p_i392_2_, 20, 20, I18n.format("narrator.button.difficulty_lock"), p_i392_3_);
    }

    protected String getNarrationMessage()
    {
        return super.getNarrationMessage() + ". " + (this.isLocked() ? I18n.format("narrator.button.difficulty_lock.locked") : I18n.format("narrator.button.difficulty_lock.unlocked"));
    }

    public boolean isLocked()
    {
        return this.locked;
    }

    public void setLocked(boolean lockedIn)
    {
        this.locked = lockedIn;
    }

    public void renderButton(int p_renderButton_1_, int p_renderButton_2_, float p_renderButton_3_)
    {
        Minecraft.getInstance().getTextureManager().bindTexture(Button.WIDGETS_LOCATION);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        LockIconButton.Icon lockiconbutton$icon;

        if (!this.active)
        {
            lockiconbutton$icon = this.locked ? LockIconButton.Icon.LOCKED_DISABLED : LockIconButton.Icon.UNLOCKED_DISABLED;
        }
        else if (this.isHovered())
        {
            lockiconbutton$icon = this.locked ? LockIconButton.Icon.LOCKED_HOVER : LockIconButton.Icon.UNLOCKED_HOVER;
        }
        else
        {
            lockiconbutton$icon = this.locked ? LockIconButton.Icon.LOCKED : LockIconButton.Icon.UNLOCKED;
        }

        this.blit(this.x, this.y, lockiconbutton$icon.getX(), lockiconbutton$icon.getY(), this.width, this.height);
    }

    static enum Icon
    {
        LOCKED(0, 146),
        LOCKED_HOVER(0, 166),
        LOCKED_DISABLED(0, 186),
        UNLOCKED(20, 146),
        UNLOCKED_HOVER(20, 166),
        UNLOCKED_DISABLED(20, 186);

        private final int x;
        private final int y;

        private Icon(int p_i2442_3_, int p_i2442_4_)
        {
            this.x = p_i2442_3_;
            this.y = p_i2442_4_;
        }

        public int getX()
        {
            return this.x;
        }

        public int getY()
        {
            return this.y;
        }
    }
}
