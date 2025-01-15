// 
// Decompiled by Procyon v0.6.0
// 

package mapped;

import java.util.AbstractList;
import javax.annotation.Nullable;
import com.google.common.hash.Hashing;

import java.util.function.Function;
import com.mojang.datafixers.types.DynamicOps;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.JsonOps;
import java.util.Iterator;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.UUID;
import java.util.Map;
import java.util.Set;
import com.mojang.datafixers.DataFixer;
import net.minecraft.nbt.INBT;
import net.minecraft.world.dimension.DimensionType;

public class Class8660
{
    private String field36337;
    private int field36338;
    private boolean field36339;
    public static final Class2113 field36340;
    private long field36341;
    private Class9505 field36342;
    private Class51 field36343;
    private String field36344;
    private int field36345;
    private int field36346;
    private int field36347;
    private long field36348;
    private long field36349;
    private long field36350;
    private long field36351;
    private final DataFixer field36352;
    private final int field36353;
    private boolean field36354;
    private Class51 field36355;
    private String field36356;
    private int field36357;
    private int field36358;
    private boolean field36359;
    private int field36360;
    private boolean field36361;
    private int field36362;
    private Class101 field36363;
    private boolean field36364;
    private boolean field36365;
    private boolean field36366;
    private boolean field36367;
    private Class2113 field36368;
    private boolean field36369;
    private double field36370;
    private double field36371;
    private double field36372;
    private long field36373;
    private double field36374;
    private double field36375;
    private double field36376;
    private int field36377;
    private int field36378;
    private final Set<String> field36379;
    private final Set<String> field36380;
    private final Map<DimensionType, Class51> field36381;
    private Class51 field36382;
    private int field36383;
    private int field36384;
    private UUID field36385;
    private Set<String> field36386;
    private boolean field36387;
    private final Class8878 field36388;
    private final Class7858<Class394> field36389;
    
    public Class8660() {
        this.field36342 = Class9505.field40892;
        this.field36343 = new Class51();
        this.field36372 = 6.0E7;
        this.field36375 = 5.0;
        this.field36376 = 0.2;
        this.field36377 = 5;
        this.field36378 = 15;
        this.field36379 = Sets.newHashSet();
        this.field36380 = Sets.newLinkedHashSet();
        this.field36381 = Maps.newIdentityHashMap();
        this.field36386 = Sets.newLinkedHashSet();
        this.field36388 = new Class8878();
        this.field36389 = new Class7858<Class394>(Class7271.field28166);
        this.field36352 = null;
        this.field36353 = Class9528.method35579().getWorldVersion();
        this.method29573(new Class51());
    }
    
