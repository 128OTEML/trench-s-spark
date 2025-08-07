
package java.mymod;

import arc.util.Log;
import mindustry.mod.Mod;

public class MyMod extends Mod {
    public MyMod() {
        Log.info("MyMod loaded.");
    }

    @Override
    public void loadContent() {
        // 无需手写注册，hjson 会自动被加载
        Log.info("Content loaded.");
    }
}