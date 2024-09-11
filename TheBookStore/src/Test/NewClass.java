/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.NumberFormat;
import java.util.Locale;
import javax.print.PrintService;

/**
 *
 * @author Admin
 */
public class NewClass {

    public PrintService findPrintService(String printerName) {
        for (PrintService service : PrinterJob.lookupPrintServices()) {
            if (service.getName().equalsIgnoreCase(printerName)) {
                return service;
            }
        }

        return null;
    }

    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if (page > 0) {
            /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }

        /* User (0,0) is typically outside the imageable area, so we must
        * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        /* Now we perform our rendering */

        g.setFont(new Font("Roman", 0, 8));
        g.drawString("Hello world !", 0, 10);

        return PAGE_EXISTS;
    }

    public void printSomething(String printerName) throws PrinterException {
        //find the printService of name printerName
        PrintService ps = findPrintService(printerName);
        //create a printerJob
        PrinterJob job = PrinterJob.getPrinterJob();
        //set the printService found (should be tested)
        job.setPrintService(ps);
        //set the printable (an object with the print method that can be called by "job.print")
        job.setPrintable((Printable) this);
        //call je print method of the Printable object
        job.print();
    }
    
//    public static void main(String[] args) {
//        NewClass nc = new NewClass();
//        nc.printSomething();
//    }
}
