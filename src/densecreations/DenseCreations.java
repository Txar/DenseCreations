package densecreations;

import mindustry.mod.Mod;
import densecreations.content.*;
import arc.*;
import arc.func.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.ctype.*;
import mindustry.mod.*;
import mindustry.net.*;
import mindustry.type.*;
import mindustry.ui.*;
import mindustry.world.*;
import mindustry.world.blocks.*;

public class DenseCreations extends Mod{

    private final ContentList[] denseContent = {
        new DenseItems(),
        new DenseLiquids(),
        new DenseBlocks()
    };

    @Override
    public void init(){
    }

    @Override
    public void loadContent(){
        for(ContentList list : denseContent){
            list.load();
        }
    }
}
