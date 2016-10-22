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
						new UniversalSingularityWrapper("coal", "blockCoal", 0, 0x282828, 0x0C0C0C),
						new UniversalSingularityWrapper("emerald", "blockEmerald", 0, 0x60DB83, 0x2CA746),
						new UniversalSingularityWrapper("diamond", "blockDiamond", 0, 0x4AEDD1, 0x30DBBD)
				)),
				// Applied Energistics Singularities
				new UniversalSingularity("appliedEnergistics", Arrays.asList(
						new UniversalSingularityWrapper("certus", "blockCertus", 0, 0xC6D4F8, 0xB9CAE7),
						new UniversalSingularityWrapper("fluix", "blockFluix", 0, 0x903BC8, 0x572FA3)
				)),
				// Big Reactors Singularities
				new UniversalSingularity("bigReactors", Arrays.asList(
						new UniversalSingularityWrapper("blutonium", "blockBlutonium", 0, 0x4642D6, 0x1B00E6),
						new UniversalSingularityWrapper("cyanite", "blockCyanite", 0, 0x5CAFDB, 0x3DAAFF),
						new UniversalSingularityWrapper("graphite", "blockGraphite", 0, 0x686868, 0x525252),
						new UniversalSingularityWrapper("ludicrite", "blockLudicrite", 0, 0xD15CD7, 0xC05EDB),
						new UniversalSingularityWrapper("yellorium", "blockYellorium", 0, 0xD9DB5C, 0xEBFF3D)
				)),
				// Botania Singularities
				new UniversalSingularity("botania", Arrays.asList(
						new UniversalSingularityWrapper("manasteel", "blockManasteel", 0, 0x7ACDFD, 0x2CAEF8),
						new UniversalSingularityWrapper("terrasteel", "blockTerrasteel", 0, 0x62D62A, 0x31AF04)
				)),
				
				// Draconic Evolution Singularities
				new UniversalSingularity("draconicEvolution", Collections.singletonList(
						new UniversalSingularityWrapper("awakenedDraconium", "blockAwakenedDraconium", 0, 0xFF7200, 0xFF5400)
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
						new UniversalSingularityWrapper("fairy", "blockFairy", 0, 0xFF83C3, 0xFF65B4),
						new UniversalSingularityWrapper("pokefennium", "blockPokefennium", 0, 0x436B73, 0x485361),
						new UniversalSingularityWrapper("red_aurum", "blockRed_aurum", 0, 0xFF5B09, 0xFF3800)
				)),
				// Extra Utilities Singularities
				new UniversalSingularity("extraUtilities", Collections.singletonList(
						new UniversalSingularityWrapper("unstable", "blockUnstable", 0, 0xFFFFFF, 0xF8F8F8)
				)),
				// Metallurgy Singularities
				new UniversalSingularity("metallurgy", Collections.singletonList(
						new UniversalSingularityWrapper("tartarite", "blockTartarite", 0, 0xAE3400, 0x792400)
				)),
				// ProjectE Singularities
				new UniversalSingularity("projectE", Arrays.asList(
						new UniversalSingularityWrapper("darkMatter", "blockDarkMatter", 0, 0x38173C, 0x240F27),
						new UniversalSingularityWrapper("redMatter", "blockRedMatter", 0, 0x9A0707, 0x7B0606)
				)),
				// Redstone Arsenal Singularities
				new UniversalSingularity("redstoneArsenal", Arrays.asList(
						new UniversalSingularityWrapper("electrumFlux", "blockElectrumFlux", 0, 0xD0B64D, 0xA40606),
						new UniversalSingularityWrapper("crystalFlux", "blockCrystalFlux", 0, 0xFE333A, 0x7A001B)
				)),
				// Tinkers' Construct Singularities
				new UniversalSingularity("tinkersConstruct", Arrays.asList(
						new UniversalSingularityWrapper("aluminumBrass", "blockAluminumBrass", 0, 0xF0D467, 0xD4B148),
						new UniversalSingularityWrapper("alumite", "blockAlumite", 0, 0xE9ADDA, 0xE298D1),
						new UniversalSingularityWrapper("ardite", "blockArdite", 0, 0xD24900, 0x960000),
						new UniversalSingularityWrapper("cobalt", "blockCobalt", 0, 0x2376DD, 0x023C9B),
						new UniversalSingularityWrapper("manyullyn", "blockManyullyn", 0, 0xA97DE0, 0x926AC3),
						new UniversalSingularityWrapper("pigIron", "blockPigIron", 0, 0xF0A8A4, 0xEF7E4A)
				)),
				// General (Not Mod Specific)
				new UniversalSingularity("general", Arrays.asList(
						new UniversalSingularityWrapper("aluminum", "blockAluminum", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("brass", "blocBrass", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("bronze", "blockBronze", 0, 0x0, 0x0),
						new UniversalSingularityWrapper("charcoal", "blockCharcoal", 0, 0x605543, 0x100E0B),
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
