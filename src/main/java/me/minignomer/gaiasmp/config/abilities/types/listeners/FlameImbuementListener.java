package me.minignomer.gaiasmp.config.abilities.types.listeners;

import me.minignomer.gaiasmp.config.abilities.AbilityManager;
import me.minignomer.gaiasmp.config.abilities.enums.AbilityType;
import me.minignomer.gaiasmp.config.element.interfaces.FireElement;
import me.minignomer.miniparticleapi.particles.ParticleBuilder;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.ArrayList;
import java.util.List;

public class FlameImbuementListener extends AbilityManager implements FireElement, Listener {
    @EventHandler
    public void onPlayerDamageEntity(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player))
            return;

        if (!(e.getEntity() instanceof LivingEntity))
            return;

        Player damager = (Player) e.getDamager();
        LivingEntity damagedEntity = (LivingEntity) e.getEntity();

        if (!isActive(damager, AbilityType.FLAME_IMBUEMENT))
            return;

        List<Particle> particleTypes = new ArrayList<>();
        particleTypes.add(Particle.FLAME);
        particleTypes.add(Particle.SOUL_FIRE_FLAME);

        double originalDmg = e.getDamage();
        double newDmg = originalDmg * 1.15;;

        if (damagedEntity instanceof Player && getElement((Player) damagedEntity) == strength) {
            newDmg += originalDmg * 0.05;
            ParticleBuilder.createCloud(
                    Particle.HEART,
                    damagedEntity.getLocation().add(0, 1, 0),
                    5,
                    0.25,
                    0.75,
                    0.25);
        }

        if (AbilityType.FLAME_IMBUEMENT.element == getElement(damager)) {
            newDmg += originalDmg * 0.05;
            damager.playSound(damager.getEyeLocation(), Sound.ENTITY_WIND_CHARGE_WIND_BURST, 1.0f, 1.2f);

        }

        e.setDamage(newDmg);

        ParticleBuilder.createExplosion(
                particleTypes,
                damagedEntity.getLocation().add(0, 1, 0),
                10,
                0.25);


    }
}
