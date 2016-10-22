package wealthyturtle.uiesingularities.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import fox.spiteful.avaritia.crafting.CompressorManager;
import fox.spiteful.avaritia.crafting.Grinder;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import wealthyturtle.uiesingularities.UniversalSingularity;
import wealthyturtle.uiesingularities.UniversalSingularityItem;
import wealthyturtle.uiesingularities.UniversalSingularityWrapper;

import javax.annotation.Nonnull;
import java.io.File;
import java.util.*;

import static fox.spiteful.avaritia.Config.craftingOnly;
import static java.io.File.separatorChar;

public class CommonProxy
{
	protected final List<UniversalSingularityItem> singularities = new ArrayList<>();

	private final Map<String, Set<String>> allowed = new HashMap<>();

	public CommonProxy()
	{
		final List<UniversalSingularity> universalSingularities = Arrays.asList(
				// Vanilla Singularities
				new UniversalSingularity("vanilla", Arrays.asList(
						new UniversalSingularityWrapper("coal", "blockCoal", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("emerald", "blockEmerald", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("diamond", "blockDiamond", 0, 0x0, 0x0)
				)),
				// Applied Energistics Singularities
				new UniversalSingularity("appliedEnergistics", Arrays.asList(
						new UniversalSingularityWrapper("certus", "blockCertus", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("fluix", "blockFluix", 0, 0x0, 0x0)
				)),
				// Big Reactors Singularities
				new UniversalSingularity("bigReactors", Arrays.asList(
						new UniversalSingularityWrapper("blutonium", "blockBlutonium", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("cyanite", "blockCyanite", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("graphite", "blockGraphite", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("ludicrite", "blockLudicrite", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("yellorium", "blockYellorium", 0, 0x0, 0x0)
				)),
				// Botania Singularities
				new UniversalSingularity("botania", Arrays.asList(
						new UniversalSingularityWrapper("manasteel", "blockManasteel", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("terrasteel", "blockTerrasteel", 0, 0x0, 0x0)
				)),
				
				// Draconic Evolution Singularities
				new UniversalSingularity("draconicEvolution", Collections.singletonList(
						new UniversalSingularityWrapper("awakenedDraconium", "blockAwakenedDraconium", 0, 0x0, 0x0)
				)),
				// Ender IO Singularities
				new UniversalSingularity("enderIO", Arrays.asList(
						new UniversalSingularityWrapper("conductiveIron", "blockConductiveIron", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("electricalSteel", "blockElectricalSteel", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("energeticAlloy", "blockEnergeticAlloy", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("darkSteel", "blockDarkSteel", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("pulsatingIron", "blockPulsatingIron", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("redstoneAlloy", "blockRedstoneAlloy", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("solarium", "blockSolarium", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("vibrantAlloy", "blockVibrantAlloy", 0, 0x0, 0x0)
				)),
				// ExtraTiC Singularities
				new UniversalSingularity("extraTiC", Arrays.asList(
						new UniversalSingularityWrapper("fairy", "blockFairy", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("pokefennium", "blockPokefennium", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("red_aurum", "blockRed_aurum", 0, 0x0, 0x0)
				)),
				// Extra Utilities Singularities
				new UniversalSingularity("extraUtilities", Collections.singletonList(
						new UniversalSingularityWrapper("unstable", "blockUnstable", 0, 0x0, 0x0)
				)),
				// Metallurgy Singularities
				new UniversalSingularity("metallurgy", Collections.singletonList(
						new UniversalSingularityWrapper("tartarite", "blockTartarite", 0, 0x0, 0x0)
				)),
				// ProjectE Singularities
				new UniversalSingularity("projectE", Arrays.asList(
						new UniversalSingularityWrapper("darkMatter", "blockDarkMatter", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("redMatter", "blockRedMatter", 0, 0x0, 0x0)
				)),
				// Redstone Arsenal Singularities
				new UniversalSingularity("redstoneArsenal", Arrays.asList(
						new UniversalSingularityWrapper("electrumFlux", "blockElectrumFlux", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("crystalFlux", "blockCrystalFlux", 0, 0x0, 0x0)
				)),
				// Tinkers' Construct Singularities
				new UniversalSingularity("tinkersConstruct", Arrays.asList(
						new UniversalSingularityWrapper("aluminumBrass", "blockAluminumBrass", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("alumite", "blockAlumite", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("ardite", "blockArdite", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("cobalt", "blockCobalt", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("manyullyn", "blockManyullyn", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("pigIron", "blockPigIron", 0, 0x0, 0x0)
				)),
				// General (Not Mod Specific)
				new UniversalSingularity("general", Arrays.asList(
						new UniversalSingularityWrapper("aluminum", "blockAluminum", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("brass", "blocBrass", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("bronze", "blockBronze", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("electrum", "blocElectrum", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("invar", "blockInvar", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("osmium", "blockOsmium", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("steel", "blockSteel", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("zinc", "blockZinc", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("ruby", "blockRuby", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("sapphire", "blockSapphire", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("peridot", "blockPeridot", 0, 0x0, 0x0)
				))
		);
		final Configuration config = new Configuration(new File("." + separatorChar + "config" + separatorChar + "UniversalSingularities.cfg"));
		universalSingularities.forEach(universalSingularity -> {
			if (config.get(universalSingularity.name, "enabled", true).getBoolean()) {
				universalSingularity.singularities.forEach(universalSingularityWrapper -> {
					if (config.get(universalSingularity.name, universalSingularityWrapper.name, true).getBoolean()) {
						if (!allowed.containsKey(universalSingularity.name))
							allowed.put(universalSingularity.name, new HashSet<>());
						allowed.get(universalSingularity.name).add(universalSingularityWrapper.name);
					}
				});
				singularities.add(new UniversalSingularityItem(universalSingularity.name, universalSingularity.singularities));
			}
		});
		if (config.hasChanged())
			config.save();
	}

	public final void preInit()
	{
		singularities.forEach(singularity -> GameRegistry.registerItem(singularity, "universal." + singularity.name + ".singularity"));
	}

	public void init() {}

	public final void postInit()
	{
		if (!craftingOnly)
			addToRecipeInput();
	}

	private void addToRecipeInput()
	{
		singularities.forEach(singularity -> {
			for (int i = 0; i < singularity.universalSingularities.size(); i++) {
				final UniversalSingularityWrapper universalSingularityWrapper = singularity.universalSingularities.get(i);
				if (allowed.get(singularity.name).contains(universalSingularityWrapper.name)) {
					final List<ItemStack> oreList = OreDictionary.getOres(universalSingularityWrapper.oreName, false);
					if (oreList != null && !oreList.isEmpty()) {
						CompressorManager.addOreRecipe(new ItemStack(singularity, 1, i), universalSingularityWrapper.recipeBaseValue, universalSingularityWrapper.oreName);
						Grinder.catalyst.getInput().add(new ItemStack(singularity, 1, i));
					}
				}
			}
		});
	}

	public UniversalSingularityItem getSingularityByName(@Nonnull final String name)
	{
		for (final UniversalSingularityItem singularity : singularities)
			if (singularity.name.equals(name))
				return singularity;
		return null;
	}
}
