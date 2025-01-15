package net.minecraft.scoreboard;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.util.text.event.HoverEvent;

public class ScoreObjective
{
    private final Scoreboard scoreboard;
    private final String name;
    private final ScoreCriteria objectiveCriteria;
    private ITextComponent displayName;
    private ScoreCriteria.RenderType renderType;

    public ScoreObjective(Scoreboard p_i3433_1_, String p_i3433_2_, ScoreCriteria p_i3433_3_, ITextComponent p_i3433_4_, ScoreCriteria.RenderType p_i3433_5_)
    {
        this.scoreboard = p_i3433_1_;
        this.name = p_i3433_2_;
        this.objectiveCriteria = p_i3433_3_;
        this.displayName = p_i3433_4_;
        this.renderType = p_i3433_5_;
    }

    public Scoreboard getScoreboard()
    {
        return this.scoreboard;
    }

    public String getName()
    {
        return this.name;
    }

    public ScoreCriteria getCriteria()
    {
        return this.objectiveCriteria;
    }

    public ITextComponent getDisplayName()
    {
        return this.displayName;
    }

    public ITextComponent func_197890_e()
    {
        return TextComponentUtils.wrapInSquareBrackets(this.displayName.deepCopy().applyTextStyle((p_211544_1_) ->
        {
            p_211544_1_.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(this.getName())));
        }));
    }

    public void setDisplayName(ITextComponent p_199864_1_)
    {
        this.displayName = p_199864_1_;
        this.scoreboard.onObjectiveChanged(this);
    }

    public ScoreCriteria.RenderType getRenderType()
    {
        return this.renderType;
    }

    public void setRenderType(ScoreCriteria.RenderType p_199866_1_)
    {
        this.renderType = p_199866_1_;
        this.scoreboard.onObjectiveChanged(this);
    }
}
