package org.spigotmc.commands.annotation;

import org.spigotmc.enums.PlayerType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CommandInfo {
    String name();
    String usage();
    String desc();
    String[] aliases() default {}; 
    PlayerType rank() default PlayerType.FREE;     
    boolean blatant();
}
