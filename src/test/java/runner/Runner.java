package runner;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

//@Suite
//@IncludeEngines("cucumber")
//@SelectClasspathResource("features/Login.feature") // Path to your feature files in src/test/resources/features
//@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,json:target/cucumber-reports/reports.json,json:target/cucumber-reports/cucumber.runtime.formatter.JSONFormatter")
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps") // Package of your step definitions
//@ConfigurationParameter(key = "tags", value = "@run")
//public class Runner {
//
//}

//@Suite
//@IncludeEngines("cucumber")
//@SelectClasspathResource("features/Login.feature") // Path to feature files in src/test/resources/features
//@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty" + "json:target/cucumber-reports/Cucumber.json" + "html:target/cucumber-reports/index.html")
//@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "steps") // Package of step definitions
//@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@run") // Filters scenarios with @run tag
//public class Runner {
//}

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features") // Ensure this path is correct
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty,json:target/cucumber-reports/Cucumber.json, html:target/cucumber-reports/index.html")
@ConfigurationParameter(key = "cucumber.glue", value = "steps") // Ensure 'steps' package contains step definitions
@ConfigurationParameter(key = "cucumber.filter.tags", value = "@run") // Ensure correct tag filtering
public class Runner {
}

