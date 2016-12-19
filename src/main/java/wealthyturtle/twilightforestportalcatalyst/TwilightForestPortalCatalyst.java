package wealthyturtle.twilightforestportalcatalyst;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import wealthyturtle.twilightforestportalcatalyst.proxy.ClientProxy;
import wealthyturtle.twilightforestportalcatalyst.proxy.CommonProxy;

@Mod(modid = TwilightForestPortalCatalyst.modid, version = TwilightForestPortalCatalyst.version)
public class TwilightForestPortalCatalyst {
	
	public static final String modid = "TwilightForestPortalCatalyst";
	public static final String version = "3.0";
	
	public static Item itemTwilightForestPortalCatalyst;
	
	@Mod.Instance(modid)
	public static TwilightForestPortalCatalyst instance;
	
	//@SidedProxy(serverSide = COMMON_PROXY, clientSide = CLIENT_PROXY)
	public static CommonProxy proxy;
	
	public static final CreativeTabs creativeTabs = new CreativeTabs(modid)
	{
		@SideOnly(Side.CLIENT)
		@Override
		public Item getTabIconItem()
		{
			return itemTwilightForestPortalCatalyst;
		}
	};
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent) {
		itemTwilightForestPortalCatalyst = new TFPCItem().setUnlocalizedName("TwilightForestPortalCatalyst");
		GameRegistry.registerItem(itemTwilightForestPortalCatalyst, "TwilightForestPortalCatalyst");
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent) {
		
	}
}
