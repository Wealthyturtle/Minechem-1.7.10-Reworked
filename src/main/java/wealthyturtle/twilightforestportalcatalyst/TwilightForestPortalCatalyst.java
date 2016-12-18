package wealthyturtle.twilightforestportalcatalyst;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

@Mod(modid = TwilightForestPortalCatalyst.modid, version = TwilightForestPortalCatalyst.version)
public class TwilightForestPortalCatalyst {
	
	public static final String modid = "TwilightForestPortalCatalyst";
	public static final String version = "1.0";
	
	public static Item itemTwilightForestPortalCatalyst;
	
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
