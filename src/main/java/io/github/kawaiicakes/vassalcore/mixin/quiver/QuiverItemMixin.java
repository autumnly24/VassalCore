package io.github.kawaiicakes.vassalcore.mixin.quiver;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.oblivioussp.spartanweaponry.item.BoltItem;
import net.mehvahdjukaar.supplementaries.common.items.QuiverItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = QuiverItem.class, remap = false)
public abstract class QuiverItemMixin {
    @WrapMethod(method = "canAcceptItem")
    private static boolean canAcceptItemMod(ItemStack toInsert, Operation<Boolean> original) {
        return toInsert.getItem() instanceof BoltItem || original.call(toInsert);
    }
}
