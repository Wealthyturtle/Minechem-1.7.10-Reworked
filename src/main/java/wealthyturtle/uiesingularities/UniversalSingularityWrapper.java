package wealthyturtle.uiesingularities;

import javax.annotation.Nonnull;

public final class UniversalSingularityWrapper
{
	public final String name;
	public final String oreName;
	public final int recipeBaseValue;
	public final int cColor;
	public final int dColor;
	public final boolean enabled;

	public UniversalSingularityWrapper(@Nonnull final String name, @Nonnull final String oreName, final int recipeBaseValue, final int cColor, final int dColor)
	{
		this.name = name;
		this.oreName = oreName;
		this.recipeBaseValue = recipeBaseValue;
		this.cColor = cColor;
		this.dColor = dColor;
		this.enabled = true;
	}

	public UniversalSingularityWrapper(@Nonnull final String name, @Nonnull final String oreName, final int recipeBaseValue, final int cColor, final int dColor, final boolean enabled)
	{
		this.name = name;
		this.oreName = oreName;
		this.recipeBaseValue = recipeBaseValue;
		this.cColor = cColor;
		this.dColor = dColor;
		this.enabled = enabled;
	}
}