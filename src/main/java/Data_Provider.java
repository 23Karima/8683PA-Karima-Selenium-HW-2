
import base.BasePage;
import org.testng.annotations.DataProvider;
import utils.ExcelData;

import java.io.File;

    public class Data_Provider extends BasePage {

        String packagePath= System.getProperty("user.dir") ;
        String dataPath= "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test_data.xlsx";
        ExcelData excelData = new ExcelData(packagePath + File.separator + dataPath);
        @DataProvider(name ="testDoSearch")
        public Object[][] getDoSearchProvider(){

            return excelData.readStringArrays("testDoSearch");
        }

    }

