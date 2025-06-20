package net.squareshaper.slacrystaltrees;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.squareshaper.slacrystaltrees.datagen.ModModelProvider;
import net.squareshaper.slacrystaltrees.datagen.ModRecipeProvider;
import net.squareshaper.slacrystaltrees.datagen.ModRegistryDataGenerator;
import net.squareshaper.slacrystaltrees.world.ModConfiguredFeatures;
import net.squareshaper.slacrystaltrees.world.ModPlacedFeatures;

public class SLACrystalTreesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModRegistryDataGenerator::new);
	}

	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}
}
