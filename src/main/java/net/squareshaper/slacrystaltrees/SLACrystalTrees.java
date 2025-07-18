package net.squareshaper.slacrystaltrees;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import net.squareshaper.slacrystaltrees.registry.ModBlocks;
import net.squareshaper.slacrystaltrees.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLACrystalTrees implements ModInitializer {
	public static final String MOD_ID = "sla-crystal-trees";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Identifier id(String name){
		return Identifier.of(MOD_ID, name);
	}

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModWorldGeneration.generateModWorldGen();
	}
}