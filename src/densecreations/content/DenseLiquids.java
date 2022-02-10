package densecreations.content;

import arc.*;
import arc.graphics.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.game.*;
import mindustry.type.*;

public class DenseLiquids implements ContentList {
    public static Liquid

    gleam

    ;

    @Override
    public void load(){
        gleam = new Liquid("gleam", Color.valueOf("68afed")){{
            temperature = 0.4f;
            heatCapacity = 0.2f;
        }};
    }
}