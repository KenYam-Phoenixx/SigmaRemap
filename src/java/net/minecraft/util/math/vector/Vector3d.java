package net.minecraft.util.math.vector;

import mapped.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.MathHelper;

import java.util.EnumSet;

public class Vector3d implements Class2955 {
   public static final Vector3d ZERO = new Vector3d(0.0D, 0.0D, 0.0D);
   public double x;
   public double y;
   public double z;

   public static Vector3d unpack(int var0) {
      double var3 = (double)(var0 >> 16 & 0xFF) / 255.0;
      double var5 = (double)(var0 >> 8 & 0xFF) / 255.0;
      double var7 = (double)(var0 & 0xFF) / 255.0;
      return new Vector3d(var3, var5, var7);
   }

   public static Vector3d method11328(Vector3i var0) {
      return new Vector3d((double)var0.getX() + 0.5, (double)var0.getY() + 0.5, (double)var0.getZ() + 0.5);
   }

   public static Vector3d copy(Vector3i var0) {
      return new Vector3d((double)var0.getX(), (double)var0.getY(), (double)var0.getZ());
   }

   public static Vector3d method11330(Vector3i var0) {
      return new Vector3d((double)var0.getX() + 0.5, (double)var0.getY(), (double)var0.getZ() + 0.5);
   }

   public static Vector3d method11331(Vector3i var0, double var1) {
      return new Vector3d((double)var0.getX() + 0.5, (double)var0.getY() + var1, (double)var0.getZ() + 0.5);
   }

   public Vector3d(double var1, double var3, double var5) {
      this.x = var1;
      this.y = var3;
      this.z = var5;
   }

   public Vector3d(Vector3f var1) {
      this((double)var1.method25269(), (double)var1.method25270(), (double)var1.method25271());
   }

   public Vector3d subtractReverse(Vector3d var1) {
      return new Vector3d(var1.x - this.x, var1.y - this.y, var1.z - this.z);
   }

   public Vector3d method11333() {
      double var3 = (double) MathHelper.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
      return !(var3 < 1.0E-4) ? new Vector3d(this.x / var3, this.y / var3, this.z / var3) : ZERO;
   }

   public double dotProduct(Vector3d var1) {
      return this.x * var1.x + this.y * var1.y + this.z * var1.z;
   }

   public Vector3d method11335(Vector3d var1) {
      return new Vector3d(
         this.y * var1.z - this.z * var1.y,
         this.z * var1.x - this.x * var1.z,
         this.x * var1.y - this.y * var1.x
      );
   }

   public Vector3d subtract(Vector3d var1) {
      return this.method11337(var1.x, var1.y, var1.z);
   }

   public Vector3d method11337(double var1, double var3, double var5) {
      return this.add(-var1, -var3, -var5);
   }

   public Vector3d add(Vector3d var1) {
      return this.add(var1.x, var1.y, var1.z);
   }

   public Vector3d add(double var1, double var3, double var5) {
      return new Vector3d(this.x + var1, this.y + var3, this.z + var5);
   }

   public boolean method11340(Class2955 var1, double var2) {
      return this.method11343(var1.getX(), var1.getY(), var1.getZ()) < var2 * var2;
   }

   public double method11341(Vector3d var1) {
      double var4 = var1.x - this.x;
      double var6 = var1.y - this.y;
      double var8 = var1.z - this.z;
      return (double) MathHelper.sqrt(var4 * var4 + var6 * var6 + var8 * var8);
   }

   public double squareDistanceTo(Vector3d var1) {
      double var4 = var1.x - this.x;
      double var6 = var1.y - this.y;
      double var8 = var1.z - this.z;
      return var4 * var4 + var6 * var6 + var8 * var8;
   }

   public double method11343(double var1, double var3, double var5) {
      double var9 = var1 - this.x;
      double var11 = var3 - this.y;
      double var13 = var5 - this.z;
      return var9 * var9 + var11 * var11 + var13 * var13;
   }

   public Vector3d scale(double var1) {
      return this.mul(var1, var1, var1);
   }

