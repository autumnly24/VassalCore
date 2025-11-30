package io.github.kawaiicakes.vassalcore.mixin.strawgolem;

import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import static net.minecraft.world.level.block.Blocks.BARRIER;

/**
 * Works only if Straw Golems mixes into here before this does.
 */
@SuppressWarnings("MixinAnnotationTarget")
@Mixin(value = CarvedPumpkinBlock.class, priority = 1337)
public abstract class CarvedPumpkinBlockMixin {
    /**
     * @author kawaiicakes
     * @reason pending figuring out how to disable other mixins, I'll just make the block pattern impossible to find
     */
    @Overwrite(remap = false)
    private BlockPattern getOrCreateStrawGolemFull() {
        return BlockPatternBuilder.start()
                .aisle("~")
                .where('~', BlockInWorld.hasState(BlockStatePredicate.forBlock(BARRIER)))
                .build();
    }

    /**
     * @author kawaiicakes
     * @reason pending figuring out how to disable other mixins, I'll just make the block pattern impossible to find
     */
    @Overwrite(remap = false)
    private BlockPattern getOrCreateStrawGolemBase() {
        return BlockPatternBuilder.start()
                .aisle("~")
                .where('~', BlockInWorld.hasState(BlockStatePredicate.forBlock(BARRIER)))
                .build();
    }
}
