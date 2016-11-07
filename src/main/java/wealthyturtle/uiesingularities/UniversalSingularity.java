package wealthyturtle.uiesingularities;

import javax.annotation.Nonnull;
import java.util.List;

public final class UniversalSingularity
{
	public final String name;
	public final List<UniversalSingularityWrapper> singularities;

	public UniversalSingularity(@Nonnull final String name, @Nonnull final List<UniversalSingularityWrapper> singularities)
	{
		this.name = name;
		this.singularities = singularities;
	}
}