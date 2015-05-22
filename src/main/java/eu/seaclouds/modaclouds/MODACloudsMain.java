package eu.seaclouds.modaclouds;


import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Objects.ToStringHelper;

import brooklyn.cli.Main;
import eu.seaclouds.modaclouds.manager.MODACloudsMonitoringManager;
import io.airlift.command.Command;
import io.airlift.command.Option;

/**
 * This class provides a static main entry point for launching a custom Brooklyn-based app.
 * <p>
 * It inherits the standard Brooklyn CLI options from {@link brooklyn.cli.Main}, plus adds a few more shortcuts for
 * favourite blueprints to the {@link LaunchCommand}.
 */
public class MODACloudsMain extends Main {

    private static final Logger log = LoggerFactory.getLogger(MODACloudsMain.class);

    public static void main(String... args) {
        log.debug("CLI invoked with args " + Arrays.asList(args));
        new MODACloudsMain().execCli(args);
    }

    @Override
    protected String cliScriptName() {
        return "start.sh";
    }

    @Override
    protected Class<? extends BrooklynCommand> cliLaunchCommand() {
        return LaunchCommand.class;
    }

    @Command(name = "launch", description = "Starts a brooklyn server, and optionally an application.")
    public static class LaunchCommand extends Main.LaunchCommand {

        @Option(name = {"--modaclouds"}, description = "Launch an Ambari application")
        public boolean modaclouds;

        @Override
        public Void call() throws Exception {
            // process our CLI arguments
            if (modaclouds) {
                setAppToLaunch(MODACloudsMonitoringManager.class.getCanonicalName());
            }

            // now process the standard launch arguments
            return super.call();
        }

        @Override
        public ToStringHelper string() {
            return super.string()
                    .add("modaclouds", modaclouds);
        }
    }
}
