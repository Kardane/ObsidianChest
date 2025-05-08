package org.karn.obsidianchest;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class Obsidianchest implements ModInitializer {
    public static GameRules.Key<GameRules.BooleanRule> OBSIDIANCHEST;

    @Override
    public void onInitialize() {
        OBSIDIANCHEST = GameRuleRegistry.register("enableObsidianChest", GameRules.Category.DROPS, GameRuleFactory.createBooleanRule(false));
    }
}
