package wealthyturtle.uiesingularities;

/*
 * Created by WanionCane(https://github.com/WanionCane).
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

import javax.annotation.Nonnull;

public final class UniversalSingularityWrapper
{
	public final String name;
	public final String oreName;
	public final int recipeBaseValue;
	public final int cColor;
	public final int dColor;

	public UniversalSingularityWrapper(@Nonnull final String name, @Nonnull final String oreName, final int recipeBaseValue, final int cColor, final int dColor)
	{
		this.name = name;
		this.oreName = oreName;
		this.recipeBaseValue = recipeBaseValue;
		this.cColor = cColor;
		this.dColor = dColor;
	}
}