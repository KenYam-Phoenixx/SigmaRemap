package net.minecraft.network.play.server;

import com.google.common.collect.Sets;
import mapped.*;
import net.minecraft.client.network.play.IClientPlayNetHandler;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.GameType;
import net.minecraft.world.World;

import java.io.IOException;
import java.util.Set;
import java.util.function.Supplier;

public class SJoinGamePacket implements IPacket<IClientPlayNetHandler> {
   private static String[] field24405;
   private int field24406;
   private long field24407;
   private boolean field24408;
   private GameType field24409;
   private GameType field24410;
   private Set<RegistryKey<World>> field24411;
   private DynamicRegistriesImpl field24412;
   private DimensionType field24413;
   private RegistryKey<World> field24414;
   private int field24415;
   private int field24416;
   private boolean field24417;
   private boolean field24418;
   private boolean field24419;
   private boolean field24420;

   public SJoinGamePacket() {
   }

   public SJoinGamePacket(
      int var1,
      GameType var2,
      GameType var3,
      long var4,
      boolean var6,
      Set<RegistryKey<World>> var7,
      DynamicRegistriesImpl var8,
      DimensionType var9,
      RegistryKey<World> var10,
      int var11,
      int var12,
      boolean var13,
      boolean var14,
      boolean var15,
      boolean var16
   ) {
      this.field24406 = var1;
      this.field24411 = var7;
      this.field24412 = var8;
      this.field24413 = var9;
      this.field24414 = var10;
      this.field24407 = var4;
      this.field24409 = var2;
      this.field24410 = var3;
      this.field24415 = var11;
      this.field24408 = var6;
      this.field24416 = var12;
      this.field24417 = var13;
      this.field24418 = var14;
      this.field24419 = var15;
      this.field24420 = var16;
   }

   @Override
   public void readPacketData(PacketBuffer var1) throws IOException {
      this.field24406 = var1.readInt();
      this.field24408 = var1.readBoolean();
      this.field24409 = GameType.getByID(var1.readByte());
      this.field24410 = GameType.getByID(var1.readByte());
      int var4 = var1.readVarInt();
      this.field24411 = Sets.newHashSet();

      for (int var5 = 0; var5 < var4; var5++) {
         this.field24411.add(RegistryKey.<World>getOrCreateKey(Registry.WORLD_KEY, var1.readResourceLocation()));
      }

      this.field24412 = var1.<DynamicRegistriesImpl>func_240628_a_(DynamicRegistriesImpl.field40301);
      this.field24413 = var1.<Supplier<DimensionType>>func_240628_a_(DimensionType.DIMENSION_TYPE_CODEC).get();
      this.field24414 = RegistryKey.<World>getOrCreateKey(Registry.WORLD_KEY, var1.readResourceLocation());
      this.field24407 = var1.readLong();
      this.field24415 = var1.readVarInt();
      this.field24416 = var1.readVarInt();
      this.field24417 = var1.readBoolean();
      this.field24418 = var1.readBoolean();
      this.field24419 = var1.readBoolean();
      this.field24420 = var1.readBoolean();
   }

   @Override
   public void writePacketData(PacketBuffer var1) throws IOException {
      var1.writeInt(this.field24406);
      var1.writeBoolean(this.field24408);
      var1.writeByte(this.field24409.getID());
      var1.writeByte(this.field24410.getID());
      var1.writeVarInt(this.field24411.size());

      for (RegistryKey var5 : this.field24411) {
         var1.writeResourceLocation(var5.getLocation());
      }

      var1.func_240629_a_(DynamicRegistriesImpl.field40301, this.field24412);
      var1.func_240629_a_(DimensionType.DIMENSION_TYPE_CODEC, () -> this.field24413);
      var1.writeResourceLocation(this.field24414.getLocation());
      var1.writeLong(this.field24407);
      var1.writeVarInt(this.field24415);
      var1.writeVarInt(this.field24416);
      var1.writeBoolean(this.field24417);
      var1.writeBoolean(this.field24418);
      var1.writeBoolean(this.field24419);
      var1.writeBoolean(this.field24420);
   }

   public void processPacket(IClientPlayNetHandler var1) {
      var1.handleJoinGame(this);
   }

   public int method17287() {
      return this.field24406;
   }

   public long method17288() {
      return this.field24407;
   }

   public boolean method17289() {
      return this.field24408;
   }

   public GameType method17290() {
      return this.field24409;
   }

   public GameType method17291() {
      return this.field24410;
   }

   public Set<RegistryKey<World>> method17292() {
      return this.field24411;
   }

   public DynamicRegistries method17293() {
      return this.field24412;
   }

   public DimensionType method17294() {
      return this.field24413;
   }

   public RegistryKey<World> method17295() {
      return this.field24414;
   }

   public int method17296() {
      return this.field24416;
   }

   public boolean method17297() {
      return this.field24417;
   }

   public boolean method17298() {
      return this.field24418;
   }

   public boolean method17299() {
      return this.field24419;
   }

   public boolean method17300() {
      return this.field24420;
   }
}
