package net.minecraft.entity.player;

import java.util.Arrays;
import java.util.Comparator;
import net.minecraft.util.math.MathHelper;

public enum ChatVisibility
{
    FULL(0, "options.chat.visibility.full"),
    SYSTEM(1, "options.chat.visibility.system"),
    HIDDEN(2, "options.chat.visibility.hidden");

    private static final ChatVisibility[] field_221255_d = Arrays.stream(values()).sorted(Comparator.comparingInt(ChatVisibility::getId)).toArray((p_221253_0_) -> {
        return new ChatVisibility[p_221253_0_];
    });
    private final int id;
    private final String resourceKey;

    private ChatVisibility(int p_i2333_3_, String p_i2333_4_)
    {
        this.id = p_i2333_3_;
        this.resourceKey = p_i2333_4_;
    }

    public int getId()
    {
        return this.id;
    }

    public String getResourceKey()
    {
        return this.resourceKey;
    }

    public static ChatVisibility getValue(int p_221252_0_)
    {
        return field_221255_d[MathHelper.normalizeAngle(p_221252_0_, field_221255_d.length)];
    }
}
