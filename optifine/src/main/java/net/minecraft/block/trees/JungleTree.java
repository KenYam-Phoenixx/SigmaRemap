package net.minecraft.block.trees;

import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class JungleTree extends BigTree
{
    @Nullable
    protected ConfiguredFeature < TreeFeatureConfig, ? > getTreeFeature(Random randomIn, boolean p_225546_2_)
    {
        return (new TreeFeature(TreeFeatureConfig::func_227338_a_)).withConfiguration(DefaultBiomeFeatures.JUNGLE_SAPLING_TREE_CONFIG);
    }

    @Nullable
    protected ConfiguredFeature < HugeTreeFeatureConfig, ? > getHugeTreeFeature(Random p_225547_1_)
    {
        return Feature.MEGA_JUNGLE_TREE.withConfiguration(DefaultBiomeFeatures.MEGA_JUNGLE_TREE_CONFIG);
    }
}
