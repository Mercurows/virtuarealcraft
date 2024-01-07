package top.yora.virtuarealcraft.item.virtuareal20th.kismet.richi;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import top.yora.virtuarealcraft.tool.Livers;
import top.yora.virtuarealcraft.tool.LootTableTool;
import top.yora.virtuarealcraft.tool.TooltipTool;

import javax.annotation.Nullable;
import java.util.List;

public class FoxMirror extends Item {
    public FoxMirror() {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE).durability(20));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        TooltipTool.addDevelopingText(tooltip);
        tooltip.add(Component.translatable("des.virtuarealcraft.fox_mirror_1").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("des.virtuarealcraft.fox_mirror_2").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));

        TooltipTool.addLiverInfo(tooltip, Livers.RICHI);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        if (!level.isClientSide && player != null && level.getServer() != null) {
            BlockState state = level.getBlockState(pos);

            ResourceLocation resourceLocation = LootTableTool.getRandomLootTable(level, "archaeology");
            if (resourceLocation != null) {
                if (state.is(Blocks.SAND)) {
                    BlockState susSand = Blocks.SUSPICIOUS_SAND.defaultBlockState();
                    BrushableBlockEntity brushableBlockEntity = new BrushableBlockEntity(pos, susSand);
                    brushableBlockEntity.setLootTable(resourceLocation, 0);

                    level.setBlockAndUpdate(pos, susSand);
                    level.setBlockEntity(brushableBlockEntity);

                    player.getCooldowns().addCooldown(stack.getItem(), 1200);
                    stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(context.getHand()));

                    return InteractionResult.SUCCESS;
                }
                if (state.is(Blocks.GRAVEL)) {
                    BlockState susGravel = Blocks.SUSPICIOUS_GRAVEL.defaultBlockState();
                    BrushableBlockEntity brushableBlockEntity = new BrushableBlockEntity(pos, susGravel);
                    brushableBlockEntity.setLootTable(resourceLocation, 0);

                    level.setBlockAndUpdate(pos, susGravel);
                    level.setBlockEntity(brushableBlockEntity);

                    player.getCooldowns().addCooldown(stack.getItem(), 1200);
                    stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(context.getHand()));

                    return InteractionResult.SUCCESS;
                }
            }
        }

        return InteractionResult.FAIL;
    }
}
