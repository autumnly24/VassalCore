package io.github.kawaiicakes.vassalcore.mixin.shearing;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Sheep.class)
public abstract class SheepMixin {
    @Unique
    private static final ResourceLocation RAW_WOOL = new ResourceLocation("vassal", "raw_wool");

    @WrapOperation(
            method = "onSheared",
            at = @At(
                    value = "NEW",
                    target = "(Lnet/minecraft/world/level/ItemLike;)Lnet/minecraft/world/item/ItemStack;"
            )
    )
    private ItemStack rawWoolShearing(ItemLike itemLike, Operation<ItemStack> original) {
        original.call(itemLike);
        return ForgeRegistries.ITEMS.getValue(RAW_WOOL).getDefaultInstance();
    }
}
