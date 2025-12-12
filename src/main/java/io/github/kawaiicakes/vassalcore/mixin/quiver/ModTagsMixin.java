package io.github.kawaiicakes.vassalcore.mixin.quiver;

import net.mehvahdjukaar.supplementaries.reg.ModTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ModTags.class, remap = false)
public abstract class ModTagsMixin {
    @Mutable
    @Accessor("QUIVER_WHITELIST")
    private static void fixQuiverTag(TagKey<Item> tag) {
        throw new AssertionError();
    }

    @Invoker("itemTag")
    private static TagKey<Item> itemTag(String name) {
        throw new AssertionError();
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void insertTag(CallbackInfo ci) {
        fixQuiverTag(itemTag("quiver_whitelist"));
    }
}
