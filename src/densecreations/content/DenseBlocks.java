package densecreations.content;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;

import mindustry.*;
import mindustry.ctype.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import mindustry.content.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;

import static mindustry.type.ItemStack.*;

import densecreations.content.*;
import densecreations.world.blocks.*;

@SuppressWarnings("deprecation")
public class DenseBlocks implements ContentList {
	public static Block

	//turrets
	quatro, shred,

	//oil things
	oilPacker, oilUnpacker, oilLamp,

	//lum farms
	lumCrystalizer, lumPlantation, gleamExtractor,

	//walls
	lumWall, lumWallLarge,

	//ores
	oreLumShard,

	// :)))))))))
	rickroll,

	//the last prism
	theLastPrism, beam

	;
	@Override
	public void load(){

	shred = new ItemTurret("shred"){{
			requirements(Category.turret, with(Items.graphite, 80, DenseItems.lumShard, 120, Items.lead, 60));
			ammo(
				Items.thorium,
				new BasicBulletType(6f, 10f, "bullet"){{
				width = 9f;
				height = 9f;
				shootEffect = Fx.shootSmall;
				smokeEffect = Fx.shootSmallSmoke;
				ammoMultiplier = 1f;
				lifetime = 180f;
				shrinkY = 0f;
				}},

				Items.graphite, 
				new BasicBulletType(6f, 8f, "bullet"){{
				width = 9f;
				height = 9f;
				shootEffect = Fx.shootSmall;
				smokeEffect = Fx.shootSmallSmoke;
				ammoMultiplier = 1f;
				lifetime = 180f;
				shrinkY = 0f;
				}},

				Items.titanium, 
				new BasicBulletType(6f, 9f, "bullet"){{
				width = 9f;
				height = 9f;
				shootEffect = Fx.shootSmall;
				smokeEffect = Fx.shootSmallSmoke;
				ammoMultiplier = 1f;
				lifetime = 180f;
				shrinkY = 0f;
				}}
			);

			ammoPerShot = 4;
			shootSound = Sounds.shotgun;
			spread = 3f;
			shots = 6;
			reloadTime = 75f;
			restitution = 0.6f;
			size = 3;
			range = 160;
			shootCone = 12f;
			ammoUseEffect = Fx.casing2;
			health = 430 * size * size;
			inaccuracy = 5f;
			rotateSpeed = 12f;
		}};

	gleamExtractor = new SolidPump("gleam-extractor"){{
            requirements(Category.production, with(Items.silicon, 40, Items.graphite, 40, Items.copper, 20, Items.lead, 40));
            result = DenseLiquids.gleam;
            pumpAmount = 0.2f;
            size = 2;
            liquidCapacity = 30f;
            rotateSpeed = 1.4f;
            attribute = Attribute.water;

            consumes.power(2f);
        }};

    quatro = new LaserTurret("quatro"){{
            requirements(Category.turret, with(Items.copper, 960, Items.lead, 240, Items.plastanium, 320, DenseItems.lumShard, 460, Items.silicon, 140));
            shootEffect = Fx.shootBigSmoke2;
            shootCone = 40f;
            recoilAmount = 4f;
            size = 3;
            shootShake = 1.2f;
            range = 160f;
            reloadTime = 90f;
            firingMoveFract = 0.5f;
            shootDuration = 160f;
            powerUse = 13f;
            shootSound = Sounds.laserbig;
            loopSound = Sounds.beam;
            loopSoundVolume = 1f;

            shootType = new ContinuousLaserBulletType(56){{
                length = 160f;
                hitEffect = Fx.hitMeltdown;
                hitColor = Pal.meltdownHit;
                status = StatusEffects.melting;
                drawSize = 240f;
                width = 6f;

                incendChance = 0.4f;
                incendSpread = 5f;
                incendAmount = 1;
                ammoMultiplier = 1f;
            }};

            health = 200 * size * size;
            consumes.add(new ConsumeLiquidFilter(liquid -> liquid.temperature <= 0.5f && liquid.flammability < 0.1f, 0.3f)).update(false);
        }};



    lumWall = new Wall("lum-wall"){{
		requirements(Category.defense, with(DenseItems.lumShard, 6));
        health = 160 * 4;
    }};

    lumWallLarge = new Wall("lum-wall-large"){{
        requirements(Category.defense, ItemStack.mult(lumWall.requirements, 4));
		health = 160 * 4 * 4;
        size = 2;
    }};



    oreLumShard = new OreBlock(DenseItems.lumShard){{
        oreDefault = true;
        oreThreshold = 0.90f;
        oreScale = 22f;
    }};
	

	rickroll = new AlertBlock("project-unity-early-acces"){{
		requirements(Category.defense, with(DenseItems.lumShard, 1, Items.surgeAlloy, 2, Items.titanium, 2, Items.plastanium, 3));
		health = 2500;
		size = 3;
		alertText = "Never gonna give you up, never gonna... wait actually I just did let you down :]";
	}};
	

	lumCrystalizer = new LiquidCrafter("lum-crystalizer"){{
		requirements(Category.production, with(Items.copper, 40, Items.graphite, 60, Items.silicon, 20));
            craftTime = 240f;
            size = 2;
            hasLiquids = hasPower = hasItems = true;
            outputItem = new ItemStack(DenseItems.lumShard, 4);
            liquidCapacity = 30f;
            itemCapacity = 24;

            craftEffect = Fx.none;

            consumes.item(Items.graphite, 8);
            consumes.power(1f);
            consumes.liquid(DenseLiquids.gleam, 0.4f);
	}};


	oilPacker = new LiquidCrafter("oil-packer"){{
		requirements(Category.distribution, with(Items.copper, 20, Items.silicon, 40, DenseItems.lumShard, 40));
		craftTime = 60f;
		size = 2;
		hasLiquids = hasPower = hasItems = true;
		outputItem = new ItemStack(DenseItems.packedOil, 1);
		liquidCapacity = 30f;

		consumes.power(0.8f);
		consumes.liquid(Liquids.oil, 0.1f);
	}};

	oilUnpacker = new LiquidCrafter("oil-unpacker"){{
		requirements(Category.distribution, with(Items.copper, 20, DenseItems.lumShard, 20, Items.silicon, 10));
		craftTime = 60f;
		size = 1;
		hasLiquids = hasItems = true;
		outputLiquid = new LiquidStack(Liquids.oil, 6f);
		consumes.item(DenseItems.packedOil);
	}};

	oilLamp = new LiquidLightBlock("oil-lamp"){{
		requirements(Category.effect, with(Items.metaglass, 5, DenseItems.lumShard, 10, Items.silicon, 10));
		size = 2;
		brightness = 0.90f;
		radius = 310f;
		consumes.liquid(Liquids.oil, 0.04f);
	}};

	}
}