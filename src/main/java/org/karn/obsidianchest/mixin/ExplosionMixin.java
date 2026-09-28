package org.karn.obsidianchest.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ServerExplosion;
import net.minecraft.world.level.block.EntityBlock;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import static org.karn.obsidianchest.Obsidianchest.OBSIDIANCHEST;

@Mixin(ServerExplosion.class)
public class ExplosionMixin {
    @Shadow @Final private ServerLevel level;

    @ModifyExpressionValue(
            method = "calculateExplodedPositions",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;isInWorldBounds(Lnet/minecraft/core/BlockPos;)Z")
    )
    private boolean onlyFlyIfAllowed(boolean original, @Local(ordinal = 0) BlockPos blockPos) {
        if (original && level.getGameRules().get(OBSIDIANCHEST)
                && level.getBlockState(blockPos).getBlock() instanceof EntityBlock) {
            return false;
        }
        return original;
    }
}
