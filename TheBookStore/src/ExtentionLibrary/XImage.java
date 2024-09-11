/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtentionLibrary;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public class XImage {
    public static Image getAppIcon()
    {
        URL url = XImage.class.getResource("src\\img\\Rimberio.png");
        return new ImageIcon(url).getImage();
    }
    
    public static void save(String whereTosave ,File src)
    {
        File destination = new File(whereTosave, src.getName());
        if (!destination.getParentFile().exists())
        {
            destination.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(destination.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    
    public static ImageIcon read(String pathToFile ,String fileName)
    {
        File path = new File(pathToFile + "\\", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
}
