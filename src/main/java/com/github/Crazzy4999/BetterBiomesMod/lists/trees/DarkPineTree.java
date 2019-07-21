package com.github.Crazzy4999.BetterBiomesMod.lists.trees;

import java.util.Random;

import javax.annotation.Nullable;

import com.github.Crazzy4999.BetterBiomesMod.world.gen.feature.DarkPineTreeFeature;
import com.github.Crazzy4999.BetterBiomesMod.world.gen.feature.MegaDarkPineTree;

import net.minecraft.block.trees.BigTree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class DarkPineTree extends BigTree {
   @Nullable
   protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
      return new DarkPineTreeFeature(NoFeatureConfig::deserialize, true);
   }

   @Nullable
   protected AbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random random) {
      return new MegaDarkPineTree(NoFeatureConfig::deserialize, false, random.nextBoolean());
   }
}