   public Vector3d method11345() {
      return this.scale(-1.0);
   }

   public Vector3d method11346(Vector3d var1) {
      return this.mul(var1.x, var1.y, var1.z);
   }

   public Vector3d mul(double var1, double var3, double var5) {
      return new Vector3d(this.x * var1, this.y * var3, this.z * var5);
   }

   public double length() {
      return (double) MathHelper.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
   }

   public double lengthSquared() {
      return this.x * this.x + this.y * this.y + this.z * this.z;
   }

   @Override
   public boolean equals(Object var1) {
      if (this != var1) {
         if (var1 instanceof Vector3d) {
            Vector3d var4 = (Vector3d)var1;
            if (Double.compare(var4.x, this.x) == 0) {
               return Double.compare(var4.y, this.y) == 0 ? Double.compare(var4.z, this.z) == 0 : false;
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   @Override
   public int hashCode() {
      long var3 = Double.doubleToLongBits(this.x);
      int var5 = (int)(var3 ^ var3 >>> 32);
      var3 = Double.doubleToLongBits(this.y);
      var5 = 31 * var5 + (int)(var3 ^ var3 >>> 32);
      var3 = Double.doubleToLongBits(this.z);
      return 31 * var5 + (int)(var3 ^ var3 >>> 32);
   }

   @Override
   public String toString() {
      return "(" + this.x + ", " + this.y + ", " + this.z + ")";
   }

   public Vector3d method11350(float var1) {
      float var4 = MathHelper.cos(var1);
      float var5 = MathHelper.sin(var1);
      double var6 = this.x;
      double var8 = this.y * (double)var4 + this.z * (double)var5;
      double var10 = this.z * (double)var4 - this.y * (double)var5;
      return new Vector3d(var6, var8, var10);
   }

   public Vector3d method11351(float var1) {
      float var4 = MathHelper.cos(var1);
      float var5 = MathHelper.sin(var1);
      double var6 = this.x * (double)var4 + this.z * (double)var5;
      double var8 = this.y;
      double var10 = this.z * (double)var4 - this.x * (double)var5;
      return new Vector3d(var6, var8, var10);
   }

   public Vector3d method11352(float var1) {
      float var4 = MathHelper.cos(var1);
      float var5 = MathHelper.sin(var1);
      double var6 = this.x * (double)var4 + this.y * (double)var5;
      double var8 = this.y * (double)var4 - this.x * (double)var5;
      double var10 = this.z;
      return new Vector3d(var6, var8, var10);
   }

   public static Vector3d method11353(Vector2f var0) {
      return method11354(var0.x, var0.y);
   }

   public static Vector3d method11354(float var0, float var1) {
      float var4 = MathHelper.cos(-var1 * (float) (Math.PI / 180.0) - (float) Math.PI);
      float var5 = MathHelper.sin(-var1 * (float) (Math.PI / 180.0) - (float) Math.PI);
      float var6 = -MathHelper.cos(-var0 * (float) (Math.PI / 180.0));
      float var7 = MathHelper.sin(-var0 * (float) (Math.PI / 180.0));
      return new Vector3d((double)(var5 * var6), (double)var7, (double)(var4 * var6));
   }

   public Vector3d method11355(EnumSet<Direction.Axis> var1) {
      double var4 = !var1.contains(Direction.Axis.X) ? this.x : (double) MathHelper.floor(this.x);
      double var6 = !var1.contains(Direction.Axis.Y) ? this.y : (double) MathHelper.floor(this.y);
      double var8 = !var1.contains(Direction.Axis.Z) ? this.z : (double) MathHelper.floor(this.z);
      return new Vector3d(var4, var6, var8);
   }

   public double getCoordinate(Direction.Axis var1) {
      return var1.getCoordinate(this.x, this.y, this.z);
   }

   @Override
   public final double getX() {
      return this.x;
   }

   @Override
   public final double getY() {
      return this.y;
   }

   @Override
   public final double getZ() {
      return this.z;
   }
}
