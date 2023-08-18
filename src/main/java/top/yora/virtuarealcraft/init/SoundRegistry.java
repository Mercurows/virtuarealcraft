package top.yora.virtuarealcraft.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import top.yora.virtuarealcraft.Utils;

public class SoundRegistry {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Utils.MOD_ID);

    public static final RegistryObject<SoundEvent> NNCB = SOUNDS.register("nncb", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "nncb")));
    public static final RegistryObject<SoundEvent> HEAL = SOUNDS.register("heal", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "heal")));
    public static final RegistryObject<SoundEvent> HOSHIMI_MUA = SOUNDS.register("hoshimi_mua", () -> new SoundEvent(new ResourceLocation(Utils.MOD_ID, "hoshimi_mua")));

}
