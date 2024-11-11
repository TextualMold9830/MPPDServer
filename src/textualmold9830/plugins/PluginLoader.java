package textualmold9830.plugins;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class PluginLoader {
    private static final String PLUGINS_DIRECTORY = "plugins";


    public static List<Plugin> loadPlugins() throws IOException, ClassNotFoundException {
        List<Plugin> plugins = new ArrayList<>();
        File[] pluginFiles = new File("plugins").listFiles();
        for (File file : pluginFiles) {
            if (file.getName().endsWith(".jar")) {
                URLClassLoader loader = new URLClassLoader(new URL[]{file.toURI().toURL()});
                ScanResult result = new ClassGraph()
                        .addClassLoader(loader)
                        .enableClassInfo()
                        .enableFieldInfo()
                        .scan();
                ClassInfoList classInfo = result.getClassesImplementing(Plugin.class);
                classInfo.forEach(info -> plugins.add(loadFromClassInfo(info)));
            }
        }
        return plugins;
    }
    public static Plugin loadFromClassInfo(ClassInfo info) {
        try {
            Plugin plugin = (Plugin) info.loadClass().getDeclaredConstructor().newInstance();
            System.out.println("loaded: " + plugin.getName());
            return plugin;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