    public Class8660(final Class51 class51, final DataFixer field36352, final int field36353, final Class51 field36354) {
        this.field36342 = Class9505.field40892;
        this.field36343 = new Class51();
        this.field36372 = 6.0E7;
        this.field36375 = 5.0;
        this.field36376 = 0.2;
        this.field36377 = 5;
        this.field36378 = 15;
        this.field36379 = Sets.newHashSet();
        this.field36380 = Sets.newLinkedHashSet();
        this.field36381 = Maps.newIdentityHashMap();
        this.field36386 = Sets.newLinkedHashSet();
        this.field36388 = new Class8878();
        this.field36389 = new Class7858<Class394>(Class7271.field28166);
        this.field36352 = field36352;
        final Class52 method328 = class51.method328("ServerBrands", 8);
        for (int i = 0; i < method328.size(); ++i) {
            this.field36386.add(method328.method353(i));
        }
        this.field36387 = class51.method329("WasModded");
        if (class51.method316("Version", 10)) {
            final Class51 method329 = class51.method327("Version");
            this.field36337 = method329.method323("Name");
            this.field36338 = method329.method319("Id");
            this.field36339 = method329.method329("Snapshot");
        }
        this.field36341 = class51.method320("RandomSeed");
        if (class51.method316("generatorName", 8)) {
            this.field36342 = Class9505.method35410(class51.method323("generatorName"));
            if (this.field36342 != null) {
                if (this.field36342 != Class9505.field40896) {
                    if (this.field36342.method35409()) {
                        int method330 = 0;
                        if (class51.method316("generatorVersion", 99)) {
                            method330 = class51.method319("generatorVersion");
                        }
                        this.field36342 = this.field36342.method35403(method330);
                    }
                }
                else {
                    this.field36344 = class51.method323("generatorOptions");
                }
            }
            else {
                this.field36342 = Class9505.field40892;
            }
            this.method29573(class51.method327("generatorOptions"));
        }
        this.field36363 = Class101.method592(class51.method319("GameType"));
        if (class51.method316("legacy_custom_options", 8)) {
            this.field36344 = class51.method323("legacy_custom_options");
        }
        if (!class51.method316("MapFeatures", 99)) {
            this.field36364 = true;
        }
        else {
            this.field36364 = class51.method329("MapFeatures");
        }
        this.field36345 = class51.method319("SpawnX");
        this.field36346 = class51.method319("SpawnY");
        this.field36347 = class51.method319("SpawnZ");
        this.field36348 = class51.method320("Time");
        if (!class51.method316("DayTime", 99)) {
            this.field36349 = this.field36348;
        }
        else {
            this.field36349 = class51.method320("DayTime");
        }
        this.field36350 = class51.method320("LastPlayed");
        this.field36351 = class51.method320("SizeOnDisk");
        this.field36356 = class51.method323("LevelName");
        this.field36357 = class51.method319("version");
        this.field36358 = class51.method319("clearWeatherTime");
        this.field36360 = class51.method319("rainTime");
        this.field36359 = class51.method329("raining");
        this.field36362 = class51.method319("thunderTime");
        this.field36361 = class51.method329("thundering");
        this.field36365 = class51.method329("hardcore");
        if (!class51.method316("initialized", 99)) {
            this.field36367 = true;
        }
        else {
            this.field36367 = class51.method329("initialized");
        }
        if (!class51.method316("allowCommands", 99)) {
            this.field36366 = (this.field36363 == Class101.field299);
        }
        else {
            this.field36366 = class51.method329("allowCommands");
        }
        this.field36353 = field36353;
        if (field36354 != null) {
            this.field36355 = field36354;
        }
        if (class51.method316("GameRules", 10)) {
            this.field36388.method31213(class51.method327("GameRules"));
        }
        if (class51.method316("Difficulty", 99)) {
            this.field36368 = Class2113.method8237(class51.method317("Difficulty"));
        }
        if (class51.method316("DifficultyLocked", 1)) {
            this.field36369 = class51.method329("DifficultyLocked");
        }
        if (class51.method316("BorderCenterX", 99)) {
            this.field36370 = class51.method322("BorderCenterX");
        }
        if (class51.method316("BorderCenterZ", 99)) {
            this.field36371 = class51.method322("BorderCenterZ");
        }
        if (class51.method316("BorderSize", 99)) {
            this.field36372 = class51.method322("BorderSize");
        }
        if (class51.method316("BorderSizeLerpTime", 99)) {
            this.field36373 = class51.method320("BorderSizeLerpTime");
        }
        if (class51.method316("BorderSizeLerpTarget", 99)) {
            this.field36374 = class51.method322("BorderSizeLerpTarget");
        }
        if (class51.method316("BorderSafeZone", 99)) {
            this.field36375 = class51.method322("BorderSafeZone");
        }
        if (class51.method316("BorderDamagePerBlock", 99)) {
            this.field36376 = class51.method322("BorderDamagePerBlock");
        }
        if (class51.method316("BorderWarningBlocks", 99)) {
            this.field36377 = class51.method319("BorderWarningBlocks");
        }
        if (class51.method316("BorderWarningTime", 99)) {
            this.field36378 = class51.method319("BorderWarningTime");
        }
        if (class51.method316("DimensionData", 10)) {
            final Class51 method331 = class51.method327("DimensionData");
            for (final String s : method331.method293()) {
                this.field36381.put(DimensionType.method1274(Integer.parseInt(s)), method331.method327(s));
            }
        }
        if (class51.method316("DataPacks", 10)) {
            final Class51 method332 = class51.method327("DataPacks");
            final Class52 method333 = method332.method328("Disabled", 8);
            for (int j = 0; j < method333.size(); ++j) {
                this.field36379.add(method333.method353(j));
            }
            final Class52 method334 = method332.method328("Enabled", 8);
            for (int k = 0; k < method334.size(); ++k) {
                this.field36380.add(method334.method353(k));
            }
        }
        if (class51.method316("CustomBossEvents", 10)) {
            this.field36382 = class51.method327("CustomBossEvents");
        }
        if (class51.method316("ScheduledEvents", 9)) {
            this.field36389.method25417(class51.method328("ScheduledEvents", 10));
        }
        if (class51.method316("WanderingTraderSpawnDelay", 99)) {
            this.field36383 = class51.method319("WanderingTraderSpawnDelay");
        }
        if (class51.method316("WanderingTraderSpawnChance", 99)) {
            this.field36384 = class51.method319("WanderingTraderSpawnChance");
        }
        if (class51.method316("WanderingTraderId", 8)) {
            this.field36385 = UUID.fromString(class51.method323("WanderingTraderId"));
        }
    }
    
