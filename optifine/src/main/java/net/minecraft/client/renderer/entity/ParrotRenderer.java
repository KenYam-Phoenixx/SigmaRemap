package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.model.ParrotModel;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class ParrotRenderer extends MobRenderer<ParrotEntity, ParrotModel>
{
    public static final ResourceLocation[] PARROT_TEXTURES = new ResourceLocation[] {new ResourceLocation("textures/entity/parrot/parrot_red_blue.png"), new ResourceLocation("textures/entity/parrot/parrot_blue.png"), new ResourceLocation("textures/entity/parrot/parrot_green.png"), new ResourceLocation("textures/entity/parrot/parrot_yellow_blue.png"), new ResourceLocation("textures/entity/parrot/parrot_grey.png")};

    public ParrotRenderer(EntityRendererManager p_i1510_1_)
    {
        super(p_i1510_1_, new ParrotModel(), 0.3F);
    }

    public ResourceLocation getEntityTexture(ParrotEntity entity)
    {
        return PARROT_TEXTURES[entity.getVariant()];
    }

    public float handleRotationFloat(ParrotEntity livingBase, float partialTicks)
    {
        float f = MathHelper.lerp(partialTicks, livingBase.oFlap, livingBase.flap);
        float f1 = MathHelper.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.flapSpeed);
        return (MathHelper.sin(f) + 1.0F) * f1;
    }
}
