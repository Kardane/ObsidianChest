package org.karn.obsidianchest;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;

public class Obsidianchest implements ModInitializer {
    public static final GameRule<Boolean> OBSIDIANCHEST = GameRuleBuilder.forBoolean(false)
            .category(GameRuleCategory.DROPS)
            .buildAndRegister(Identifier.fromNamespaceAndPath("obsidianchest", "enable_obsidian_chest"));

    @Override
    public void onInitialize() {
    }
}