    public Class8660(final Class8511 class8511, final String field36356) {
        this.field36342 = Class9505.field40892;
        this.field36343 = new Class51();
        this.field36372 = 6.0E7;
        this.field36375 = 5.0;
        this.field36376 = 0.2;
        this.field36377 = 5;
        this.field36378 = 15;
        this.field36379 = Sets.newHashSet();
        this.field36380 = Sets.newLinkedHashSet();
        this.field36381 = Maps.newIdentityHashMap();
        this.field36386 = Sets.newLinkedHashSet();
        this.field36388 = new Class8878();
        this.field36389 = new Class7858<Class394>(Class7271.field28166);
        this.field36352 = null;
        this.field36353 = Class9528.method35579().getWorldVersion();
        this.method29531(class8511);
        this.field36356 = field36356;
        this.field36368 = Class8660.field36340;
        this.field36367 = false;
    }
    
    public void method29531(final Class8511 class8511) {
        this.field36341 = class8511.method28435();
        this.field36363 = class8511.method28436();
        this.field36364 = class8511.method28438();
        this.field36365 = class8511.method28437();
        this.field36342 = class8511.method28439();
        this.method29573((Class51)Dynamic.convert((DynamicOps)JsonOps.INSTANCE, (DynamicOps)Class8453.field34721, (Object)class8511.method28441()));
        this.field36366 = class8511.method28440();
    }
    
    public Class51 method29532(Class51 field36355) {
        this.method29541();
        if (field36355 == null) {
            field36355 = this.field36355;
        }
        final Class51 class51 = new Class51();
        this.method29533(class51, field36355);
        return class51;
    }
    
