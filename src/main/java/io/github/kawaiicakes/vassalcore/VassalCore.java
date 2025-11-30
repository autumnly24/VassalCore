package io.github.kawaiicakes.vassalcore;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(VassalCore.MOD_ID)
public final class VassalCore {
    public static final String MOD_ID = "vassalcore";

    public VassalCore() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public VassalCore(FMLJavaModLoadingContext context) {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
