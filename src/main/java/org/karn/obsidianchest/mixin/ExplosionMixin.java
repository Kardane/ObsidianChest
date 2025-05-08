package org.karn.obsidianchest.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import static org.karn.obsidianchest.Obsidianchest.OBSIDIANCHEST;

@Mixin(Explosion.class)
public class ExplosionMixin {
    @Shadow
    private ServerWorld world;

    @ModifyExpressionValue(
            method = "collectBlocksAndDamageEntities",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;isInBuildLimit(Lnet/minecraft/util/math/BlockPos;)Z")
    )
    private boolean onlyFlyIfAllowed(boolean original,@Local(ordinal = 0) BlockPos blockPos) {
        if(world.getGameRules().getBoolean(OBSIDIANCHEST) && world.getBlockEntity(blockPos) != null) {
            return false;
        }
        return original;
    }
}