    private void method29533(final Class51 class51, final Class51 class52) {
        final Class52 class53 = new Class52();
        this.field36386.stream().map((Function<? super Object, ?>)Class50::method290).forEach(class53::add);
        class51.method295("ServerBrands", class53);
        class51.method312("WasModded", this.field36387);
        final Class51 class54 = new Class51();
        class54.method306("Name", Class9528.method35579().getName());
        class54.method298("Id", Class9528.method35579().getWorldVersion());
        class54.method312("Snapshot", !Class9528.method35579().isStable());
        class51.method295("Version", class54);
        class51.method298("DataVersion", Class9528.method35579().getWorldVersion());
        class51.method299("RandomSeed", this.field36341);
        class51.method306("generatorName", this.field36342.method35399());
        class51.method298("generatorVersion", this.field36342.method35402());
        if (!this.field36343.method331()) {
            class51.method295("generatorOptions", this.field36343);
        }
        if (this.field36344 != null) {
            class51.method306("legacy_custom_options", this.field36344);
        }
        class51.method298("GameType", this.field36363.method585());
        class51.method312("MapFeatures", this.field36364);
        class51.method298("SpawnX", this.field36345);
        class51.method298("SpawnY", this.field36346);
        class51.method298("SpawnZ", this.field36347);
        class51.method299("Time", this.field36348);
        class51.method299("DayTime", this.field36349);
        class51.method299("SizeOnDisk", this.field36351);
        class51.method299("LastPlayed", Class8349.method27839());
        class51.method306("LevelName", this.field36356);
        class51.method298("version", this.field36357);
        class51.method298("clearWeatherTime", this.field36358);
        class51.method298("rainTime", this.field36360);
        class51.method312("raining", this.field36359);
        class51.method298("thunderTime", this.field36362);
        class51.method312("thundering", this.field36361);
        class51.method312("hardcore", this.field36365);
        class51.method312("allowCommands", this.field36366);
        class51.method312("initialized", this.field36367);
        class51.method305("BorderCenterX", this.field36370);
        class51.method305("BorderCenterZ", this.field36371);
        class51.method305("BorderSize", this.field36372);
        class51.method299("BorderSizeLerpTime", this.field36373);
        class51.method305("BorderSafeZone", this.field36375);
        class51.method305("BorderDamagePerBlock", this.field36376);
        class51.method305("BorderSizeLerpTarget", this.field36374);
        class51.method305("BorderWarningBlocks", this.field36377);
        class51.method305("BorderWarningTime", this.field36378);
        if (this.field36368 != null) {
            class51.method296("Difficulty", (byte)this.field36368.method8235());
        }
        class51.method312("DifficultyLocked", this.field36369);
        class51.method295("GameRules", this.field36388.method31212());
        final Class51 class55 = new Class51();
        for (final Map.Entry entry : this.field36381.entrySet()) {
            class55.method295(String.valueOf(((DimensionType)entry.getKey()).method1270()), (INBT)entry.getValue());
        }
        class51.method295("DimensionData", class55);
        if (class52 != null) {
            class51.method295("Player", class52);
        }
        final Class51 class56 = new Class51();
        final Class52 class57 = new Class52();
        final Iterator<String> iterator2 = this.field36380.iterator();
        while (iterator2.hasNext()) {
            ((AbstractList<Class50>)class57).add(Class50.method290(iterator2.next()));
        }
        class56.method295("Enabled", class57);
        final Class52 class58 = new Class52();
        final Iterator<String> iterator3 = this.field36379.iterator();
        while (iterator3.hasNext()) {
            ((AbstractList<Class50>)class58).add(Class50.method290(iterator3.next()));
        }
        class56.method295("Disabled", class58);
        class51.method295("DataPacks", class56);
        if (this.field36382 != null) {
            class51.method295("CustomBossEvents", this.field36382);
        }
        class51.method295("ScheduledEvents", this.field36389.method25419());
        class51.method298("WanderingTraderSpawnDelay", this.field36383);
        class51.method298("WanderingTraderSpawnChance", this.field36384);
        if (this.field36385 != null) {
            class51.method306("WanderingTraderId", this.field36385.toString());
        }
    }
    
    public long method29534() {
        return this.field36341;
    }
    
    public static long method29535(final long n) {
        return Hashing.sha256().hashLong(n).asLong();
    }
    
    public int method29536() {
        return this.field36345;
    }
    
    public int method29537() {
        return this.field36346;
    }
    
    public int method29538() {
        return this.field36347;
    }
    
    public long method29539() {
        return this.field36348;
    }
    
    public long method29540() {
        return this.field36349;
    }
    
