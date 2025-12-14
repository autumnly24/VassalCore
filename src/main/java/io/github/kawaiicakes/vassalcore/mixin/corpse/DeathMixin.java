package io.github.kawaiicakes.vassalcore.mixin.corpse;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import de.maxhenkel.corpse.corelib.death.Death;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import nuparu.tinyinv.world.item.FakeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Death.class)
public abstract class DeathMixin {
    @WrapOperation(
            method = "fromPlayer",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/core/NonNullList;set(ILjava/lang/Object;)Ljava/lang/Object;"
            )
    )
    private static Object removeTinyInvItems(
            NonNullList<Object> instance, int slot, Object stack, Operation<Object> returnOfSet
    ) {
        Object original = returnOfSet.call(instance, slot, stack);

        if (!(stack instanceof ItemStack itemStack) || !(itemStack.getItem() instanceof FakeItem)) {
            return original;
        }

        return instance.set(slot, ItemStack.EMPTY);
    }
}
