package testing.com.ola.qa.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WordDoc {

public static String FilePath;
static File docFile;
static XWPFDocument docx;
static XWPFParagraph para;
static FileInputStream fis;

String scenario;

public void writeInWord(String scenario) throws IOException, InvalidFormatException {

 createWordFile(scenario);

 docx = new XWPFDocument();
 para = docx.createParagraph();
 create();

 try (FileOutputStream out = new FileOutputStream(docFile)) {
  docx.write(out);
  out.flush();
 } catch (IOException e) {
  e.printStackTrace();
 }

 docx.close();

}

public void create() throws InvalidFormatException, IOException {
 for (String key : Singleton.getInstance().getRegistry().keySet()) {
  XWPFRun run_1 = para.createRun();
  run_1.setFontSize(12);
  run_1.setBold(true);
  run_1.setUnderline(UnderlinePatterns.SINGLE);

  run_1.setText(key);
  run_1.addBreak();
  run_1.addBreak();

  attachScreenShot(run_1, key, Singleton.getInstance().getRegistry().get(key).toString());
  run_1.addBreak();
  run_1.addBreak();
 }
}

public void attachScreenShot(XWPFRun run, String imgFileName, String path)
  throws IOException, InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

 File imgFile = new File(path);
 fis = new FileInputStream(imgFile);
 BufferedImage bi = ImageIO.read(imgFile);

 run.addPicture(fis, XWPFDocument.PICTURE_TYPE_JPEG, imgFileName, Units.toEMU(bi.getWidth() / 2.9),
   Units.toEMU(bi.getHeight() / 2.5));

 fis.close();
}

public void createWordFile(String scenario) throws IOException {
 DateFormat sdf = new SimpleDateFormat("MM_dd-HH_mm");
 Date date = new Date();
 String todaysDate = sdf.format(date);

 docFile = new File(System.getProperty("user.dir") + "\\PassLogs\\" + scenario + ".docx");
 docFile.createNewFile();
 FilePath = docFile.getAbsolutePath();
}

}




