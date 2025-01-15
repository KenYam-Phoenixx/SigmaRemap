package net.minecraft.util.math.shapes;

import it.unimi.dsi.fastutil.doubles.DoubleList;

public class SimpleDoubleMerger implements IDoubleListMerger
{
    private final DoubleList list;

    public SimpleDoubleMerger(DoubleList p_i2172_1_)
    {
        this.list = p_i2172_1_;
    }

    public boolean forMergedIndexes(IDoubleListMerger.IConsumer consumer)
    {
        for (int i = 0; i <= this.list.size(); ++i)
        {
            if (!consumer.merge(i, i, i))
            {
                return false;
            }
        }

        return true;
    }

    public DoubleList func_212435_a()
    {
        return this.list;
    }
}
