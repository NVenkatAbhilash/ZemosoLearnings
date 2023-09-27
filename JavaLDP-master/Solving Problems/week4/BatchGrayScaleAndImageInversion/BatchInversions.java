
/**
 * Write a description of Imag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class BatchInversions {
    public ImageResource makeInversion(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel pixel: outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            pixel.setRed(255 - inPixel.getRed());
            pixel.setGreen(255 - inPixel.getBlue());
            pixel.setBlue(255 - inPixel.getGreen());
        }
        return outImage;
    }
    
    public void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource inverted = makeInversion(inImage);
            String fname = f.getName();
            String newName = "images/inverted-" + fname;
            inverted.setFileName(newName);
            inverted.draw();
            inverted.save();
        }
    }
}
