package io.github.kawaiicakes.potionnuke.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BrewingStandBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import javax.annotation.Nullable;

@Mixin(BrewingStandBlock.class)
public abstract class BrewingStandBlockMixin {
    /**
     * @author kawaiicakes
     * @reason NUKE Brewing Stand GUI/player interaction
     */
    @Overwrite
    public InteractionResult use(BlockState a, Level b, BlockPos c, Player d, InteractionHand e, BlockHitResult f) {
        return InteractionResult.FAIL;
    }

    /**
     * @author kawaiicakes
     * @reason NUKE Brewing Stand functionality
     */
    @Nullable
    @Overwrite
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level a, BlockState b, BlockEntityType<T> c) {
        return null;
    }

    /**
     * @author kawaiicakes
     * @reason this one I'm not really a fan of since I'm less certain of its side effects, but NUKEs Brewing Stand
     *          internal slots and functionality
     */
    @Nullable
    @Overwrite
    public BlockEntity newBlockEntity(BlockPos a, BlockState b) {
        return null;
    }
}
