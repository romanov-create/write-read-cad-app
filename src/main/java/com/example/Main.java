package com.example;

import com.aspose.cad.Image;
import com.aspose.cad.fileformats.cad.CadImage;
import com.aspose.cad.fileformats.cad.cadobjects.Cad3DPoint;
import com.aspose.cad.fileformats.cad.cadobjects.CadText;
import com.aspose.cad.imageoptions.CadRasterizationOptions;
import com.aspose.cad.imageoptions.PdfOptions;

public class Main {
    public static void main(String[] args) {
        String srcFile = "src/main/resources/files-input/playseat.dwg";

        CadImage cadImage = (CadImage) Image.load(srcFile);

        // or add more simple entity like Text
        CadText text = new CadText();
        text.setDefaultValue("Some text");
        text.setTextHeight(40);
        text.setFirstAlignment(new Cad3DPoint(300, 40));
        text.setLayerName("0");
        cadImage.getBlockEntities().get_Item("*Model_Space").addEntity(text);


        // export to pdf
        CadRasterizationOptions rasterizationOptions = new CadRasterizationOptions();
        rasterizationOptions.setPageWidth(1600);
        rasterizationOptions.setPageHeight(1600);
        rasterizationOptions.setLayouts(new String[]{"Model"});
        PdfOptions pdfOptions = new PdfOptions();
        pdfOptions.setVectorRasterizationOptions(rasterizationOptions);
        cadImage.save("src/main/resources/files-output/output.pdf", pdfOptions);
    }
}