    private void method29541() {
        if (!this.field36354) {
            if (this.field36355 != null) {
                if (this.field36353 < Class9528.method35579().getWorldVersion()) {
                    if (this.field36352 == null) {
                        throw Class8349.method27859(new NullPointerException("Fixer Upper not set inside LevelData, and the player tag is not upgraded."));
                    }
                    this.field36355 = Class9346.method34651(this.field36352, Class1959.field10676, this.field36355, this.field36353);
                }
                this.field36354 = true;
            }
        }
    }
    
    public Class51 method29542() {
        this.method29541();
        return this.field36355;
    }
    
    public void method29543(final int field36345) {
        this.field36345 = field36345;
    }
    
    public void method29544(final int field36346) {
        this.field36346 = field36346;
    }
    
    public void method29545(final int field36347) {
        this.field36347 = field36347;
    }
    
    public void method29546(final long field36348) {
        this.field36348 = field36348;
    }
    
    public void method29547(final long field36349) {
        this.field36349 = field36349;
    }
    
    public void method29548(final BlockPos class354) {
        this.field36345 = class354.getX();
        this.field36346 = class354.getY();
        this.field36347 = class354.getZ();
    }
    
    public String method29549() {
        return this.field36356;
    }
    
    public void method29550(final String field36356) {
        this.field36356 = field36356;
    }
    
    public int method29551() {
        return this.field36357;
    }
    
    public void method29552(final int field36357) {
        this.field36357 = field36357;
    }
    
    public long method29553() {
        return this.field36350;
    }
    
    public int method29554() {
        return this.field36358;
    }
    
    public void method29555(final int field36358) {
        this.field36358 = field36358;
    }
    
    public boolean method29556() {
        return this.field36361;
    }
    
    public void method29557(final boolean field36361) {
        this.field36361 = field36361;
    }
    
    public int method29558() {
        return this.field36362;
    }
    
    public void method29559(final int field36362) {
        this.field36362 = field36362;
    }
    
    public boolean method29560() {
        return this.field36359;
    }
    
    public void method29561(final boolean field36359) {
        this.field36359 = field36359;
    }
    
    public int method29562() {
        return this.field36360;
    }
    
    public void method29563(final int field36360) {
        this.field36360 = field36360;
    }
    
    public Class101 method29564() {
        return this.field36363;
    }
    
    public boolean method29565() {
        return this.field36364;
    }
    
    public void method29566(final boolean field36364) {
        this.field36364 = field36364;
    }
    
    public void method29567(final Class101 field36363) {
        this.field36363 = field36363;
    }
    
    public boolean method29568() {
        return this.field36365;
    }
    
    public void method29569(final boolean field36365) {
        this.field36365 = field36365;
    }
    
    public Class9505 method29570() {
        return this.field36342;
    }
    
    public void method29571(final Class9505 field36342) {
        this.field36342 = field36342;
    }
    
    public Class51 method29572() {
        return this.field36343;
    }
    
    public void method29573(final Class51 field36343) {
        this.field36343 = field36343;
    }
    
    public boolean method29574() {
        return this.field36366;
    }
    
    public void method29575(final boolean field36366) {
        this.field36366 = field36366;
    }
    
    public boolean method29576() {
        return this.field36367;
    }
    
    public void method29577(final boolean field36367) {
        this.field36367 = field36367;
    }
    
    public Class8878 method29578() {
        return this.field36388;
    }
    
    public double method29579() {
        return this.field36370;
    }
    
    public double method29580() {
        return this.field36371;
    }
    
    public double method29581() {
        return this.field36372;
    }
    
    public void method29582(final double field36372) {
        this.field36372 = field36372;
    }
    
    public long method29583() {
        return this.field36373;
    }
    
    public void method29584(final long field36373) {
        this.field36373 = field36373;
    }
    
    public double method29585() {
        return this.field36374;
    }
    
    public void method29586(final double field36374) {
        this.field36374 = field36374;
    }
    
    public void method29587(final double field36371) {
        this.field36371 = field36371;
    }
    
