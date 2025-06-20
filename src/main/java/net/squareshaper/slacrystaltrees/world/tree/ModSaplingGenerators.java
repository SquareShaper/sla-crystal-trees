package net.squareshaper.slacrystaltrees.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.squareshaper.slacrystaltrees.SLACrystalTrees;
import net.squareshaper.slacrystaltrees.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator CRYSTAL_TREE = new SaplingGenerator(SLACrystalTrees.MOD_ID + ":crystal_tree",
            Optional.empty(), Optional.of(ModConfiguredFeatures.CRYSTAL_TREE_KEY), Optional.empty());
}
