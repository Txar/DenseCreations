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

public class AlertBlock extends Wall {
    public AlertBlock(String name){
        super(name);
    }
    public String alertText = "";

    public TextureRegion rlImage;

    @Override
    public void load(){
        rlImage = atlas.find(name + "2");
    }

    public class AlertBlockBuild extends WallBuild {
        @Override
        public Building init(Tile tile, Team team, boolean shouldAdd, int rotation) {
            Vars.ui.showInfo(alertText);
            return super.init(tile, team, shouldAdd, rotation);
        };

        @Override
        public void draw(){
            Draw.rect(rlImage, x, y);
        };
    }
}