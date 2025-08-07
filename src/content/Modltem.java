package mymod;

import arc.struct.Seq;
import mindustry.content.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.meta.*;

public class ContentLoader {
    public static void load() {
        var eclipseCopy = new UnitType("eclipse-copy") {{
            localizedName = "厄兆（纯Java版）";
            health = 22000;
            armor = 13;
            speed = 0.43f;
            accel = 0.04f;
            drag = 0.04f;
            rotateSpeed = 0.9f;
            flying = true;
            lowAltitude = true;
            circleTarget = true;
            hitSize = 58f;

            weapons.add(
                    new Weapon("large-laser-mount") {{
                        x = 18.5f;
                        y = 0;
                        rotate = true;
                        shootCone = 8f;
                        shootY = 5.5f;
                        reload = 90f;
                        recoil = 4f;
                        shootSound = Sounds.laser;
                        bullet = new ContinuousLaserBulletType(75f) {{
                            length = 560f;
                            width = 45f;
                            colors = new Color[]{Color.valueOf("bf4f37ff"), Color.white};
                            largeHit = true;
                            lightColor = Color.valueOf("ff4f37");
                            continuous = true;
                        }};
                    }},
                    new Weapon("missile-mount") {{
                        x = 0;
                        y = -8f;
                        shootY = 3f;
                        reload = 30f;
                        shots = 2;
                        shotDelay = 4f;
                        inaccuracy = 2f;
                        bullet = new MissileBulletType(4.2f, 40f) {{
                            lifetime = 60f;
                            splashDamage = 30f;
                            splashDamageRadius = 24f;
                            homingPower = 0.08f;
                            keepVelocity = false;
                            smokeEffect = Fx.shootBigSmoke2;
                            hitEffect = despawnEffect = Fx.blastExplosion;
                            trailColor = backColor = Color.valueOf("bf4f37");
                            frontColor = Color.white;
                        }};
                    }}
            );

            abilities.add(
                    new ForceFieldAbility(60f, 400f, 7000f, 10f),
                    new RepairFieldAbility(500f, 180f, 60f)
            );

            outlineColor = Color.valueOf("404040ff");
        }};

        eclipseCopy.requirements(Category.unit, BuildVisibility.shown, ItemStack.with(
                Items.copper, 3500,
                Items.lead, 2800,
                Items.metaglass, 1200,
                Items.graphite, 900,
                Items.silicon, 900,
                Items.plastanium, 600,
                Items.phaseFabric, 400,
                Items.surgeAlloy, 350
        ));
        eclipseCopy.research = UnitTypes.eclipse;
    }
}