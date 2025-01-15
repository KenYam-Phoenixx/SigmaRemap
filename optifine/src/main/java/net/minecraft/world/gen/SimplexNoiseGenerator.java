package net.minecraft.world.gen;

import java.util.Random;
import net.minecraft.util.math.MathHelper;

public class SimplexNoiseGenerator
{
    protected static final int[][] GRADS = new int[][] {{1, 1, 0}, { -1, 1, 0}, {1, -1, 0}, { -1, -1, 0}, {1, 0, 1}, { -1, 0, 1}, {1, 0, -1}, { -1, 0, -1}, {0, 1, 1}, {0, -1, 1}, {0, 1, -1}, {0, -1, -1}, {1, 1, 0}, {0, -1, 1}, { -1, 1, 0}, {0, -1, -1}};
    private static final double SQRT_3 = Math.sqrt(3.0D);
    private static final double F2 = 0.5D * (SQRT_3 - 1.0D);
    private static final double G2 = (3.0D - SQRT_3) / 6.0D;
    private final int[] p = new int[512];
    public final double xo;
    public final double yo;
    public final double zo;

    public SimplexNoiseGenerator(Random p_i1075_1_)
    {
        this.xo = p_i1075_1_.nextDouble() * 256.0D;
        this.yo = p_i1075_1_.nextDouble() * 256.0D;
        this.zo = p_i1075_1_.nextDouble() * 256.0D;

        for (int i = 0; i < 256; this.p[i] = i++)
        {
            ;
        }

        for (int l = 0; l < 256; ++l)
        {
            int j = p_i1075_1_.nextInt(256 - l);
            int k = this.p[l];
            this.p[l] = this.p[j + l];
            this.p[j + l] = k;
        }
    }

    private int getPermutValue(int permutIndex)
    {
        return this.p[permutIndex & 255];
    }

    protected static double processGrad(int[] gradElement, double xFactor, double yFactor, double zFactor)
    {
        return (double)gradElement[0] * xFactor + (double)gradElement[1] * yFactor + (double)gradElement[2] * zFactor;
    }

    private double getContrib(int gradIndex, double x, double y, double z, double offset)
    {
        double d1 = offset - x * x - y * y - z * z;
        double d0;

        if (d1 < 0.0D)
        {
            d0 = 0.0D;
        }
        else
        {
            d1 = d1 * d1;
            d0 = d1 * d1 * processGrad(GRADS[gradIndex], x, y, z);
        }

        return d0;
    }

    public double getValue(double x, double y)
    {
        double d0 = (x + y) * F2;
        int i = MathHelper.floor(x + d0);
        int j = MathHelper.floor(y + d0);
        double d1 = (double)(i + j) * G2;
        double d2 = (double)i - d1;
        double d3 = (double)j - d1;
        double d4 = x - d2;
        double d5 = y - d3;
        int k;
        int l;

        if (d4 > d5)
        {
            k = 1;
            l = 0;
        }
        else
        {
            k = 0;
            l = 1;
        }

        double d6 = d4 - (double)k + G2;
        double d7 = d5 - (double)l + G2;
        double d8 = d4 - 1.0D + 2.0D * G2;
        double d9 = d5 - 1.0D + 2.0D * G2;
        int i1 = i & 255;
        int j1 = j & 255;
        int k1 = this.getPermutValue(i1 + this.getPermutValue(j1)) % 12;
        int l1 = this.getPermutValue(i1 + k + this.getPermutValue(j1 + l)) % 12;
        int i2 = this.getPermutValue(i1 + 1 + this.getPermutValue(j1 + 1)) % 12;
        double d10 = this.getContrib(k1, d4, d5, 0.0D, 0.5D);
        double d11 = this.getContrib(l1, d6, d7, 0.0D, 0.5D);
        double d12 = this.getContrib(i2, d8, d9, 0.0D, 0.5D);
        return 70.0D * (d10 + d11 + d12);
    }

    public double func_227464_a_(double p_227464_1_, double p_227464_3_, double p_227464_5_)
    {
        double d0 = 0.3333333333333333D;
        double d1 = (p_227464_1_ + p_227464_3_ + p_227464_5_) * 0.3333333333333333D;
        int i = MathHelper.floor(p_227464_1_ + d1);
        int j = MathHelper.floor(p_227464_3_ + d1);
        int k = MathHelper.floor(p_227464_5_ + d1);
        double d2 = 0.16666666666666666D;
        double d3 = (double)(i + j + k) * 0.16666666666666666D;
        double d4 = (double)i - d3;
        double d5 = (double)j - d3;
        double d6 = (double)k - d3;
        double d7 = p_227464_1_ - d4;
        double d8 = p_227464_3_ - d5;
        double d9 = p_227464_5_ - d6;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;

        if (d7 >= d8)
        {
            if (d8 >= d9)
            {
                l = 1;
                i1 = 0;
                j1 = 0;
                k1 = 1;
                l1 = 1;
                i2 = 0;
            }
            else if (d7 >= d9)
            {
                l = 1;
                i1 = 0;
                j1 = 0;
                k1 = 1;
                l1 = 0;
                i2 = 1;
            }
            else
            {
                l = 0;
                i1 = 0;
                j1 = 1;
                k1 = 1;
                l1 = 0;
                i2 = 1;
            }
        }
        else if (d8 < d9)
        {
            l = 0;
            i1 = 0;
            j1 = 1;
            k1 = 0;
            l1 = 1;
            i2 = 1;
        }
        else if (d7 < d9)
        {
            l = 0;
            i1 = 1;
            j1 = 0;
            k1 = 0;
            l1 = 1;
            i2 = 1;
        }
        else
        {
            l = 0;
            i1 = 1;
            j1 = 0;
            k1 = 1;
            l1 = 1;
            i2 = 0;
        }

        double d10 = d7 - (double)l + 0.16666666666666666D;
        double d11 = d8 - (double)i1 + 0.16666666666666666D;
        double d12 = d9 - (double)j1 + 0.16666666666666666D;
        double d13 = d7 - (double)k1 + 0.3333333333333333D;
        double d14 = d8 - (double)l1 + 0.3333333333333333D;
        double d15 = d9 - (double)i2 + 0.3333333333333333D;
        double d16 = d7 - 1.0D + 0.5D;
        double d17 = d8 - 1.0D + 0.5D;
        double d18 = d9 - 1.0D + 0.5D;
        int j2 = i & 255;
        int k2 = j & 255;
        int l2 = k & 255;
        int i3 = this.getPermutValue(j2 + this.getPermutValue(k2 + this.getPermutValue(l2))) % 12;
        int j3 = this.getPermutValue(j2 + l + this.getPermutValue(k2 + i1 + this.getPermutValue(l2 + j1))) % 12;
        int k3 = this.getPermutValue(j2 + k1 + this.getPermutValue(k2 + l1 + this.getPermutValue(l2 + i2))) % 12;
        int l3 = this.getPermutValue(j2 + 1 + this.getPermutValue(k2 + 1 + this.getPermutValue(l2 + 1))) % 12;
        double d19 = this.getContrib(i3, d7, d8, d9, 0.6D);
        double d20 = this.getContrib(j3, d10, d11, d12, 0.6D);
        double d21 = this.getContrib(k3, d13, d14, d15, 0.6D);
        double d22 = this.getContrib(l3, d16, d17, d18, 0.6D);
        return 32.0D * (d19 + d20 + d21 + d22);
    }
}
