package gay.arty.botania_building_blocks;

import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.function.Function;

import static net.minecraft.world.level.block.state.BlockBehaviour.Properties;

@Mod(BotaniaBuildingBlocks.MODID)
public class BotaniaBuildingBlocks {
    public static final String MODID = "botania";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final ArrayList<DeferredBlock<Block>> ALL = new ArrayList<>();
    public static DeferredBlock<Block> register(String name, Function<BlockBehaviour.Properties, ? extends Block> func, BlockBehaviour.Properties props) {
        DeferredBlock<Block> block = BLOCKS.registerBlock(name, func, props);
        ITEMS.registerSimpleBlockItem(name, block);
        ALL.add(block);
        return block;
    }
    public static DeferredBlock<Block> registerStairs(String name, DeferredBlock<Block> base, Properties props) {
        return register(name, props1 -> new StairBlock(base.get().defaultBlockState(), props1), props);
    }

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static Properties livingrock() { return Properties.of()
        .strength(2, 10)
        .sound(SoundType.STONE)
        .instrument(NoteBlockInstrument.BASEDRUM)
        .mapColor(MapColor.TERRACOTTA_WHITE)
        .requiresCorrectToolForDrops(); }
    public static Properties woodBase() { return Properties.of()
        .strength(2)
        .sound(SoundType.WOOD)
        .instrument(NoteBlockInstrument.BASS); }
    public static Properties livingwoodLog() { return woodBase() 
        .mapColor(state -> state.getValue(BlockStateProperties.AXIS) == Direction.Axis.Y
            ? MapColor.TERRACOTTA_RED
            : MapColor.TERRACOTTA_BROWN); }
    public static Properties livingwood() { return woodBase().mapColor(MapColor.TERRACOTTA_BROWN); }
    public static Properties strippedLivingwood() { return woodBase().mapColor(MapColor.TERRACOTTA_RED); }
    public static Properties dreamwood() { return woodBase().mapColor(MapColor.QUARTZ); }
    public static Properties metamorphic() { return Properties.of()
        .strength(1.5F, 10)
        .instrument(NoteBlockInstrument.BASEDRUM)
        .requiresCorrectToolForDrops(); }
    public static Properties fuchsite() { return metamorphic().sound(SoundType.TUFF).mapColor(MapColor.WARPED_NYLIUM); }
    public static Properties talc() { return metamorphic().sound(SoundType.CALCITE).mapColor(MapColor.QUARTZ); }
    public static Properties gneiss() { return metamorphic().sound(SoundType.DEEPSLATE_TILES).mapColor(MapColor.GLOW_LICHEN); }
    public static Properties mycelite() { return metamorphic().sound(SoundType.DEEPSLATE_BRICKS).mapColor(MapColor.TERRACOTTA_PURPLE); }
    public static Properties cataclasite() { return metamorphic().sound(SoundType.DEEPSLATE_TILES).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY); }
    public static Properties solite() { return metamorphic().sound(SoundType.DEEPSLATE).mapColor(MapColor.DIRT); }
    public static Properties lunite() { return metamorphic().sound(SoundType.DEEPSLATE).mapColor(MapColor.TERRACOTTA_BLUE); }
    public static Properties rosyTalc() { return metamorphic().sound(SoundType.CALCITE).mapColor(MapColor.TERRACOTTA_WHITE); }

    public static final DeferredBlock<Block> LIVINGROCK = register("livingrock", Block::new, livingrock());
    public static final DeferredBlock<Block> LIVINGROCK_STAIRS = registerStairs("livingrock_stairs", LIVINGROCK, livingrock());
    public static final DeferredBlock<Block> LIVINGROCK_SLAB = register("livingrock_slab", SlabBlock::new, livingrock());
    public static final DeferredBlock<Block> LIVINGROCK_WALL = register("livingrock_wall", WallBlock::new, livingrock());
    public static final DeferredBlock<Block> POLISHED_LIVINGROCK = register("polished_livingrock", Block::new, livingrock());
    public static final DeferredBlock<Block> POLISHSED_LIVINGROCK_STAIRS = registerStairs("polished_livingrock_stairs", POLISHED_LIVINGROCK, livingrock());
    public static final DeferredBlock<Block> POLISHSED_LIVINGROCK_SLAB = register("polished_livingrock_slab", SlabBlock::new, livingrock());
    public static final DeferredBlock<Block> POLISHSED_LIVINGROCK_WALL = register("polished_livingrock_wall", WallBlock::new, livingrock());
    public static final DeferredBlock<Block> LIVINGROCK_SLATE = register("livingrock_slate", Block::new, livingrock());
    public static final DeferredBlock<Block> LIVINGROCK_BRICKS = register("livingrock_bricks", Block::new, livingrock());
    public static final DeferredBlock<Block> LIVINGROCK_BRICKS_STAIRS = registerStairs("livingrock_bricks_stairs", LIVINGROCK_BRICKS, livingrock());
    public static final DeferredBlock<Block> LIVINGROCK_BRICKS_SLAB = register("livingrock_bricks_slab", SlabBlock::new, livingrock());
    public static final DeferredBlock<Block> LIVINGROCK_BRICKS_WALL = register("livingrock_bricks_wall", WallBlock::new, livingrock());
    public static final DeferredBlock<Block> MOSSY_LIVINGROCK_BRICKS = register("mossy_livingrock_bricks", Block::new, livingrock());
    public static final DeferredBlock<Block> MOSSY_LIVINGROCK_BRICKS_STAIRS = registerStairs("mossy_livingrock_bricks_stairs", MOSSY_LIVINGROCK_BRICKS, livingrock());
    public static final DeferredBlock<Block> MOSSY_LIVINGROCK_BRICKS_SLAB = register("mossy_livingrock_bricks_slab", SlabBlock::new, livingrock());
    public static final DeferredBlock<Block> MOSSY_LIVINGROCK_BRICKS_WALL = register("mossy_livingrock_bricks_wall", WallBlock::new, livingrock());
    public static final DeferredBlock<Block> CRACKED_LIVINGROCK_BRICKS = register("cracked_livingrock_bricks", Block::new, livingrock());
    public static final DeferredBlock<Block> CHISELED_LIVINGROCK_BRICKS = register("chiseled_livingrock_bricks", Block::new, livingrock());

    public static final DeferredBlock<Block> LIVINGWOOD_LOG = register("livingwood_log", RotatedPillarBlock::new, livingwoodLog());
    public static final DeferredBlock<Block> STRIPPED_LIVINGWOOD_LOG = register("stripped_livingwood_log", RotatedPillarBlock::new, strippedLivingwood());
    public static final DeferredBlock<Block> GLIMMERING_LIVINGWOOD_LOG = register("glimmering_livingwood_log", RotatedPillarBlock::new, livingwoodLog().lightLevel(s -> 12));
    public static final DeferredBlock<Block> GLIMMERING_STRIPPED_LIVINGWOOD_LOG = register("glimmering_stripped_livingwood_log", RotatedPillarBlock::new, strippedLivingwood().lightLevel(s -> 8));
    public static final DeferredBlock<Block> LIVINGWOOD = register("livingwood", RotatedPillarBlock::new, livingwood());
    public static final DeferredBlock<Block> LIVINGWOOD_STAIRS = registerStairs("livingwood_stairs", LIVINGWOOD, livingwood());
    public static final DeferredBlock<Block> LIVINGWOOD_SLAB = register("livingwood_slab", SlabBlock::new, livingwood());
    public static final DeferredBlock<Block> LIVINGWOOD_WALL = register("livingwood_wall", WallBlock::new, livingwood());
    public static final DeferredBlock<Block> STRIPPED_LIVINGWOOD = register("stripped_livingwood", RotatedPillarBlock::new, strippedLivingwood());
    public static final DeferredBlock<Block> STRIPPED_LIVINGWOOD_STAIRS = registerStairs("stripped_livingwood_stairs", STRIPPED_LIVINGWOOD, strippedLivingwood());
    public static final DeferredBlock<Block> STRIPPED_LIVINGWOOD_SLAB = register("stripped_livingwood_slab", SlabBlock::new, strippedLivingwood());
    public static final DeferredBlock<Block> STRIPPED_LIVINGWOOD_WALL = register("stripped_livingwood_wall", WallBlock::new, strippedLivingwood());
    public static final DeferredBlock<Block> GLIMMERING_LIVINGWOOD = register("glimmering_livingwood", RotatedPillarBlock::new, livingwood().lightLevel(s -> 12));
    public static final DeferredBlock<Block> GLIMMERING_STRIPPED_LIVINGWOOD = register("glimmering_stripped_livingwood", RotatedPillarBlock::new, strippedLivingwood().lightLevel(s -> 8));
    public static final DeferredBlock<Block> LIVINGWOOD_PLANKS = register("livingwood_planks", Block::new, strippedLivingwood());
    public static final DeferredBlock<Block> LIVINGWOOD_PLANKS_STAIRS = registerStairs("livingwood_planks_stairs", LIVINGWOOD_PLANKS, strippedLivingwood());
    public static final DeferredBlock<Block> LIVINGWOOD_PLANKS_SLAB = register("livingwood_planks_slab", SlabBlock::new, strippedLivingwood());
    public static final DeferredBlock<Block> MOSSY_LIVINGWOOD_PLANKS = register("mossy_livingwood_planks", Block::new, strippedLivingwood());
    public static final DeferredBlock<Block> FRAMED_LIVINGWOOD = register("framed_livingwood", RotatedPillarBlock::new, strippedLivingwood());
    public static final DeferredBlock<Block> PATTERN_FRAMED_LIVINGWOOD = register("pattern_framed_livingwood", Block::new, strippedLivingwood());
    public static final DeferredBlock<Block> LIVINGWOOD_FENCE = register("livingwood_fence", FenceBlock::new, strippedLivingwood());
    public static final DeferredBlock<Block> LIVINGWOOD_FENCE_GATE = register("livingwood_fence_gate", props -> new FenceGateBlock(props, SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE), strippedLivingwood());

    public static final DeferredBlock<Block> DREAMWOOD_LOG = register("dreamwood_log", RotatedPillarBlock::new, dreamwood());
    public static final DeferredBlock<Block> STRIPPED_DREAMWOOD_LOG = register("stripped_dreamwood_log", RotatedPillarBlock::new, dreamwood());
    public static final DeferredBlock<Block> GLIMMERING_DREAMWOOD_LOG = register("glimmering_dreamwood_log", RotatedPillarBlock::new, dreamwood().lightLevel(s -> 12));
    public static final DeferredBlock<Block> GLIMMERING_STRIPPED_DREAMWOOD_LOG = register("glimmering_stripped_dreamwood_log", RotatedPillarBlock::new, dreamwood().lightLevel(s -> 8));
    public static final DeferredBlock<Block> DREAMWOOD = register("dreamwood", RotatedPillarBlock::new, dreamwood());
    public static final DeferredBlock<Block> DREAMWOOD_STAIRS = registerStairs("dreamwood_stairs", DREAMWOOD, dreamwood());
    public static final DeferredBlock<Block> DREAMWOOD_SLAB = register("dreamwood_slab", SlabBlock::new, dreamwood());
    public static final DeferredBlock<Block> DREAMWOOD_WALL = register("dreamwood_wall", WallBlock::new, dreamwood());
    public static final DeferredBlock<Block> STRIPPED_DREAMWOOD = register("stripped_dreamwood", RotatedPillarBlock::new, dreamwood());
    public static final DeferredBlock<Block> STRIPPED_DREAMWOOD_STAIRS = registerStairs("stripped_dreamwood_stairs", STRIPPED_DREAMWOOD, dreamwood());
    public static final DeferredBlock<Block> STRIPPED_DREAMWOOD_SLAB = register("stripped_dreamwood_slab", SlabBlock::new, dreamwood());
    public static final DeferredBlock<Block> STRIPPED_DREAMWOOD_WALL = register("stripped_dreamwood_wall", WallBlock::new, dreamwood());
    public static final DeferredBlock<Block> GLIMMERING_DREAMWOOD = register("glimmering_dreamwood", RotatedPillarBlock::new, dreamwood().lightLevel(s -> 12));
    public static final DeferredBlock<Block> GLIMMERING_STRIPPED_DREAMWOOD = register("glimmering_stripped_dreamwood", RotatedPillarBlock::new, dreamwood().lightLevel(s -> 8));
    public static final DeferredBlock<Block> DREAMWOOD_PLANKS = register("dreamwood_planks", Block::new, dreamwood());
    public static final DeferredBlock<Block> DREAMWOOD_PLANKS_STAIRS = registerStairs("dreamwood_planks_stairs", DREAMWOOD_PLANKS, dreamwood());
    public static final DeferredBlock<Block> DREAMWOOD_PLANKS_SLAB = register("dreamwood_planks_slab", SlabBlock::new, dreamwood());
    public static final DeferredBlock<Block> MOSSY_DREAMWOOD_PLANKS = register("mossy_dreamwood_planks", Block::new, dreamwood());
    public static final DeferredBlock<Block> FRAMED_DREAMWOOD = register("framed_dreamwood", RotatedPillarBlock::new, dreamwood());
    public static final DeferredBlock<Block> PATTERN_FRAMED_DREAMWOOD = register("pattern_framed_dreamwood", Block::new, dreamwood());
    public static final DeferredBlock<Block> DREAMWOOD_FENCE = register("dreamwood_fence", FenceBlock::new, dreamwood());
    public static final DeferredBlock<Block> DREAMWOOD_FENCE_GATE = register("dreamwood_fence_gate", props -> new FenceGateBlock(props, SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE), dreamwood());

    public static final DeferredBlock<Block> FUCHSITE = register("metamorphic_forest_stone", Block::new, fuchsite());
    public static final DeferredBlock<Block> FUCHSITE_STAIRS = registerStairs("metamorphic_forest_stone_stairs", FUCHSITE, fuchsite());
    public static final DeferredBlock<Block> FUCHSITE_SLAB = register("metamorphic_forest_stone_slab", SlabBlock::new, fuchsite());
    public static final DeferredBlock<Block> FUCHSITE_WALL = register("metamorphic_forest_stone_wall", WallBlock::new, fuchsite());
    public static final DeferredBlock<Block> COBBLED_FUCHSITE = register("metamorphic_forest_cobblestone", Block::new, fuchsite());
    public static final DeferredBlock<Block> COBBLED_FUCHSITE_STAIRS = registerStairs("metamorphic_forest_cobblestone_stairs", COBBLED_FUCHSITE, fuchsite());
    public static final DeferredBlock<Block> COBBLED_FUCHSITE_SLAB = register("metamorphic_forest_cobblestone_slab", SlabBlock::new, fuchsite());
    public static final DeferredBlock<Block> COBBLED_FUCHSITE_WALL = register("metamorphic_forest_cobblestone_wall", WallBlock::new, fuchsite());
    public static final DeferredBlock<Block> FUCHSITE_BRICKS = register("metamorphic_forest_bricks", Block::new, fuchsite());
    public static final DeferredBlock<Block> FUCHSITE_BRICKS_STAIRS = registerStairs("metamorphic_forest_bricks_stairs", FUCHSITE_BRICKS, fuchsite());
    public static final DeferredBlock<Block> FUCHSITE_BRICKS_SLAB = register("metamorphic_forest_bricks_slab", SlabBlock::new, fuchsite());
    public static final DeferredBlock<Block> FUCHSITE_BRICKS_WALL = register("metamorphic_forest_bricks_wall", WallBlock::new, fuchsite());
    public static final DeferredBlock<Block> CHISELED_FUCHSITE_BRICKS = register("chiseled_metamorphic_forest_bricks", Block::new, fuchsite());

    public static final DeferredBlock<Block> TALC = register("metamorphic_plains_stone", Block::new, talc());
    public static final DeferredBlock<Block> TALC_STAIRS = registerStairs("metamorphic_plains_stone_stairs", TALC, talc());
    public static final DeferredBlock<Block> TALC_SLAB = register("metamorphic_plains_stone_slab", SlabBlock::new, talc());
    public static final DeferredBlock<Block> TALC_WALL = register("metamorphic_plains_stone_wall", WallBlock::new, talc());
    public static final DeferredBlock<Block> COBBLED_TALC = register("metamorphic_plains_cobblestone", Block::new, talc());
    public static final DeferredBlock<Block> COBBLED_TALC_STAIRS = registerStairs("metamorphic_plains_cobblestone_stairs", COBBLED_TALC, talc());
    public static final DeferredBlock<Block> COBBLED_TALC_SLAB = register("metamorphic_plains_cobblestone_slab", SlabBlock::new, talc());
    public static final DeferredBlock<Block> COBBLED_TALC_WALL = register("metamorphic_plains_cobblestone_wall", WallBlock::new, talc());
    public static final DeferredBlock<Block> TALC_BRICKS = register("metamorphic_plains_bricks", RotatedPillarBlock::new, talc());
    public static final DeferredBlock<Block> TALC_BRICKS_STAIRS = registerStairs("metamorphic_plains_bricks_stairs", TALC_BRICKS, talc());
    public static final DeferredBlock<Block> TALC_BRICKS_SLAB = register("metamorphic_plains_bricks_slab", SlabBlock::new, talc());
    public static final DeferredBlock<Block> TALC_BRICKS_WALL = register("metamorphic_plains_bricks_wall", WallBlock::new, talc());
    public static final DeferredBlock<Block> CHISELED_TALC_BRICKS = register("chiseled_metamorphic_plains_bricks", Block::new, talc());

    public static final DeferredBlock<Block> GNEISS = register("metamorphic_mountain_stone", Block::new, gneiss());
    public static final DeferredBlock<Block> GNEISS_STAIRS = registerStairs("metamorphic_mountain_stone_stairs", GNEISS, gneiss());
    public static final DeferredBlock<Block> GNEISS_SLAB = register("metamorphic_mountain_stone_slab", SlabBlock::new, gneiss());
    public static final DeferredBlock<Block> GNEISS_WALL = register("metamorphic_mountain_stone_wall", WallBlock::new, gneiss());
    public static final DeferredBlock<Block> COBBLED_GNEISS = register("metamorphic_mountain_cobblestone", Block::new, gneiss());
    public static final DeferredBlock<Block> COBBLED_GNEISS_STAIRS = registerStairs("metamorphic_mountain_cobblestone_stairs", COBBLED_GNEISS, gneiss());
    public static final DeferredBlock<Block> COBBLED_GNEISS_SLAB = register("metamorphic_mountain_cobblestone_slab", SlabBlock::new, gneiss());
    public static final DeferredBlock<Block> COBBLED_GNEISS_WALL = register("metamorphic_mountain_cobblestone_wall", WallBlock::new, gneiss());
    public static final DeferredBlock<Block> GNEISS_BRICKS = register("metamorphic_mountain_bricks", Block::new, gneiss());
    public static final DeferredBlock<Block> GNEISS_BRICKS_STAIRS = registerStairs("metamorphic_mountain_bricks_stairs", GNEISS_BRICKS, gneiss());
    public static final DeferredBlock<Block> GNEISS_BRICKS_SLAB = register("metamorphic_mountain_bricks_slab", SlabBlock::new, gneiss());
    public static final DeferredBlock<Block> GNEISS_BRICKS_WALL = register("metamorphic_mountain_bricks_wall", WallBlock::new, gneiss());
    public static final DeferredBlock<Block> CHISELED_GNEISS_BRICKS = register("chiseled_metamorphic_mountain_bricks", Block::new, gneiss());

    public static final DeferredBlock<Block> MYCELITE = register("metamorphic_fungal_stone", Block::new, mycelite());
    public static final DeferredBlock<Block> MYCELITE_STAIRS = registerStairs("metamorphic_fungal_stone_stairs", MYCELITE, mycelite());
    public static final DeferredBlock<Block> MYCELITE_SLAB = register("metamorphic_fungal_stone_slab", SlabBlock::new, mycelite());
    public static final DeferredBlock<Block> MYCELITE_WALL = register("metamorphic_fungal_stone_wall", WallBlock::new, mycelite());
    public static final DeferredBlock<Block> COBBLED_MYCELITE = register("metamorphic_fungal_cobblestone", Block::new, mycelite());
    public static final DeferredBlock<Block> COBBLED_MYCELITE_STAIRS = registerStairs("metamorphic_fungal_cobblestone_stairs", COBBLED_MYCELITE, mycelite());
    public static final DeferredBlock<Block> COBBLED_MYCELITE_SLAB = register("metamorphic_fungal_cobblestone_slab", SlabBlock::new, mycelite());
    public static final DeferredBlock<Block> COBBLED_MYCELITE_WALL = register("metamorphic_fungal_cobblestone_wall", WallBlock::new, mycelite());
    public static final DeferredBlock<Block> MYCELITE_BRICKS = register("metamorphic_fungal_bricks", Block::new, mycelite());
    public static final DeferredBlock<Block> MYCELITE_BRICKS_STAIRS = registerStairs("metamorphic_fungal_bricks_stairs", MYCELITE_BRICKS, mycelite());
    public static final DeferredBlock<Block> MYCELITE_BRICKS_SLAB = register("metamorphic_fungal_bricks_slab", SlabBlock::new, mycelite());
    public static final DeferredBlock<Block> MYCELITE_BRICKS_WALL = register("metamorphic_fungal_bricks_wall", WallBlock::new, mycelite());
    public static final DeferredBlock<Block> CHISELED_MYCELITE_BRICKS = register("chiseled_metamorphic_fungal_bricks", Block::new, mycelite());

    public static final DeferredBlock<Block> CATACLASITE = register("metamorphic_swamp_stone", Block::new, cataclasite());
    public static final DeferredBlock<Block> CATACLASITE_STAIRS = registerStairs("metamorphic_swamp_stone_stairs", CATACLASITE, cataclasite());
    public static final DeferredBlock<Block> CATACLASITE_SLAB = register("metamorphic_swamp_stone_slab", SlabBlock::new, cataclasite());
    public static final DeferredBlock<Block> CATACLASITE_WALL = register("metamorphic_swamp_stone_wall", WallBlock::new, cataclasite());
    public static final DeferredBlock<Block> COBBLED_CATACLASITE = register("metamorphic_swamp_cobblestone", Block::new, cataclasite());
    public static final DeferredBlock<Block> COBBLED_CATACLASITE_STAIRS = registerStairs("metamorphic_swamp_cobblestone_stairs", COBBLED_CATACLASITE, cataclasite());
    public static final DeferredBlock<Block> COBBLED_CATACLASITE_SLAB = register("metamorphic_swamp_cobblestone_slab", SlabBlock::new, cataclasite());
    public static final DeferredBlock<Block> COBBLED_CATACLASITE_WALL = register("metamorphic_swamp_cobblestone_wall", WallBlock::new, cataclasite());
    public static final DeferredBlock<Block> CATACLASITE_BRICKS = register("metamorphic_swamp_bricks", BotaniaDirectionalBlock::new, cataclasite());
    public static final DeferredBlock<Block> CATACLASITE_BRICKS_STAIRS = registerStairs("metamorphic_swamp_bricks_stairs", CATACLASITE_BRICKS, cataclasite());
    public static final DeferredBlock<Block> CATACLASITE_BRICKS_SLAB = register("metamorphic_swamp_bricks_slab", SlabBlock::new, cataclasite());
    public static final DeferredBlock<Block> CATACLASITE_BRICKS_WALL = register("metamorphic_swamp_bricks_wall", WallBlock::new, cataclasite());
    public static final DeferredBlock<Block> CHISELED_CATACLASITE_BRICKS = register("chiseled_metamorphic_swamp_bricks", BotaniaDirectionalBlock::new, cataclasite());

    public static final DeferredBlock<Block> SOLITE = register("metamorphic_desert_stone", Block::new, solite());
    public static final DeferredBlock<Block> SOLITE_STAIRS = registerStairs("metamorphic_desert_stone_stairs", SOLITE, solite());
    public static final DeferredBlock<Block> SOLITE_SLAB = register("metamorphic_desert_stone_slab", SlabBlock::new, solite());
    public static final DeferredBlock<Block> SOLITE_WALL = register("metamorphic_desert_stone_wall", WallBlock::new, solite());
    public static final DeferredBlock<Block> COBBLED_SOLITE = register("metamorphic_desert_cobblestone", Block::new, solite());
    public static final DeferredBlock<Block> COBBLED_SOLITE_STAIRS = registerStairs("metamorphic_desert_cobblestone_stairs", COBBLED_SOLITE, solite());
    public static final DeferredBlock<Block> COBBLED_SOLITE_SLAB = register("metamorphic_desert_cobblestone_slab", SlabBlock::new, solite());
    public static final DeferredBlock<Block> COBBLED_SOLITE_WALL = register("metamorphic_desert_cobblestone_wall", WallBlock::new, solite());
    public static final DeferredBlock<Block> SOLITE_BRICKS = register("metamorphic_desert_bricks", Block::new, solite());
    public static final DeferredBlock<Block> SOLITE_BRICKS_STAIRS = registerStairs("metamorphic_desert_bricks_stairs", SOLITE_BRICKS, solite());
    public static final DeferredBlock<Block> SOLITE_BRICKS_SLAB = register("metamorphic_desert_bricks_slab", SlabBlock::new, solite());
    public static final DeferredBlock<Block> SOLITE_BRICKS_WALL = register("metamorphic_desert_bricks_wall", WallBlock::new, solite());
    public static final DeferredBlock<Block> CHISELED_SOLITE_BRICKS = register("chiseled_metamorphic_desert_bricks", Block::new, solite());

    public static final DeferredBlock<Block> LUNITE = register("metamorphic_taiga_stone", Block::new, lunite());
    public static final DeferredBlock<Block> LUNITE_STAIRS = registerStairs("metamorphic_taiga_stone_stairs", LUNITE, lunite());
    public static final DeferredBlock<Block> LUNITE_SLAB = register("metamorphic_taiga_stone_slab", SlabBlock::new, lunite());
    public static final DeferredBlock<Block> LUNITE_WALL = register("metamorphic_taiga_stone_wall", WallBlock::new, lunite());
    public static final DeferredBlock<Block> COBBLED_LUNITE = register("metamorphic_taiga_cobblestone", Block::new, lunite());
    public static final DeferredBlock<Block> COBBLED_LUNITE_STAIRS = registerStairs("metamorphic_taiga_cobblestone_stairs", COBBLED_LUNITE, lunite());
    public static final DeferredBlock<Block> COBBLED_LUNITE_SLAB = register("metamorphic_taiga_cobblestone_slab", SlabBlock::new, lunite());
    public static final DeferredBlock<Block> COBBLED_LUNITE_WALL = register("metamorphic_taiga_cobblestone_wall", WallBlock::new, lunite());
    public static final DeferredBlock<Block> LUNITE_BRICKS = register("metamorphic_taiga_bricks", Block::new, lunite());
    public static final DeferredBlock<Block> LUNITE_BRICKS_STAIRS = registerStairs("metamorphic_taiga_bricks_stairs", LUNITE_BRICKS, lunite());
    public static final DeferredBlock<Block> LUNITE_BRICKS_SLAB = register("metamorphic_taiga_bricks_slab", SlabBlock::new, lunite());
    public static final DeferredBlock<Block> LUNITE_BRICKS_WALL = register("metamorphic_taiga_bricks_wall", WallBlock::new, lunite());
    public static final DeferredBlock<Block> CHISELED_LUNITE_BRICKS = register("chiseled_metamorphic_taiga_bricks", Block::new, lunite());

    public static final DeferredBlock<Block> ROSY_TALC = register("metamorphic_mesa_stone", Block::new, rosyTalc());
    public static final DeferredBlock<Block> ROSY_TALC_STAIRS = registerStairs("metamorphic_mesa_stone_stairs", ROSY_TALC, rosyTalc());
    public static final DeferredBlock<Block> ROSY_TALC_SLAB = register("metamorphic_mesa_stone_slab", SlabBlock::new, rosyTalc());
    public static final DeferredBlock<Block> ROSY_TALC_WALL = register("metamorphic_mesa_stone_wall", WallBlock::new, rosyTalc());
    public static final DeferredBlock<Block> COBBLED_ROSY_TALC = register("metamorphic_mesa_cobblestone", Block::new, rosyTalc());
    public static final DeferredBlock<Block> COBBLED_ROSY_TALC_STAIRS = registerStairs("metamorphic_mesa_cobblestone_stairs", COBBLED_ROSY_TALC, rosyTalc());
    public static final DeferredBlock<Block> COBBLED_ROSY_TALC_SLAB = register("metamorphic_mesa_cobblestone_slab", SlabBlock::new, rosyTalc());
    public static final DeferredBlock<Block> COBBLED_ROSY_TALC_WALL = register("metamorphic_mesa_cobblestone_wall", WallBlock::new, rosyTalc());
    public static final DeferredBlock<Block> ROSY_TALC_BRICKS = register("metamorphic_mesa_bricks", Block::new, rosyTalc());
    public static final DeferredBlock<Block> ROSY_TALC_BRICKS_STAIRS = registerStairs("metamorphic_mesa_bricks_stairs", ROSY_TALC_BRICKS, rosyTalc());
    public static final DeferredBlock<Block> ROSY_TALC_BRICKS_SLAB = register("metamorphic_mesa_bricks_slab", SlabBlock::new, rosyTalc());
    public static final DeferredBlock<Block> ROSY_TALC_BRICKS_WALL = register("metamorphic_mesa_bricks_wall", WallBlock::new, rosyTalc());
    public static final DeferredBlock<Block> CHISELED_ROSY_TALC_BRICKS = register("chiseled_metamorphic_mesa_bricks", RotatedPillarBlock::new, rosyTalc());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TABS.register("botania_building_blocks", () -> CreativeModeTab.builder()
        .title(Component.translatable("itemGroup.botania_building_blocks"))
        .withTabsBefore(CreativeModeTabs.COMBAT)
        .icon(LIVINGROCK_BRICKS::toStack)
        .displayItems((parameters, output) -> {
            for (DeferredBlock<Block> block : ALL) {
                output.accept(block);
            }
        }).build());

    public BotaniaBuildingBlocks(IEventBus modEventBus, ModContainer modContainer) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
