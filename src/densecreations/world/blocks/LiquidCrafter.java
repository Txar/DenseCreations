package densecreations.world.blocks;

import arc.math.*;
import mindustry.entities.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.blocks.defense.*;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.game.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.production.*;
import mindustry.world.consumers.*;
import mindustry.world.meta.*;
import mindustry.*;

import java.util.*;

import static arc.Core.atlas;
import static mindustry.Vars.tilesize;
import static mindustry.Vars.world;

public class LiquidCrafter extends GenericCrafter {
    public LiquidCrafter(String name){
        super(name);
    }

    public TextureRegion bottomRegion, liquidRegion, topRegion;

    @Override
    public void load(){
        liquidRegion = atlas.find(name + "-liquid");
        bottomRegion = atlas.find(name + "-base");
        topRegion = atlas.find(name + "-top");
    }

    @Override
    public TextureRegion[] icons(){
        return new TextureRegion[] {
        bottomRegion,
        topRegion
        };
    }

    public class LiquidCrafterBuild extends GenericCrafterBuild{

        @Override
        public void draw(){
            Draw.rect(bottomRegion, x, y);

            if(liquids.total() > 0.001f){
                Drawf.liquid(liquidRegion, x, y, liquids.total() / liquidCapacity, liquids.current().color);
            }

            Draw.rect(topRegion, x, y);
        }

    }
}