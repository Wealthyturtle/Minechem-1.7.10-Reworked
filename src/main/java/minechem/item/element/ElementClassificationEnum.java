package minechem.item.element;

import minechem.item.IDescriptiveName;
import net.minecraft.util.StatCollector;

public enum ElementClassificationEnum implements IDescriptiveName
{
    //Wealthyturtle Injection Begin
    nonmetal("Non-Metal"), inertGas("Inert Gas"), halogen("Halogen"), alkaliMetal("Alkali Metal"), alkalineEarthMetal("Alkaline Earth Metal"), semimetallic("Metalloid"), // Yes this is the proper name!
    postTransitionMetal("Post-Transition Metal"), transitionMetal("Transition Metal"), lanthanide("Lanthanide"), actinide("Actinide"), superActinide("Superactinide"), unknown("Unknown");
    //Wealthyturtle Injection End
	
    private final String descriptiveName;

    ElementClassificationEnum(String descriptiveName)
    {
        this.descriptiveName = descriptiveName;
    }

    public String className()
    {
        return descriptiveName;
    }

    @Override
    public String descriptiveName()
    {
        String localizedName = StatCollector.translateToLocal("element.classification." + descriptiveName);
        if (!localizedName.isEmpty() || !localizedName.equals("element.classification." + descriptiveName))
        {
            return localizedName;
        }
        return descriptiveName;
    }
}
