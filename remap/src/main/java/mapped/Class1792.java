// 
// Decompiled by Procyon v0.6.0
// 

package mapped;

import java.util.function.Function;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.concurrent.CompletionStage;
import com.mojang.datafixers.util.Pair;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class Class1792 implements Class1662
{
    private final Class6209<Class3833> field9918;
    private final Class6209<Class3820> field9919;
    private final Class6209<Class7255> field9920;
    private final Class6209<EntityType<?>> field9921;
    
    public Class1792() {
        this.field9918 = new Class6209<Class3833>(Class90.field208, "tags/blocks", "block");
        this.field9919 = new Class6209<Class3820>(Class90.field211, "tags/items", "item");
        this.field9920 = new Class6209<Class7255>(Class90.field206, "tags/fluids", "fluid");
        this.field9921 = new Class6209<EntityType<?>>(Class90.field210, "tags/entity_types", "entity_type");
    }
    
    public Class6209<Class3833> method6463() {
        return this.field9918;
    }
    
    public Class6209<Class3820> method6464() {
        return this.field9919;
    }
    
    public Class6209<Class7255> method6465() {
        return this.field9920;
    }
    
    public Class6209<EntityType<?>> method6466() {
        return this.field9921;
    }
    
    public void method6467(final Class8654 class8654) {
        this.field9918.method18474(class8654);
        this.field9919.method18474(class8654);
        this.field9920.method18474(class8654);
        this.field9921.method18474(class8654);
    }
    
    public static Class1792 method6468(final Class8654 class8654) {
        final Class1792 class8655 = new Class1792();
        class8655.method6463().method18475(class8654);
        class8655.method6464().method18475(class8654);
        class8655.method6465().method18475(class8654);
        class8655.method6466().method18475(class8654);
        return class8655;
    }
    
    @Override
    public CompletableFuture<Void> method5785(final Class7885 class7885, final Class6582 class7886, final Class5028 class7887, final Class5028 class7888, final Executor executor, final Executor executor2) {
        return this.field9918.method18464(class7886, executor).thenCombine((CompletionStage<?>)this.field9919.method18464(class7886, executor), (BiFunction<? super Map<Class1932, Class8162<Object>>, ? super Object, ?>)Pair::of).thenCombine((CompletionStage<?>)this.field9920.method18464(class7886, executor).thenCombine((CompletionStage<?>)this.field9921.method18464(class7886, executor), (BiFunction<? super Map<Class1932, Class8162<Object>>, ? super Object, ?>)Pair::of), (pair, pair2) -> new Class6950((Map<Class1932, Class8162<Class3833>>)pair.getFirst(), (Map<Class1932, Class8162<Class3820>>)pair.getSecond(), (Map<Class1932, Class8162<Class7255>>)pair2.getFirst(), (Map<Class1932, Class8162<EntityType<?>>>)pair2.getSecond())).thenCompose((Function<? super Object, ? extends CompletionStage<Object>>)class7885::method25538).thenAcceptAsync(class7889 -> {
            this.field9918.method18465(class7889.field27211);
            this.field9919.method18465(class7889.field27212);
            this.field9920.method18465(class7889.field27213);
            this.field9921.method18465(class7889.field27214);
            Class7188.method22056(this.field9918);
            Class7855.method25401(this.field9919);
            Class7324.method22477(this.field9920);
            Class8039.method26370(this.field9921);
        }, executor2);
    }
}
