package top.yora.virtuarealcraft.item.virtuareal17th.sui;

import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.yora.virtuarealcraft.Utils;
import top.yora.virtuarealcraft.init.SoundRegistry;
import top.yora.virtuarealcraft.models.item.SuiJokesModel;
import top.yora.virtuarealcraft.render.item.SuiJokesRenderer;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SuiJokes extends Item {
    public SuiJokes() {
        super(new Properties().stacksTo(1));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        TooltipTool.addDevelopingText(tooltip);

        tooltip.add((Component.translatable("des.virtuarealcraft.sui_jokes_1")).withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        tooltip.add((Component.translatable("des.virtuarealcraft.sui_jokes_2")).withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(tooltip, Livers.SUI);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundRegistry.CANNED_LAUGHTER.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return new SuiJokesRenderer();
            }
        });
    }

    @SubscribeEvent
    public static void onModelBaked(ModelEvent.ModifyBakingResult event) {
        Map<ResourceLocation, BakedModel> modelRegistry = event.getModels();
        ModelResourceLocation location = new ModelResourceLocation(Utils.MOD_ID, "special/sui_jokes_3d", "inventory");
        BakedModel existingModel = modelRegistry.get(location);
        if (existingModel == null) {
            throw new RuntimeException();
        } else if (existingModel instanceof SuiJokesModel) {
            throw new RuntimeException();
        } else {
            SuiJokesModel model = new SuiJokesModel(existingModel);
            event.getModels().put(location, model);
        }
    }
}
