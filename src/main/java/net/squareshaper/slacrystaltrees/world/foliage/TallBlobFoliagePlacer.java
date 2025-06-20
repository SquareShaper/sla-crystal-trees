package net.squareshaper.slacrystaltrees.world.foliage;

import com.mojang.datafixers.Products;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.squareshaper.slacrystaltrees.datagen.ModRegistryDataGenerator;
import net.squareshaper.slacrystaltrees.world.ModConfiguredFeatures;

public class TallBlobFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<TallBlobFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            createCodec(instance).apply(instance, TallBlobFoliagePlacer::new));
    protected final int height;

    protected static <P extends TallBlobFoliagePlacer> Products.P3<RecordCodecBuilder.Mu<P>, IntProvider, IntProvider, Integer> createCodec(RecordCodecBuilder.Instance<P> builder) {
        return fillFoliagePlacerFields(builder).and(Codec.intRange(0, 256).fieldOf("height").forGetter(placer -> placer.height));
    }

    public TallBlobFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModConfiguredFeatures.TALL_BLOB_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        for (int y = offset; y <= foliageHeight - offset; y++) {
                int j = Math.min(Math.max(radius - (y - offset)/(foliageHeight/radius), 0),radius);
                this.generateSquare(world, placer, random, config, treeNode.getCenter(), j, y, treeNode.isGiantTrunk());
            }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return dx == radius && dz == radius && (random.nextInt(2) == 0 || y == 0);
    }
}
