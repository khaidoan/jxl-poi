
import java.io.File;

import jxlpoi.Workbook;
import jxlpoi.write.*;
import jxlpoi.write.Number;
import jxlpoi.write.biff.RowsExceededException;

public class CreateExcelTest  {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			WritableWorkbook workbook = Workbook.createWorkbook(new File("C:\\Users\\kdoan\\Desktop\\createExcelTest.xlsx"));
			WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 10);
			arial10font.setBoldStyle(WritableFont.BOLD);

			WritableCellFormat arial10format = new WritableCellFormat(arial10font);

			WritableFont arial11font = new WritableFont(WritableFont.ARIAL, 10);
			arial11font.setBoldStyle(WritableFont.BOLD);
			arial11font.setPointSize(16);
			WritableCellFormat arial11format = new WritableCellFormat(arial11font);

			WritableSheet sheet = workbook.createSheet("data", 0);

			sheet.addCell(new Label(1, 1, "Test Title", arial11format));

			workbook.write();
			workbook.close();

		} catch (Exception e) {
			throw e;
		}
	}

}
