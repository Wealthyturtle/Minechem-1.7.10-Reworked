package wealthyturtle.uiesingularities;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import wealthyturtle.uiesingularities.proxy.CommonProxy;

import static wealthyturtle.uiesingularities.Reference.*;

@SuppressWarnings("unused")
@Mod(modid = MOD_ID, name = MOD_NAME, version = MOD_VERSION, acceptedMinecraftVersions = MC_VERSION, dependencies = "required-after:Avaritia")
public class UniversalSingularityMod
{
	@Mod.Instance(MOD_ID)
	public static UniversalSingularityMod instance;

	@SidedProxy(serverSide = COMMON_PROXY, clientSide = CLIENT_PROXY)
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(final FMLPreInitializationEvent event)
	{
		proxy.preInit();
	}

	@Mod.EventHandler
	public void init(final FMLInitializationEvent event)
	{
		proxy.init();
	}

	@Mod.EventHandler
	public void postInit(final FMLPostInitializationEvent event)
	{
		proxy.postInit();
	}
}