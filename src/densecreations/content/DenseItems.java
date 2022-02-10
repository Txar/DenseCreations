package densecreations.content;

import arc.*;
import arc.graphics.*;
import arc.math.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.entities.units.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;

public class DenseItems implements ContentList {
    public static Item 

    packedOil, lumShard

    ;

    public void load(){
    	lumShard = new Item("lum-shard", Color.valueOf("68afed")){{
            flammability = 0f;
            hardness = 3;
            cost = 3;
        }};

        packedOil = new Item("packed-oil", Color.valueOf("313131")){{
        	flammability = 1.2f;
        }};
    }
}