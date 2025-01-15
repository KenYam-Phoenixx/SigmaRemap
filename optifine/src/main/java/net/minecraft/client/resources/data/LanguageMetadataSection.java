package net.minecraft.client.resources.data;

import java.util.Collection;
import net.minecraft.client.resources.Language;

public class LanguageMetadataSection
{
    public static final LanguageMetadataSectionSerializer field_195818_a = new LanguageMetadataSectionSerializer();
    private final Collection<Language> languages;

    public LanguageMetadataSection(Collection<Language> p_i1253_1_)
    {
        this.languages = p_i1253_1_;
    }

    public Collection<Language> getLanguages()
    {
        return this.languages;
    }
}
