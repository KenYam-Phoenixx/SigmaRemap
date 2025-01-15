package net.minecraft.client.resources.data;

public class TextureMetadataSection
{
    public static final TextureMetadataSectionSerializer SERIALIZER = new TextureMetadataSectionSerializer();
    private final boolean textureBlur;
    private final boolean textureClamp;

    public TextureMetadataSection(boolean p_i3751_1_, boolean p_i3751_2_)
    {
        this.textureBlur = p_i3751_1_;
        this.textureClamp = p_i3751_2_;
    }

    public boolean getTextureBlur()
    {
        return this.textureBlur;
    }

    public boolean getTextureClamp()
    {
        return this.textureClamp;
    }
}
