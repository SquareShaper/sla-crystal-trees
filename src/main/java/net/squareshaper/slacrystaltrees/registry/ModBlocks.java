package net.squareshaper.slacrystaltrees.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.squareshaper.slacrystaltrees.SLACrystalTrees;

public class ModBlocks {
//    public static final Block SMOOTH_MAGMASTONE = registerBlock("smooth_magmastone",
//            new MagmaBlock(AbstractBlock.Settings.create()
//                    .sounds(BlockSoundGroup.BASALT).mapColor(MapColor.DARK_CRIMSON).strength(1.25F, 4.2F)
//                    .requiresTool().luminance(state -> 3)));
//
//    public static final Block MAGMASTONE = registerBlock("magmastone",
//            new MagmaPillarBlock(AbstractBlock.Settings.create()
//                    .sounds(BlockSoundGroup.BASALT).mapColor(MapColor.DARK_CRIMSON).strength(1.25F, 4.2F)
//                    .requiresTool().luminance(state -> 3)));


    public static void registerModBlocks() {
        SLACrystalTrees.LOGGER.info("Registering Mod Blocks for " + SLACrystalTrees.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
        });
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, SLACrystalTrees.id(name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, SLACrystalTrees.id(name),
                new BlockItem(block, new Item.Settings()));
    }
}
