import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import sudoku.Settings;

public class SettingsTest {
	@Test
	public void aSettingsObjectCanBeCreatedWiThreeParameters() throws Exception
	{
		Settings setting = new Settings("level", "algorith", "output.xml");
		assertNotNull(setting);
	}
	@Test
	public void aSettingsObjectCanBeCreatedWiThoutParameters() throws Exception
	{
		Settings setting = new Settings();
		assertNotNull(setting);
	}
	@Test
	public void aSettingsConfigDefaultCanBeWritedInAXmlFile() throws Exception
	{
		Settings setting = new Settings();
		setting.setOutput(".\\files\\SettingTest.xml");
		setting.writeXmlSettings();
		File file = new File(setting.getOuput());
		assertTrue(file.exists());
	}
	@Test
	public void theSettingsInformationCanBeReadedFromXmlConfigFile() throws Exception
	{
		Settings set = new Settings("levelTestSetting", "algorithmTestSettings", ".\\files\\SettingTest.xml");
		set.writeXmlSettings();
		set.readXmlSettings();
		assertEquals("levelTestSetting", set.getLevel());
		assertEquals("algorithmTestSettings", set.getAlgorithm());
		assertEquals(".\\files\\SettingTest.xml", set.getOuput());
	}
}