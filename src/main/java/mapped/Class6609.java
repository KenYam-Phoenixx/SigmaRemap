package mapped;

import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import net.minecraft.world.GameType;
import net.minecraft.world.storage.IServerWorldInfo;

import java.util.UUID;

public class Class6609 implements IServerWorldInfo {
   private final IServerConfiguration field29061;
   private final IServerWorldInfo field29062;

   public Class6609(IServerConfiguration var1, IServerWorldInfo var2) {
      this.field29061 = var1;
      this.field29062 = var2;
   }

   @Override
   public int getSpawnX() {
      return this.field29062.getSpawnX();
   }

   @Override
   public int getSpawnY() {
      return this.field29062.getSpawnY();
   }

   @Override
   public int getSpawnZ() {
      return this.field29062.getSpawnZ();
   }

   @Override
   public float method20032() {
      return this.field29062.method20032();
   }

   @Override
   public long getGameTime() {
      return this.field29062.getGameTime();
   }

   @Override
   public long getDayTime() {
      return this.field29062.getDayTime();
   }

   @Override
   public String method20054() {
      return this.field29061.getWorldName();
   }

   @Override
   public int method20060() {
      return this.field29062.method20060();
   }

   @Override
   public void method20061(int var1) {
   }

   @Override
   public boolean method20042() {
      return this.field29062.method20042();
   }

   @Override
   public int method20059() {
      return this.field29062.method20059();
   }

   @Override
   public boolean method20043() {
      return this.field29062.method20043();
   }

   @Override
   public int method20056() {
      return this.field29062.method20056();
   }

   @Override
   public GameType method20067() {
      return this.field29061.method20067();
   }

   @Override
   public void method20035(int var1) {
   }

   @Override
   public void method20036(int var1) {
   }

   @Override
   public void method20037(int var1) {
   }

   @Override
   public void method20038(float var1) {
   }

   @Override
   public void method20075(long var1) {
   }

   @Override
   public void method20076(long var1) {
   }

   @Override
   public void setSpawn(BlockPos var1, float var2) {
   }

   @Override
   public void method20055(boolean var1) {
   }

   @Override
   public void method20058(int var1) {
   }

   @Override
   public void method20044(boolean var1) {
   }

   @Override
   public void method20057(int var1) {
   }

   @Override
   public void setGameType(GameType var1) {
   }

   @Override
   public boolean isHardcore() {
      return this.field29061.isHardcore();
   }

   @Override
   public boolean method20072() {
      return this.field29061.method20072();
   }

   @Override
   public boolean method20070() {
      return this.field29062.method20070();
   }

   @Override
   public void method20071(boolean var1) {
   }

   @Override
   public GameRules getGameRulesInstance() {
      return this.field29061.getGameRulesInstance();
   }

   @Override
   public Class7235 method20069() {
      return this.field29062.method20069();
   }

   @Override
   public void method20068(Class7235 var1) {
   }

   @Override
   public Difficulty method20047() {
      return this.field29061.method20047();
   }

   @Override
   public boolean method20048() {
      return this.field29061.isDifficultyLocked();
   }

   @Override
   public Class8559<MinecraftServer> method20074() {
      return this.field29062.method20074();
   }

   @Override
   public int method20062() {
      return 0;
   }

   @Override
   public void method20063(int var1) {
   }

   @Override
   public int method20064() {
      return 0;
   }

   @Override
   public void method20065(int var1) {
   }

   @Override
   public void method20066(UUID var1) {
   }

   @Override
   public void method20049(CrashReportCategory var1) {
      var1.addDetail("Derived", true);
      this.field29062.method20049(var1);
   }
}
