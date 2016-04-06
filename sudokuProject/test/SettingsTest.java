import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import sudoku.Settings;
import sudoku.io.XMLHandler;

public class SettingsTest {
	@Test
	public void aSettingsObjectCanBeCreatedWiThreeParameters() {
		Settings setting = new Settings("level", "algorith", "output.xml", ".\\files\\sudokuDefaultConfig.xml");
		assertNotNull(setting);
	}

	@Test
	public void aSettingsObjectCanBeCreatedWiThoutParameters() {
		Settings setting = new Settings();
		assertNotNull(setting);
	}

	@Test
	public void aSettingsConfigDefaultCanBeWritedInAXmlFile() {
		Settings setting = new Settings();
		setting.setPath(".\\files\\SettingTestCCCC.xml");
		setting.writeXmlSettings();
		File file = new File(setting.getPath());
		assertTrue(file.exists());
	}

	@Test
	public void theSettingsInformationCanBeReadedFromXmlConfigFile() {
		Settings set = new Settings("levelTestSetting", "algorithmTestSettings", "junit.txt",
				".\\files\\SettingTest.xml");
		set.writeXmlSettings();
		set.readXmlSettings();
		assertEquals("levelTestSetting", set.getLevel());
		assertEquals("algorithmTestSettings", set.getAlgorithm());
		assertEquals("junit.txt", set.getOutput());
	}

	@Test
	public void theLevelCanBeChanged() {
		Settings setting = new Settings("levelXMLHandlerTest", "algorithmXMLHandlerTest", "out.csv",
				".\\files\\xmlHandlerXYZ.xml");
		setting.writeXmlSettings();
		setting.readXmlSettings();
		setting.setLevel("whatever");
		setting.writeXmlSettings();
		assertEquals("whatever", setting.getLevel());
	}
}
