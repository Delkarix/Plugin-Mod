package KAMKEEL.PluginMod.Config;

import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import org.apache.logging.log4j.Level;

import java.io.File;

public class ConfigItems {
    public static Configuration config;

    public final static String GENERAL = "General";

    /**
     *  General Properties
     **/
    public static Property EnableCardsProperty;
    public static boolean EnableCards = true;

    public static Property EnablePillsProperty;
    public static boolean EnablePills = true;

    public static Property EnableEyesProperty;
    public static boolean EnableEyes = true;

    public static Property EnableBallsProperty;
    public static boolean EnableBalls = true;

    public static Property EnableArtifactsProperty;
    public static boolean EnableArtifacts = true;

    public static Property EnableEnergyAttacksProperty;
    public static boolean EnableEnergyAttacks = true;

    public static Property EnableApplesProperty;
    public static boolean EnableApples = true;

    public static Property EnableMISCProperty;
    public static boolean EnableMISC = true;


    public static void init(File configFile) {
        config = new Configuration(configFile);

        try {
            config.load();

            // General
            EnableCardsProperty = config.get(GENERAL, "Enable Cards", true);
            EnableCards = EnableCardsProperty.getBoolean(true);

            EnablePillsProperty = config.get(GENERAL, "Enable Pills", true);
            EnablePills = EnablePillsProperty.getBoolean(true);

            EnableEyesProperty = config.get(GENERAL, "Enable Eyes", true);
            EnableEyes = EnableEyesProperty.getBoolean(true);

            EnableBallsProperty = config.get(GENERAL, "Enable Balls", true);
            EnableBalls = EnableBallsProperty.getBoolean(true);

            EnableArtifactsProperty = config.get(GENERAL, "Enable Artifacts", true);
            EnableArtifacts = EnableArtifactsProperty.getBoolean(true);

            EnableEnergyAttacksProperty = config.get(GENERAL, "Enable Energy Attacks", true);
            EnableEnergyAttacks = EnableEnergyAttacksProperty.getBoolean(true);

            EnableApplesProperty = config.get(GENERAL, "Enable Apples", true);
            EnableApples = EnableApplesProperty.getBoolean(true);

            EnableMISCProperty = config.get(GENERAL, "Enable MISC", true);
            EnableMISC = EnableMISCProperty.getBoolean(true);
        }
        catch (Exception e)
        {
            FMLLog.log(Level.ERROR, e, "PluginMod has had a problem loading its main configuration");
        }
        finally
        {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }
}