    public void method29588(final double field36370) {
        this.field36370 = field36370;
    }
    
    public double method29589() {
        return this.field36375;
    }
    
    public void method29590(final double field36375) {
        this.field36375 = field36375;
    }
    
    public double method29591() {
        return this.field36376;
    }
    
    public void method29592(final double field36376) {
        this.field36376 = field36376;
    }
    
    public int method29593() {
        return this.field36377;
    }
    
    public int method29594() {
        return this.field36378;
    }
    
    public void method29595(final int field36377) {
        this.field36377 = field36377;
    }
    
    public void method29596(final int field36378) {
        this.field36378 = field36378;
    }
    
    public Class2113 method29597() {
        return this.field36368;
    }
    
    public void method29598(final Class2113 field36368) {
        this.field36368 = field36368;
    }
    
    public boolean method29599() {
        return this.field36369;
    }
    
    public void method29600(final boolean field36369) {
        this.field36369 = field36369;
    }
    
    public Class7858<Class394> method29601() {
        return this.field36389;
    }
    
    public void method29602(final Class5204 class5204) {
        class5204.method16296("Level name", () -> this.field36356);
        class5204.method16296("Level seed", () -> String.valueOf(this.field36341));
        class5204.method16296("Level generator", () -> String.format("ID %02d - %s, ver %d. Features enabled: %b", this.field36342.method35411(), this.field36342.method35398(), this.field36342.method35402(), this.field36364));
        class5204.method16296("Level generator options", () -> this.field36343.toString());
        class5204.method16296("Level spawn location", () -> Class5204.method16295(this.field36345, this.field36346, this.field36347));
        class5204.method16296("Level time", () -> String.format("%d game time, %d day time", this.field36348, this.field36349));
        class5204.method16296("Known server brands", () -> String.join(", ", this.field36386));
        class5204.method16296("Level was modded", () -> Boolean.toString(this.field36387));
        class5204.method16296("Level storage version", () -> {
            try {
                switch (this.field36357) {
                    case 19132: {
                        break;
                    }
                    case 19133: {
                        break;
                    }
                }
            }
            catch (final Throwable t) {}
            final String s;
            return String.format("0x%05X - %s", this.field36357, s);
        });
        class5204.method16296("Level weather", () -> String.format("Rain time: %d (now: %b), thunder time: %d (now: %b)", this.field36360, this.field36359, this.field36362, this.field36361));
        class5204.method16296("Level game mode", () -> String.format("Game mode: %s (ID %d). Hardcore: %b. Cheats: %b", this.field36363.method586(), this.field36363.method585(), this.field36365, this.field36366));
    }
    
    public Class51 method29603(final DimensionType class383) {
        final Class51 class384 = this.field36381.get(class383);
        return (class384 != null) ? class384 : new Class51();
    }
    
    public void method29604(final DimensionType class383, final Class51 class384) {
        this.field36381.put(class383, class384);
    }
    
    public int method29605() {
        return this.field36338;
    }
    
    public boolean method29606() {
        return this.field36339;
    }
    
    public String method29607() {
        return this.field36337;
    }
    
    public Set<String> method29608() {
        return this.field36379;
    }
    
    public Set<String> method29609() {
        return this.field36380;
    }
    
    @Nullable
    public Class51 method29610() {
        return this.field36382;
    }
    
    public void method29611(final Class51 field36382) {
        this.field36382 = field36382;
    }
    
    public int method29612() {
        return this.field36383;
    }
    
    public void method29613(final int field36383) {
        this.field36383 = field36383;
    }
    
    public int method29614() {
        return this.field36384;
    }
    
    public void method29615(final int field36384) {
        this.field36384 = field36384;
    }
    
    public void method29616(final UUID field36385) {
        this.field36385 = field36385;
    }
    
    public void method29617(final String s, final boolean b) {
        this.field36386.add(s);
        this.field36387 |= b;
    }
    
    static {
        field36340 = Class2113.field12292;
    }
}
