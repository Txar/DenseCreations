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
import mindustry.world.blocks.power.*;
import mindustry.world.consumers.*;
import mindustry.world.meta.*;
import mindustry.*;

import java.util.*;

import static arc.Core.atlas;
import static mindustry.Vars.tilesize;
import static mindustry.Vars.world;

public class LiquidLightBlock extends LightBlock {
    public LiquidLightBlock(String name){
        super(name);
    }

    //public float maxBrightness = 1f;

    public class LiquidLightBlockBuild extends LightBuild {

        //@Override
        //public void updateTile() {
        //    brightness = maxBrightness * (liquids.total() / liquidCapacity);
        //};

        @Override
        public void drawLight(){
            Drawf.light(team, x, y, lightRadius * Math.min(smoothTime, 2f), Tmp.c1.set(color), brightness * (liquids.total() / liquidCapacity));
        }
    }
}