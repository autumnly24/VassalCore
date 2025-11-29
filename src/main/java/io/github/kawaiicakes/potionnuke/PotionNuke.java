package io.github.kawaiicakes.potionnuke;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PotionNuke.MOD_ID)
public final class PotionNuke {
    public static final String MOD_ID = "potionnuke";

    public PotionNuke() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public PotionNuke(FMLJavaModLoadingContext context) {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
